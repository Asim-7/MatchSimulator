package com.miniclip.matchsimulator.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miniclip.matchsimulator.ui.matches.MatchDaysScreen
import com.miniclip.matchsimulator.ui.navigation.MatchesScreen
import com.miniclip.matchsimulator.ui.navigation.StatScreen
import com.miniclip.matchsimulator.ui.navigation.TableScreen
import com.miniclip.matchsimulator.ui.navigation.navigateSingleTopTo

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            CustomTopBar(
                onMatchesClick = { navController.navigateSingleTopTo("matches") },
                onTableClick = { navController.navigateSingleTopTo("table") },
                onStatsClick = { navController.navigateSingleTopTo("stats") },
                onResetClick = { /* handle reset */ }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MatchesScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MatchesScreen.route) { MatchDaysScreen() }
            composable(route = TableScreen.route) { TableScreen() }
            composable(route = StatScreen.route) { StatsScreen() }
        }
    }
}

@Composable
fun TableScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Table Screen")
    }
}

@Composable
fun StatsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Stats Screen")
    }
}