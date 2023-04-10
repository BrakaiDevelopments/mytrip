package com.brakai.mytrip.usecase.trip.loadTripList

import com.brakai.mytrip.usecase.trip.base.InputPort

interface LoadTripListInputPort : InputPort<LoadTripListOutputPort> {
    suspend fun startUpdatingTripList()
}