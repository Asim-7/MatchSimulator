package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.model.MatchEntity
import kotlinx.coroutines.flow.Flow

/**
 * MatchRepository interface defines the contract for match data operations.
 */
interface MatchRepository {
    fun getAllMatches(): Flow<List<MatchEntity>>
    suspend fun insertMatches(matches: List<MatchEntity>)
    suspend fun updateMatch(match: MatchEntity)
    suspend fun clearMatches()
    suspend fun getDummyMatches(): List<MatchEntity>
}