package com.miniclip.matchsimulator.ui.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.ui.theme.Dimens
import com.miniclip.matchsimulator.utils.sortStandings
import androidx.compose.ui.tooling.preview.Preview
import com.miniclip.matchsimulator.data.remote.DummyData
import com.miniclip.matchsimulator.ui.table.components.TableHeader
import com.miniclip.matchsimulator.ui.table.components.TableRow

@Composable
fun TableScreen(teamStandings: List<TeamStanding>) {
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

@Preview(showBackground = true, widthDp = 640, heightDp = 360, apiLevel = 34)
@Composable
fun TableScreenPreview() {
    TableScreen(
        teamStandings = DummyData.dummyStandingsData,
    )
}