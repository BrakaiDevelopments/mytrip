package com.brakai.mytrip.viewmodel.trips

import com.brakai.mytrip.viewmodel.mvi.MVIIntent

sealed class TripsIntent : MVIIntent {

    object RefreshTrips : TripsIntent()

    class OnTripClicked(
        val position: Int,
        val id: String,
    ) : TripsIntent()

}
