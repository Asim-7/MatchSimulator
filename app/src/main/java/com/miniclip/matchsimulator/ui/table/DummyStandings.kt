package com.miniclip.matchsimulator.ui.table

import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.data.model.TeamStanding

val dummyStandings = listOf(
    TeamStanding(
        team = "Ajax",
        logo = R.drawable.ajax,
        strength = 88,
        played = 6,
        win = 4,
        draw = 1,
        loss = 1,
        goalsFor = 12,
        goalsAgainst = 6,
        points = 13,
        headToHead = mapOf("PSV" to 1, "Feyenoord" to 0, "Utrecht" to -1)
    ),
    TeamStanding(
        team = "PSV",
        logo = R.drawable.psv,
        strength = 84,
        played = 6,
        win = 3,
        draw = 2,
        loss = 1,
        goalsFor = 10,
        goalsAgainst = 7,
        points = 11,
        headToHead = mapOf("Ajax" to -1, "Feyenoord" to 1, "Utrecht" to 0)
    ),
    TeamStanding(
        team = "Feyenoord",
        logo = R.drawable.feyenoord,
        strength = 78,
        played = 6,
        win = 2,
        draw = 2,
        loss = 2,
        goalsFor = 8,
        goalsAgainst = 9,
        points = 8,
        headToHead = mapOf("Ajax" to 0, "PSV" to -1, "Utrecht" to 1)
    ),
    TeamStanding(
        team = "Utrecht",
        logo = R.drawable.utrecht,
        strength = 72,
        played = 6,
        win = 1,
        draw = 1,
        loss = 4,
        goalsFor = 5,
        goalsAgainst = 13,
        points = 4,
        headToHead = mapOf("Feyenoord" to 1, "PSV" to 0, "Ajax" to -1)
    )
)