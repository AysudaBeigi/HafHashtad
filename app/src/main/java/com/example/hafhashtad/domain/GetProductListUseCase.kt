package com.example.hafhashtad.domain

class GetProductListUseCase(private val repository: IRepository) {
    suspend fun execute() = repository.getProducts()
}