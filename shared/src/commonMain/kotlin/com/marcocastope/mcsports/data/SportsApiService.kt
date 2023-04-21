package com.marcocastope.mcsports.data

import com.marcocastope.mcsports.data.responses.LeaguesResponse
import com.marcocastope.mcsports.data.responses.LivesScoreResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class SportsApiService : KtorApi() {

    suspend fun getLeagues(): LeaguesResponse = client.get {
        pathUrl("football", "Leagues")
    }.body()

    suspend fun getLivesScore(): LivesScoreResponse = client.get {
        pathUrl("football", "Livescore")
    }.body()
}