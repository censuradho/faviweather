package com.fist.weather.domain.setting

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingDao {
    @Upsert()
    suspend fun upset (data: SettingEntity): Unit

    @Query("SELECT * FROM settings WHERE id = 1")
    fun find (): Flow<SettingEntity?>

    @Query("UPDATE settings SET unit = :unit WHERE id = 1")
    suspend fun updateUnit (unit: String)
}