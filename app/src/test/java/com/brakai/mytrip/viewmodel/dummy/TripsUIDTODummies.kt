package com.brakai.mytrip.viewmodel.dummy

import com.brakai.mytrip.viewmodel.dto.TripUIDTO
import java.util.*

@Suppress("MemberVisibilityCanBePrivate", "unused")
object TripsUIDTODummies {

    val dummyTripUIDTO = TripUIDTO(
        UUID.randomUUID(),
        displayName = "London",
        displayImage = "",
        locationName = "London",
        createdAt = 1672596010,
        updatedAt = 1672596010,
        completed = false,
        canceled = false,
        startAt = 1680643843,
        endAt = 1680730243
    )

    val dummyTripUIDTO1 = TripUIDTO(
        UUID.randomUUID(),
        displayName = "Paris",
        displayImage = "",
        locationName = "Paris",
        createdAt = 1672596010,
        updatedAt = 1672596010,
        completed = false,
        canceled = false,
        startAt = 1681849843,
        endAt = 1681767043
    )


    val dummyTripUIDTOList = listOf(
        dummyTripUIDTO,
        dummyTripUIDTO1,
    )
}
