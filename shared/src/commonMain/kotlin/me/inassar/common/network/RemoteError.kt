package me.inassar.common.network

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
fun Throwable.toUserErrorMessage() = runCatching {
    when (this) {
        is RedirectResponseException -> {
            // 3xx - responses
            Throwable(message)
        }

        is ClientRequestException -> {
            // 4xx - responses
            Throwable(message)
        }

        is ServerResponseException -> {
            // 5xx - responses
            Throwable(message)
        }

        else -> {
            Throwable("Unknown error has occurred.")
        }
    }
}.getOrDefault(Throwable("Unknown error has occurred."))