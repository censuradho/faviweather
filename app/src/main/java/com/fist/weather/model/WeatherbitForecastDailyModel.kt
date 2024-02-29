package com.fist.weather.model

import com.google.gson.annotations.SerializedName

data class Weather (
    val icon: String,
    val description: String,
    val code: Int
)

data class WeatherbitForecastDailyEntryModel(
    @SerializedName("high_temp")
    val highTemp: Double,
    @SerializedName("low_temp")
    val lowTemp: Double,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("sunrise_ts")
    val sunriseTs: Int,
    @SerializedName("sunset_ts")
    val sunsetTs: Int,
    val temp: Double,
    @SerializedName("valid_date")
    val validDate: String,
    @SerializedName("wind_spd")
    val windSpd: Double,
    val weather: Weather
)

data class WeatherbitForecastDailyResponseModel(
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_code")
    val countryCode: String,
    val lat: String,
    val lon: String,
    val timezone: String,
    val data: List<WeatherbitForecastDailyEntryModel>
)