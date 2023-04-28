package com.marcocastope.mcsports.android

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.marcocastope.mcsports.android.ui.home.HomeScreen
import com.marcocastope.mcsports.android.ui.home.HomeUiState
import com.marcocastope.mcsports.android.ui.livescore.DetailUiState
import com.marcocastope.mcsports.android.ui.navigation.CustomNavHost

@Composable
fun SportsApp(homeState: HomeUiState) {
    Scaffold(
        content = {
            CustomNavHost(paddingValues = it, homeState = homeState)
        }
    )
}