package com.innowise.pexelskmp.data.cloud.photos.service

import com.innowise.pexelskmp.data.cloud.core.HttpKtorClient
import com.innowise.pexelskmp.data.cloud.core.getResult
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotosResponse
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi
import io.ktor.client.*
import io.ktor.http.*

class PhotosApiImpl(private val client: HttpClient): PhotosApi {
    override suspend fun getCuratedPhotos(): Result<PhotosResponse> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/curated")
                parameters.append(PAGE, "1")
                parameters.append(PER_PAGE, PER_PAGE_COUNT)
            }
        }

    override suspend fun getPhotoById(id: Int): Result<PhotoDto> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/photos/${path("$id")}")
            }
        }

    override suspend fun getPhotosByQuery(query: String): Result<PhotosResponse> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/search")
                parameters.append(QUERY, query)
                parameters.append(PER_PAGE, PER_PAGE_COUNT)
            }
        }

    companion object {
        private const val PER_PAGE_COUNT = "30"
        private const val PER_PAGE = "per_page"
        private const val PAGE = "page"
        private const val QUERY = "query"
    }
}