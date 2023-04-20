package com.marcocastope.mcsports.domain.repository

import com.marcocastope.mcsports.domain.entities.League

internal interface SportsRepository {
    suspend fun getLeagues(): List<League>
}