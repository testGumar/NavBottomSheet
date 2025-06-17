package com.app.composableapp.ui.feature.store.data.remote

import com.app.composableapp.ui.feature.store.domain.model.Product
import retrofit2.http.GET

interface AppApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}