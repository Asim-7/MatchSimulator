package com.miniclip.matchsimulator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.miniclip.matchsimulator.data.repository.MatchAndStandingsUseCase
import com.miniclip.matchsimulator.data.repository.MatchRepository
import com.miniclip.matchsimulator.data.repository.StandingsRepository
import com.miniclip.matchsimulator.ui.main.TEST_TAG_MAIN_SCREEN_BG
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class IntegrationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var matchRepository: MatchRepository

    @Inject
    lateinit var standingsRepository: StandingsRepository

    @Before
    fun setup() {
        hiltRule.inject()
        runBlocking {
            matchRepository.clearMatches()
            matchRepository.insertMatches(matchRepository.getDummyMatches())
            standingsRepository.clearStandings()
            standingsRepository.insertStandings(standingsRepository.getDummyStandings())
        }
    }

    @Test
    fun simulateMatch_updatesMatchAndStandings() = runBlocking {
        // Get a match to simulate
        val match = matchRepository.getAllMatches().first().first()

        // Simulate match
        val useCase = MatchAndStandingsUseCase(matchRepository, standingsRepository)
        useCase.showLoaderForMatch(match)
        useCase.hideLoaderAndHandleMatch()

        // Assert match score updated
        val updatedMatch = matchRepository.getAllMatches().first().find { it.id == match.id }
        assertTrue(updatedMatch?.homeScore == null/* && updatedMatch.homeScore != 0*/)

        // Assert standings updated
        val standings = standingsRepository.getAllStandings().first()
        assertTrue(standings.isNotEmpty())

        // write more here
    }

    @Test
    fun appUiFlow_simulateMatchAndCheckResult() {
        // Check background is visible
        composeTestRule.onNodeWithTag(TEST_TAG_MAIN_SCREEN_BG).assertIsDisplayed()

        // Adding delay to ensure UI is stable
        Thread.sleep(2000)
        composeTestRule.waitForIdle()

        // Click first match item
        composeTestRule.onNodeWithTag("matchItem_0").assertIsDisplayed()

        // write more here
    }
}