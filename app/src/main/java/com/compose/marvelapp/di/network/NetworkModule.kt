package com.compose.marvelapp.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}