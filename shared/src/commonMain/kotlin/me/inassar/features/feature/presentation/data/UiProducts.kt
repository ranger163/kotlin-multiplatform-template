package me.inassar.features.feature.presentation.data


data class UiProducts(
    val products: List<UiProduct>
)


data class UiProduct(
    val description: String,
    val id: Int,
    val price: Int,
    val rating: Double,
    val thumbnail: String,
    val title: String
)