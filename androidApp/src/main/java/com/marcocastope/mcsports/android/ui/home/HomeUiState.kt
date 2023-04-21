package com.marcocastope.mcsports.android.ui.home

import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore

data class HomeUiState(
    val leagues: List<League> = listOf(),
    val livesScore: List<LiveScore> = listOf(),
    val loading: Boolean = true
)
