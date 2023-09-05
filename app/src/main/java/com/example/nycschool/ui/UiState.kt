package com.example.nycschool.ui

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
sealed class UiState<T> {
    class Loading<T> : UiState<T>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error<T>(val error: String) : UiState<T>()
}
