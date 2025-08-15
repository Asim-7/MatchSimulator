package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun NoMatches(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.no_matches), fontSize = Dimens.font_16)
    }
}