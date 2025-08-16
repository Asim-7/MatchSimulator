package com.miniclip.matchsimulator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.miniclip.matchsimulator.ui.main.ResetEventViewModel
import com.miniclip.matchsimulator.ui.main.components.CustomTopBar

@Composable
fun TopBarRoute(
    navController: NavHostController,
    resetEventViewModel: ResetEventViewModel = hiltViewModel()
) {
    CustomTopBar(
        onMatchesClick = { navController.navigateSingleTopTo(MATCH_ROUTE_ID) },
        onTableClick = { navController.navigateSingleTopTo(TABLE_ROUTE_ID) },
        onStatsClick = { navController.navigateSingleTopTo(STATS_ROUTE_ID) },
        onResetClick = { resetEventViewModel.restAll() }
    )
}