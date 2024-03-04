package com.fist.weather.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fist.weather.ui.screens.main.components.ForecastEntry
import com.fist.weather.ui.screens.main.components.Header
import com.fist.weather.ui.screens.main.components.NotFoundMessage
import com.fist.weather.ui.screens.main.components.Temperature

@Composable
fun MainScreen (
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    city: String
) {
    val uiState by mainViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.findWeatherForecastDaily(city)
    }
    if (uiState.forecast == null) NotFoundMessage(
        query = city,
        loading = uiState.loading
    )

    val forecast = uiState.forecast

    if (forecast !== null) {

        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Header(
                city = city,
                country = forecast.countryCode,
                isFavorite = uiState.isFavorite,
                onLike = {
                    mainViewModel.handleLike(forecast)
                },
                onUnlike = {
                    mainViewModel.handleUnlike(forecast)
                }
            )
            Temperature(
                forecast = forecast
            )
            LazyRow(
                contentPadding = PaddingValues(
                    end = 16.dp,
                    start = 16.dp
                )
            ) {
                itemsIndexed(forecast.data) { _, entry ->
                    ForecastEntry(
                        entry = entry
                    )
                }
            }
        }
    }
}