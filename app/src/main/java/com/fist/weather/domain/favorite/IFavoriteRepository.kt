package com.fist.weather.domain.favorite

import kotlinx.coroutines.flow.Flow

interface IFavoriteRepository {
    suspend fun create (payload: FavoriteEntity)
    suspend fun update (payload: FavoriteEntity)

    fun findMany (): Flow<List<FavoriteEntity>>

    suspend fun findByLatLon (lat: Double, lon: Double): FavoriteEntity?

    suspend fun delete (payload: FavoriteEntity)

    suspend fun deleteMany ()
}