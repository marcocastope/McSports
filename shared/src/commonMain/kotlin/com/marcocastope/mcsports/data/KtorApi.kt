package com.marcocastope.mcsports.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal abstract class KtorApi {

    companion object {
        private const val BASE_URL = "https://apiv2.allsportsapi.com/"
        private const val API_KEY = "yourApiKey"
    }

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String, methodName: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            parameter("met", methodName)
            parameter("APIkey", API_KEY)
        }
    }
}