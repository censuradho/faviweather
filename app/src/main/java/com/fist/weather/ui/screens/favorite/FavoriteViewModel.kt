package com.fist.weather.ui.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fist.weather.domain.favorite.IFavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRepository: IFavoriteRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(FavoriteUIState())
    val uiState = _uiState.asStateFlow()

    private fun findAAllFavorites () {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository
                .findMany()
                .distinctUntilChanged()
                .collect {
                    data -> _uiState.update {
                        it.copy(
                            data = data
                        )
                    }
                }
        }
    }

    init {
        findAAllFavorites()
    }
}