package com.example.auth.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auth.presentation.navigation.Navigation
import com.example.livetvapp.commons.utils.SystemBarUtils
import theme.AppBackground
import theme.LiveTvAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // System navbar and status bar color change
        SystemBarUtils.applySystemBarStyle(this)

        // Force your theme (no system override)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // or MODE_NIGHT_YES

        setContent {
            LiveTvAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.Companion.fillMaxSize(),
                    color = AppBackground
                ) {
                    Navigation()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LiveTvAppTheme {
        Surface(
            modifier = Modifier.Companion.fillMaxSize(),
            color = AppBackground
        ) {
            Navigation()
        }
    }
}