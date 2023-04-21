package com.marcocastope.mcsports.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LiveScoreRemote(
    @SerialName("event_key")
    val eventKey: Int,
    @SerialName("event_date")
    val eventDate: String?,
    @SerialName("event_time")
    val eventTime: String?,
    @SerialName("event_home_team")
    val homeTeam: String,
    @SerialName("event_away_team")
    val awayTeam: String,
    @SerialName("home_team_logo")
    val homeTeamLogo: String?,
    @SerialName("away_team_logo")
    val awayTeamLogo: String?,
    @SerialName("league_logo")
    val leagueLogo: String?,
    @SerialName("league_name")
    val leagueName: String?,
    @SerialName("league_round")
    val leagueRound: String?,
    @SerialName("event_final_result")
    val eventFinalResult: String?
)
