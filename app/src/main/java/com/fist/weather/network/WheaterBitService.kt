package com.fist.weather.network

import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

/***
 * M - DEFAULT Metric (Celsius, m/s, mm)
 *
 * S - Scientific (Kelvin, m/s, mm)
 *
 * I - Fahrenheit (F, mph, in)
 * */
enum class UnitQuery {
    M,
    S,
    I
}

interface WeatherBitService {
    @GET("forecast/daily")
    suspend fun findForecastDaily (
        @Query("city") city: String,
        @Query("key") key: String,
        @Query("units") units: Char? = null,
        @Query("days") days: Int? = 10
    ): WeatherbitForecastDailyResponseModel
}