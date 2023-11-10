package com.innowise.pexelskmp.data.cloud.core

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HttpKtorClient {
    fun createHttpClient() = HttpClient {
        install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }

        install(Logging) { logger = Logger.SIMPLE }

        defaultRequest {
            url {
                host = "api.pexels.com"
                protocol = URLProtocol.HTTPS
                headers.append("Authorization", "Ljn2UedHlkxlowwdfqupawsiCLN1zgUU3kUTHNLPL2FQZb256pxwEqBv") //todo вынести в конфиг
            }
        }
    }

    companion object {
        const val API_V1 = "/v1"
    }
}