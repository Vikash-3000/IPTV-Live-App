package com.example.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("LoginScreen")
    object ForgotPassword : Screen("ForgotPassword")
    object ResetPassword : Screen("ResetPassword")
    object Signup : Screen("SignupScreen")
}
