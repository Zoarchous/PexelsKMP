package com.innowise.pexelskmp.data.cloud.core.pagination

data class BasePagingItem<T : Any>(
    val items: List<T>,
)
