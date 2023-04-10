package com.brakai.mytrip.repository.repositoryImp

import com.brakai.mytrip.repository.base.RepositoryImp
import com.brakai.mytrip.repository.local.dataSource.TripLocalDataSource
import com.brakai.mytrip.repository.local.mapper.toEntity
import com.brakai.mytrip.repository.local.mapper.toLocalDTO
import com.brakai.mytrip.repository.remote.dataSource.TripRemoteDataSource
import com.brakai.mytrip.repository.remote.mapper.toEntity
import com.brakai.mytrip.usecase.trip.repository.TripRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TripRepositoryImp @Inject constructor(
    private val tripRemoteDataSource: TripRemoteDataSource,
    private val tripLocalDataSource: TripLocalDataSource,
) : RepositoryImp(), TripRepository {

    override suspend fun updateTripList() = tripLocalDataSource.updateTripList(
        tripRemoteDataSource.loadTripList().toEntity().toLocalDTO()
    )

    override suspend fun observeTrips() = tripLocalDataSource.observeTrips().map {
        val a = it.toEntity()
        a
    }

    override suspend fun loadTripSize(): Int = tripLocalDataSource.loadTripSize()

}