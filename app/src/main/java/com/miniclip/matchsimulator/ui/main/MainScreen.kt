package com.miniclip.matchsimulator.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miniclip.matchsimulator.ui.navigation.MatchesScreen
import com.miniclip.matchsimulator.ui.navigation.StatScreen
import com.miniclip.matchsimulator.ui.navigation.TableScreen
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.ui.navigation.FullScreenRoute
import com.miniclip.matchsimulator.ui.navigation.MatchesRoute
import com.miniclip.matchsimulator.ui.navigation.TableRoute
import com.miniclip.matchsimulator.ui.navigation.TopBarRoute
import com.miniclip.matchsimulator.ui.stats.StatsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Main screen layout with a Scaffold for top bar and content
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(WindowInsets.safeDrawing.asPaddingValues()),
            topBar = {
                TopBarRoute(navController = navController)
            }
        ) { innerPadding ->
            // Main content of the screen
            Box(modifier = Modifier.fillMaxSize()) {
                // Background image for the main screen
                Image(
                    painter = painterResource(id = R.drawable.stadium),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag(TEST_TAG_MAIN_SCREEN_BG),
                    contentScale = ContentScale.Crop
                )

                // Semi-transparent overlay to darken the background
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.2f))
                )

                // Navigation host for the main content
                NavHost(
                    navController = navController,
                    startDestination = MatchesScreen.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = MatchesScreen.route) { MatchesRoute() }
                    composable(route = TableScreen.route) { TableRoute() }
                    composable(route = StatScreen.route) { StatsScreen() }
                }
            }
        }

        // Full-screen loader that appears to indicate match simulation
        FullScreenRoute()
    }
}

const val TEST_TAG_MAIN_SCREEN_BG = "main_background"
