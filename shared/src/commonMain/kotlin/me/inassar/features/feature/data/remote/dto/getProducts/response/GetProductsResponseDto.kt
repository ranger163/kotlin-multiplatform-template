package me.inassar.features.feature.data.remote.dto.getProducts.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetProductsResponseDto(
    @SerialName("limit")
    val limit: Int? = null, // 30
    @SerialName("products")
    val products: List<ProductDto?>? = null,
    @SerialName("skip")
    val skip: Int? = null, // 0
    @SerialName("total")
    val total: Int? = null // 100
)

@Serializable
data class ProductDto(
    @SerialName("brand")
    val brand: String? = null, // Apple
    @SerialName("category")
    val category: String? = null, // smartphones
    @SerialName("description")
    val description: String? = null, // An apple mobile which is nothing like apple
    @SerialName("discountPercentage")
    val discountPercentage: Double? = null, // 12.96
    @SerialName("id")
    val id: Int? = null, // 1
    @SerialName("images")
    val images: List<String?>? = null,
    @SerialName("price")
    val price: Int? = null, // 549
    @SerialName("rating")
    val rating: Double? = null, // 4.69
    @SerialName("stock")
    val stock: Int? = null, // 94
    @SerialName("thumbnail")
    val thumbnail: String? = null, // https://i.dummyjson.com/data/products/1/thumbnail.jpg
    @SerialName("title")
    val title: String? = null // iPhone 9
)