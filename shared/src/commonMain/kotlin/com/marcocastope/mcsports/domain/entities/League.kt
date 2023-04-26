package com.marcocastope.mcsports.domain.entities

data class League(
    val id: String,
    val name: String,
    val countryID: String,
    val countryName: String,
    val leagueLogo: String?,
    val countryLogo: String?
)
