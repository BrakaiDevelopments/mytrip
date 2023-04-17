package com.brakai.mytrip.viewmodel.landing

import com.brakai.mytrip.viewmodel.mvi.MVIIntent

sealed class LandingIntent : MVIIntent {

    class OnTripClicked(
        val position: Int,
        val id: String,
    ) : LandingIntent()

    object RefreshLanding : LandingIntent()
    object ShowAllTrips : LandingIntent()
    object ShowAllRecommendation : LandingIntent()
    object OpenSearch : LandingIntent()
}