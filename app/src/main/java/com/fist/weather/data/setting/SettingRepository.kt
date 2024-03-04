package com.fist.weather.data.setting

import com.fist.weather.domain.setting.ISettingRepository
import com.fist.weather.domain.setting.SettingDao
import com.fist.weather.domain.setting.SettingEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingRepository @Inject constructor(
    private val settingDao: SettingDao
): ISettingRepository {
    override suspend fun upsert(payload: SettingEntity) = settingDao.upset(payload)

    override fun find(): Flow<SettingEntity> = settingDao.find()

}