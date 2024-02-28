package com.fist.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fist.weather.ui.screens.splash.SplashScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Paths.SplashScreen.name
    ) {
        composable(Paths.SplashScreen.name) {
            SplashScreen(
                onGoNextScreen = {
                    navController.navigate(Paths.MainScreen.name)
                }
            )
        }
    }
}