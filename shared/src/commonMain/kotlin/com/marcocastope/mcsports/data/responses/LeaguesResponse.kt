package com.marcocastope.mcsports.data.responses

import com.marcocastope.mcsports.data.LeagueRemote
import kotlinx.serialization.Serializable

@Serializable
internal data class LeaguesResponse(
    val result: List<LeagueRemote>
)
