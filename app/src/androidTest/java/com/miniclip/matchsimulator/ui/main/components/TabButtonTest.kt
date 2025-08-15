package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

class TabButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tabButton_clickChangesSelection() {
        var clicked = false
        composeTestRule.setContent {
            TabButton(label = "Tab", selected = false, "test", onClick = { clicked = true })
        }
        composeTestRule.onNodeWithText("Tab").performClick()
        assert(clicked)
    }
}