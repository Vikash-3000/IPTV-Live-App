package com.example.livetvapp.presentation.ui.loginscreens.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.livetvapp.R
import com.example.livetvapp.presentation.ui.loginscreens.components.AppNameTextComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.ForgotPasswordHeadingTextComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.ImageComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.MyButton
import com.example.livetvapp.presentation.ui.loginscreens.components.PasswordInputComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.TextInfoComponent
import com.example.livetvapp.ui.theme.AppBackground

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    Surface(
        color = AppBackground,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            ImageComponent(image = R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.height(20.dp))
            ForgotPasswordHeadingTextComponent(action = "Reset")
            TextInfoComponent(
                textVal = "Don't worry, strange things happen. Please enter the email address associated with your account."
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                PasswordInputComponent(labelVal = "Password")
                Spacer(modifier = Modifier.height(15.dp))
                PasswordInputComponent(labelVal = "Confirm new password")
            }
            MyButton(labelVal = "Submit", navController = navController)
        }
    }
}