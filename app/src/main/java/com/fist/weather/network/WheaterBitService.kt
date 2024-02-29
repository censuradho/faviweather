package com.fist.weather.network

import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherBitService {
    @GET("/forecast/daily?key=8d1b990ac4d5498597a6af1cb35cf4ab")
    suspend fun findForecastDaily (
        @Query("city") city: String
    ): WeatherbitForecastDailyResponseModel
}