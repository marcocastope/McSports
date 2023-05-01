package com.marcocastope.mcsports.android.ui.navigation

import com.marcocastope.mcsports.android.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home_24, "home")
    object Leagues : BottomNavItem("Leagues", R.drawable.ic_list_24, "leagues")
}
