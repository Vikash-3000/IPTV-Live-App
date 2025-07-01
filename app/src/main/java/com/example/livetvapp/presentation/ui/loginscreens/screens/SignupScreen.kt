package com.example.livetvapp.presentation.ui.loginscreens.screens

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
import com.example.livetvapp.R
import com.example.livetvapp.presentation.ui.loginscreens.components.AppNameTextComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.BottomSignupTextComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.HeadingTextComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.ImageComponent
import com.example.livetvapp.presentation.ui.loginscreens.components.MyButton
import com.example.livetvapp.presentation.ui.loginscreens.components.MyTextField
import com.example.livetvapp.presentation.ui.loginscreens.components.SignupTermsAndPrivacyText
import com.example.livetvapp.ui.theme.AppBackground

@Composable
fun SignupScreen(navController: NavHostController) {
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
            HeadingTextComponent(heading = "Sign Up")
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                MyTextField(labelVal = "email ID", icon = R.drawable.at_symbol)
                Spacer(modifier = Modifier.height(15.dp))
                MyTextField(labelVal = "full name", icon = R.drawable.lockperson)
                Spacer(modifier = Modifier.height(15.dp))
                MyTextField(labelVal = "mobile", icon = R.drawable.lockphone)
            }
            Spacer(modifier = Modifier.height(20.dp))
            SignupTermsAndPrivacyText()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    MyButton(labelVal = "Continue", navController = navController)
                    Spacer(modifier = Modifier.height(14.dp))
                    BottomSignupTextComponent(navController)
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
            
        }
    }
}