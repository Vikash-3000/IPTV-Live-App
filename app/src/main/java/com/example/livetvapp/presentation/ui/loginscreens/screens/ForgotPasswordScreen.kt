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
import com.example.livetvapp.presentation.ui.loginscreens.components.MyTextField
import com.example.livetvapp.presentation.ui.loginscreens.components.TextInfoComponent
import com.example.livetvapp.ui.theme.AppBackground

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        color = AppBackground
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            ImageComponent(image = R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.height(20.dp))
            ForgotPasswordHeadingTextComponent(action = "Forgot")
            TextInfoComponent(
                textVal = "Forgot your password? Enter the email linked to your StreamX account to reset it."
            )
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelVal = "email ID", icon = R.drawable.at_symbol)
            MyButton(labelVal = "Submit", navController)
        }
    }
}
