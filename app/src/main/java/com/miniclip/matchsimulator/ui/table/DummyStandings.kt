package com.miniclip.matchsimulator.ui.table

val dummyStandings = listOf(
    TeamStanding(
        team = "Team A",
        played = 6,
        win = 4,
        draw = 1,
        loss = 1,
        goalsFor = 12,
        goalsAgainst = 6,
        points = 13,
        headToHead = mapOf("Team B" to 1, "Team C" to 0, "Team D" to -1)
    ),
    TeamStanding(
        team = "Team B",
        played = 6,
        win = 3,
        draw = 2,
        loss = 1,
        goalsFor = 10,
        goalsAgainst = 7,
        points = 11,
        headToHead = mapOf("Team A" to -1, "Team C" to 1, "Team D" to 0)
    ),
    TeamStanding(
        team = "Team C",
        played = 6,
        win = 2,
        draw = 2,
        loss = 2,
        goalsFor = 8,
        goalsAgainst = 9,
        points = 8,
        headToHead = mapOf("Team A" to 0, "Team B" to -1, "Team D" to 1)
    ),
    TeamStanding(
        team = "Team D",
        played = 6,
        win = 1,
        draw = 1,
        loss = 4,
        goalsFor = 5,
        goalsAgainst = 13,
        points = 4,
        headToHead = mapOf("Team A" to 1, "Team B" to 0, "Team C" to -1)
    )
)