package com.fist.weather.domain.setting

import kotlinx.coroutines.flow.Flow

interface ISettingRepository {
    suspend fun upsert (payload: SettingEntity): Unit
    fun find (): Flow<SettingEntity>
}