package com.marcocastope.mcsports.android

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.marcocastope.mcsports.android.ui.home.HomeScreen
import com.marcocastope.mcsports.android.ui.home.HomeUiState

@Composable
fun SportsApp(state: HomeUiState) {
    Scaffold(
        content = { HomeScreen(paddingValues = it, state = state)}
    )
}