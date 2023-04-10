package com.brakai.mytrip.usecase.trip.base

interface InputPort<in O : OutputPort> {
    suspend fun registerOutputPort(outputPort: O)
}