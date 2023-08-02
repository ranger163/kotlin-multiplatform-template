package me.inassar.features.feature.domain.mapper

import me.inassar.common.config.DEFAULT_DOUBLE
import me.inassar.common.config.DEFAULT_INT
import me.inassar.common.config.DEFAULT_STRING
import me.inassar.features.feature.data.remote.dto.getProducts.response.GetProductsResponseDto
import me.inassar.features.feature.domain.model.DomainProduct
import me.inassar.features.feature.domain.model.DomainProducts

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
fun GetProductsResponseDto.toDomainProducts() = DomainProducts(
    limit = this.limit ?: DEFAULT_INT,
    products = this.products?.map { productDto ->
        DomainProduct(
            brand = productDto?.brand ?: DEFAULT_STRING,
            category = productDto?.category ?: DEFAULT_STRING,
            description = productDto?.description ?: DEFAULT_STRING,
            discountPercentage = productDto?.discountPercentage ?: DEFAULT_DOUBLE,
            id = productDto?.id ?: DEFAULT_INT,
            images = productDto?.images?.map { it ?: DEFAULT_STRING }.orEmpty(),
            price = productDto?.price ?: DEFAULT_INT,
            rating = productDto?.rating ?: DEFAULT_DOUBLE,
            stock = productDto?.stock ?: DEFAULT_INT,
            thumbnail = productDto?.thumbnail ?: DEFAULT_STRING,
            title = productDto?.title ?: DEFAULT_STRING,
        )
    }.orEmpty(),
    skip = this.skip ?: DEFAULT_INT,
    total = this.total ?: DEFAULT_INT,
)