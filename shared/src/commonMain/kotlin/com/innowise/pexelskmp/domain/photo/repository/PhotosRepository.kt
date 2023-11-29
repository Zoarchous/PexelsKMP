package com.innowise.pexelskmp.domain.photo.repository

import androidx.paging.PagingData
import com.innowise.pexelskmp.data.cloud.photos.dto.CollectionsResponse
import com.innowise.pexelskmp.domain.photo.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    suspend fun getCuratedPhotos(): Flow<PagingData<Photo>>

    suspend fun getPhotosByQuery(query: String): Result<List<Photo>>

    suspend fun getPhotoById(id: Int): Result<Photo>

    suspend fun getFeaturedCollections(): Result<CollectionsResponse>

}