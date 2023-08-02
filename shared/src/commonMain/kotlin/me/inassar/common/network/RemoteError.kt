package me.inassar.common.network

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import me.inassar.common.locale.GeneralStrings

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
            Throwable(GeneralStrings.Network.NETWORK_UNKNOWN_ERROR.localize())
        }
    }
}.getOrDefault(Throwable(GeneralStrings.Network.NETWORK_UNKNOWN_ERROR.localize()))