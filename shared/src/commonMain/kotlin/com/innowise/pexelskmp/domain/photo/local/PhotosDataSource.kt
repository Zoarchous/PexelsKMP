package com.innowise.pexelskmp.domain.photo.local

import com.innowise.pexelskmp.domain.photo.model.Photo

interface PhotosDataSource {

    suspend fun insertPhoto(photo: Photo)
    suspend fun getAllPhotos(): List<Photo>

    suspend fun getPhotoById(id: Int): Photo

    suspend fun cleatPhotos()

    suspend fun getAllFavorites(isFavorite: Boolean): List<Photo>
}