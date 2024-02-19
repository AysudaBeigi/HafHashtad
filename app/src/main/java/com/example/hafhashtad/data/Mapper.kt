package com.example.hafhashtad.data

import com.example.hafhashtad.domain.Product
import com.example.hafhashtad.domain.Rating

fun List<ProductDto>.mapToProductList() = map {
    it.mapToProduct()
}
fun ProductDto.mapToProduct() =  Product(
    id = id,
    title = title,
    image = image,
    price = price,
    description = description,
    category = category,
    rating = Rating(rate = rating.rate, count = rating.count)
)