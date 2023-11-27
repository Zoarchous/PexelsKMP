package com.innowise.pexelskmp.domain.photo.useCases

import com.innowise.pexelskmp.domain.photo.repository.PhotosRepository

class GetCuratedPhotosUseCase(
    private val repository: PhotosRepository
) {
    suspend fun getCuratedPhotos() = repository.getCuratedPhotos()
}