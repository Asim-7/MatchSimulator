package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

// This defines a reusable TabButton component for the app
// It is marked as @Immutable to indicate that it is a stateless component
@Immutable
data class TabItem(
    val label: String,
    val index: Int,
    val testTag: String,
    val onClick: () -> Unit
)

@Composable
fun TabButton(
    label: String,
    selected: Boolean,
    testTag: String,
    onClick: () -> Unit
) {
    // Defined colors here for simplicity
    val selectedColor = Color.White
    val unselectedColor = MaterialTheme.colorScheme.primary
    Button(
        modifier = Modifier.testTag(testTag),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) selectedColor else unselectedColor,
            contentColor = if (selected) unselectedColor else selectedColor
        )
    ) {
        Text(label)
    }
}