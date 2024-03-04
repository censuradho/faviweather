package com.fist.weather.ui.screens.main

import com.fist.weather.model.WeatherbitForecastDailyResponseModel

data class MainUIState(
    val loading: Boolean = true,
    val isFavorite: Boolean = false,
    val forecast: WeatherbitForecastDailyResponseModel? = null
)