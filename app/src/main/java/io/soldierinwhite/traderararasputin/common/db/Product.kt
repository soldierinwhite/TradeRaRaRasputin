package io.soldierinwhite.traderararasputin.common.db

data class Products(
    val products: List<Product>
)

data class Product(
    val id: String,
    val title: String,
    val price: Int,
    val currency: String,
    val image: String
)
