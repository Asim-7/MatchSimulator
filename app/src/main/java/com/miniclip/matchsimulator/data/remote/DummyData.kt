package com.miniclip.matchsimulator.data.remote

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.R

object DummyData {
    val matches = listOf(
        MatchEntity(
            matchDay = 1,
            homeTeam = "Team A",
            awayTeam = "Team B",
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        ),
        MatchEntity(
            matchDay = 1,
            homeTeam = "Team C",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Team A",
            awayTeam = "Team C",
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Team B",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "Team A",
            awayTeam = "Team D",
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "Team B",
            awayTeam = "Team C",
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.ic_profile,
            awayTeamLogo = R.drawable.ic_reset
        )
    )
}