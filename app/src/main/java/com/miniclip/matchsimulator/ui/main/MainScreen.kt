package com.miniclip.matchsimulator.ui.main

import androidx.compose.foundation.background
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
import com.miniclip.matchsimulator.ui.table.TableScreen
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.matchsimulator.ui.main.components.CustomTopBar
import com.miniclip.matchsimulator.ui.matches.MatchesViewModel
import com.miniclip.matchsimulator.ui.navigation.MATCH_ROUTE_ID
import com.miniclip.matchsimulator.ui.navigation.STATS_ROUTE_ID
import com.miniclip.matchsimulator.ui.navigation.TABLE_ROUTE_ID
import com.miniclip.matchsimulator.ui.table.TeamStandingViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModelMatches: MatchesViewModel = hiltViewModel()
    val viewModelStandings: TeamStandingViewModel = hiltViewModel()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        topBar = {
            CustomTopBar(
                onMatchesClick = { navController.navigateSingleTopTo(MATCH_ROUTE_ID) },
                onTableClick = { navController.navigateSingleTopTo(TABLE_ROUTE_ID) },
                onStatsClick = { navController.navigateSingleTopTo(STATS_ROUTE_ID) },
                onResetClick = {
                    viewModelMatches.clearMatchesAndInsertDummy()
                    viewModelStandings.clearStandingsAndInsertDummy()
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MatchesScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MatchesScreen.route) { MatchDaysScreen(viewModelMatches) }
            composable(route = TableScreen.route) { TableScreen(viewModelStandings) }
            composable(route = StatScreen.route) { StatsScreen() }
        }
    }
}

@Composable
fun StatsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Stats Screen")
    }
}