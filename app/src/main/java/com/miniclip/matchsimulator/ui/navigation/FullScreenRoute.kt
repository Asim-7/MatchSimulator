package com.miniclip.matchsimulator.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.matchsimulator.ui.main.FullScreenViewModel
import com.miniclip.matchsimulator.ui.main.components.FullScreenLoader

@Composable
fun FullScreenRoute(fullScreenViewModel: FullScreenViewModel = hiltViewModel()) {

    val showLoader by fullScreenViewModel.showLoader.collectAsState()

    FullScreenLoader(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        visible = showLoader,
        onTimeout = {
            fullScreenViewModel.hideLoaderAndHandleMatch()
        }
    )
}