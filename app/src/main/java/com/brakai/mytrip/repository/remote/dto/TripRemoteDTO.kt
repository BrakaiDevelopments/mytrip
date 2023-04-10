package com.brakai.mytrip.repository.remote.dto

import com.squareup.moshi.Json

data class TripRemoteDTO(
    @Json(name = "id") val id: String,
    @Json(name = "displayName") val displayName: String,
    @Json(name = "displayImage") val displayImage: String,
    @Json(name = "locationName") val locationName: String,
    @Json(name = "createdAt") val createdAt: Long,
    @Json(name = "updatedAt") val updatedAt: Long,
    @Json(name = "completed") val completed: Boolean,
    @Json(name = "canceled") val canceled: Boolean,
    @Json(name = "startAt") val startAt: Long,
    @Json(name = "endAt") val endAt: Long
)
