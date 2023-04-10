package com.brakai.mytrip.usecase.trip.repository


import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.usecase.trip.base.Repository
import kotlinx.coroutines.flow.Flow

interface TripRepository : Repository {
    suspend fun updateTripList()
    suspend fun observeTrips(): Flow<List<Trip>>
    suspend fun loadTripSize(): Int
}
