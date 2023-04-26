package com.marcocastope.mcsports.android.ui.home

import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.entities.Match

data class HomeUiState(
    val livesScore: List<LiveScore> = listOf(),
    val matches: List<Match> = listOf(),
    val loading: Boolean = true
)
