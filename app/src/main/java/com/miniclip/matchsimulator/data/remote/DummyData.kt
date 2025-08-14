package com.miniclip.matchsimulator.data.remote

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.R

object DummyData {
    val matches = listOf(
        MatchEntity(
            matchDay = 1,
            homeTeam = "Ajax",
            homeTeamStrength = 85,
            awayTeam = "PSV",
            awayTeamStrength = 82,
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.ajax,
            awayTeamLogo = R.drawable.psv
        ),
        MatchEntity(
            matchDay = 1,
            homeTeam = "Feyenoord",
            homeTeamStrength = 80,
            awayTeam = "Utrecht",
            awayTeamStrength = 75,
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.feyenoord,
            awayTeamLogo = R.drawable.utrecht
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Utrecht",
            homeTeamStrength = 75,
            awayTeam = "PSV",
            awayTeamStrength = 82,
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.utrecht,
            awayTeamLogo = R.drawable.psv
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = "Feyenoord",
            homeTeamStrength = 80,
            awayTeam = "Ajax",
            awayTeamStrength = 85,
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.feyenoord,
            awayTeamLogo = R.drawable.ajax
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "Ajax",
            homeTeamStrength = 85,
            awayTeam = "Utrecht",
            awayTeamStrength = 75,
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = "18:30 CET",
            homeTeamLogo = R.drawable.ajax,
            awayTeamLogo = R.drawable.utrecht
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = "PSV",
            homeTeamStrength = 82,
            awayTeam = "Feyenoord",
            awayTeamStrength = 80,
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = "21:00 CET",
            homeTeamLogo = R.drawable.psv,
            awayTeamLogo = R.drawable.feyenoord
        )
    )
}