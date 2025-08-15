package com.miniclip.matchsimulator.ui.table.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun TableRow(position: Int, team: TeamStanding, highlight: Boolean) {
    val bgColor = if (highlight) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
    // TableRow displays a single row in the league table with team standings
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor)
            .padding(vertical = Dimens.padding_8),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableCell(position.toString())
        TableCellImage(team.team, team.logo)
        TableCell(team.played.toString())
        TableCell(team.win.toString())
        TableCell(team.draw.toString())
        TableCell(team.loss.toString())
        TableCell(team.goalsFor.toString())
        TableCell(team.goalsAgainst.toString())
        TableCell((team.goalsFor - team.goalsAgainst).toString())
        TableCell(team.points.toString())
    }
}