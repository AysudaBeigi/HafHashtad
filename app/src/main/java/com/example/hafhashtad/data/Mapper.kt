package com.example.hafhashtad.data

import com.example.hafhashtad.domain.Category
import com.example.hafhashtad.domain.Product
import com.example.hafhashtad.domain.Rating

fun List<ProductDto>.mapToProductList() = map {
    it.mapToProduct()
}

fun ProductDto.mapToProduct() = Product(
    id = id,
    title = title,
    image = image,
    price = price,
    description = description,
    category = when (category) {
        "women's clothing" -> Category.WOMEN_CLOTHING
        "men's clothing" -> Category.MEN_CLOTHING
        "jewelery" -> Category.JEWELERY
        else -> Category.ELECTRONIC
    },
    rating = Rating(rate = rating.rate, count = rating.count)
)