package com.fist.weather.di

import com.fist.weather.network.WeatherBitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object WeatherBitModule {
    val BASE_URL = "https://api.weatherbit.io/v2.0/"

    @Singleton
    @Provides
    fun providesWeatherBitRetrofit (): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesWeatherBitService (retrofit: Retrofit): WeatherBitService {
        val retrofitService: WeatherBitService by lazy {
            retrofit.create(WeatherBitService::class.java)
        }
        return retrofitService
    }
}