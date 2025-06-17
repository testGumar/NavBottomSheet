package com.app.nbapp.domain.usecase

import com.app.nbapp.common.Resource
import com.app.nbapp.data.remote.dto.toCoin
import com.app.nbapp.domain.model.Coin
import com.app.nbapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getCoins().map { it.toCoin() }))
        } catch (ex: HttpException) {
            emit(Resource.Error("An unexpected error occurred!"))
        } catch (ex: IOException) {
            emit(Resource.Error("Couldn't reach server, check internet connection!"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message?: "Something went wrong!"))
        }
    }
}