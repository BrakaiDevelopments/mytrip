package com.brakai.mytrip.repository.local

import com.brakai.mytrip.entity.TripDummies.trip01
import com.brakai.mytrip.entity.TripDummies.trip02
import com.brakai.mytrip.repository.local.dto.TripLocalDTO

@Suppress("MemberVisibilityCanBePrivate", "unused")
object TripLocalDTODummies {

    val dummyTripLocalDTO = TripLocalDTO(
        id = trip01.id,
        displayName = trip01.displayName,
        displayImage = trip01.displayImage,
        locationName = trip01.locationName,
        createdAt = trip01.createdAt,
        updatedAt = trip01.updatedAt,
        completed = trip01.completed,
        canceled = trip01.canceled,
        startAt = trip01.startAt,
        endAt = trip01.endAt
    )

    val dummyTripLocalDTO1 = TripLocalDTO(
        id = trip02.id,
        displayName = trip02.displayName,
        displayImage = trip02.displayImage,
        locationName = trip02.locationName,
        createdAt = trip02.createdAt,
        updatedAt = trip02.updatedAt,
        completed = trip02.completed,
        canceled = trip02.canceled,
        startAt = trip02.startAt,
        endAt = trip02.endAt
    )

    val dummyTripLocalDTOList = listOf(
        dummyTripLocalDTO,
        dummyTripLocalDTO1
    )
}