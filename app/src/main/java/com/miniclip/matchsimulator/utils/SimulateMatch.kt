package com.miniclip.matchsimulator.utils

// Simulation function
fun simulateMatch(homeStrength: Int, awayStrength: Int): Pair<Int, Int> {
    // Simple Poisson-based simulation
    val homeGoals = (0..4).maxByOrNull { Math.random() * homeStrength }
    val awayGoals = (0..4).maxByOrNull { Math.random() * awayStrength }
    return Pair(homeGoals ?: 0, awayGoals ?: 0)
}