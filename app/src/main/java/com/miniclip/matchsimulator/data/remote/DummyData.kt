package com.miniclip.matchsimulator.data.remote

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.data.model.TeamInfo
import com.miniclip.matchsimulator.data.model.TeamStanding

object DummyData {

    private const val FIRST_TIME = "18:30 CET"
    private const val SECOND_TIME = "21:00 CET"

    private val teamInfo = listOf(
        TeamInfo(
            name = "Ajax",
            logo = R.drawable.ajax,
            strength = 88
        ),
        TeamInfo(
            name = "PSV",
            logo = R.drawable.psv,
            strength = 84
        ),
        TeamInfo(
            name = "Feyenoord",
            logo = R.drawable.feyenoord,
            strength = 78
        ),
        TeamInfo(
            name = "Utrecht",
            logo = R.drawable.utrecht,
            strength = 72
        )
    )

    val matches = listOf(
        MatchEntity(
            matchDay = 1,
            homeTeam = teamInfo[0].name,
            homeTeamStrength = teamInfo[0].strength,
            awayTeam = teamInfo[1].name,
            awayTeamStrength = teamInfo[1].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = FIRST_TIME,
            homeTeamLogo = teamInfo[0].logo,
            awayTeamLogo = teamInfo[1].logo
        ),
        MatchEntity(
            matchDay = 1,
            homeTeam = teamInfo[2].name,
            homeTeamStrength = teamInfo[2].strength,
            awayTeam = teamInfo[3].name,
            awayTeamStrength = teamInfo[3].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "10/10/2025",
            matchTime = SECOND_TIME,
            homeTeamLogo = teamInfo[2].logo,
            awayTeamLogo = teamInfo[3].logo
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = teamInfo[3].name,
            homeTeamStrength = teamInfo[3].strength,
            awayTeam = teamInfo[1].name,
            awayTeamStrength = teamInfo[1].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = FIRST_TIME,
            homeTeamLogo = teamInfo[3].logo,
            awayTeamLogo = teamInfo[1].logo
        ),
        MatchEntity(
            matchDay = 2,
            homeTeam = teamInfo[2].name,
            homeTeamStrength = teamInfo[2].strength,
            awayTeam = teamInfo[0].name,
            awayTeamStrength = teamInfo[0].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "12/10/2025",
            matchTime = SECOND_TIME,
            homeTeamLogo = teamInfo[2].logo,
            awayTeamLogo = teamInfo[0].logo
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = teamInfo[0].name,
            homeTeamStrength = teamInfo[0].strength,
            awayTeam = teamInfo[3].name,
            awayTeamStrength = teamInfo[3].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = FIRST_TIME,
            homeTeamLogo = teamInfo[0].logo,
            awayTeamLogo = teamInfo[3].logo
        ),
        MatchEntity(
            matchDay = 3,
            homeTeam = teamInfo[1].name,
            homeTeamStrength = teamInfo[1].strength,
            awayTeam = teamInfo[2].name,
            awayTeamStrength = teamInfo[2].strength,
            homeScore = null,
            awayScore = null,
            matchDate = "14/10/2025",
            matchTime = SECOND_TIME,
            homeTeamLogo = teamInfo[1].logo,
            awayTeamLogo = teamInfo[2].logo
        )
    )

    val dummyStandingsData = listOf(
        TeamStanding(
            team = teamInfo[0].name,
            logo = teamInfo[0].logo,
            strength = teamInfo[0].strength,
        ),
        TeamStanding(
            team = teamInfo[1].name,
            logo = teamInfo[1].logo,
            strength = teamInfo[1].strength,
        ),
        TeamStanding(
            team = teamInfo[2].name,
            logo = teamInfo[2].logo,
            strength = teamInfo[2].strength,
        ),
        TeamStanding(
            team = teamInfo[3].name,
            logo = teamInfo[3].logo,
            strength = teamInfo[3].strength,
        )
    )
}