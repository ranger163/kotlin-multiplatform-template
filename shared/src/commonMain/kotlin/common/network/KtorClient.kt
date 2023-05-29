package common.network

import common.config.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

private const val TIMEOUT = 60_000L

fun ktorHttpClient(
    httpClientEngine: HttpClientEngine,
    enableNetworkLogs: Boolean
) = HttpClient(httpClientEngine) {
    expectSuccess = true

    if (enableNetworkLogs) {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println("Network Logger-> $message")
                }
            }
        }
    }

    install(HttpTimeout) {
        connectTimeoutMillis = TIMEOUT
        requestTimeoutMillis = TIMEOUT
        socketTimeoutMillis = TIMEOUT
    }

    install(ContentNegotiation) {
        json(Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }
    install(ResponseObserver) {
        onResponse { response ->
            if (enableNetworkLogs)
                println("Http status: ${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}

fun HttpRequestBuilder.performCall(path: String) {
    url {
        takeFrom(BASE_URL)
        encodedPath = path
        headers {
            append(
                HttpHeaders.Authorization, "tokenFromSession"
            )
        }
    }

}