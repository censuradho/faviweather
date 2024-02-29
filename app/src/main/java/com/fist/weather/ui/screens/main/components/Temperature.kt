package com.fist.weather.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fist.weather.R
import com.fist.weather.model.WeatherbitForecastDailyResponseModel

@Composable
fun Temperature(
    modifier: Modifier = Modifier,
    forecast: WeatherbitForecastDailyResponseModel
) {
    val (current) = forecast.data

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 90.dp
            )
            .paint(
                painter = painterResource(id = R.drawable.world),
                contentScale = ContentScale.Fit,
                alignment = Alignment.CenterStart
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        AsyncImage(
            model = "https://cdn.weatherbit.io/static/img/icons/${current.weather.icon}.png",
            contentDescription = "",
            modifier = modifier
                .width(150.dp)
                .height(150.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = current.weather.description,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier.padding(top = 30.dp)
        )
        Text(
            text = "${current.temp}°",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
    }
}