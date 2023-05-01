package com.marcocastope.mcsports.android.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcocastope.mcsports.android.ui.home.HomeScreen
import com.marcocastope.mcsports.android.ui.home.HomeUiState
import com.marcocastope.mcsports.android.ui.leagues.LeaguesScreen
import com.marcocastope.mcsports.android.ui.livescore.DetailUiState
import com.marcocastope.mcsports.android.ui.livescore.LiveScoreDetailScreen

@Composable
fun CustomNavHost(
    paddingValues: PaddingValues,
    homeState: HomeUiState,
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen(
                paddingValues = paddingValues,
                state = homeState,
                onLiveScoreSelected = { navController.navigate("liveScoreDetail/${it.id}") })
        }
        composable("liveScoreDetail/{matchId}") {
            val matchId = it.arguments?.getString("matchId")
            LiveScoreDetailScreen(matchId = matchId, onBackPressed = {navController.popBackStack()})
        }
        composable(BottomNavItem.Leagues.screenRoute) {
            LeaguesScreen()
        }
    }
}