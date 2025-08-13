package com.miniclip.matchsimulator.ui.table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class TeamStanding(
    val team: String,
    val played: Int,
    val win: Int,
    val draw: Int,
    val loss: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val points: Int,
    val headToHead: Map<String, Int> // team name to result (1=win, 0=draw, -1=loss)
)

@Composable
fun TableScreen(standings: List<TeamStanding>) {
    // Sort by: Points, Goal diff, Goals for, Goals against, Head-to-head
    val sorted = standings.sortedWith(
        compareByDescending<TeamStanding> { it.points }
            .thenByDescending { it.goalsFor - it.goalsAgainst }
            .thenByDescending { it.goalsFor }
            .thenBy { it.goalsAgainst }
        // Head-to-head logic can be added here if needed
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TableHeader()
        LazyColumn {
            itemsIndexed(sorted) { index, team ->
                val qualified = index < 2
                TableRow(
                    position = index + 1,
                    team = team,
                    highlight = qualified
                )
            }
        }
    }
}

@Composable
fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(vertical = 8.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableCell("Position", bold = true)
        TableCell("Team", bold = true)
        TableCell("Played", bold = true)
        TableCell("Win", bold = true)
        TableCell("Draw", bold = true)
        TableCell("Loss", bold = true)
        TableCell("For", bold = true)
        TableCell("Against", bold = true)
        TableCell("-/+", bold = true)
        TableCell("Points", bold = true)
    }
}

@Composable
fun TableRow(position: Int, team: TeamStanding, highlight: Boolean) {
    val bgColor = if (highlight) Color(0xFFD0FFD0) else Color.Transparent
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableCell(position.toString())
        TableCell(team.team)
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

@Composable
fun TableCell(text: String, bold: Boolean = false) {
    Box(
        modifier = Modifier.width(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}