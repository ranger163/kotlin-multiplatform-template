package me.inassar.features.feature.data.remote.source

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import me.inassar.common.network.ResponseResource
import me.inassar.common.network.performCall
import me.inassar.features.feature.data.remote.FeatureRemoteApi
import me.inassar.features.feature.data.remote.dto.getProducts.response.GetProductsResponseDto
import org.koin.core.component.KoinComponent

class FeatureRemoteApiImpl(private val client: HttpClient) : FeatureRemoteApi, KoinComponent {
    override suspend fun getProductsList(): ResponseResource<GetProductsResponseDto> = runCatching {
        val response =
            client.get { performCall(endpoint = "products") }.body<GetProductsResponseDto>()
        ResponseResource.success(response)
    }.getOrElse { error ->
        ResponseResource.error(error)
    }
}