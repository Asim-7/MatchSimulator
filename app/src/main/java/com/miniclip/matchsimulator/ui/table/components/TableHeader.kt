package com.miniclip.matchsimulator.ui.table.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun TableHeader() {
    // TableHeader displays the header row of the table with column titles
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