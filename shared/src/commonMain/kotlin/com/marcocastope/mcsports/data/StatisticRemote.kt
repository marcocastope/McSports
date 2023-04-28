package com.marcocastope.mcsports.data

import kotlinx.serialization.Serializable

@Serializable
internal data class StatisticRemote(
    val type: String,
    val home: String,
    val away: String
)
