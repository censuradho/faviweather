package com.fist.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fist.weather.ui.screens.main.Mainscreen
import com.fist.weather.ui.screens.splash.SplashScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Paths.MainScreen.name
    ) {
        composable(Paths.MainScreen.name) {
            Mainscreen()
        }
    }
}