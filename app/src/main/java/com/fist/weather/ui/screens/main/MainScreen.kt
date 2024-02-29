package com.fist.weather.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fist.weather.R
import com.fist.weather.ui.screens.main.components.ForecastEntry
import com.fist.weather.ui.screens.main.components.Header
import com.fist.weather.ui.screens.main.components.Temperature
import com.google.android.material.progressindicator.CircularProgressIndicator

@Composable
fun MainScreen (
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    val uiState by mainViewModel.uiState.collectAsState()
    uiState.forecast?.let {
        val forecast = uiState.forecast!!

        Column(
            modifier = modifier
                .fillMaxSize()

        ) {
            Header(
                city = forecast.cityName,
                country = forecast.countryCode
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