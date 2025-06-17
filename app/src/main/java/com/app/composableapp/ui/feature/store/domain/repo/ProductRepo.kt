package com.app.composableapp.ui.feature.store.domain.repo

import arrow.core.Either
import com.app.composableapp.ui.feature.store.domain.model.NetworkError
import com.app.composableapp.ui.feature.store.domain.model.Product

interface ProductRepo {

    suspend fun getProdcuts(): Either<NetworkError, List<Product>>
}