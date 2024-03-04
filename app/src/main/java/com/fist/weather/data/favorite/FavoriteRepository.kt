package com.fist.weather.data.favorite

import com.fist.weather.domain.favorite.FavoriteDao
import com.fist.weather.domain.favorite.FavoriteEntity
import com.fist.weather.domain.favorite.IFavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
): IFavoriteRepository {
    override suspend fun create(payload: FavoriteEntity)  = favoriteDao.create(payload)
    override suspend fun update(payload: FavoriteEntity) = favoriteDao.update(payload)

    override fun findMany(): Flow<List<FavoriteEntity>> = favoriteDao.findMany()
    override suspend fun findByLatLon(lat: Double, lon: Double): FavoriteEntity {
        return favoriteDao
            .findByLatLon(lat, lon)
    }

    override suspend fun delete(payload: FavoriteEntity) = favoriteDao.delete(payload)

    override suspend fun deleteMany() = favoriteDao.deleteMany()

}