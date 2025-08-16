package com.miniclip.matchsimulator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.matchsimulator.ui.table.TableScreen
import com.miniclip.matchsimulator.ui.table.TeamStandingViewModel

@Composable
fun TableRoute(viewModelStandings: TeamStandingViewModel = hiltViewModel()) {
    val teamStandings by viewModelStandings.teamStandings.collectAsState()

    TableScreen(teamStandings)
}