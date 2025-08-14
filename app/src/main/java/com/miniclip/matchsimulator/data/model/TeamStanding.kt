package com.miniclip.matchsimulator.data.model

data class TeamStanding(
    val team: String,
    val logo: Int, // resource ID for team logo
    val strength: Int, // strength defines win probability against other teams
    val played: Int,
    val win: Int,
    val draw: Int,
    val loss: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val points: Int,
    val headToHead: Map<String, Int?> // team name to result (1=win, 0=draw, -1=loss), null means not played yet
)
