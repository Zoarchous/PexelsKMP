package com.innowise.pexelskmp.data.local.photos

import com.innowise.pexelskmp.data.core.mapFromEntityList
import com.innowise.pexelskmp.data.core.mapToCollectionList
import com.innowise.pexelskmp.data.core.toPhoto
import com.innowise.pexelskmp.database.PhotosDatabase
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.CollectionItem
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
        queries.getAllPhotos().executeAsList().mapFromEntityList()

    override suspend fun getPhotoById(id: Long): Photo =
        queries.getPhotoById(id).executeAsOne().toPhoto()

    override suspend fun cleatPhotos() = queries.clearTable()

    override suspend fun getAllFavorites(): List<Photo> =
        queries.getAllFavorites().executeAsList().mapFromEntityList()

    override suspend fun getCollections(): List<CollectionItem> =
        queries.getAllCollections().executeAsList().mapToCollectionList()

    override suspend fun insertCollectionEntity(collectionItem: CollectionItem) = with(collectionItem) {
        queries.insertCollection(
            id = null,
            title = title
        )
    }
}