package com.app.composableapp.ui.feature.store.domain.model

import com.app.composableapp.ui.feature.store.data.dto.RatingDto

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)
