package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.local.MatchDao
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MatchRepositoryImplTest {

    private lateinit var matchDao: MatchDao
    private lateinit var repository: MatchRepositoryImpl

    @Before
    fun setUp() {
        matchDao = mock(MatchDao::class.java)
        repository = MatchRepositoryImpl(matchDao)
    }

    @Test
    fun getAllMatches_returnsFlow() {
        val matches = DummyData.matches
        `when`(matchDao.getAllMatches()).thenReturn(flowOf(matches))
        val result = repository.getAllMatches()
        assertEquals(matches, runBlocking { result.first() })
    }

    @Test
    fun insertMatches_callsDao() = runBlocking {
        val matches = DummyData.matches
        repository.insertMatches(matches)
        verify(matchDao).insertMatches(matches)
    }

    @Test
    fun updateMatch_callsDao() = runBlocking {
        val match = DummyData.matches.first()
        repository.updateMatch(match)
        verify(matchDao).updateMatch(match)
    }

    @Test
    fun clearMatches_callsDao() = runBlocking {
        repository.clearMatches()
        verify(matchDao).clearMatches()
    }

    @Test
    fun getDummyMatches_returnsDummyData() = runBlocking {
        val result = repository.getDummyMatches()
        assertEquals(DummyData.matches, result)
    }
}