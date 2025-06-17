package com.app.composableapp.ui.feature.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.composableapp.ui.feature.store.domain.repo.ProductRepo
import com.app.composableapp.ui.feature.store.presentation.util.sendEvent
import com.app.composableapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepo: ProductRepo
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            productRepo.getProdcuts()
                .onRight { result ->
                    _state.update { it.copy(products = result) }
                }
                .onLeft { error ->
                    _state.update { it.copy(error = error.error.msg) }
                    sendEvent(Event.Toast(error.error.msg))
                }
            _state.update { it.copy(isLoading = false) }
        }

    }
}