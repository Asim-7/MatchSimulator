package com.miniclip.matchsimulator.ui.table

import com.miniclip.matchsimulator.data.remote.DummyData
import com.miniclip.matchsimulator.data.repository.StandingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

@OptIn(ExperimentalCoroutinesApi::class)
class TeamStandingViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var standingsRepository: StandingsRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        standingsRepository = mock(StandingsRepository::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun insertsDummyStandingsIfEmpty() = runTest {
        `when`(standingsRepository.getAllStandings()).thenReturn(flowOf(emptyList()))
        `when`(standingsRepository.getDummyStandings()).thenReturn(DummyData.dummyStandingsData)
        TeamStandingViewModel(standingsRepository)
        testDispatcher.scheduler.advanceUntilIdle() // Ensure all coroutines are executed
        verify(standingsRepository).insertStandings(anyList())
    }

    @Test
    fun clearStandingsAndInsertDummy_callsRepository() = runTest {
        `when`(standingsRepository.getAllStandings()).thenReturn(flowOf(emptyList()))
        `when`(standingsRepository.getDummyStandings()).thenReturn(DummyData.dummyStandingsData)
        val vm = TeamStandingViewModel(standingsRepository)
        vm.clearStandingsAndInsertDummy()
        testDispatcher.scheduler.advanceUntilIdle() // Ensure all coroutines are executed
        verify(standingsRepository).clearStandings()
        verify(standingsRepository, atLeastOnce()).insertStandings(anyList())
    }
}