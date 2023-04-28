package com.marcocastope.mcsports.android.ui.livescore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcocastope.mcsports.domain.usecases.GetLiveScoreDetailsUseCase
import kotlinx.coroutines.launch

class LiveScoreViewModel(private val getLiveScoreDetailsUseCase: GetLiveScoreDetailsUseCase) :
    ViewModel() {

    var detailUiState by mutableStateOf(DetailUiState())
        private set



    fun getLiveScoreDetail(matchId: String) {
        viewModelScope.launch {
            val liveScore = getLiveScoreDetailsUseCase(mathId = matchId)
            detailUiState = detailUiState.copy(liveScore = liveScore.first())
        }
    }
}