package com.example.jetpackcompose.data.remote

import com.example.jetpackcompose.domain.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts()  : List<Product>
}