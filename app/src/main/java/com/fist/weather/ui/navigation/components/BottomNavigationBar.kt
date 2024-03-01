package com.fist.weather.ui.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fist.weather.ui.navigation.Paths


@Composable
fun BottomNavigationBar (
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    BottomAppBar(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(top = 10.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                label  = "Home",
                activeIcon = Icons.Default.Home,
                inactiveIcon = Icons.Outlined.Home,
                path = "${Paths.MainScreen.name}/Porto Alegre",
                navController = navController
            )
            BottomNavItem(
                label  = "Search",
                activeIcon = Icons.Default.Search,
                inactiveIcon = Icons.Outlined.Search,
                path = Paths.SearchScreen.name,
                navController = navController
            )
            BottomNavItem(
                label  = "Favorite",
                activeIcon = Icons.Default.Favorite,
                inactiveIcon = Icons.Outlined.FavoriteBorder,
                path = Paths.FavoriteScreen.name,
                navController = navController

            )
            BottomNavItem(
                label  = "Settings",
                activeIcon = Icons.Default.Settings,
                inactiveIcon = Icons.Outlined.Settings,
                path = Paths.SettingScreen.name,
                navController = navController
            )
        }

    }
}