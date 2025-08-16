package com.miniclip.matchsimulator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.matchsimulator.ui.matches.MatchDaysScreen
import com.miniclip.matchsimulator.ui.matches.MatchesViewModel

@Composable
fun MatchesRoute(viewModelMatches: MatchesViewModel = hiltViewModel()) {
    val matches by viewModelMatches.matches.collectAsState()

    MatchDaysScreen(
        matches = matches,
        onMatchClick = { match -> viewModelMatches.showLoaderForMatch(match) }
    )
}