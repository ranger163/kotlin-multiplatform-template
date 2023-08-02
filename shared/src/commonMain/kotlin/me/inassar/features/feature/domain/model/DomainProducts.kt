package me.inassar.features.feature.domain.model


data class DomainProducts(
    val limit: Int,
    val products: List<DomainProduct>,
    val skip: Int,
    val total: Int
)


data class DomainProduct(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)