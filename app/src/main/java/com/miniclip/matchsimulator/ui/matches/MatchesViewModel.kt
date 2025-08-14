package com.miniclip.matchsimulator.ui.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.data.repository.MatchRepository
import com.miniclip.matchsimulator.data.repository.UpdateMatchAndStandingsUseCase
import com.miniclip.matchsimulator.utils.simulateMatch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val repository: MatchRepository,
    private val updateMatchAndStandingsUseCase: UpdateMatchAndStandingsUseCase
) : ViewModel() {

    val matches: StateFlow<List<MatchEntity>> =
        repository.getAllMatches().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        ensureDummyDataIfEmpty()
    }

    private fun ensureDummyDataIfEmpty() {
        viewModelScope.launch {
            // Collect the current state of matches
            val localMatches = repository.getAllMatches().first()
            if (localMatches.isEmpty()) {
                val remoteMatches = repository.getDummyMatches()
                repository.insertMatches(remoteMatches)
            }
        }
    }

    fun clearMatchesAndInsertDummy() {
        viewModelScope.launch {
            repository.clearMatches()
            ensureDummyDataIfEmpty()
        }
    }

    fun onMatchClick(match: MatchEntity) {
        viewModelScope.launch {
            val (homeScore, awayScore) = simulateMatch(
                match.homeTeamStrength,
                match.awayTeamStrength
            )
            val updatedMatch = match.copy(homeScore = homeScore, awayScore = awayScore)
            updateMatchAndStandingsUseCase.updateMatchAndStandings(updatedMatch)
        }
    }
}