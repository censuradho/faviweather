package com.fist.weather.ui.screens.main

import com.fist.weather.model.WeatherbitForecastDailyResponseModel

data class MainUIState(
    val loading: Boolean = true,
    val forecast: WeatherbitForecastDailyResponseModel? = null
)