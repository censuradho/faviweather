package com.fist.weather.mock

import com.fist.weather.model.Weather
import com.fist.weather.model.WeatherbitForecastDailyEntryModel
import com.fist.weather.model.WeatherbitForecastDailyResponseModel

val WeatherForecastDailyMock = WeatherbitForecastDailyResponseModel(
    cityName = "Porto Alegre",
    countryCode = "BR",
    lon = -51.23,
    lat = -30.03306,
    timezone = "America/Sao_Paulo",
    data = listOf(
        WeatherbitForecastDailyEntryModel(
            weather = Weather(
                code = 802,
                description = "Scattered clouds",
                icon = "c02d"
            ),
            highTemp = 27.4,
            lowTemp = 18.6,
            maxTemp = 27.4,
            minTemp = 17.9,
            sunriseTs = 1709716468,
            sunsetTs = 1709761563,
            temp = 22.3,
            validDate = "2024-02-29",
            windSpd = 3.6
        ),
        WeatherbitForecastDailyEntryModel(
            weather = Weather(
                code = 802,
                description = "Scattered clouds",
                icon = "c02d"
            ),
            highTemp = 27.4,
            lowTemp = 18.6,
            maxTemp = 27.4,
            minTemp = 17.9,
            sunriseTs = 1709716468,
            sunsetTs = 1709761563,
            temp = 22.3,
            validDate = "2024-03-01",
            windSpd = 3.6
        ),
        WeatherbitForecastDailyEntryModel(
            weather = Weather(
                code = 802,
                description = "Scattered clouds",
                icon = "c02d"
            ),
            highTemp = 27.4,
            lowTemp = 18.6,
            maxTemp = 27.4,
            minTemp = 17.9,
            sunriseTs = 1709716468,
            sunsetTs = 1709761563,
            temp = 22.3,
            validDate = "2024-03-02",
            windSpd = 3.6
        ),
        WeatherbitForecastDailyEntryModel(
            weather = Weather(
                code = 802,
                description = "Scattered clouds",
                icon = "c02d"
            ),
            highTemp = 27.4,
            lowTemp = 18.6,
            maxTemp = 27.4,
            minTemp = 17.9,
            sunriseTs = 1709716468,
            sunsetTs = 1709761563,
            temp = 22.3,
            validDate = "2024-03-03",
            windSpd = 3.6
        ),
        WeatherbitForecastDailyEntryModel(
            weather = Weather(
                code = 802,
                description = "Scattered clouds",
                icon = "c02d"
            ),
            highTemp = 27.4,
            lowTemp = 18.6,
            maxTemp = 27.4,
            minTemp = 17.9,
            sunriseTs = 1709716468,
            sunsetTs = 1709761563,
            temp = 22.3,
            validDate = "2024-03-04",
            windSpd = 3.6
        )
    )
)
