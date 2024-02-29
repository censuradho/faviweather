package com.fist.weather.data.weatherBit

import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import com.fist.weather.network.WeatherBitService
import javax.inject.Inject

class WeatherBitRepository @Inject constructor(
    private val service: WeatherBitService
): IWeatherBitRepository {
    private val securityKey ="8d1b990ac4d5498597a6af1cb35cf4ab"

    override suspend fun findForecastDaily(city: String): WeatherbitForecastDailyResponseModel {
        return service.findForecastDaily(city = city, key = securityKey)
    }
}