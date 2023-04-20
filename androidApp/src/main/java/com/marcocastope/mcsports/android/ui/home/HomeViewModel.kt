package com.marcocastope.mcsports.android.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcocastope.mcsports.domain.usecases.GetLeaguesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getLeaguesUseCase: GetLeaguesUseCase) : ViewModel() {

    var homeUiState by mutableStateOf(HomeUiState())

    init {
        viewModelScope.launch {
            val leagues = getLeaguesUseCase()
            homeUiState = homeUiState.copy(leagues = leagues)
        }
    }
}