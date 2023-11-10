package com.innowise.pexelskmp.data.cloud.photos.dto

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PhotosResponse(
    val photos: List<PhotoDto>
): Parcelable
