package com.miniclip.matchsimulator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.miniclip.matchsimulator.utils.HeadToHeadConverter

@Entity(tableName = "team_standing")
@TypeConverters(HeadToHeadConverter::class)
data class TeamStanding(
    @PrimaryKey val team: String,
    val logo: Int,
    val strength: Int,
    val played: Int = 0,
    val win: Int = 0,
    val draw: Int = 0,
    val loss: Int = 0,
    val goalsFor: Int = 0,
    val goalsAgainst: Int = 0,
    val points: Int = 0,
    val headToHead: Map<String, Int?> = emptyMap()
)
