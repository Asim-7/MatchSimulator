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
    val selectedColor = Color.White
    val unselectedColor = MaterialTheme.colorScheme.primary
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) selectedColor else unselectedColor,
            contentColor = if (selected) unselectedColor else selectedColor
        )
    ) {
        Text(label)
    }
}