package com.app.nbapp.domain.repository

import com.app.nbapp.data.remote.dto.CoinDetailDto
import com.app.nbapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto

}