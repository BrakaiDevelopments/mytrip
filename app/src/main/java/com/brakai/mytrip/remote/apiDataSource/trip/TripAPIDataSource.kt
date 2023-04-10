package com.brakai.mytrip.remote.apiDataSource.trip

import com.brakai.mytrip.remote.api.TripApi
import com.brakai.mytrip.remote.apiDataSource.base.APIDataSource
import com.brakai.mytrip.remote.util.bodyOrException
import com.brakai.mytrip.repository.remote.dataSource.TripRemoteDataSource
import com.brakai.mytrip.repository.remote.dto.TripRemoteDTO
import javax.inject.Inject

class TripAPIDataSource @Inject constructor(
    private val movieApi: TripApi
) : APIDataSource(), TripRemoteDataSource {

    override suspend fun loadTripList(
    ): List<TripRemoteDTO> = movieApi.loadTripList().bodyOrException()
//    ): List<TripRemoteDTO> = movieApi.loadTripList().bodyOrException().tripList

}