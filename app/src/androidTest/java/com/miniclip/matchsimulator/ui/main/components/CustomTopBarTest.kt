package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

class CustomTopBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun customTopBar_tabSelectionAndResetClick() {
        var matchesClicked = false
        var tableClicked = false
        var statsClicked = false
        var resetClicked = false

        composeTestRule.setContent {
            CustomTopBar(
                onMatchesClick = { matchesClicked = true },
                onTableClick = { tableClicked = true },
                onStatsClick = { statsClicked = true },
                onResetClick = { resetClicked = true }
            )
        }

        // Click each tab and check callback
        composeTestRule.onNodeWithTag(TEST_TAG_MATCHES).performClick()
        assert(matchesClicked)
        composeTestRule.onNodeWithTag(TEST_TAG_TABLE).performClick()
        assert(tableClicked)
        composeTestRule.onNodeWithTag(TEST_TAG_STATS).performClick()
        assert(statsClicked)
        // Click reset icon
        composeTestRule.onNodeWithTag(TEST_TAG_RESET).performClick()
        assert(resetClicked)
    }
}