package com.brakai.mytrip.usecase.trip.loadTripList

import com.brakai.mytrip.usecase.trip.base.UseCase
import com.brakai.mytrip.usecase.trip.repository.TripRepository
import com.brakai.mytrip.usecase.utils.tryTo
import javax.inject.Inject

class LoadTripList @Inject constructor(
    private val tripRepository: TripRepository,
) : UseCase<LoadTripListOutputPort>(), LoadTripListInputPort {

    override suspend fun onReady() {
        observeTrips()
        loadMoviesIfNeeded()
    }

    override suspend fun startUpdatingTripList() {
        showLoading()
        val e = tryTo { updateTrips() }
        hideLoading()
        e?.let { throw e }
    }

    private suspend fun loadMoviesIfNeeded() {
        if (tripRepository.loadTripSize() <= 0) startUpdatingTripList()
    }

    private suspend fun observeTrips() = outputPort.startObserveTrips(tripRepository.observeTrips())

    private suspend fun showLoading() = outputPort.showLoading(true)

    private suspend fun hideLoading() = outputPort.showLoading(false)

    private suspend fun updateTrips() = tripRepository.updateTripList()

}