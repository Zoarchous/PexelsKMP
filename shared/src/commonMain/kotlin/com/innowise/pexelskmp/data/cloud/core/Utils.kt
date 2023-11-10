package com.innowise.pexelskmp.data.cloud.core

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

suspend inline fun <reified T> HttpClient.getResult(
    block: HttpRequestBuilder.() -> Unit = {},
): Result<T> = com.innowise.pexelskmp.data.cloud.core.request {
    get { block() }
}

suspend inline fun <reified T> request(
    requester: () -> HttpResponse,
): Result<T> = try {
    val httpResponse: HttpResponse = requester()
    val response: T = httpResponse.body()
    Result.success(response)
} catch (exception: ResponseException) {
    Result.failure(exception)
} catch (exception: Throwable) {
    exception.printStackTrace()
    Result.failure(exception)
}