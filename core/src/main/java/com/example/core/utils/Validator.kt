package com.example.core.utils

object Validator {

    fun isValidPassword(password: String, email: String): Boolean {
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\$%^&*()_+=\\-{}\\[\\]:\";'<>?,./]).{8,}$")
        return passwordRegex.matches(password) && !password.contains(email.split("@").first(), ignoreCase = true)
    }

    fun passwordValidationError(password: String, email: String): String? {
        if (password.length < 8) return "Password must be at least 8 characters"
        if (!password.any { it.isUpperCase() }) return "Password must contain at least one uppercase letter"
        if (!password.any { it.isLowerCase() }) return "Password must contain at least one lowercase letter"
        if (!password.any { it.isDigit() }) return "Password must contain at least one digit"
        if (!password.any { "!@#\$%^&*()_+=-{}[]|:;\"'<>,.?/".contains(it) }) return "Password must have one special character"
        if (password.contains(email.split("@").first(), ignoreCase = true)) return "Password must not contain your email"
        return null // Valid
    }
}