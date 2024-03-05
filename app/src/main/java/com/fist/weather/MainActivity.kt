package com.fist.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.fist.weather.ui.navigation.Navigation
import com.fist.weather.ui.screens.setting.SettingViewModel
import com.fist.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

// https://api.openweathermap.org/data/2.5/forecast/daily?q=lisbon&appid=ed60fcfbd110ee65c7150605ea8aceea&units=imperial
// UI Template: https://dribbble.com/shots/16256783-Weather-App-UI
// Weather Forecast API (Weatherbit): https://www.weatherbit.io/account/dashboard

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    WeatherTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            val settingViewModel = hiltViewModel<SettingViewModel>()

            Navigation(
                navController = navController,
                settingViewModel = settingViewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WeatherTheme {
        App()
    }
}