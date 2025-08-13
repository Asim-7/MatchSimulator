package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.local.MatchDao
import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao
) : MatchRepository {

    override fun getAllMatches(): Flow<List<MatchEntity>> {
        return matchDao.getAllMatches()
    }

    override suspend fun insertMatches(matches: List<MatchEntity>) {
        matchDao.insertMatches(matches)
    }

    override suspend fun clearMatches() {
        matchDao.clearMatches()
    }

    override suspend fun getDummyMatches(): List<MatchEntity> {
        // Simulate remote fetch
        return DummyData.matches
    }
}