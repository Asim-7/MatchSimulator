package com.miniclip.matchsimulator.ui.table.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.miniclip.matchsimulator.ui.theme.Dimens

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