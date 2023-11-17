package com.innowise.pexelskmp.data.local.photos

import com.innowise.pexelskmp.database.PhotosDatabase
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.Photo

class PhotosDataSourceImpl(db: PhotosDatabase): PhotosDataSource {
    private val queries = db.photoQueries
    override suspend fun insertPhoto(photo: Photo) = with(photo) {
        queries.insertPhoto(
            id = id,
            url = imageUrl,
            photographer = photographer,
            isFavorite = isFavorite
        )
    }

    override suspend fun getAllPhotos(): List<Photo> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotoById(id: Int): Photo {
        TODO("Not yet implemented")
    }

    override suspend fun cleatPhotos() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFavorites(isFavorite: Boolean): List<Photo> {
        TODO("Not yet implemented")
    }
}