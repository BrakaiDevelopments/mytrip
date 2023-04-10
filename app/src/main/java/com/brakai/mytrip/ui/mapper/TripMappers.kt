package com.brakai.mytrip.ui.mapper

import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.viewmodel.dto.TripUIDTO


internal fun Trip.toUIDTO() = TripUIDTO(
    id = id,
    displayName = displayName,
    displayImage = displayImage,
    locationName = locationName,
    createdAt = createdAt,
    updatedAt = updatedAt,
    completed = completed,
    canceled = canceled,
    startAt = startAt,
    endAt = endAt
)

internal fun List<Trip>.toUIDTO() = map { it.toUIDTO() }
