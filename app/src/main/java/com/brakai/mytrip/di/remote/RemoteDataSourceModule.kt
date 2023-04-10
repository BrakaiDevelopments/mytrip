package com.brakai.mytrip.di.remote

import com.brakai.mytrip.remote.apiDataSource.trip.TripAPIDataSource
import com.brakai.mytrip.repository.remote.dataSource.TripRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RemoteDataSourceModule {

    @Binds
    fun provide(tripAPIDataSource: TripAPIDataSource): TripRemoteDataSource

}
