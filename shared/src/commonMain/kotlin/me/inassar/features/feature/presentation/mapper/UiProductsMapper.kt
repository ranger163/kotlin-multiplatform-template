package me.inassar.features.feature.presentation.mapper

import me.inassar.features.feature.domain.model.DomainProducts
import me.inassar.features.feature.presentation.data.UiProduct
import me.inassar.features.feature.presentation.data.UiProducts

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
fun DomainProducts.toUiProducts() = UiProducts(
    products = this.products.map { domainProduct ->
        UiProduct(
            description = domainProduct.description,
            id = domainProduct.id,
            price = domainProduct.price,
            rating = domainProduct.rating,
            thumbnail = domainProduct.thumbnail,
            title = domainProduct.title,
        )
    }
)