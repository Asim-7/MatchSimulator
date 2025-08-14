package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class TabItem(
    val label: String,
    val index: Int,
    val onClick: () -> Unit
)

@Composable
fun TabButton(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.White else MaterialTheme.colorScheme.primary,
            contentColor = if (selected) MaterialTheme.colorScheme.primary else Color.White
        )
    ) {
        Text(label)
    }
}