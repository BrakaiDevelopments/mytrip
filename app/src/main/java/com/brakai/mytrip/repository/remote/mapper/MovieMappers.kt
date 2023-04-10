package com.brakai.mytrip.repository.remote.mapper

import com.brakai.mytrip.entity.Trip
import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO


internal fun TripRemoteDTO.toEntity() = Trip(
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

internal fun List<TripRemoteDTO>.toEntity() = map { it.toEntity() }
