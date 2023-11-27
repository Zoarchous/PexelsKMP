package com.innowise.pexelskmp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.innowise.pexelskmp.data.cloud.photos.paging.PhotosPagingRemoteMediator
import com.innowise.pexelskmp.data.local.photos.PhotosDataSourceImpl
import com.innowise.pexelskmp.data.repository.PhotosRepositoryImpl
import com.innowise.pexelskmp.database.PhotosDatabase
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi
import com.innowise.pexelskmp.domain.photo.repository.PhotosRepository
import com.innowise.pexelskmp.domain.photo.useCases.GetCuratedPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    @Provides
    @Singleton
    fun providePhotosDataSource(sqlDriver: SqlDriver): PhotosDataSource =
        PhotosDataSourceImpl(PhotosDatabase(sqlDriver))

    @Provides
    fun providePhotosRepository(
        photosApi: PhotosApi,
        photosDataSource: PhotosDataSource,
        photosPagingRemoteMediator: PhotosPagingRemoteMediator,
    ): PhotosRepository =
        PhotosRepositoryImpl(
            photosApi,
            photosDataSource,
            photosPagingRemoteMediator
        )

    @Provides
    fun provideGetCuratedPhotosUseCase(repository: PhotosRepository): GetCuratedPhotosUseCase =
        GetCuratedPhotosUseCase(repository)
}