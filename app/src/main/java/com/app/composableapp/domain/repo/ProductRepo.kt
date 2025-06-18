package com.app.composableapp.domain.repo

import arrow.core.Either
import com.app.composableapp.domain.model.NetworkError
import com.app.composableapp.domain.model.Product

interface ProductRepo {

    suspend fun getProdcuts(): Either<NetworkError, List<Product>>
}