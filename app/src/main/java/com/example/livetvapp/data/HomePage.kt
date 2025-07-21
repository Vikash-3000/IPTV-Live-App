package com.example.livetvapp.data

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.livetvapp.commons.utils.SystemBarUtils

class HomePage : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // System navbar and status bar color change
        SystemBarUtils.applySystemBarStyle(this)

//        setContent {
//            LiveTvAppTheme {
//                TopBar()
//            }
//        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopBar() {
//    TopAppBar(
//        modifier = Modifier.fillMaxWidth()
//            .padding(8.dp,0.dp,8.dp,0.dp),
//        title = {
//            Row {
//                Text(
//                    text = "StreamX",
//                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W900,
//                        fontFamily = FontFamily(Font(R.font.poppins_bold))),
//                    color = colorResource(id = R.color.primary)
//                )
//            }
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = colorResource(id = R.color.primary_background_dark) // Set background color
//        ),
//        navigationIcon = {
//            Icon(
//                painter = painterResource(id = R.drawable.app_logo),
//                contentDescription = "App Icon",
//                tint = colorResource(id = R.color.primary),
//                modifier = Modifier.size(44.dp) // Set your desired size here
//            )
//        },
//        actions = {
//            IconButton(onClick = { /* Handle favourites click */ }) {
//                Icon(
//                    imageVector = Icons.Filled.FavoriteBorder,
//                    contentDescription = "Favourites",
//                    tint = colorResource(id = R.color.white),
//                    modifier = Modifier.size(26.dp) // Set your desired size here
//                )
//            }
//            IconButton(onClick = { /* Handle search click */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Search,
//                    contentDescription = "Search",
//                    tint = colorResource(id = R.color.white),
//                    modifier = Modifier.size(26.dp) // Set your desired size here
//                )
//            }
//        },
//        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//    )
//}
