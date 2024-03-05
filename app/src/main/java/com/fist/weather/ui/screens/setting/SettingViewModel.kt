package com.fist.weather.ui.screens.setting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fist.weather.data.setting.SettingRepository
import com.fist.weather.domain.setting.SettingEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(SettingUIState())

    val uiState = _uiState.asStateFlow()

    fun handleChangeUnit (unit: String) {
      viewModelScope.launch(Dispatchers.IO) {

        settingRepository.updateUnit(unit)
      }
    }

    private fun findSettings () {
        viewModelScope.launch(Dispatchers.IO) {
            settingRepository
                .find()
                .distinctUntilChanged()
                .collect { setting ->
                    if (setting == null) {
                        _uiState.update {
                            it.copy(
                                data = SettingEntity()
                            )
                        }
                    } else {
                        _uiState.update {
                            it.copy(
                                data = setting
                            )
                        }
                    }
                }
        }
    }

    init {
        findSettings()
        Log.d("a", uiState.value.toString())
    }
}