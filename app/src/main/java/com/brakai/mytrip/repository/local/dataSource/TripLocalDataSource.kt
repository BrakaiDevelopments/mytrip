package com.brakai.mytrip.repository.local.dataSource

import com.brakai.mytrip.repository.local.dto.TripLocalDTO
import kotlinx.coroutines.flow.Flow

interface TripLocalDataSource {
    suspend fun updateTripList(tripList: List<TripLocalDTO>)
    suspend fun observeTrips(): Flow<List<TripLocalDTO>>
    suspend fun loadTripSize(): Int
}