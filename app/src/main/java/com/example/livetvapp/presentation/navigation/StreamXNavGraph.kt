package com.example.livetvapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.presentation.navigation.authGraph
import com.example.core.navigation.Screen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route // Replace with Splash/Home logic later
    ) {
        authGraph(navController)

        // Add more graph functions like:
        // homeGraph(navController)
        // profileGraph(navController)
    }
}