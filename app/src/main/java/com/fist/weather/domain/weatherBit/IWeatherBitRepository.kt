package com.fist.weather.domain.weatherBit

import com.fist.weather.model.WeatherbitForecastDailyResponseModel

interface IWeatherBitRepository {
    suspend fun findForecastDaily (city: String): WeatherbitForecastDailyResponseModel
}