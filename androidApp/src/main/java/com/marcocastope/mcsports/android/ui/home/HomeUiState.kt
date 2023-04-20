package com.marcocastope.mcsports.android.ui.home

import com.marcocastope.mcsports.domain.entities.League

data class HomeUiState(
    val leagues: List<League> = listOf()
)
