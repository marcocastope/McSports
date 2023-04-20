package com.marcocastope.mcsports.domain.entities

data class League(
    val id: Int,
    val name: String,
    val countryID: Int,
    val countryName: String,
    val leagueLogo: String?,
    val countryLogo: String?
)
