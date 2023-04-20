package com.marcocastope.mcsports.android

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.marcocastope.mcsports.android.ui.home.HomeScreen

@Composable
fun SportsApp() {
    Scaffold(
        content = { HomeScreen(paddingValues = it)}
    )
}