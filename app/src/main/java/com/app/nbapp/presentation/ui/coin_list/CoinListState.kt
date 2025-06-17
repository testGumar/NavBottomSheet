package com.app.nbapp.presentation.ui.coin_list

import com.app.nbapp.common.Resource
import com.app.nbapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
