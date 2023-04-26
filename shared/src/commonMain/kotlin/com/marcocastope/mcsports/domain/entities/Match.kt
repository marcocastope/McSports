package com.marcocastope.mcsports.domain.entities

data class Match(
    val id: String,
    val date: String?,
    val time: String?,
    val homeTeam: String?,
    val awayTeam: String?,
    val finalResult: String?,
    val homeTeamLogo: String?,
    val awayTeamLogo: String?
)
