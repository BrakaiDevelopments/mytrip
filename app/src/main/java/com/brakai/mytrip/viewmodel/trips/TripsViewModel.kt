package com.brakai.mytrip.viewmodel.trips

import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.ui.mapper.toUIDTO
import com.brakai.mytrip.usecase.trip.loadTripList.LoadTripListInputPort
import com.brakai.mytrip.usecase.trip.loadTripList.LoadTripListOutputPort
import com.brakai.mytrip.viewmodel.standard.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TripsViewModel @Inject constructor(
    private val tripInputPort: LoadTripListInputPort
) : StandardViewModel<TripsState, TripsIntent>(),
    LoadTripListOutputPort {

    override suspend fun handleIntent(intent: TripsIntent) = when (intent) {
        is TripsIntent.RefreshTrips -> handleRefreshMovies()
        is TripsIntent.OnTripClicked -> handleTripClicked(intent)
    }

    private suspend fun handleRefreshMovies() {
        tripInputPort.startUpdatingTripList()
    }

    private fun handleTripClicked(intent: TripsIntent.OnTripClicked) {
        state.value?.trips?.getOrNull(intent.position)?.takeIf { it.id == intent.id }?.let {
            println("showing trip : $it")
        }
    }

    override suspend fun startObserveTrips(flow: Flow<List<Trip>>) {
        flow.collectResult {
            updateState(TripsState.TripList(it.toUIDTO()))
        }
    }

    override suspend fun showLoading(loading: Boolean) {
        state.value?.trips?.let { trips ->
            updateState(TripsState.TripList(trips, loading))
        }
    }
}
