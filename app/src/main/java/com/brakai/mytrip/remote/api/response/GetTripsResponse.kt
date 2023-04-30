package com.brakai.mytrip.remote.api.response

import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO
import com.squareup.moshi.Json

data class GetTripsResponse(
    val page: Int,
    @Json(name = "total_results") val totalResults: Int,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "results") val tripList: List<TripRemoteDTO>,
)
