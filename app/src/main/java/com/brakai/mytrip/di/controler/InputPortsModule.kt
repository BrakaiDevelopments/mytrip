package com.brakai.mytrip.di.controler

import com.brakai.mytrip.usecase.trip.loadTripList.LoadTripList
import com.brakai.mytrip.usecase.trip.loadTripList.LoadTripListInputPort
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface InputPortsModule {

    @Binds
    @ViewModelScoped
    fun provideLoadTripListInputPort(inputPort: LoadTripList): LoadTripListInputPort

}
