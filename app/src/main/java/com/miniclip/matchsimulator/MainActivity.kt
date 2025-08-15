package com.miniclip.matchsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miniclip.matchsimulator.ui.main.MainScreen
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
                HideSystemBars() // Hide system bars for immersive experience
                BackgroundAudioPlayer() // Initialize background audio player
                MainScreen()
            }
        }
    }
}