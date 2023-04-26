package com.marcocastope.mcsports.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LeagueRemote(
    @SerialName("league_key")
    val leagueKey: String,
    @SerialName("league_name")
    val leagueName: String,
    @SerialName("country_key")
    val countryKey: String,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("league_logo")
    val leagueLogo: String?,
    @SerialName("country_logo")
    val countryLogo: String?
)
