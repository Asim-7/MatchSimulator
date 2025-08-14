package com.miniclip.matchsimulator.ui.table

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.utils.sortStandings

@Composable
fun TableScreen() {
    // Get data from ViewModel or repository
    val sorted = sortStandings(dummyStandings)

    Column(modifier = Modifier.fillMaxSize()) {
        TableHeader()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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

@Composable
fun TableCellImage(text: String, logo: Int) {
    Box(
        modifier = Modifier.width(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = text,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        )
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