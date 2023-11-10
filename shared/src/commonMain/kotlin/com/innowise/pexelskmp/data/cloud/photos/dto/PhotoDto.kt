package com.innowise.pexelskmp.data.cloud.photos.dto

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PhotoDto(
    val id: Int,
    val url: String,
    val photographer: String
): Parcelable