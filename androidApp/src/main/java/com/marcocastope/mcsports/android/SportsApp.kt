package com.marcocastope.mcsports.android

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.marcocastope.mcsports.android.ui.composables.CustomBottomNavigation
import com.marcocastope.mcsports.android.ui.home.HomeUiState
import com.marcocastope.mcsports.android.ui.navigation.CustomNavHost

@Composable
fun SportsApp(homeState: HomeUiState) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { CustomBottomNavigation(navController = navController) },
        content = {
            CustomNavHost(paddingValues = it, homeState = homeState, navController = navController)
        }
    )
}