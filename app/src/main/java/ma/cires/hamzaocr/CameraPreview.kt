package ma.cires.hamzaocr

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.util.concurrent.Executors

@Composable
fun CameraPreview(imageAnalyzer: ImageAnalysis) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    AndroidView(
        factory = { ctx ->
            PreviewView(ctx).apply {
                scaleType = PreviewView.ScaleType.FILL_CENTER
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { previewView ->
            val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val cameraSelector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                val preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }

                // Bind camera to lifecycle
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageAnalyzer)
            }, ContextCompat.getMainExecutor(context))
        }
    )
}

@androidx.annotation.OptIn(ExperimentalGetImage::class)
fun getTextAnalyzer(onTextFound: (String) -> Unit): ImageAnalysis {
    return ImageAnalysis.Builder()
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
        .also { imageAnalysis ->
            imageAnalysis.setAnalyzer(Executors.newSingleThreadExecutor()) { imageProxy ->
                val mediaImage = imageProxy.image
                if (mediaImage != null) {
                    val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
                    val recognizer = TextRecognition.getClient(
                        TextRecognizerOptions.DEFAULT_OPTIONS
                    )

                    recognizer.process(image)
                        .addOnSuccessListener { visionText ->
                            val text = visionText.text
                            onTextFound(text)
                        }
                        .addOnFailureListener { e ->
                            Log.e("OCR", "Text recognition failed", e)
                        }
                        .addOnCompleteListener {
                            imageProxy.close()
                        }
                }
            }
        }
}

fun extractIdNumber(detectedText: String): String? {
    val passportPattern = Regex("\\b[A-Z]{1,2}[0-9]{6,9}\\b") // Adjust based on country format
    val idCardPattern = Regex("\\b\\d{8,12}\\b") // Generic ID number format

    return passportPattern.find(detectedText)?.value ?: idCardPattern.find(detectedText)?.value
}