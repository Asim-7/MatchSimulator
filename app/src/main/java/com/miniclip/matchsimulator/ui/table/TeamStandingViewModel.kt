package com.miniclip.matchsimulator.ui.table

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.data.repository.StandingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamStandingViewModel @Inject constructor(
    private var repository: StandingsRepository
) : ViewModel() {
    val teamStandings: StateFlow<List<TeamStanding>> =
        repository.getAllStandings().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        ensureDummyDataIfEmpty()
    }

    private fun ensureDummyDataIfEmpty() {
        viewModelScope.launch {
            val localStandings = repository.getAllStandings().first()
            if (localStandings.isEmpty()) {
                val remoteStandings = repository.getDummyStandings()
                repository.insertStandings(remoteStandings)
            }
        }
    }

    fun clearStandingsAndInsertDummy() {
        viewModelScope.launch {
            repository.clearStandings()
            ensureDummyDataIfEmpty()
        }
    }
}