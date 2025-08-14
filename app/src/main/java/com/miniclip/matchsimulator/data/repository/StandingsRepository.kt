package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.model.TeamStanding
import kotlinx.coroutines.flow.Flow

interface StandingsRepository {
    fun getAllStandings(): Flow<List<TeamStanding>>
    suspend fun getTeamStanding(teamName: String): TeamStanding
    suspend fun insertStandings(teamStandings: List<TeamStanding>)
    suspend fun updateStandings(teamStanding: TeamStanding)
    suspend fun clearStandings()
    suspend fun getDummyStandings(): List<TeamStanding>
}