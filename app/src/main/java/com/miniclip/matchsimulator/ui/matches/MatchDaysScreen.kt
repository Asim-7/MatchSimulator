package com.miniclip.matchsimulator.ui.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.miniclip.matchsimulator.ui.matches.components.MatchesGroup
import com.miniclip.matchsimulator.ui.matches.components.NoMatches
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun MatchDaysScreen(viewModel: MatchesViewModel) {
    val matches by viewModel.matches.collectAsState()
    Column(
        modifier = Modifier
            .padding(
                start = Dimens.padding_16,
                end = Dimens.padding_16,
                bottom = Dimens.padding_8
            )
            .fillMaxSize()
    ) {
        if (matches.isEmpty()) {
            NoMatches(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.padding_32)
            )
        } else {
            val grouped = matches.groupBy { it.matchDay }
            MatchesGroup(
                modifier = Modifier.fillMaxSize(),
                grouped = grouped,
                onMatchClick = { match -> viewModel.onMatchClick(match) }
            )
        }
    }
}