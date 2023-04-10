package com.brakai.mytrip.remote.api

import com.brakai.mytrip.remote.api.response.GetTripsResponse
import retrofit2.Response
import retrofit2.http.GET

interface TripApi {
    @GET("trip/popular")
    suspend fun loadTripList(): Response<GetTripsResponse>
}