package com.fist.weather.ui.screens.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.fist.weather.ui.screens.favorite.components.FavoriteEntry
import com.fist.weather.ui.screens.favorite.components.TopBar

@Composable
fun FavoriteScreen (
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel,
    navController: NavHostController,
) {
    val uiState by favoriteViewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ) {
            itemsIndexed(uiState.data) { _, entry ->
                FavoriteEntry(
                    favorite = entry,
                    navController = navController
                )
            }
        }
    }

}