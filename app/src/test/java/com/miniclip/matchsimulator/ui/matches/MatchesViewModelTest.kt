package com.miniclip.matchsimulator.ui.matches

import com.miniclip.matchsimulator.data.remote.DummyData
import com.miniclip.matchsimulator.data.repository.MatchRepository
import com.miniclip.matchsimulator.data.repository.MatchAndStandingsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After

@OptIn(ExperimentalCoroutinesApi::class)
class MatchesViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var matchRepository: MatchRepository
    private lateinit var updateUseCase: MatchAndStandingsUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        matchRepository = mock(MatchRepository::class.java)
        updateUseCase = mock(MatchAndStandingsUseCase::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun insertsDummyMatchesIfEmpty() = runTest {
        `when`(matchRepository.getAllMatches()).thenReturn(flowOf(emptyList()))
        `when`(matchRepository.getDummyMatches()).thenReturn(DummyData.matches)
        MatchesViewModel(matchRepository, updateUseCase)
        testDispatcher.scheduler.advanceUntilIdle() // Ensure all coroutines are executed
        verify(matchRepository).insertMatches(anyList())
    }

    @Test
    fun clearMatchesAndInsertDummy_callsRepository() = runTest {
        `when`(matchRepository.getAllMatches()).thenReturn(flowOf(emptyList()))
        `when`(matchRepository.getDummyMatches()).thenReturn(DummyData.matches)
        val vm = MatchesViewModel(matchRepository, updateUseCase)
        vm.clearMatchesAndInsertDummy()
        testDispatcher.scheduler.advanceUntilIdle() // Ensure all coroutines are executed
        verify(matchRepository).clearMatches()
        verify(matchRepository, atLeastOnce()).insertMatches(anyList())
    }
}