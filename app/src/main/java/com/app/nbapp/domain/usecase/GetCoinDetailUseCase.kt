package com.app.nbapp.domain.usecase

import com.app.nbapp.common.Resource
import com.app.nbapp.data.remote.dto.toCoinDetail
import com.app.nbapp.domain.model.CoinDetail
import com.app.nbapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getCoinById(coinId).toCoinDetail()))
        } catch (ex: HttpException) {
            emit(Resource.Error("An unexpected error occurred!"))
        } catch (ex: IOException) {
            emit(Resource.Error("Couldn't reach server, check internet connection!"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message?: "Something went wrong!"))
        }
    }
}