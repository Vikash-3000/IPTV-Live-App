package com.example.auth.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.presentation.events.SignupEvent
import com.example.auth.presentation.state.SignupUiState
import com.example.core.domain.auth.usecase.SignupUseCase
import com.example.core.utils.Validator
import com.example.core.utils.location.LocationService
import com.example.core.utils.state.AuthResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
    private val locationService: LocationService
) : ViewModel() {

    var state by mutableStateOf(SignupUiState())
        private set

    fun fetchLocationAndAddress() {
        viewModelScope.launch(Dispatchers.IO) {
            val location = locationService.getCurrentLocation()
            location?.let {
                val address = locationService.getAddressFromLocation(it.latitude, it.longitude)

                withContext(Dispatchers.Main) {
                    state = state.copy(
                        address = address
                    )
                }
            }
        }
    }

    fun setAddressFallback(value: String) {
        state = state.copy(address = value)
    }

    fun onEvent(event: SignupEvent) {
        when (event) {
            is SignupEvent.EnteredEmail -> {
                state = state.copy(
                    email = event.email,
                    emailError = Validator.validateEmail(event.email)
                )
            }
            is SignupEvent.EnteredFullName -> {
                state = state.copy(
                    fullName = event.name,
                    fullNameError = Validator.validateName(event.name)
                )
            }
            is SignupEvent.EnteredMobile -> {
                state = state.copy(
                    mobile = event.mobile,
                    mobileError = Validator.validatePhone(event.mobile)
                )
            }
            is SignupEvent.EnteredPassword -> {
                state = state.copy(
                    password = event.password,
                    passwordError = Validator.passwordValidationError(event.password, state.email)
                )
            }
            SignupEvent.Submit -> validateAndSubmit()
        }
    }

    private fun validateAndSubmit() {
        val fullNameError = Validator.validateName(state.fullName)
        val emailError = Validator.validateEmail(state.email)
        val mobileError = Validator.validatePhone(state.mobile)
        val passwordError = Validator.passwordValidationError(state.password, state.email)

        if (fullNameError != null || emailError != null || mobileError != null || passwordError != null) {
            state = state.copy(
                fullNameError = fullNameError,
                emailError = emailError,
                mobileError = mobileError,
                passwordError = passwordError
            )
            return
        }

        signup()
    }

    private fun signup() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            val result = signupUseCase(
                email = state.email.trim(),
                password = state.password,
                fullName = state.fullName.trim(),
                mobile = state.mobile.trim(),
                location = state.address ?: ""
            )

            state = when (result) {
                is AuthResultState.Success<*> -> state.copy(isLoading = false, success = true)
                is AuthResultState.Error ->
                    state.copy(isLoading = false, error = result.message)
                else -> state.copy(isLoading = false)
            }
        }
    }
}