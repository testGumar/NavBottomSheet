package com.app.composableapp.ui.feature.store.data.dto

import com.app.composableapp.ui.feature.store.domain.model.Product


data class ProductDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}