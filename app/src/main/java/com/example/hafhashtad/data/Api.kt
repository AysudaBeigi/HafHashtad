package com.example.hafhashtad.data

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductDto>>

}
