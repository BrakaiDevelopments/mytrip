package com.brakai.mytrip.repository.remote.dataSource

import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO

interface TripRemoteDataSource {
    suspend fun loadTripList(): List<TripRemoteDTO>
}