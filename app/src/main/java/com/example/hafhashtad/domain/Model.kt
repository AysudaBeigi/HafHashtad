package com.example.hafhashtad.domain

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: Category,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int,
)
enum class Category {
    MEN_CLOTHING,JEWELERY , WOMEN_CLOTHING,ELECTRONIC
}