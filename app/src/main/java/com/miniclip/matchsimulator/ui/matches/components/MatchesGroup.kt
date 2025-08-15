package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun MatchesGroup(
    modifier: Modifier,
    matches: List<MatchEntity>,
    onMatchClick: (MatchEntity) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.padding_12),
        contentPadding = PaddingValues(vertical = Dimens.padding_8)
    ) {
        val grouped = matches.groupBy { it.matchDay }
        grouped.forEach { (day, dayMatches) ->
            item {
                MatchDayRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.padding_16, vertical = Dimens.padding_8),
                    day = day
                )
            }
            items(dayMatches.size) { index ->
                val match = dayMatches[index]
                MatchCard(match = match, onMatchClick = onMatchClick)
            }
        }
    }
}