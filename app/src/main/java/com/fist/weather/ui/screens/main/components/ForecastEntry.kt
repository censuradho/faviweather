package com.fist.weather.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fist.weather.model.WeatherbitForecastDailyEntryModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ForecastEntry (
    modifier: Modifier = Modifier,
    entry: WeatherbitForecastDailyEntryModel
) {
    val maxTemp = "${entry.maxTemp}".substringBefore(".")
    val minTemp = "${entry.minTemp}".substringBefore(".")

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp,
            alignment =  Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(
            start = 0.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = LocalDate
                .parse(entry.validDate)
                .format(DateTimeFormatter
                    .ofPattern("EEE")),
            fontSize = 12.sp,
            color = MaterialTheme.typography.displaySmall.color,
            fontWeight = FontWeight.Bold
        )
        AsyncImage(
            model = "https://cdn.weatherbit.io/static/img/icons/${entry.weather.icon}.png",
            contentDescription = entry.weather.description,
            modifier = modifier
                .width(40.dp)
                .height(40.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "${maxTemp}°/${minTemp}°",
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )

    }
}