package com.miniclip.matchsimulator.ui.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.matchsimulator.ui.matches.components.MatchesGroup
import com.miniclip.matchsimulator.ui.matches.components.NoMatches

@Composable
fun MatchDaysScreen(
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val matches by viewModel.matches.collectAsState()
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxSize()
    ) {
        if (matches.isEmpty()) {
            NoMatches(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )
        } else {
            // Group matches by matchDay for display
            val grouped = matches.groupBy { it.matchDay }
            MatchesGroup(
                modifier = Modifier.fillMaxSize(),
                grouped = grouped
            )
        }
    }
}