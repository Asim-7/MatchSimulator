package com.miniclip.matchsimulator.data.repository

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.utils.updateTeamStandingsAfterMatch
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for updating a match and the corresponding team standings.
 * This use case handles the logic of updating a match in the repository
 * and recalculating the standings based on the updated match data.
 */
class UpdateMatchAndStandingsUseCase @Inject constructor(
    private val matchRepository: MatchRepository,
    private val standingsRepository: StandingsRepository
) {
    suspend fun updateMatchAndStandings(updatedMatch: MatchEntity) {
        matchRepository.updateMatch(updatedMatch)
        val standings = standingsRepository.getAllStandings().first()
        val result = updateTeamStandingsAfterMatch(updatedMatch, standings)
        result?.let { (updatedHome, updatedAway) ->
            standingsRepository.updateStandings(updatedHome)
            standingsRepository.updateStandings(updatedAway)
        }
    }
}