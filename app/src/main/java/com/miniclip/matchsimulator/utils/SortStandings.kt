package com.miniclip.matchsimulator.utils

import com.miniclip.matchsimulator.data.model.TeamStanding

fun sortStandings(standings: List<TeamStanding>): List<TeamStanding> {
    // Sort by: Points, Goal diff, Goals for, Goals against, Head-to-head
    return standings.sortedWith(
        compareByDescending<TeamStanding> { it.points }
            .thenByDescending { it.goalsFor - it.goalsAgainst }
            .thenByDescending { it.goalsFor }
            .thenBy { it.goalsAgainst }
        // Head-to-head logic can be added here if needed
    )
}