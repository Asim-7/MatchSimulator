package com.miniclip.matchsimulator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val matchDay: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: Int?, // null means not played yet
    val awayScore: Int?  // null means not played yet
)