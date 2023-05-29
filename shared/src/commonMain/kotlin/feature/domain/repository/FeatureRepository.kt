package feature.domain.repository

import common.network.ResponseResource
import feature.domain.model.DomainProducts
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
interface FeatureRepository {
    suspend fun getProducts(): Flow<ResponseResource<DomainProducts>>
}