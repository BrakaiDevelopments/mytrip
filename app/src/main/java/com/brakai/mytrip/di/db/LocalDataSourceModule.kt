package com.brakai.mytrip.di.db

import com.brakai.mytrip.db.dbDataSource.trip.TripDBDataSource
import com.brakai.mytrip.repository.local.dataSource.TripLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface LocalDataSourceModule {

    @Binds
    fun provide(tripRemoteDataSource: TripDBDataSource): TripLocalDataSource

}
