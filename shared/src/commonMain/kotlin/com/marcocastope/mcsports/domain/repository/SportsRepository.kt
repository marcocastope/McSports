package com.marcocastope.mcsports.domain.repository

import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore

internal interface SportsRepository {
    suspend fun getLeagues(): List<League>
    suspend fun getLivesScore(): List<LiveScore>
}