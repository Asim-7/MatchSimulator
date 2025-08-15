package com.miniclip.matchsimulator.di

import com.miniclip.matchsimulator.data.model.MatchEntity
import com.miniclip.matchsimulator.data.model.TeamStanding
import com.miniclip.matchsimulator.data.remote.DummyData
import com.miniclip.matchsimulator.data.repository.MatchRepository
import com.miniclip.matchsimulator.data.repository.StandingsRepository
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import dagger.Module
import dagger.Provides

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object FakeRepositoryModule {

    @Provides
    fun provideFakeMatchesRepository(): MatchRepository =
        object : MatchRepository {
            override fun getAllMatches(): Flow<List<MatchEntity>> = flowOf(DummyData.matches)
            override suspend fun insertMatches(matches: List<MatchEntity>) {}
            override suspend fun updateMatch(match: MatchEntity) {}
            override suspend fun clearMatches() {}
            override suspend fun getDummyMatches(): List<MatchEntity> = emptyList()
        }

    @Provides
    fun provideFakeTeamStandingsRepository(): StandingsRepository =
        object : StandingsRepository {
            override fun getAllStandings(): Flow<List<TeamStanding>> =
                flowOf(DummyData.dummyStandingsData)
            override suspend fun getTeamStanding(teamName: String): TeamStanding =
                DummyData.dummyStandingsData.first()
            override suspend fun insertStandings(teamStandings: List<TeamStanding>) {}
            override suspend fun updateStandings(teamStanding: TeamStanding) {}
            override suspend fun clearStandings() {}
            override suspend fun getDummyStandings(): List<TeamStanding> = emptyList()
        }
}
