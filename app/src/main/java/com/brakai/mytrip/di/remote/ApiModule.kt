package com.brakai.mytrip.di.remote

import com.brakai.mytrip.remote.api.TripApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Singleton
    @Provides
    fun provideMYTRIPAPI(@Named(DiNames.MYTRIP_API) retrofit: Retrofit): TripApi =
        retrofit.create(TripApi::class.java)
}
