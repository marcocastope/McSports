package com.marcocastope.mcsports.android.ui.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marcocastope.mcsports.android.ui.navigation.BottomNavItem

@Composable
fun CustomBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Leagues
    )

    BottomNavigation(backgroundColor = Color(0xff226cfe), contentColor = Color.Black) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(selected = currentRoute == item.screenRoute, onClick = {
                navController.navigate(item.screenRoute) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(it) { saveState = true }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }, alwaysShowLabel = true,
                unselectedContentColor = Color.Black.copy(alpha = 0.4f),
                selectedContentColor = Color.White,
                label = { Text(text = item.title, fontSize = 9.sp) },
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
                }
            )
        }
    }
}