package com.marcocastope.mcsports.domain.repository

import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.entities.Match

internal interface SportsRepository {
    suspend fun getLeagues(): List<League>
    suspend fun getLivesScore(): List<LiveScore>
    suspend fun getMatches(): List<Match>
}