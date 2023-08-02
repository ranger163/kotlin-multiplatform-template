package me.inassar.features.feature.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.inassar.common.network.ResponseResource
import me.inassar.common.network.toUserErrorMessage
import me.inassar.features.feature.data.remote.FeatureRemoteApi
import me.inassar.features.feature.domain.mapper.toDomainProducts
import me.inassar.features.feature.domain.model.DomainProducts
import me.inassar.features.feature.domain.repository.FeatureRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FeatureRepositoryImpl : FeatureRepository, KoinComponent {
    private val remote: FeatureRemoteApi by inject()

    override suspend fun getProducts(): Flow<ResponseResource<DomainProducts>> = flow {
        when (val result = remote.getProductsList()) {
            is ResponseResource.Error -> emit(ResponseResource.error(result.error.toUserErrorMessage()))
            is ResponseResource.Success -> emit(ResponseResource.success(result.data.toDomainProducts()))
        }
    }
}