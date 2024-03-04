package com.fist.weather.di

import android.content.Context
import androidx.room.Room
import com.fist.weather.domain.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase (@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesFavoriteDao (db: AppDatabase) = db.favoriteDao()

    @Provides
    fun providesSettingDao (db: AppDatabase) = db.settingDao()
}