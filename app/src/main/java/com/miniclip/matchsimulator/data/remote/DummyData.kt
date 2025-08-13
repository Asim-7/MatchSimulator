package com.miniclip.matchsimulator.data.remote

import com.miniclip.matchsimulator.data.model.MatchEntity

object DummyData {
    val matches = listOf(
        MatchEntity(
            matchDay = 1,
            homeTeam = "Team A",
            awayTeam = "Team B",
            homeScore = null,
            awayScore = null
        ),
        MatchEntity(
            matchDay = 1,
            homeTeam = "Team C",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Team A",
            awayTeam = "Team C",
            homeScore = null,
            awayScore = null
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Team B",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "Team A",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "Team B",
            awayTeam = "Team C",
            homeScore = null,
            awayScore = null
        )
    )
}