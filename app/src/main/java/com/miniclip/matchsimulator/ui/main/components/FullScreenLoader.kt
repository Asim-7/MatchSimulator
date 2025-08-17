package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import com.miniclip.matchsimulator.ui.theme.Dimens
import android.media.MediaPlayer
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import com.miniclip.matchsimulator.R

@Composable
fun FullScreenLoader(
    modifier: Modifier,
    visible: Boolean,
    onTimeout: () -> Unit
) {
    val context = LocalContext.current
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("football.json"))
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    if (visible) {
        // Start a coroutine to handle timeout
        LaunchedEffect(Unit) {
            delay(3000)
            currentOnTimeout()
        }
        // Play whistle sound when loader opens
        DisposableEffect(Unit) {
            val mediaPlayer = MediaPlayer.create(context, R.raw.whistle)
            mediaPlayer?.setOnCompletionListener {
                it.release()
            }
            mediaPlayer?.start()
            onDispose {
                mediaPlayer?.release()
            }
        }
    }

    // Show the full-screen loader with fade-in and fade-out animations
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        // Full-screen loader with Lottie animation
        Box(
            modifier = modifier
                .testTag(TEST_TAG_FULL_SCREEN_LOADER)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
                .clickable { /*Consuming click*/ },
            contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = composition,
                iterations = 2,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.padding_32)
            )
        }
    }
}

const val TEST_TAG_FULL_SCREEN_LOADER = "fullScreenLoader"
