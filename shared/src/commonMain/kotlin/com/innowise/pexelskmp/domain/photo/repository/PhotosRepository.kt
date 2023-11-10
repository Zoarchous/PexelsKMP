package com.innowise.pexelskmp.domain.photo.repository

interface PhotosRepository {
    suspend fun getPhotos()
}