package com.example.livetvapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.livetvapp.ui.theme.LiveTvAppTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class MainActivity : ComponentActivity() {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(0)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(mapOf("festival_gif_url" to ""))

        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            val gifUrl = if (task.isSuccessful) {
                remoteConfig.getString("festival_gif_url")
            } else ""
            setContent {
                LiveTvAppTheme {
                    TopBar(gifUrl = gifUrl.takeIf { it.isNotBlank() })
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(gifUrl : String?) {

    val context = LocalContext.current

    // Coil ImageLoader with GIF support
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "LiveTV App",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
                )
                if (!gifUrl.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(gifUrl)
                            .crossfade(true)
                            .build(),
                        imageLoader = imageLoader, // Use the custom loader with GIF support
                        contentDescription = "Festival GIF",
                        modifier = Modifier.size(60.dp)
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle left icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            Row {
                IconButton(onClick = { /* Handle search click */ }) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Favourites"
                    )
                }
                IconButton(onClick = { /* Handle saved click */ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior() // Optional for scroll
    )
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewTopBar() {
//    LiveTvAppTheme {
//        TopBar()
//    }
//}
