package com.app.composableapp.presentation.products_screen

import com.app.composableapp.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
