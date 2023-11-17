package com.innowise.pexelskmp.data.cloud.core.pagination

import androidx.paging.PagingState
import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage

abstract class BasePagingSource<T : Any> : PagingSource<Int, T>() {

    protected abstract suspend fun fetchData(page: Int, limit: Int): BasePagingItem<T>
    override fun getRefreshKey(state: PagingState<Int, T>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val currentPage = params.key ?: START_PAGE
        val limit = params.loadSize
        return try {
            val response = fetchData(currentPage, limit)
            PagingSourceLoadResultPage(
                data = response.items,
                prevKey = if (currentPage == START_PAGE) null else currentPage - 1,
                nextKey = (currentPage + 1).takeIf { response.items.lastIndex >= currentPage }
            )
        } catch (e: Exception) {
            PagingSourceLoadResultError(e)
        }
    }

    companion object {
        private const val START_PAGE = 1
    }
}