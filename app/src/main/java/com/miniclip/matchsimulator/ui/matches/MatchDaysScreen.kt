package com.miniclip.matchsimulator.ui.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.ui.matches.components.MatchesGroup
import com.miniclip.matchsimulator.ui.matches.components.NoMatches
import com.miniclip.matchsimulator.ui.theme.Dimens
import androidx.compose.ui.tooling.preview.Preview
import com.miniclip.matchsimulator.data.remote.DummyData

@Composable
fun MatchDaysScreen(matches: List<MatchEntity>, onMatchClick: (MatchEntity) -> Unit) {
    // MatchDaysScreen displays a list of matches grouped by match day
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
            // Display matches grouped by match day
            MatchesGroup(
                modifier = Modifier.fillMaxSize(),
                matches = matches,
                onMatchClick = { match -> onMatchClick(match) }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 640, heightDp = 360, apiLevel = 34)
@Composable
fun MatchDaysScreenPreview() {
    MatchDaysScreen(
        matches = DummyData.matches,
        onMatchClick = {}
    )
}