package com.example.auth.presentation.ui.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.auth.presentation.components.AppNameTextComponent
import com.example.auth.presentation.components.BottomSignupTextComponent
import com.example.auth.presentation.components.HeadingTextComponent
import com.example.auth.presentation.components.ImageComponent
import com.example.auth.presentation.components.MyButton
import com.example.auth.presentation.components.MyTextField
import com.example.auth.presentation.components.SignupTermsAndPrivacyText
import com.example.livetvapp.features.R
import theme.AppBackground

@Composable
fun SignupScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(20.dp), color = AppBackground
    ) {
        Column {
            Spacer(modifier = Modifier.Companion.height(10.dp))
            ImageComponent(image = com.example.livetvapp.commons.R.drawable.app_logo)
            AppNameTextComponent(heading = "StreamX")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            HeadingTextComponent(heading = "Sign Up")
            Spacer(modifier = Modifier.Companion.height(20.dp))
            Column {
                MyTextField(labelVal = "email ID", icon = R.drawable.at_symbol)
                Spacer(modifier = Modifier.Companion.height(15.dp))
                MyTextField(labelVal = "full name", icon = R.drawable.lockperson)
                Spacer(modifier = Modifier.Companion.height(15.dp))
                MyTextField(labelVal = "mobile", icon = R.drawable.lockphone)
            }
            Spacer(modifier = Modifier.Companion.height(20.dp))
            SignupTermsAndPrivacyText()
            Box(
                modifier = Modifier.Companion.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    MyButton(labelVal = "Continue", navController = navController)
                    Spacer(modifier = Modifier.Companion.height(14.dp))
                    BottomSignupTextComponent(navController)
                    Spacer(modifier = Modifier.Companion.height(18.dp))
                }
            }

        }
    }
}