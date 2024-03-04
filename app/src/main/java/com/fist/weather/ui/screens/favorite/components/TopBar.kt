package com.fist.weather.ui.screens.favorite.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar () {
    TopAppBar(
        title = {
            Text(
                text = "Favorites",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    )
}