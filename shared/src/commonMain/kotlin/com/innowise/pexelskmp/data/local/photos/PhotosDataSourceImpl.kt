package com.innowise.pexelskmp.data.local.photos

import com.innowise.pexelskmp.data.core.mapFromEntity
import com.innowise.pexelskmp.data.core.toPhoto
import com.innowise.pexelskmp.database.PhotosDatabase
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.Photo

class PhotosDataSourceImpl(db: PhotosDatabase) : PhotosDataSource {
    private val queries = db.photoQueries
    override suspend fun insertPhoto(photo: Photo) = with(photo) {
        queries.insertPhoto(
            id = id,
            url = imageUrl,
            photographer = photographer,
            isFavorite = isFavorite
        )
    }

    override suspend fun getAllPhotos(): List<Photo> =
        queries.getAllPhotos().executeAsList().mapFromEntity()

    override suspend fun getPhotoById(id: Long): Photo =
        queries.getPhotoById(id).executeAsOne().toPhoto()

    override suspend fun cleatPhotos() = queries.clearTable()

    override suspend fun getAllFavorites(): List<Photo> =
        queries.getAllFavorites().executeAsList().mapFromEntity()
}