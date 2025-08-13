package com.miniclip.matchsimulator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miniclip.matchsimulator.data.model.MatchEntity

@Database(entities = [MatchEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
}