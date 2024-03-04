package com.fist.weather.ui.screens.favorite.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fist.weather.domain.favorite.FavoriteEntity
import com.fist.weather.ui.navigation.Paths
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteEntry(
    modifier: Modifier = Modifier,
    favorite: FavoriteEntity,
    navController: NavHostController,
) {
    Card(
        onClick = {
            navController.navigate("${Paths.MainScreen.name}/${favorite.cityName}")
        },
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = favorite.cityName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Row() {
                Text(
                    text =
                        LocalDateTime
                            .parse(favorite.createdAt)
                            .format(
                                DateTimeFormatter
                                    .ofPattern("EEE dd  MMM yyyy")
                            ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }

}