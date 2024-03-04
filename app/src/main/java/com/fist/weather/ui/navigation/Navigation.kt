package com.fist.weather.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fist.weather.ui.navigation.components.BottomNavigationBar
import com.fist.weather.ui.screens.favorite.FavoriteScreen
import com.fist.weather.ui.screens.favorite.FavoriteViewModel
import com.fist.weather.ui.screens.main.MainScreen
import com.fist.weather.ui.screens.main.MainViewModel
import com.fist.weather.ui.screens.search.SearchScreen
import com.fist.weather.ui.screens.setting.SettingScreen

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
                startDestination = Paths.SettingScreen.name
            ) {
                composable(
                    "${Paths.MainScreen.name}/{city}",
                    arguments = listOf(
                        navArgument(
                            name = "city"
                        ) {
                            type = NavType.StringType
                        }
                    )
                ) { navBackStackEntry ->
                    val city = navBackStackEntry.arguments?.getString("city") ?: "Porto Alegre"

                    city?.let {
                        val mainViewModel = hiltViewModel<MainViewModel>()

                        MainScreen(
                            mainViewModel = mainViewModel,
                            city = it
                        )
                    }

                }
                composable(Paths.SearchScreen.name) {
                    SearchScreen(
                        onSearch = {
                            navController.navigate("${Paths.MainScreen.name}/${it}")
                        }
                    )
                }
                composable(Paths.FavoriteScreen.name) {
                    val viewModel = hiltViewModel<FavoriteViewModel>()

                    FavoriteScreen(
                        favoriteViewModel = viewModel,
                        navController = navController
                    )
                }
                composable(Paths.SettingScreen.name) {
                    SettingScreen()
                }

            }
        }
    }

}