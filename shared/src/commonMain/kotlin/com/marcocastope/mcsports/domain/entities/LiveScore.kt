package com.marcocastope.mcsports.domain.entities

data class LiveScore(
    val id: Int,
    val date: String?,
    val time: String?,
    val homeTeam: String,
    val awayTeam: String,
    val homeTeamLogo: String?,
    val awayTeamLogo: String?,
    val leagueLogo: String?,
    val leagueName: String?,
    val leagueRound: String?,
    val finalResult: String?
)
