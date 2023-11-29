package com.innowise.pexelskmp.domain.photo.remote

import com.innowise.pexelskmp.data.cloud.photos.dto.CollectionsResponse
import com.innowise.pexelskmp.data.cloud.photos.dto.PaginationResponse
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotosResponse

interface PhotosApi {

    suspend fun getCuratedPhotos(page: String, perPage: String): Result<PaginationResponse>

    suspend fun getPhotoById(id: Int): Result<PhotoDto>

    suspend fun getPhotosByQuery(query: String, perPage: String): Result<PhotosResponse>

    suspend fun getFeaturedCollections(perPage: String): Result<CollectionsResponse>
}