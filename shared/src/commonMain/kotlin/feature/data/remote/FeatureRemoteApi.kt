package feature.data.remote

import common.network.ResponseResource
import feature.data.remote.dto.getProducts.response.GetProductsResponseDto

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
interface FeatureRemoteApi {
    suspend fun getProductsList(): ResponseResource<GetProductsResponseDto>
}