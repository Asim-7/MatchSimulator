package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.utils.simulateMatch
import com.miniclip.matchsimulator.utils.updateTeamStandingsAfterMatch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for updating a match and the corresponding team standings.
 * This use case handles the logic of updating a match in the repository
 * and recalculating the standings based on the updated match data.
 * Also provides functionality to show a loader while the match is being processed
 * and to reset all matches and standings to their initial dummy state.
 */
class UpdateMatchAndStandingsUseCase @Inject constructor(
    private val matchRepository: MatchRepository,
    private val standingsRepository: StandingsRepository
) {

    private val _showLoader = MutableStateFlow(false)
    val showLoader: StateFlow<Boolean> = _showLoader.asStateFlow()

    private val _selectedMatch = MutableStateFlow<MatchEntity?>(null)

    private suspend fun updateMatchAndStandings(updatedMatch: MatchEntity) {
        matchRepository.updateMatch(updatedMatch)
        val standings = standingsRepository.getAllStandings().first()
        val result = updateTeamStandingsAfterMatch(updatedMatch, standings)
        result?.let { (updatedHome, updatedAway) ->
            standingsRepository.updateStandings(updatedHome)
            standingsRepository.updateStandings(updatedAway)
        }
    }

    suspend fun resetAll() {
        matchRepository.clearMatches()
        matchRepository.insertMatches(matchRepository.getDummyMatches())
        standingsRepository.clearStandings()
        standingsRepository.insertStandings(standingsRepository.getDummyStandings())
    }

    fun showLoaderForMatch(match: MatchEntity) {
        _showLoader.value = true
        _selectedMatch.value = match
    }

    suspend fun hideLoaderAndHandleMatch() {
        _selectedMatch.value?.let { onMatchClick(it) }
        _showLoader.value = false
        _selectedMatch.value = null
    }

    private suspend fun onMatchClick(match: MatchEntity) {
        val (homeScore, awayScore) = simulateMatch(
            match.homeTeamStrength,
            match.awayTeamStrength
        )
        val updatedMatch = match.copy(homeScore = homeScore, awayScore = awayScore)
        updateMatchAndStandings(updatedMatch)
    }
}