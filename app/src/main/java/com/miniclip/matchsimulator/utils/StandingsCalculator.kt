package com.miniclip.matchsimulator.utils

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.data.model.TeamStanding

/**
 * Updates the team standings after a match is played.
 *
 * @param match The match that was played.
 * @param standings The current standings of the teams.
 * @return A pair of updated standings for the home and away teams, or null if no update was needed.
 */
suspend fun updateTeamStandingsAfterMatch(
    match: MatchEntity,
    standings: List<TeamStanding>
): Pair<TeamStanding, TeamStanding>? {
    val homeStanding = standings.find { it.team == match.homeTeam }
    val awayStanding = standings.find { it.team == match.awayTeam }

    if (homeStanding != null && awayStanding != null && match.homeScore != null && match.awayScore != null) {
        val homeHeadToHead = homeStanding.headToHead.toMutableMap()
        val awayHeadToHead = awayStanding.headToHead.toMutableMap()

        val previousResult = homeHeadToHead[match.awayTeam]
        var homePlayed = homeStanding.played
        var awayPlayed = awayStanding.played
        var homeWin = homeStanding.win
        var homeDraw = homeStanding.draw
        var homeLoss = homeStanding.loss
        var homePoints = homeStanding.points
        var homeGoalsFor = homeStanding.goalsFor
        var homeGoalsAgainst = homeStanding.goalsAgainst

        var awayWin = awayStanding.win
        var awayDraw = awayStanding.draw
        var awayLoss = awayStanding.loss
        var awayPoints = awayStanding.points
        var awayGoalsFor = awayStanding.goalsFor
        var awayGoalsAgainst = awayStanding.goalsAgainst

        // If there was a previous result, need to revert it before applying the new match result.
        if (previousResult != null) {
            homePlayed -= 1
            awayPlayed -= 1

            val prevHomeScore = homeHeadToHead["${match.awayTeam}_score"] ?: 0
            val prevAwayScore = awayHeadToHead["${match.homeTeam}_score"] ?: 0

            homeGoalsFor -= prevHomeScore
            homeGoalsAgainst -= prevAwayScore
            awayGoalsFor -= prevAwayScore
            awayGoalsAgainst -= prevHomeScore

            when (previousResult) {
                1 -> {
                    homeWin -= 1
                    homePoints -= 3
                    awayLoss -= 1
                }
                -1 -> {
                    awayWin -= 1
                    awayPoints -= 3
                    homeLoss -= 1
                }
                0 -> {
                    homeDraw -= 1
                    awayDraw -= 1
                    homePoints -= 1
                    awayPoints -= 1
                }
            }
        }

        homePlayed += 1
        awayPlayed += 1
        homeGoalsFor += match.homeScore
        homeGoalsAgainst += match.awayScore
        awayGoalsFor += match.awayScore
        awayGoalsAgainst += match.homeScore

        when {
            match.homeScore > match.awayScore -> {
                homeWin += 1
                homePoints += 3
                awayLoss += 1
                homeHeadToHead[match.awayTeam] = 1
                awayHeadToHead[match.homeTeam] = -1
            }
            match.homeScore < match.awayScore -> {
                awayWin += 1
                awayPoints += 3
                homeLoss += 1
                homeHeadToHead[match.awayTeam] = -1
                awayHeadToHead[match.homeTeam] = 1
            }
            else -> {
                homeDraw += 1
                awayDraw += 1
                homePoints += 1
                awayPoints += 1
                homeHeadToHead[match.awayTeam] = 0
                awayHeadToHead[match.homeTeam] = 0
            }
        }

        // Update head-to-head scores
        homeHeadToHead["${match.awayTeam}_score"] = match.homeScore
        awayHeadToHead["${match.homeTeam}_score"] = match.awayScore

        // Create updated standings
        val updatedHome = homeStanding.copy(
            played = homePlayed,
            win = homeWin,
            draw = homeDraw,
            loss = homeLoss,
            goalsFor = homeGoalsFor,
            goalsAgainst = homeGoalsAgainst,
            points = homePoints,
            headToHead = homeHeadToHead
        )
        val updatedAway = awayStanding.copy(
            played = awayPlayed,
            win = awayWin,
            draw = awayDraw,
            loss = awayLoss,
            goalsFor = awayGoalsFor,
            goalsAgainst = awayGoalsAgainst,
            points = awayPoints,
            headToHead = awayHeadToHead
        )

        return Pair(updatedHome, updatedAway)
    }
    return null
}