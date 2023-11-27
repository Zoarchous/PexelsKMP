package com.innowise.pexelskmp.android.di

import com.innowise.pexelskmp.data.cloud.core.HttpKtorClient
import com.innowise.pexelskmp.data.cloud.photos.paging.PhotosPagingRemoteMediator
import com.innowise.pexelskmp.data.cloud.photos.service.PhotosApiImpl
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient =
        HttpKtorClient().createHttpClient()

    @Provides
    @Singleton
    fun providePhotosApi(httpKtorClient: HttpClient): PhotosApi =
        PhotosApiImpl(httpKtorClient)

    @Provides
    fun providePhotosPagingMediator(
        photosApi: PhotosApi,
        photosDataSource: PhotosDataSource,
    ): PhotosPagingRemoteMediator =
        PhotosPagingRemoteMediator(photosApi, photosDataSource)
}