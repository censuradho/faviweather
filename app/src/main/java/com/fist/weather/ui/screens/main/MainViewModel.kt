package com.fist.weather.ui.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fist.weather.data.favorite.FavoriteRepository
import com.fist.weather.domain.favorite.FavoriteEntity
import com.fist.weather.domain.favorite.IFavoriteRepository
import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import com.fist.weather.mock.WeatherForecastDailyMock
import com.fist.weather.model.WeatherbitForecastDailyResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.isActive
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherBitRepository: IWeatherBitRepository,
    private val favoriteRepository: IFavoriteRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    private fun getMock () {
        _uiState.update { it.copy(forecast = WeatherForecastDailyMock) }
    }

    fun handleLike (payload: WeatherbitForecastDailyResponseModel) {


        viewModelScope.launch(Dispatchers.IO) {

            val favorite = favoriteRepository.findByLatLon(
                lat = payload.lat,
                lon = payload.lon,
            )

            if (favorite !== null) return@launch

            favoriteRepository.create(
                payload = FavoriteEntity(
                    lat = payload.lat,
                    lon = payload.lon,
                    countryCode = payload.countryCode,
                    cityName = payload.cityName,
                )
            )

            _uiState.update{
                it.copy(
                    isFavorite = true
                )
            }
        }
    }

    fun handleUnlike (payload: WeatherbitForecastDailyResponseModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val favorite = favoriteRepository.findByLatLon(
                lat = payload.lat,
                lon = payload.lon,
            ) ?: return@launch

            favoriteRepository.delete(
                    payload = FavoriteEntity(
                        id = favorite.id,
                        lat = payload.lat,
                        lon = payload.lon,
                        countryCode = payload.countryCode,
                        cityName = payload.cityName,
                        createdAt = favorite.createdAt
                    )
                )
            }

            _uiState.update{
                it.copy(
                    isFavorite = false
                )
            }
    }

    fun findWeatherForecastDaily (city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    loading = true,
                    forecast = null
                )
            }

            try {
                val response = weatherBitRepository.findForecastDaily(city)

                val favorite = favoriteRepository.findByLatLon(
                    lat = response.lat,
                    lon = response.lon,
                )

                val isFavorite = favorite !== null

                _uiState.update {
                    it.copy(
                        forecast = response,
                        isFavorite = isFavorite
                    )
                }
            } catch (e: IOException) {
                Log.d("ERROR", e.toString())
                _uiState.update { it.copy(forecast = WeatherForecastDailyMock) }
            } finally {
                _uiState.update { it.copy(loading = false) }
            }
            return@launch
        }
    }
}