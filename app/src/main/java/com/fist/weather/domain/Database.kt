package com.fist.weather.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fist.weather.domain.favorite.FavoriteDao
import com.fist.weather.domain.favorite.FavoriteEntity
import com.fist.weather.domain.setting.SettingDao
import com.fist.weather.domain.setting.SettingEntity

@Database(
    entities = [
        FavoriteEntity::class,
        SettingEntity::class
   ],
    version = 2
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao (): FavoriteDao
    abstract fun settingDao (): SettingDao
}