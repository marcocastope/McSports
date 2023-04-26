package com.marcocastope.mcsports.android.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcocastope.mcsports.domain.usecases.GetLivesScoreUseCase
import com.marcocastope.mcsports.domain.usecases.GetMatchesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getLivesScoreUseCase: GetLivesScoreUseCase,
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    var homeUiState by mutableStateOf(HomeUiState())

    init {
        viewModelScope.launch {
            val livesScore = getLivesScoreUseCase()
            val matches = getMatchesUseCase()
            homeUiState = homeUiState.copy(
                livesScore = livesScore,
                matches = matches,
                loading = livesScore.isEmpty()
            )
        }
    }
}