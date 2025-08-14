package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.local.TeamStandingDao
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StandingsRepositoryImpl @Inject constructor(
    private val standingsDao: TeamStandingDao
) : StandingsRepository {

    override fun getAllStandings() : Flow<List<TeamStanding>> = standingsDao.getAll()

    override suspend fun getTeamStanding(teamName: String): TeamStanding {
        return standingsDao.getByTeam(teamName)
    }

    override suspend fun insertStandings(teamStandings: List<TeamStanding>) {
        standingsDao.insert(teamStandings)
    }

    override suspend fun updateStandings(teamStanding: TeamStanding) {
        standingsDao.update(teamStanding)
    }

    override suspend fun clearStandings() {
        standingsDao.clear()
    }

    override suspend fun getDummyStandings(): List<TeamStanding> {
        return DummyData.dummyStandingsData
    }
}