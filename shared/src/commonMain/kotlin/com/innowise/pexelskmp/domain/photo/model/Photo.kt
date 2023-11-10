package com.innowise.pexelskmp.domain.photo.model

data class Photo(
    val id: Int,
    val imageUrl: String,
    val photographer: String,
    val isFavorite: Boolean
)
