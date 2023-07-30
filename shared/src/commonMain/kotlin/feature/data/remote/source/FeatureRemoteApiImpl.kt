package feature.data.remote.source

import common.network.ResponseResource
import common.network.performCall
import feature.data.remote.FeatureRemoteApi
import feature.data.remote.dto.getProducts.response.GetProductsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
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