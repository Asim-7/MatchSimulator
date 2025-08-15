package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun MatchDayRow(modifier: Modifier, day: Int) {
    // MatchDayRow displays the match day information with home and away labels
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.home),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "${stringResource(id = R.string.match_day)} $day",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = Dimens.padding_8)
        )
        Text(
            text = stringResource(id = R.string.away),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}