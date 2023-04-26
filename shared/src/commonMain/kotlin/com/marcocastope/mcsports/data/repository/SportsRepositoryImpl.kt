package com.marcocastope.mcsports.data.repository

import com.marcocastope.mcsports.data.SportsDataSource
import com.marcocastope.mcsports.data.util.toLeague
import com.marcocastope.mcsports.data.util.toLiveScore
import com.marcocastope.mcsports.data.util.toMatch
import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.entities.Match
import com.marcocastope.mcsports.domain.repository.SportsRepository

internal class SportsRepositoryImpl(
    private val dataSource: SportsDataSource
) : SportsRepository {
    override suspend fun getLeagues(): List<League> {
        return dataSource.getLeagues().result.map { it.toLeague() }
    }

    override suspend fun getLivesScore(): List<LiveScore> {
        return dataSource.getLivesScore().result.map { it.toLiveScore() }
    }

    override suspend fun getMatches(): List<Match> {
        return dataSource.getMatches().result.map { it.toMatch() }
    }
}