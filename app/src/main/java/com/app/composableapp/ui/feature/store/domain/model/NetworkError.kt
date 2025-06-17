package com.app.composableapp.ui.feature.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable?
)
enum class ApiError(val msg: String){
    NetworkError("Network Error!"),
    UnknownError("Unknown Response!"),
    UnknownResponse("Unknown Error!"),
}