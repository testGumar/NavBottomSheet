package com.app.composableapp.data.remote

import com.app.composableapp.domain.model.Product
import retrofit2.http.GET

interface AppApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}