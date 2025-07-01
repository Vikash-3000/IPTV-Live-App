package com.example.livetvapp.presentation.ui.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.livetvapp.R
import com.example.livetvapp.ui.theme.LiveTvAppTheme
import com.example.livetvapp.utils.SystemBarUtils

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // System navbar and status bar color change
        SystemBarUtils.applySystemBarStyle(this)

        setContent {
            LiveTvAppTheme {
                TopBar()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp,0.dp,8.dp,0.dp),
        title = {
            Row {
                Text(
                    text = "StreamX",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W900,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))),
                    color = colorResource(id = R.color.primary)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.primary_background_dark) // Set background color
        ),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Icon",
                tint = colorResource(id = R.color.primary),
                modifier = Modifier.size(44.dp) // Set your desired size here
            )
        },
        actions = {
            IconButton(onClick = { /* Handle favourites click */ }) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Favourites",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(26.dp) // Set your desired size here
                )
            }
            IconButton(onClick = { /* Handle search click */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(26.dp) // Set your desired size here
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}
