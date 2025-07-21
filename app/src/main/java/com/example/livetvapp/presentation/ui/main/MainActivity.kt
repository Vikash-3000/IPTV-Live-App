package com.example.livetvapp.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.livetvapp.commons.utils.SystemBarUtils
import com.example.livetvapp.presentation.navigation.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint
import theme.AppBackground
import theme.LiveTvAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                    val navController = rememberNavController()
                    AppNavGraph(navController)
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
            val navController = rememberNavController()
            AppNavGraph(navController)
        }
    }
}