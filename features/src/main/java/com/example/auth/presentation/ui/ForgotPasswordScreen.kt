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
import com.example.auth.presentation.components.MyTextField
import com.example.auth.presentation.components.TextInfoComponent
import com.example.livetvapp.features.R
import theme.AppBackground

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(20.dp),
        color = AppBackground
    ) {
        Column {
            Spacer(modifier = Modifier.Companion.height(10.dp))
            ImageComponent(image = com.example.livetvapp.commons.R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            ForgotPasswordHeadingTextComponent(action = "Forgot")
            TextInfoComponent(
                textVal = "Forgot your password? Enter the email linked to your StreamX account to reset it."
            )
            Spacer(modifier = Modifier.Companion.height(20.dp))
            MyTextField(
                labelVal = "email ID",
                icon = R.drawable.at_symbol,
                value = "",
                onValueChange = {},
                isError = false,
                supportingText = {}
            )
            MyButton(
                labelVal = "Submit",
                onClick = {},
                navController)
        }
    }
}
