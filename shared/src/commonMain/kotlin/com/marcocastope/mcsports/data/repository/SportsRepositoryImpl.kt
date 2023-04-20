package com.marcocastope.mcsports.data.repository

import com.marcocastope.mcsports.data.SportsDataSource
import com.marcocastope.mcsports.data.util.toLeague
import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.repository.SportsRepository

internal class SportsRepositoryImpl(
    private val dataSource: SportsDataSource
) : SportsRepository {
    override suspend fun getLeagues(): List<League> {
        return dataSource.getLeagues().result.map { it.toLeague() }
    }
}