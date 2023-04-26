package com.marcocastope.mcsports.data.responses

import com.marcocastope.mcsports.data.MatchRemote
import kotlinx.serialization.Serializable

@Serializable
internal data class MatchesResponse(
    val result: List<MatchRemote>
)
