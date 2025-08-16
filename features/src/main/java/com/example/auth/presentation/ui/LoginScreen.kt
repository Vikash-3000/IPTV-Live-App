package com.example.auth.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.auth.presentation.components.AppNameTextComponent
import com.example.auth.presentation.components.BottomComponent
import com.example.auth.presentation.components.BottomLoginTextComponent
import com.example.auth.presentation.components.ForgotPasswordTextComponent
import com.example.auth.presentation.components.HeadingTextComponent
import com.example.auth.presentation.components.ImageComponent
import com.example.auth.presentation.components.MyTextField
import com.example.livetvapp.features.R
import theme.AppBackground

@Composable
fun LoginScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(20.dp), color = AppBackground
    ) {
        Column() {
            Spacer(modifier = Modifier.Companion.height(10.dp))
            ImageComponent(image = com.example.livetvapp.commons.R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            HeadingTextComponent(heading = "Login")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            Column {
                MyTextField(
                    labelVal = "email ID",
                    R.drawable.at_symbol,
                    value = "",
                    onValueChange = {},
                    isError = false,
                    supportingText = {}
                )
                Spacer(modifier = Modifier.Companion.height(15.dp))
//                PasswordInputComponent(labelVal = "Password")
                Spacer(modifier = Modifier.Companion.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.Companion.fillMaxWidth()
                ) {
                    ForgotPasswordTextComponent(navController)
                }
                Box(
                    modifier = Modifier.Companion.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter // ⬅️ Center horizontally at bottom
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally // ⬅️ Center Column contents horizontally
                    ) {
                        BottomComponent(navController)
                        Spacer(modifier = Modifier.Companion.height(12.dp))
                        BottomLoginTextComponent(
                            initialText = "New to StreamX? ",
                            action = "Sign Up!",
                            navController = navController
                        )
                        Spacer(modifier = Modifier.Companion.height(18.dp))
                    }
                }

            }
        }
    }
}

