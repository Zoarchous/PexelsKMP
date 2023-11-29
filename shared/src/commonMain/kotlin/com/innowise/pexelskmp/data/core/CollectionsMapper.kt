package com.innowise.pexelskmp.data.core

import com.innowise.pexelskmp.data.cloud.photos.dto.CollectionDto
import com.innowise.pexelskmp.domain.photo.model.CollectionItem
import database.CollectionEntity

fun CollectionDto.toCollectionItem() = CollectionItem(title = title)

fun CollectionEntity.toCollectionItem() = CollectionItem(title = title)

fun List<CollectionDto>.mapToCollectionList() = map { CollectionItem(title = it.title) }

fun List<CollectionEntity>.mapToCollectionList() = map { CollectionItem(title = it.title) }
