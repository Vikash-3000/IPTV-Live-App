package com.example.livetvapp.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.livetvapp.R

object SystemBarUtils {
    fun applySystemBarStyle(activity: Activity) {
        val window = activity.window

        // 1. Edge-to-edge support for Compose
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // 2. Set system bar colors (same as theme XML)
        val darkColor = ContextCompat.getColor(activity, R.color.primary_background_dark)
        window.statusBarColor = darkColor
        window.navigationBarColor = darkColor
        window.setBackgroundDrawableResource(R.color.primary_background_dark)

        // 3. Set immersive flags for fullscreen and hide nav bar
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        // 4. Force white icons (dark content = false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightStatusBars = false
        controller.isAppearanceLightNavigationBars = false
    }
}
