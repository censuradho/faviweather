package com.fist.weather.ui.screens.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fist.weather.data.setting.SettingRepository
import com.fist.weather.domain.setting.SettingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository
): ViewModel() {

    fun upsert (payload: SettingEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            settingRepository.upsert(payload)
        }
    }

    suspend fun find () {
        viewModelScope.launch(Dispatchers.IO) {
            
        }
    }

}