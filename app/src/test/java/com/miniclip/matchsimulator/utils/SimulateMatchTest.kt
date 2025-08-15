package com.miniclip.matchsimulator.utils

import org.junit.Assert.assertTrue
import org.junit.Test

class SimulateMatchTest {

    @Test
    fun simulateMatch_returnsValidScores() {
        repeat(10) {
            val (home, away) = simulateMatch(5, 3)
            assertTrue(home in 0..4)
            assertTrue(away in 0..4)
        }
    }

    @Test
    fun simulateMatch_randomness() {
        val results = (1..20).map { simulateMatch(2, 2) }
        assertTrue(results.distinct().size > 1)
    }
}