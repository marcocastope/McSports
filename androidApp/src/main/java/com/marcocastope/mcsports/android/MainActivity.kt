package com.marcocastope.mcsports.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.marcocastope.mcsports.android.ui.home.HomeViewModel
import com.marcocastope.mcsports.android.ui.livescore.LiveScoreViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val homeViewModel: HomeViewModel = koinViewModel()
                    SportsApp(homeViewModel.homeUiState)
                }
            }
        }
    }
}
