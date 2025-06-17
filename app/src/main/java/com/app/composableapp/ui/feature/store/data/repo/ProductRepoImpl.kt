package com.app.composableapp.ui.feature.store.data.repo

import arrow.core.Either
import com.app.composableapp.ui.feature.store.data.mapper.toNetworkError
import com.app.composableapp.ui.feature.store.data.remote.AppApi
import com.app.composableapp.ui.feature.store.domain.model.NetworkError
import com.app.composableapp.ui.feature.store.domain.model.Product
import com.app.composableapp.ui.feature.store.domain.repo.ProductRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val api: AppApi
) : ProductRepo {
    override suspend fun getProdcuts(): Either<NetworkError, List<Product>> {
        return Either.catch { api.getProducts() }.mapLeft { it.toNetworkError() }
    }
}