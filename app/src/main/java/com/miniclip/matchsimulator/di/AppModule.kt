package com.miniclip.matchsimulator.di

import android.app.Application
import androidx.room.Room
import com.miniclip.matchsimulator.data.local.AppDatabase
import com.miniclip.matchsimulator.data.local.MatchDao
import com.miniclip.matchsimulator.data.repository.MatchRepository
import com.miniclip.matchsimulator.data.repository.MatchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "matches.db").build()

    @Provides
    fun provideMatchDao(db: AppDatabase): MatchDao = db.matchDao()

    @Provides
    @Singleton
    fun provideMatchRepository(matchDao: MatchDao): MatchRepository =
        MatchRepositoryImpl(matchDao)
}