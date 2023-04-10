package com.brakai.mytrip.di.remote

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    @Named(DiNames.MYTRIP_API)
    fun provideRetrofit(
        @Named(DiNames.MYTRIP_API) httpClient: OkHttpClient,
        moshi: Moshi,
        @Named(DiNames.MYTRIP_API) baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseURL)
            .build()
    }

}
