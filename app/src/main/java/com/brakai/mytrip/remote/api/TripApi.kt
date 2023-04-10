package com.brakai.mytrip.remote.api

import com.brakai.mytrip.remote.api.response.GetTripsResponse
import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO
import retrofit2.Response
import retrofit2.http.GET

interface TripApi {
    @GET("trips")
    suspend fun loadTripList(): Response<List<TripRemoteDTO>>
//    suspend fun loadTripList(): Response<GetTripsResponse>
}