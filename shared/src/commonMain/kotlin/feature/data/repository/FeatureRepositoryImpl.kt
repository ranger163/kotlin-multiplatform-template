package feature.data.repository

import common.network.ResponseResource
import common.network.toUserErrorMessage
import feature.data.remote.FeatureRemoteApi
import feature.domain.mapper.toDomainProducts
import feature.domain.model.DomainProducts
import feature.domain.repository.FeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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