package com.miniclip.matchsimulator.local

import androidx.test.core.app.ApplicationProvider
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.miniclip.matchsimulator.data.local.AppDatabase
import com.miniclip.matchsimulator.data.local.MatchDao
import com.miniclip.matchsimulator.data.local.TeamStandingDao
import com.miniclip.matchsimulator.data.remote.DummyData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var db: AppDatabase
    private lateinit var matchDao: MatchDao
    private lateinit var teamStandingDao: TeamStandingDao

    @Before
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        matchDao = db.matchDao()
        teamStandingDao = db.teamStandingDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertAndGetMatchEntity() = runBlocking {
        val matches = DummyData.matches
        matchDao.insertMatches(matches)
        val result = matchDao.getAllMatches().first()
        Assert.assertEquals(matches.size, result.size)
        Assert.assertEquals(matches[0].matchTime, result[0].matchTime)
    }

    /*@Test
    fun updateMatchEntity() = runBlocking {
        val matches = DummyData.matches
        matchDao.insertMatches(matches)
        val updated = matches[0].copy(matchTime = "Updated Time")
        matchDao.updateMatch(updated)
        val result = matchDao.getAllMatches().first()
        Assert.assertEquals("Updated Time", result[0].matchTime)
    }*/

    @Test
    fun clearMatches() = runBlocking {
        matchDao.insertMatches(DummyData.matches)
        matchDao.clearMatches()
        val result = matchDao.getAllMatches().first()
        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun insertAndGetTeamStanding() = runBlocking {
        val standings = DummyData.dummyStandingsData
        teamStandingDao.insert(standings)
        val result = teamStandingDao.getAll().first()
        Assert.assertEquals(standings.size, result.size)
        Assert.assertEquals(standings[0].team, result[0].team)
    }

    @Test
    fun updateTeamStanding() = runBlocking {
        val standings = DummyData.dummyStandingsData
        teamStandingDao.insert(standings)
        val updated = standings[0].copy(points = standings[0].points + 1)
        teamStandingDao.update(updated)
        val result = teamStandingDao.getAll().first()
        Assert.assertEquals(standings[0].points + 1, result[0].points)
    }

    @Test
    fun clearTeamStandings() = runBlocking {
        teamStandingDao.insert(DummyData.dummyStandingsData)
        teamStandingDao.clear()
        val result = teamStandingDao.getAll().first()
        Assert.assertTrue(result.isEmpty())
    }
}