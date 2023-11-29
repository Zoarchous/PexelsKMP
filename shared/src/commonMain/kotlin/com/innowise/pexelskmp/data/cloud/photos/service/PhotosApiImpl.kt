package com.innowise.pexelskmp.data.cloud.photos.service

import com.innowise.pexelskmp.data.cloud.core.HttpKtorClient
import com.innowise.pexelskmp.data.cloud.core.getResult
import com.innowise.pexelskmp.data.cloud.photos.dto.CollectionsResponse
import com.innowise.pexelskmp.data.cloud.photos.dto.PaginationResponse
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotoDto
import com.innowise.pexelskmp.data.cloud.photos.dto.PhotosResponse
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi
import io.ktor.client.*
import io.ktor.http.*

class PhotosApiImpl(private val client: HttpClient) : PhotosApi {

    override suspend fun getCuratedPhotos(page: String, perPage: String): Result<PaginationResponse> = client
        .getResult {
            println("Api call")
            url {
                path("${HttpKtorClient.API_V1}/curated")
                parameters.append(PAGE, page)
                parameters.append(PER_PAGE, perPage)
            }
        }

    override suspend fun getPhotoById(id: Int): Result<PhotoDto> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/photos/${path("$id")}")
            }
        }

    override suspend fun getPhotosByQuery(query: String, perPage: String): Result<PhotosResponse> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/search")
                parameters.append(QUERY, query)
                parameters.append(PER_PAGE, perPage)
            }
        }

    override suspend fun getFeaturedCollections(perPage: String): Result<CollectionsResponse> = client
        .getResult {
            url {
                path("${HttpKtorClient.API_V1}/collections/featured")
                parameters.append(PER_PAGE, perPage)
            }
        }

    companion object {
        private const val PER_PAGE = "per_page"
        private const val PAGE = "page"
        private const val QUERY = "query"
    }
}