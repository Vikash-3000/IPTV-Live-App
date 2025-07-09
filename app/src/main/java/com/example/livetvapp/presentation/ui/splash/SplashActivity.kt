package com.example.livetvapp.presentation.ui.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.livetvapp.databinding.ActivitySplashBinding
import com.example.livetvapp.presentation.ui.loginscreens.LoginActivity
import com.example.livetvapp.utils.SystemBarUtils

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //System navbar and status bar color change
        SystemBarUtils.applySystemBarStyle(this);

        animateLottieLogo(binding.lottieLogo, binding.appName)
    }

    private fun animateLottieLogo(lottieView: LottieAnimationView, textView: TextView) {
        lottieView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // 1. Prepare scale-up animation
                val scaleUpX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 30f)
                val scaleUpY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 30f)

                val scaleAnim = ObjectAnimator.ofPropertyValuesHolder(lottieView, scaleUpX, scaleUpY).apply {
                    duration = 1700 // Faster for snappier feel
                    interpolator = AccelerateInterpolator()
                }

                // 2. Fade out app name
                val fadeOutText = ObjectAnimator.ofFloat(textView, View.ALPHA, 1f, 0f).apply {
                    duration = 300
                    interpolator = AccelerateInterpolator()
                }

                // 3. Start both animations together
                AnimatorSet().apply {
                    playTogether(scaleAnim, fadeOutText)
                    start()
                }

                // 4. Launch MainActivity *during* animation (not after)
                lottieView.postDelayed({
                    val intent = Intent(this@SplashActivity, LoginActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                }, 1250) // Start transition mid-animation
            }
        })

        lottieView.playAnimation()
    }
}