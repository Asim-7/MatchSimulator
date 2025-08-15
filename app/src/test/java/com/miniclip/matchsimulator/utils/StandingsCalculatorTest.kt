package com.miniclip.matchsimulator.utils

import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class StandingsCalculatorTest {

    /*@Test
    fun updateTeamStandingsAfterMatch_updatesCorrectly() = runBlocking {
        val standings = listOf(
            TeamStanding("Ajax", 1, 0, 0, 1, 1, 2, 0, 1, 3, mutableMapOf()),
            TeamStanding("Away", 1, 0, 0, 1, 2, 1, 0, 1, 3, mutableMapOf())
        )
        val match = DummyData.matches[0].copy(
            homeScore = 1,
            awayScore = 2,
        )

        val result = updateTeamStandingsAfterMatch(match, standings)
        assertNotNull(result)
        val (home, away) = result!!
        assertEquals(2, home.played)
        assertEquals(1, home.win)
        assertEquals(0, home.draw)
        assertEquals(1, home.loss)
        assertEquals(3, home.points)
        assertEquals(3, home.goalsFor)
        assertEquals(3, home.goalsAgainst)
        assertEquals(2, away.played)
        assertEquals(0, away.win)
        assertEquals(0, away.draw)
        assertEquals(2, away.loss)
        assertEquals(0, away.points)
        assertEquals(3, away.goalsFor)
        assertEquals(3, away.goalsAgainst)
    }*/

    @Test
    fun updateTeamStandingsAfterMatch_returnsNullIfTeamsNotFound() = runBlocking {
        val standings = listOf(
            TeamStanding("Home", 0, 0, 0, 0, 0, 0, 0, 1, 3, mutableMapOf())
        )
        val match = DummyData.matches[0].copy(
            homeScore = 1,
            awayScore = 2,
        )
        val result = updateTeamStandingsAfterMatch(match, standings)
        assertNull(result)
    }
}