package com.marcocastope.mcsports.android.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues, viewModel: HomeViewModel = koinViewModel()) {
    println("LAS LEAGUES SON: ${viewModel.homeUiState.leagues}")
}