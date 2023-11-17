package com.innowise.pexelskmp.data.cloud.photos.paging

import androidx.paging.ExperimentalPagingApi
import com.innowise.pexelskmp.data.cloud.core.pagination.BasePagingItem
import com.innowise.pexelskmp.data.cloud.core.pagination.BasePagingSource
import com.innowise.pexelskmp.data.cloud.photos.service.PhotosApiImpl
import com.innowise.pexelskmp.domain.photo.local.PhotosDataSource
import com.innowise.pexelskmp.domain.photo.model.Photo

@OptIn(ExperimentalPagingApi::class)
class PhotosPagingRemoteMediator(
    private val photosApiImpl: PhotosApiImpl,
    private val photosDataSource: PhotosDataSource,
) : BasePagingSource<Photo>() {
    override suspend fun fetchData(page: Int, limit: Int): BasePagingItem<Photo> {
        TODO()
    }
}