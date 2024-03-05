package com.fist.weather.di

import com.fist.weather.data.favorite.FavoriteRepository
import com.fist.weather.data.setting.SettingRepository
import com.fist.weather.data.weatherBit.WeatherBitRepository
import com.fist.weather.domain.favorite.IFavoriteRepository
import com.fist.weather.domain.setting.ISettingRepository
import com.fist.weather.domain.weatherBit.IWeatherBitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherBitRepository (
        weatherBitRepository: WeatherBitRepository
    ): IWeatherBitRepository

    @Binds
    @Singleton
    abstract fun bindFavoriteRepository (favoriteRepository: FavoriteRepository): IFavoriteRepository

    @Binds
    @Singleton
    abstract fun bindSettingRepository (settingRepository: SettingRepository): ISettingRepository
}