package com.fist.weather.ui.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import com.fist.weather.mock.WeatherForecastDailyMock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherBitRepository: IWeatherBitRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    private fun getMock () {
        _uiState.update { it.copy(forecast = WeatherForecastDailyMock) }
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
                _uiState.update {
                    it.copy(forecast = response )
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