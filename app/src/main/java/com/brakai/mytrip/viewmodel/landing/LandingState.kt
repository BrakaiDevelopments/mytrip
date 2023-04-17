package com.brakai.mytrip.viewmodel.landing

import com.brakai.mytrip.viewmodel.dto.TripUIDTO
import com.brakai.mytrip.viewmodel.mvi.MVIState

sealed class LandingState(
    open val trips: List<TripUIDTO> = listOf(),
    open val recommendedTrips: List<TripUIDTO> = listOf()
) : MVIState {

    class Normal(
        override val trips: List<TripUIDTO>,
        override val recommendedTrips: List<TripUIDTO>,
        val loading: Boolean = false
    ) : LandingState(trips, recommendedTrips)

    class Search(
        override val trips: List<TripUIDTO>,
        override val recommendedTrips: List<TripUIDTO>,
        val loading: Boolean = false,
        val query: String = ""
    ) : LandingState(trips, recommendedTrips)


}