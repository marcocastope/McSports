package com.marcocastope.mcsports.data

import com.marcocastope.mcsports.data.responses.LeaguesResponse
import com.marcocastope.mcsports.data.responses.LiveScoreResponse
import com.marcocastope.mcsports.data.responses.LivesScoreResponse
import com.marcocastope.mcsports.data.responses.MatchesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class SportsApiService : KtorApi() {

    suspend fun getLeagues(): LeaguesResponse = client.get {
        pathUrl("football", "Leagues")
        parameter("countryId", "7")
        parameter("countryId", "6")
    }.body()

    suspend fun getLivesScore(): LivesScoreResponse = client.get {
        pathUrl("football", "Livescore")
    }.body()

    suspend fun getMatches(): MatchesResponse = client.get {
        pathUrl("football", "Fixtures")
        parameter("timezone", "America/New_York")
        parameter("from", "2023-04-25")
        parameter("to", "2023-04-30")
    }.body()

    suspend fun getLiveScoreDetails(matchId: String): LivesScoreResponse = client.get {
        pathUrl("football", "Livescore")
        parameter("matchId", matchId)
    }.body()
}