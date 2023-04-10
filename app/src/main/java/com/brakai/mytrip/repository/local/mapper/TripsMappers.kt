package com.brakai.mytrip.repository.local.mapper

import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.repository.local.dto.TripLocalDTO


internal fun TripLocalDTO.toEntity() = Trip(
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

internal fun List<TripLocalDTO>.toEntity() = map { it.toEntity() }

internal fun Trip.toLocalDTO() = TripLocalDTO(
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

internal fun List<Trip>.toLocalDTO() = map { it.toLocalDTO() }
