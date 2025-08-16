package com.example.auth.presentation.events

sealed class SignupEvent {
    data class EnteredEmail(val email: String) : SignupEvent()
    data class EnteredFullName(val name: String) : SignupEvent()
    data class EnteredMobile(val mobile: String) : SignupEvent()
    data class EnteredPassword(val password: String) : SignupEvent()
    object Submit : SignupEvent()
}