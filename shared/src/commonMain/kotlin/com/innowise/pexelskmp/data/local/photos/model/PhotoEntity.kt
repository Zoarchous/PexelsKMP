package com.innowise.pexelskmp.data.local.photos.model

data class PhotoEntity(
    val id: Long,
    val url: String,
    val photographer: String,
    val isFavorite: Boolean
)
