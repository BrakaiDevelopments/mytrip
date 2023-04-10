package com.brakai.mytrip.usecase.trip.base

abstract class UseCase<O : OutputPort> : InputPort<O> {
    protected lateinit var outputPort: O

    protected open suspend fun onReady() = Unit

    override suspend fun registerOutputPort(outputPort: O) {
        this.outputPort = outputPort
        onReady()
    }
}