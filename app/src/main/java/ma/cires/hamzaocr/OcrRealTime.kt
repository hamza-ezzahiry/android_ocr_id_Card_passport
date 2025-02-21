package ma.cires.hamzaocr

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun RealTimeOCRScreen(modifier: Modifier = Modifier) {
    var detectedId by remember { mutableStateOf("Scanning...") }

    val imageAnalyzer = getTextAnalyzer { text ->
        extractIdNumber(text)?.let { id ->
            detectedId = "Detected ID: $id"
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        CameraPreview(imageAnalyzer)

        Text(
            text = detectedId,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.7f))
                .padding(10.dp)
        )
    }
}
