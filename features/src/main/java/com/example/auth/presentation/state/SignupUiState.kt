package com.example.auth.presentation.state

// clean UI state holding form data and UI states
data class SignupUiState(
    val fullName: String = "",
    val email: String = "",
    val mobile: String = "",
    val password: String = "",
    val address: String? = null,

    val fullNameError: String? = null,
    val emailError: String? = null,
    val mobileError: String? = null,
    val passwordError: String? = null,

    val isLoading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null
)