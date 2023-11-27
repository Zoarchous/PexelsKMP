package com.innowise.pexelskmp.data.cloud.photos.dto

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PaginationResponse(
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoDto>,
    val next_page: String?,
    val total_results: Int
): Parcelable