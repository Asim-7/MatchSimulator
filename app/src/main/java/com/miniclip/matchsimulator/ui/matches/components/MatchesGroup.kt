package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miniclip.matchsimulator.data.model.MatchEntity

@Composable
fun MatchesGroup(
    modifier: Modifier,
    grouped: Map<Int, List<MatchEntity>>,
    onMatchClick: (MatchEntity) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        grouped.forEach { (day, dayMatches) ->
            item {
                MatchDayRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
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