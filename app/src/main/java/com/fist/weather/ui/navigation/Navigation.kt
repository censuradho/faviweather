package com.fist.weather.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fist.weather.ui.navigation.components.BottomNavigationBar
import com.fist.weather.ui.screens.favorite.FavoriteScreen
import com.fist.weather.ui.screens.search.SearchScreen
import com.fist.weather.ui.screens.setting.SettingScreen
import com.fist.weather.ui.screens.main.MainScreen
import com.fist.weather.ui.screens.main.MainViewModel

@Composable
fun Navigation (
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Paths.MainScreen.name
            ) {
                composable(Paths.MainScreen.name) {
                    val mainViewModel = hiltViewModel<MainViewModel>()

                    MainScreen(
                        mainViewModel = mainViewModel
                    )
                }

                composable(Paths.FavoriteScreen.name) {
                    FavoriteScreen()
                }

                composable(Paths.SettingScreen.name) {
                    SettingScreen()
                }
                composable(Paths.SettingScreen.name) {
                    SearchScreen()
                }
            }
        }
    }

}