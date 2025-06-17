package com.app.nbapp.data.repository

import com.app.nbapp.data.remote.CoinPaprikaApi
import com.app.nbapp.data.remote.dto.CoinDetailDto
import com.app.nbapp.data.remote.dto.CoinDto
import com.app.nbapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}