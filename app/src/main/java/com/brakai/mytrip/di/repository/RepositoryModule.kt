package com.brakai.mytrip.di.repository

import com.brakai.mytrip.repository.repositoryImp.TripRepositoryImp
import com.brakai.mytrip.usecase.trip.repository.TripRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun provide(tripGateway: TripRepositoryImp): TripRepository

}
