package com.compose.marvelapp.di.comics

import com.compose.marvelapp.data.api.comics.retrofit.RetrofitComicsClient
import com.compose.marvelapp.data.repositories.comics.ComicsRepositoryImpl
import com.compose.marvelapp.domain.repositories.comics.ComicsRepository
import com.compose.marvelapp.domain.usecases.comics.GetComicsBySuperheroUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComicsModule {

    @Singleton
    @Provides
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideComicsRepository(
        retrofitClient: RetrofitComicsClient,
        coroutineDispatcher: CoroutineDispatcher,
    ): ComicsRepository = ComicsRepositoryImpl(
        retrofitClient,
        coroutineDispatcher
    )

    @Singleton
    @Provides
    fun provideRetrofitComicsClient(retrofitClient: Retrofit): RetrofitComicsClient =
        retrofitClient.create(RetrofitComicsClient::class.java)

    @Singleton
    @Provides
    fun provideGetComicsBySuperheroUseCase(
        comicsRepository: ComicsRepository,
    ): GetComicsBySuperheroUseCase = GetComicsBySuperheroUseCase(comicsRepository)

}