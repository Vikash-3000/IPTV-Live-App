package com.example.core.utils.state

sealed class AuthResultState<out T> {
    object Loading : AuthResultState<Nothing>()
    data class Success<T>(val data: T) : AuthResultState<T>()
    data class Error(val message: String) : AuthResultState<Nothing>()
}