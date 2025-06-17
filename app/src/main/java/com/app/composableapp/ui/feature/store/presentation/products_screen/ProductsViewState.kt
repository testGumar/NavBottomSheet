package com.app.composableapp.ui.feature.store.presentation.products_screen

import com.app.composableapp.ui.feature.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
