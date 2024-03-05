package com.fist.weather.data.weatherBit

import android.content.Context
import android.util.Log
import com.fist.weather.domain.setting.ISettingRepository
import com.fist.weather.domain.setting.UnitSetting
import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import com.fist.weather.network.WeatherBitService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class WeatherBitRepository @Inject constructor(
    private val service: WeatherBitService,
    private val settingsRepository: ISettingRepository,
    @ApplicationContext val context: Context
): IWeatherBitRepository {
    private val securityKeyCensuradho ="8d1b990ac4d5498597a6af1cb35cf4ab"
    private val securityKeyGustavoLeite = "001b487c829e409e81a63676744c186f"

    override suspend fun findForecastDaily(city: String): WeatherbitForecastDailyResponseModel {
        val settings = settingsRepository.find().first()

        val unitMap = mapOf(
            UnitSetting.CELSIUS.name to 'M',
            UnitSetting.FAHRENHEIT.name to 'I'
        )

        var unit: String = settings?.unit ?: UnitSetting.CELSIUS.name

        return service.findForecastDaily(
            city = city,
            key = securityKeyGustavoLeite,
            units = unitMap.getValue(unit)
        )
    }
}