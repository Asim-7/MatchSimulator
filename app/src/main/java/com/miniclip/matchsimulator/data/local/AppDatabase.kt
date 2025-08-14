package com.miniclip.matchsimulator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.utils.HeadToHeadConverter

@Database(entities = [MatchEntity::class, TeamStanding::class], version = 1)
@TypeConverters(HeadToHeadConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
    abstract fun teamStandingDao(): TeamStandingDao
}