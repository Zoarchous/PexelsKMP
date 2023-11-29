package com.innowise.pexelskmp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.innowise.pexelskmp.data.cloud.photos.dto.CollectionsResponse
import com.innowise.pexelskmp.data.cloud.photos.paging.PhotosPagingRemoteMediator
import com.innowise.pexelskmp.data.core.mapFromDtoList
import com.innowise.pexelskmp.data.core.toPhoto
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.Photo
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi
import com.innowise.pexelskmp.domain.photo.repository.PhotosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class PhotosRepositoryImpl(
    private val photosApi: PhotosApi,
    private val photosDb: PhotosDataSource,
    private val photosPagingRemoteMediator: PhotosPagingRemoteMediator,
) : PhotosRepository {
    override suspend fun getCuratedPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(
                pageSize = PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                photosPagingRemoteMediator
            }
        )
            .flow
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getPhotosByQuery(query: String): Result<List<Photo>> = runCatching {
        photosApi.getPhotosByQuery(query, PER_PAGE.toString()).getOrThrow().photos.mapFromDtoList()
    }

    override suspend fun getPhotoById(id: Int): Result<Photo> = runCatching {
        photosApi.getPhotoById(id).getOrThrow().toPhoto()
    }

    override suspend fun getFeaturedCollections(): Result<CollectionsResponse> = runCatching {
        photosApi.getFeaturedCollections(PER_PAGE_COLLECTIONS.toString()).getOrThrow()
    }

    companion object {
        const val PER_PAGE = 30
        const val PER_PAGE_COLLECTIONS = 7
    }
}