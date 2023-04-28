package com.marcocastope.mcsports.data.responses

import com.marcocastope.mcsports.data.LiveScoreRemote
import kotlinx.serialization.Serializable

@Serializable
internal data class LiveScoreResponse(
    val result: LiveScoreRemote
)
