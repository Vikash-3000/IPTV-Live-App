package com.example.auth.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.auth.presentation.components.AppNameTextComponent
import com.example.auth.presentation.components.ForgotPasswordHeadingTextComponent
import com.example.auth.presentation.components.ImageComponent
import com.example.auth.presentation.components.MyButton
import com.example.auth.presentation.components.TextInfoComponent
import com.example.livetvapp.commons.R
import theme.AppBackground

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    Surface(
        color = AppBackground, modifier = Modifier.Companion
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.Companion.height(10.dp))
            ImageComponent(image = R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            ForgotPasswordHeadingTextComponent(action = "Reset")
            TextInfoComponent(
                textVal = "Don't worry, strange things happen. Please enter the email address associated with your account."
            )
            Spacer(modifier = Modifier.Companion.height(20.dp))
            Column {
//                PasswordInputComponent(labelVal = "Password")
                Spacer(modifier = Modifier.Companion.height(15.dp))
//                PasswordInputComponent(labelVal = "Confirm new password")
            }
            MyButton(labelVal = "Submit",
                onClick = { /*TODO*/ },
                navController = navController)
        }
    }
}