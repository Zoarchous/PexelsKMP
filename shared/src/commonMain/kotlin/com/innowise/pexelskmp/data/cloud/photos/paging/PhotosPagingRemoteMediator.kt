package com.innowise.pexelskmp.data.cloud.photos.paging

import androidx.paging.PagingState
import app.cash.paging.PagingSource
import com.innowise.pexelskmp.data.core.mapFromDto
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.Photo
import com.innowise.pexelskmp.domain.photo.remote.PhotosApi

class PhotosPagingRemoteMediator(
    private val photosApi: PhotosApi,
    private val photosDb: PhotosDataSource,
) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val position = params.key ?: 1
            val photos = photosApi.getCuratedPhotos(position.toString(), params.loadSize.toString())
                .getOrThrow()
                .photos
                .mapFromDto()
            photos.forEach {
                photosDb.insertPhoto(it)
            }
            LoadResult.Page(
                data = photos,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            val photosFromDb = photosDb.getAllPhotos()
            if (photosFromDb.isEmpty())
                LoadResult.Error(e)
            else
                LoadResult.Page(
                    data = photosFromDb,
                    prevKey = null,
                    nextKey = null
                )
        }
    }
}