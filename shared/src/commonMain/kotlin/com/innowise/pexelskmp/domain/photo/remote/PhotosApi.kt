package com.innowise.pexelskmp.domain.photo.remote

import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotosResponse

interface PhotosApi {
    suspend fun getCuratedPhotos(): Result<PhotosResponse>

    suspend fun getPhotoById(id: Int): Result<PhotoDto>

    suspend fun getPhotosByQuery(query: String): Result<PhotosResponse>
}