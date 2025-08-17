package com.example.auth.presentation.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.auth.presentation.components.AppNameTextComponent
import com.example.auth.presentation.components.BottomSignupTextComponent
import com.example.auth.presentation.components.HeadingTextComponent
import com.example.auth.presentation.components.ImageComponent
import com.example.auth.presentation.components.MyButton
import com.example.auth.presentation.components.MyTextField
import com.example.auth.presentation.components.PasswordInputComponent
import com.example.auth.presentation.components.SignupTermsAndPrivacyText
import com.example.auth.presentation.events.SignupEvent
import com.example.auth.presentation.viewmodel.SignupViewModel
import com.example.livetvapp.features.R
import kotlinx.coroutines.launch
import theme.AppBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    navController: NavHostController,
    viewModel: SignupViewModel = hiltViewModel()
) {

    // If your viewModel still uses var state by mutableStateOf(SignupUiState())
    val state = viewModel.state

    // Snackbar host
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LocationGetAddress()

    // react to global error or success
    LaunchedEffect(state.error) {
        state.error?.let { message ->
            scope.launch {
                snackbarHostState.showSnackbar(message)
            }
        }
    }

    LaunchedEffect(state.success) {
        if (state.success) {
            // navigate to next screen (MFA or Home)
            navController.navigate("Home") {
                popUpTo("SignupScreen") { inclusive = true }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = AppBackground
    ) { padding ->
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
                    MyTextField(
                        labelVal = "full name",
                        icon = R.drawable.lockperson,
                        value = state.fullName,
                        onValueChange = { newValue ->
                            viewModel.onEvent(SignupEvent.EnteredFullName(newValue))
                        },
                        isError = state.fullNameError != null,
                        supportingText = {
                            state.fullNameError?.let {
                                Text(it, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.Companion.height(15.dp))

                    MyTextField(
                        labelVal = "email ID",
                        icon = R.drawable.at_symbol,
                        value = state.email,
                        onValueChange = { newValue ->
                            viewModel.onEvent(SignupEvent.EnteredEmail(newValue))
                        },
                        isError = state.emailError != null,
                        supportingText = {
                            state.emailError?.let {
                                Text(it, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.Companion.height(15.dp))

                    MyTextField(
                        labelVal = "mobile",
                        icon = R.drawable.lockphone,
                        value = state.mobile,
                        onValueChange = { newValue ->
                            viewModel.onEvent(SignupEvent.EnteredMobile(newValue))
                        },
                        isError = state.mobileError != null,
                        supportingText = {
                            state.mobileError?.let {
                                Text(it, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.Companion.height(15.dp))

                    PasswordInputComponent(
                        labelVal = "Password",
                        value = state.password,
                        onValueChange = { newValue ->
                            viewModel.onEvent(SignupEvent.EnteredPassword(newValue))
                        },
                        isError = state.passwordError != null,
                        supportingText = {
                            state.passwordError?.let {
                                Text(it, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.Companion.height(20.dp))
                SignupTermsAndPrivacyText()
                Box(
                    modifier = Modifier.Companion.fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Column {
                        MyButton(
                            labelVal = "Continue",
                            onClick = { viewModel.onEvent(SignupEvent.Submit) },
                            navController = navController
                        )
                        Spacer(modifier = Modifier.Companion.height(14.dp))
                        BottomSignupTextComponent(navController)
                        Spacer(modifier = Modifier.Companion.height(18.dp))
                    }
                }

            }
        }
    }
}

@Composable
fun LocationGetAddress(viewModel: SignupViewModel = hiltViewModel()) {
    val ctx = LocalContext.current

    var hasFine by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                ctx, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    var hasCoarse by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                ctx, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val requestPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        hasFine = results[Manifest.permission.ACCESS_FINE_LOCATION] == true
        hasCoarse = results[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (hasFine || hasCoarse) {
            viewModel.fetchLocationAndAddress()   // ✅ now we can fetch
        } else {
            // Optional: set a fallback so you don't save empty string
            viewModel.setAddressFallback("Permission not granted")
        }
    }

    // Ask once when screen opens
    LaunchedEffect(Unit) {
        if (hasFine || hasCoarse) {
            viewModel.fetchLocationAndAddress()
        } else {
            requestPermission.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }
}