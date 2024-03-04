package com.fist.weather.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fist.weather.ui.screens.search.components.SearchTextField
import com.fist.weather.ui.screens.search.components.TopBar

@Composable
fun SearchScreen (
    modifier: Modifier = Modifier,
    onSearch: (value: String) -> Unit = {}
) {
    fun handleSearch (query: String) {
        onSearch(query.trim())
    }

    Scaffold(
        topBar =  {
            TopBar()
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding(),
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxSize()
        ) {
            SearchTextField(
                onSearch = {
                    handleSearch(it)
                }
            )
        }
    }
}