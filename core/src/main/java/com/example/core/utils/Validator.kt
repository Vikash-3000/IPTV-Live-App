package com.example.core.utils

import android.util.Patterns

object Validator {

    fun validateName(name: String): String? =
        if (name.isBlank()) "Full name is required" else null

    fun validateEmail(email: String): String? =
        if (email.isEmpty()) "Email is required"
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Invalid email" else null

    fun validatePhone(phone: String): String? =
        if (phone.isBlank()) "Phone number is required"
        else if (phone.length != 10 || !phone.all { it.isDigit() }) "Phone number must be 10 digits" else null

    fun passwordValidationError(password: String, email: String): String? {
        if (password.isBlank()) return "Password is required"
        if (password.length < 8) return "At least 8 characters required"
        if (!password.any { it.isUpperCase() }) return "One uppercase letter required"
        if (!password.any { it.isLowerCase() }) return "One lowercase letter required"
        if (!password.any { it.isDigit() }) return "One digit required"
        if (!password.any { "!@#\$%^&*()_+=-{}[]|:;\"'<>,.?/".contains(it) }) return "One special character required"
        if (email.isNotBlank() && password.contains(email.split("@").first(), ignoreCase = true))
            return "Password must not contain your email"
        return null
    }
}

