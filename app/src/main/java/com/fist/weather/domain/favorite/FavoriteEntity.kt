package com.fist.weather.domain.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "city_name")
    val cityName: String,
    @ColumnInfo(name = "country_code")
    val countryCode: String,
    val lat: Double,
    val lon: Double,
    @ColumnInfo(name = "created_at")
    val createdAt: String = LocalDateTime.now().toString()
)