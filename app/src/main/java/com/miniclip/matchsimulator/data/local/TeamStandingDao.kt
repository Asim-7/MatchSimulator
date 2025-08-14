package com.miniclip.matchsimulator.data.local
import androidx.room.*
import com.miniclip.matchsimulator.data.model.TeamStanding
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamStandingDao {
    @Query("SELECT * FROM team_standing")
    fun getAll(): Flow<List<TeamStanding>>

    @Query("SELECT * FROM team_standing WHERE team = :teamName")
    suspend fun getByTeam(teamName: String): TeamStanding

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teamStandings: List<TeamStanding>)

    @Update
    suspend fun update(teamStanding: TeamStanding)

    @Query("DELETE FROM team_standing")
    suspend fun clear()
}