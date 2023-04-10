package com.brakai.mytrip.repository.remote

import com.brakai.mytrip.entity.TripDummies
import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO

@Suppress("MemberVisibilityCanBePrivate", "unused")
object TripRemoteDTODummies {

    val dummyTripRemoteDTO = TripRemoteDTO(
        id = TripDummies.trip01.id,
        displayName = TripDummies.trip01.displayName,
        displayImage = TripDummies.trip01.displayImage,
        locationName = TripDummies.trip01.locationName,
        createdAt = TripDummies.trip01.createdAt,
        updatedAt = TripDummies.trip01.updatedAt,
        completed = TripDummies.trip01.completed,
        canceled = TripDummies.trip01.canceled,
        startAt = TripDummies.trip01.startAt,
        endAt = TripDummies.trip01.endAt
    )

    val dummyTripRemoteDTO2 = TripRemoteDTO(
        id = TripDummies.trip02.id,
        displayName = TripDummies.trip02.displayName,
        displayImage = TripDummies.trip02.displayImage,
        locationName = TripDummies.trip02.locationName,
        createdAt = TripDummies.trip02.createdAt,
        updatedAt = TripDummies.trip02.updatedAt,
        completed = TripDummies.trip02.completed,
        canceled = TripDummies.trip02.canceled,
        startAt = TripDummies.trip02.startAt,
        endAt = TripDummies.trip02.endAt
    )

    val dummyTripRemoteDTOList = listOf(
        dummyTripRemoteDTO,
        dummyTripRemoteDTO2,
    )
}