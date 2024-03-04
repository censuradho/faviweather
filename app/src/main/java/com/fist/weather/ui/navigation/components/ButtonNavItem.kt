package com.fist.weather.ui.navigation.components

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavItem (
    modifier: Modifier = Modifier,
    label: String,
    inactiveIcon: ImageVector,
    activeIcon: ImageVector,
    path: String,
    navController: NavHostController,
    exact: Boolean = false
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val baseCurrentRoute = currentRoute?.substringBefore("/")
    val basePath = path.substringBefore("/")

    val isActive =
        if (exact) currentRoute == path
        else baseCurrentRoute == basePath

    IconButton(
        onClick = {
            navController.navigate(path)
        },
    ) {
       Icon(
           imageVector =
            if(isActive) activeIcon else inactiveIcon,
           contentDescription = label
       )

    }

}