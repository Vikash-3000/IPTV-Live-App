package com.example.livetvapp.data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class Channels : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContent {
//            LiveTvAppTheme {
//                ChannelCard()
//            }
//        }

    }

//
//@Composable
//fun ChannelCard() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .height(220.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
//    ) {
//        Box(modifier = Modifier.fillMaxSize()) {
//            val url = "https://d35j504z0x2vu2.cloudfront.net/v1/manifest/0bc8e8376bd8417a1b6761138aa41c26c7309312/9xm/23886666-8fc5-470f-aab1-bd637ed607b1/3.m3u8";
//            if (!url.isEmpty()) {
//                ExoPlayerPreview(videoUrl = url)
//            }
////            else {
////                AsyncImage(
////                    model = "https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExbXBzZWo1dWNzODRnbGxpcnFyd3oyYTNwcTF3angxYXRxdG5vd3d0NSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/26xBukhJ0i8KXADYc/giphy.gif",
////                    contentDescription = null,
////                    contentScale = ContentScale.Crop,
////                    modifier = Modifier.fillMaxSize()
////                )
////            }
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.BottomStart)
//                    .background(Color(0xFF424242).copy(alpha = 0.8f))
//                    .padding(12.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "Gemini TV",
//                        color = Color.White,
//                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    Text(
//                        text = "Category",
//                        color = Color.White.copy(alpha = 0.6f),
//                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun ExoPlayerPreview(
//    videoUrl: String,
//    modifier: Modifier = Modifier,
//    playWhenReady: Boolean = true,
//    useController: Boolean = false,
//    isMutedInit: Boolean = true,
//    repeat: Boolean = true
//) {
//    val context = LocalContext.current
//    var isMuted by remember { mutableStateOf(isMutedInit) }
//
//    // Remember ExoPlayer instance
//    val exoPlayer = remember(videoUrl) {
//        ExoPlayer.Builder(context).build().apply {
//            val mediaItem = MediaItem.Builder().setUri(videoUrl.toUri())
//                .setSubtitleConfigurations(
//                    listOf(
//                        MediaItem.SubtitleConfiguration.Builder(videoUrl.toUri())
//                            .setMimeType(MimeTypes.TEXT_VTT) // e.g., application/x-subrip or text/vtt
//                            .setLanguage("en")
//                            .setSelectionFlags(C.SELECTION_FLAG_DEFAULT)
//                            .build()
//                    )
//                )
//                .build()
//            setMediaItem(mediaItem)
//            prepare()
//            this.playWhenReady = playWhenReady
//            volume = if (isMutedInit) 0f else 1f
//            repeatMode = if (repeat) Player.REPEAT_MODE_ONE else Player.REPEAT_MODE_OFF
//        }
//    }
//
//    // Update volume when mute state changes
//    LaunchedEffect(isMuted) {
//        exoPlayer.volume = if (isMuted) 0f else 1f
//    }
//
//    // Cleanup when composable leaves
//    DisposableEffect(key1 = exoPlayer) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//    Box(modifier = modifier) {
//        AndroidView(
//            modifier = Modifier.fillMaxSize(),
//            factory = {
//                PlayerView(it).apply {
//                    player = exoPlayer
//                    this.useController = useController
//                    layoutParams = FrameLayout.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT
//                    )
//                }
//            }
//        )
//
//        // Sound toggle button (icon)
//        IconButton(
//            onClick = { isMuted = !isMuted },
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//                .padding(8.dp)
//                .background(Color.Black.copy(alpha = 0.5f), shape = CircleShape)
//        ) {
//            Icon(
//                imageVector = if (isMuted) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
//                contentDescription = if (isMuted) "Unmute" else "Mute",
//                tint = Color.White
//            )
//        }
//    }
//}
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewTopBar() {
//    LiveTvAppTheme {
//        ChannelCard()
//    }
//}

}