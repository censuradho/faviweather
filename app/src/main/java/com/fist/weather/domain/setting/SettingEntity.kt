package com.fist.weather.domain.setting

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class SettingEntity(
    @PrimaryKey
    val id: Int = 1,
    val unit: String = UnitSetting.CELSIUS.name,
)

enum class UnitSetting {
    FAHRENHEIT,
    CELSIUS
}