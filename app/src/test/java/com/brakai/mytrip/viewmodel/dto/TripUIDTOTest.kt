package com.brakai.mytrip.viewmodel.dto

import com.brakai.mytrip.viewmodel.dummy.TripsUIDTODummies
import com.google.common.truth.Truth
import org.junit.Test


class TripUIDTOTest {

    @Test
    fun `Given a same month start and end date, get the duration for the trip`() {
        val tripDuration = "Apr 4-5"

        val duration = tripUIDTO.getDurationText()

        Truth.assertThat(duration).isEqualTo(tripDuration)
    }

    @Test
    fun `Given a different month start and end date, get the duration for the trip`() {
        val tripDuration = "Apr 4-May 4"

        val trip = tripUIDTO.copy(endAt = 1683200913)

        val duration = trip.getDurationText()

        Truth.assertThat(duration).isEqualTo(tripDuration)
    }

    companion object{
        val tripUIDTO = TripsUIDTODummies.dummyTripUIDTO

    }
}