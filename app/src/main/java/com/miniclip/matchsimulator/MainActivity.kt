package com.miniclip.matchsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.miniclip.matchsimulator.ui.matches.MatchDaysScreen
import com.miniclip.matchsimulator.ui.theme.MatchSimulatorTheme
import com.miniclip.matchsimulator.utils.BackgroundAudioPlayer
import com.miniclip.matchsimulator.utils.HideSystemBars
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatchSimulatorTheme {
                HideSystemBars()
                BackgroundAudioPlayer() // Initialize background audio player
                MatchDaysScreen()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 640, heightDp = 360)
@Composable
fun MatchDaysScreenPreview() {
    MatchSimulatorTheme {
        MatchDaysScreen()
    }
}