package com.app.nbapp.presentation.ui.coin_list

import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
//import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.nbapp.common.Resource
import com.app.nbapp.domain.model.Coin
import com.app.nbapp.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    private val _coinState = MutableStateFlow<Resource<List<Coin>>>(Resource.Loading())
    val coinState: StateFlow<Resource<List<Coin>>> = _coinState

//    private val _state = mutableStateOf(CoinListState())
//    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins () {
        getCoinsUseCase()
            .onEach { result ->
                _coinState.value = result
            }
            .launchIn(viewModelScope)
//        getCoinsUseCase().onEach { result ->
//            when (result) {
//                is Resource.Loading -> {}
//                is Resource.Success -> {
//                    _coinState.value = result
//                }
//                is Resource.Error -> {}
//            }
//        }.launchIn(viewModelScope)
    }
}