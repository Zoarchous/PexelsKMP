package com.innowise.pexelskmp.data.core

import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.domain.photo.model.Photo
import database.PhotoEntity

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

fun List<PhotoEntity>.mapFromEntity(): List<Photo> = map { it.toPhoto() }

fun List<PhotoDto>.mapFromDto(): List<Photo> = map { it.toPhoto() }