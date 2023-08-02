package me.inassar.features.feature.domain.repository

import kotlinx.coroutines.flow.Flow
import me.inassar.common.network.ResponseResource
import me.inassar.features.feature.domain.model.DomainProducts

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
interface FeatureRepository {
    suspend fun getProducts(): Flow<ResponseResource<DomainProducts>>
}