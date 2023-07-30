package me.inassar.common.network

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
sealed class ResponseResource<T> {
    data class Success<T>(val data: T) : ResponseResource<T>()
    data class Error<T>(val error: Throwable) : ResponseResource<T>()

    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> error(error: Throwable) = Error<T>(error)
    }
}