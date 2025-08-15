package com.miniclip.matchsimulator.utils

import com.miniclip.matchsimulator.data.model.TeamStanding
import org.junit.Assert.assertEquals
import org.junit.Test

class SortStandingsTest {

    @Test
    fun sortStandings_ordersByPointsAndGoalDiff() {
        val standings = listOf(
            TeamStanding("B", 10, 3, 1, 1, 0, 0, 0, 1, 3, emptyMap()),
            TeamStanding("C", 12, 4, 1, 0, 1, 0, 0, 0, 1, emptyMap()),
            TeamStanding("A", 10, 3, 1, 0, 0, 1, 1, 0, 0, emptyMap())
        )
        val sorted = sortStandings(standings)
        assertEquals(listOf("B", "C", "A"), sorted.map { it.team })
    }
}