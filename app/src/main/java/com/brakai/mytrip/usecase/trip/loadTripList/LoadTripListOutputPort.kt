package com.brakai.mytrip.usecase.trip.loadTripList

import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.usecase.trip.base.OutputPort
import kotlinx.coroutines.flow.Flow

interface LoadTripListOutputPort : OutputPort {
    suspend fun showLoading(loading: Boolean)
    suspend fun startObserveTrips(flow: Flow<List<Trip>>)
}