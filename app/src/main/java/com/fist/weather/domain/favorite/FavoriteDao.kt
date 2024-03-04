package com.fist.weather.domain.favorite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(payload: FavoriteEntity)

    @Update
    suspend fun update (payload: FavoriteEntity)

    @Query("SELECT * FROM favorite")
    fun findMany (): Flow<List<FavoriteEntity>>

    @Delete
    suspend fun delete (payload: FavoriteEntity)

    @Query("SELECT * FROM favorite WHERE lat = :lat AND lon = :lon")
    suspend fun findByLatLon (lat: Double, lon: Double): FavoriteEntity

    @Query("DELETE from favorite")
    suspend fun deleteMany ()
}