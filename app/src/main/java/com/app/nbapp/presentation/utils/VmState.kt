package com.app.nbapp.presentation.utils

sealed class VmState<out T> {
    object Loading : VmState<Nothing>()
    data class Success<T>(val data: T) : VmState<T>()
    data class Error(val message: String) : VmState<Nothing>()
}
