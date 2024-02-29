package com.fist.weather.data.weatherBit

import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import com.fist.weather.network.WeatherBitService
import javax.inject.Inject

class WeatherBitRepository @Inject constructor(
    private val service: WeatherBitService
): IWeatherBitRepository {
    override suspend fun findForecastDaily(city: String): WeatherbitForecastDailyResponseModel {
        return service.findForecastDaily(city)
    }
}