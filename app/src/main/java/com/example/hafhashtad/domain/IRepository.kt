package com.example.hafhashtad.domain

interface IRepository {
    suspend fun getProducts():List<Product>
}