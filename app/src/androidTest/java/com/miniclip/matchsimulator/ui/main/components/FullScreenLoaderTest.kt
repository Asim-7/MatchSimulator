package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

class FullScreenLoaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun fullScreenLoader_visibleShowsAnimation() {
        composeTestRule.setContent {
            FullScreenLoader(
                modifier = Modifier,
                visible = true,
                onTimeout = { }
            )
        }
        // Check animation is visible
        composeTestRule.onNodeWithTag(TEST_TAG_FULL_SCREEN_LOADER).assertIsDisplayed()
    }
}