package com.brakai.mytrip.viewmodel.trips

import com.brakai.mytrip.viewmodel.mvi.MVIIntent
import java.util.UUID

sealed class TripsIntent : MVIIntent {

    object RefreshTrips : TripsIntent()

    class OnTripClicked(
        val position: Int,
        val id: UUID,
    ) : TripsIntent()

}
