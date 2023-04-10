package com.brakai.mytrip.db.dbDataSource.trip

import com.brakai.mytrip.db.dao.TripDao
import com.brakai.mytrip.db.dbDataSource.base.DBDataSource
import com.brakai.mytrip.repository.local.dataSource.TripLocalDataSource
import com.brakai.mytrip.repository.local.dto.TripLocalDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TripDBDataSource @Inject constructor(
    private val tripDao: TripDao
) : DBDataSource(), TripLocalDataSource {

    override suspend fun updateTripList(tripList: List<TripLocalDTO>): Unit =
        tripDao.insertAll(tripList)

    override suspend fun observeTrips(): Flow<List<TripLocalDTO>> =
        tripDao.observeTrips()

    override suspend fun loadTripSize(): Int = tripDao.loadTripSize()
}