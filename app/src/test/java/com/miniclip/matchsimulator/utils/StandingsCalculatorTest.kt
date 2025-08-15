package com.miniclip.matchsimulator.utils

import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class StandingsCalculatorTest {

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