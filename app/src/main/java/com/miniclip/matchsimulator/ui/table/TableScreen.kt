package com.miniclip.matchsimulator.ui.table

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.ui.theme.Dimens
import com.miniclip.matchsimulator.utils.sortStandings
import androidx.compose.ui.res.stringResource
import com.miniclip.matchsimulator.R

@Composable
fun TableScreen(viewModel: TeamStandingViewModel) {
    val teamStandings by viewModel.teamStandings.collectAsState()
    val sorted = sortStandings(teamStandings)

    Column(modifier = Modifier.fillMaxSize()) {
        TableHeader()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimens.padding_8)
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
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(vertical = Dimens.padding_8, horizontal = Dimens.padding_8),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableCell(stringResource(id = R.string.table_position), bold = true)
        TableCell(stringResource(id = R.string.table_team), bold = true)
        TableCell(stringResource(id = R.string.table_played), bold = true)
        TableCell(stringResource(id = R.string.table_win), bold = true)
        TableCell(stringResource(id = R.string.table_draw), bold = true)
        TableCell(stringResource(id = R.string.table_loss), bold = true)
        TableCell(stringResource(id = R.string.table_for), bold = true)
        TableCell(stringResource(id = R.string.table_against), bold = true)
        TableCell(stringResource(id = R.string.table_difference), bold = true)
        TableCell(stringResource(id = R.string.table_points), bold = true)
    }
}

@Composable
fun TableRow(position: Int, team: TeamStanding, highlight: Boolean) {
    val bgColor = if (highlight) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
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

@Composable
fun TableCellImage(text: String, logo: Int) {
    Box(
        modifier = Modifier.width(Dimens.TableCellWidth),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = text,
            modifier = Modifier
                .clip(CircleShape)
                .size(Dimens.TableCellImageSize)
        )
    }
}

@Composable
fun TableCell(text: String, bold: Boolean = false) {
    Box(
        modifier = Modifier.width(Dimens.TableCellWidth),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}