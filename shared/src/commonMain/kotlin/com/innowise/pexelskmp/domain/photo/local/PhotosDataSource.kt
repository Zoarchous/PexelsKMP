package com.innowise.pexelskmp.domain.photo.local

import com.innowise.pexelskmp.domain.photo.model.CollectionItem
import com.innowise.pexelskmp.domain.photo.model.Photo

interface PhotosDataSource {

    suspend fun insertPhoto(photo: Photo)
    suspend fun getAllPhotos(): List<Photo>

    suspend fun getPhotoById(id: Long): Photo

    suspend fun cleatPhotos()

    suspend fun getAllFavorites(): List<Photo>

    suspend fun getCollections(): List<CollectionItem>

    suspend fun insertCollectionEntity(collectionItem: CollectionItem)
}