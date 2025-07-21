package com.example.auth.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.auth.presentation.ui.forgetpassword.ForgotPasswordScreen
import com.example.auth.presentation.ui.login.LoginScreen
import com.example.auth.presentation.ui.resetpassword.ResetPasswordScreen
import com.example.auth.presentation.ui.signup.SignupScreen
import com.example.core.navigation.Screen

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable(Screen.Login.route) {
        LoginScreen(navController)
    }
    composable(Screen.ForgotPassword.route) {
        ForgotPasswordScreen(navController)
    }
    composable(Screen.ResetPassword.route) {
        ResetPasswordScreen(navController)
    }
    composable(Screen.Signup.route) {
        SignupScreen(navController)
    }
}