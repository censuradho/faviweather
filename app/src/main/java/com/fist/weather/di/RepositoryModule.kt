package com.fist.weather.di

import com.fist.weather.data.weatherBit.WeatherBitRepository
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
    abstract fun bindWeatherBitRepository (weatherBitRepository: WeatherBitRepository): IWeatherBitRepository
}