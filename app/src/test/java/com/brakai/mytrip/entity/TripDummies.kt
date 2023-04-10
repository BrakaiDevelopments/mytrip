package com.brakai.mytrip.entity

import java.util.*

@Suppress("unused", "MemberVisibilityCanBePrivate")
object TripDummies {
    val trip01 = Trip(
        id = "1",
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

    val trip02 = Trip(
        id = "2",
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

    val dummyTripList = listOf(
        trip01,
        trip02,
    )

}