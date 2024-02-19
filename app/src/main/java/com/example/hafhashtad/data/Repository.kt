package com.example.hafhashtad.data

import com.example.hafhashtad.domain.IRepository
import com.example.hafhashtad.domain.Product

class Repository(private val api: Api) : IRepository {
    override suspend fun getProducts(): List<Product> {
       return api.getProducts().body()!!.mapToProductList()
    }
}