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
        val match = DummyData.matches
        matchDao.insertMatches(match)
        val result = matchDao.getAllMatches().first()
        Assert.assertEquals(match[0].matchTime, result[0].matchTime)
    }

    @Test
    fun insertAndGetTeamStanding() = runBlocking {
        val standing = DummyData.dummyStandingsData
        teamStandingDao.insert(standing)
        val result = teamStandingDao.getAll().first()
        Assert.assertEquals(standing[0].team, result[0].team)
    }
}