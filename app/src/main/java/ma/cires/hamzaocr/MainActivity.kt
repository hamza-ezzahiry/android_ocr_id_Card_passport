package ma.cires.hamzaocr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ma.cires.hamzaocr.ui.theme.HamzaocrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HamzaocrTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { /* Add TopAppBar here if needed */ },
                    bottomBar = { /* Add BottomAppBar here if needed */ }
                ) { innerPadding ->
                    RealTimeOCRScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
