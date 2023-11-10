package com.innowise.pexelskmp.data.cloud.photos.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.innowise.pexelskmp.data.cloud.photos.service.PhotosApi
import com.innowise.pexelskmp.data.local.photos.model.PhotoEntity

@OptIn(ExperimentalPagingApi::class)
class PagingRemoteMediator(
    private val photosApi: PhotosApi,
) : RemoteMediator<Int, PhotoEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PhotoEntity>,
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}