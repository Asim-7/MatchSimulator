package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.local.TeamStandingDao
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class StandingsRepositoryImplTest {

    private lateinit var standingsDao: TeamStandingDao
    private lateinit var repository: StandingsRepositoryImpl

    @Before
    fun setUp() {
        standingsDao = mock(TeamStandingDao::class.java)
        repository = StandingsRepositoryImpl(standingsDao)
    }

    @Test
    fun getAllStandings_returnsFlow() {
        val standings = DummyData.dummyStandingsData
        `when`(standingsDao.getAll()).thenReturn(flowOf(standings))
        val result = repository.getAllStandings()
        assertEquals(standings, runBlocking { result.first() })
    }

    @Test
    fun getTeamStanding_returnsDaoResult() = runBlocking {
        val team = "TeamA"
        val standing = DummyData.dummyStandingsData.first()
        `when`(standingsDao.getByTeam(team)).thenReturn(standing)
        val result = repository.getTeamStanding(team)
        assertEquals(standing, result)
    }

    @Test
    fun insertStandings_callsDao() = runBlocking {
        val standings = DummyData.dummyStandingsData
        repository.insertStandings(standings)
        verify(standingsDao).insert(standings)
    }

    @Test
    fun updateStandings_callsDao() = runBlocking {
        val standing = DummyData.dummyStandingsData.first()
        repository.updateStandings(standing)
        verify(standingsDao).update(standing)
    }

    @Test
    fun clearStandings_callsDao() = runBlocking {
        repository.clearStandings()
        verify(standingsDao).clear()
    }

    @Test
    fun getDummyStandings_returnsDummyData() = runBlocking {
        val result = repository.getDummyStandings()
        assertEquals(DummyData.dummyStandingsData, result)
    }
}