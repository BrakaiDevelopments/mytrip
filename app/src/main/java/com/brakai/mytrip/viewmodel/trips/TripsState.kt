package com.brakai.mytrip.viewmodel.trips

import com.brakai.mytrip.viewmodel.dto.TripUIDTO
import com.brakai.mytrip.viewmodel.mvi.MVIState


sealed class TripsState(
    open val trips: List<TripUIDTO> = listOf(),
) : MVIState {

    class TripList(
        override val trips: List<TripUIDTO>,
        val isLoading: Boolean = false
    ) : TripsState(trips)

}
