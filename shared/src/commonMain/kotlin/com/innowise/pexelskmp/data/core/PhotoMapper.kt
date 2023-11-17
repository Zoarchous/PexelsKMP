package com.innowise.pexelskmp.data.core

import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.data.local.photos.model.PhotoEntity
import com.innowise.pexelskmp.domain.photo.model.Photo

fun PhotoEntity.toPhoto(): Photo = Photo(
    id = id,
    imageUrl = url,
    photographer = photographer,
    isFavorite = isFavorite
)

fun PhotoDto.toPhoto(): Photo = Photo(
    id = id.toLong(),
    imageUrl = url,
    photographer = photographer,
    isFavorite = false
)

fun List<PhotoEntity>.toPhotoList(): List<Photo> = map { it.toPhoto() }

fun List<PhotoDto>.toPhotoList(): List<Photo> = map { it.toPhoto() }