package com.miniclip.matchsimulator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val matchDay: Int,
    val homeTeam: String,
    val homeTeamStrength: Int,
    val awayTeam: String,
    val awayTeamStrength: Int,
    val homeScore: Int?, // null means not played yet
    val awayScore: Int?,  // null means not played yet
    val matchDate: String,
    val matchTime: String,
    val homeTeamLogo: Int,
    val awayTeamLogo: Int
)