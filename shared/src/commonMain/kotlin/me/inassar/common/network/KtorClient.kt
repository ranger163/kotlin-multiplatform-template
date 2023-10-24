package me.inassar.common.network

import io.github.aakira.napier.Napier
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
import me.inassar.TemplateConfig

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
                    Napier.log(
                        priority = io.github.aakira.napier.LogLevel.INFO,
                        tag = "Network Logger",
                        message = message
                    )
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
                Napier.log(
                    priority = io.github.aakira.napier.LogLevel.INFO,
                    tag = "Http status",
                    message = response.status.value.toString()
                )
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Any)
    }
}

/**
 * @param baseUrl: passing a new baseUrl will override the default one, so you can
 * use multiple baseUrls using same client.
 * @param endpoint: pass your endpoint here to be able to perform your request.
 */
fun HttpRequestBuilder.performCall(endpoint: String, baseUrl: String = TemplateConfig.BASE_URL) = url {
    takeFrom(baseUrl)
    encodedPath = endpoint
    headers {
        append(
            HttpHeaders.Authorization, "tokenFromSession"
        )
    }
}