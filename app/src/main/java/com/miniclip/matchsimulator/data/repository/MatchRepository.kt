package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.model.MatchEntity
import kotlinx.coroutines.flow.Flow

interface MatchRepository {
    fun getAllMatches(): Flow<List<MatchEntity>>
    suspend fun insertMatches(matches: List<MatchEntity>)
    suspend fun clearMatches()
    suspend fun getDummyMatches(): List<MatchEntity>
}