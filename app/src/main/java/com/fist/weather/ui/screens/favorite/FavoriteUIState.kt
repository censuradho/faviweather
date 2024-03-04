package com.fist.weather.ui.screens.favorite

import com.fist.weather.domain.favorite.FavoriteEntity

data class FavoriteUIState(
    val data: List<FavoriteEntity> = emptyList(),
    val loading: Boolean = false,
)