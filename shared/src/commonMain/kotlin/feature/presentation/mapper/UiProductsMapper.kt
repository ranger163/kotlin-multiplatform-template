package feature.presentation.mapper

import feature.domain.model.DomainProducts
import feature.presentation.data.UiProduct
import feature.presentation.data.UiProducts

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