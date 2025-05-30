package com.example.livetvapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.livetvapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Optional: make it fullscreen for immersive experience
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Optional: Disable user interaction
        window.decorView.isEnabled = false

        animateLottieLogo(binding.lottieLogo, binding.appName)
    }

    private fun animateLottieLogo(lottieView: LottieAnimationView, textView: TextView) {
        lottieView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // Scale up LottieView quickly
                val lottieScaleUpX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 30f)
                val lottieScaleUpY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 30f)
                val lottieScale = ObjectAnimator.ofPropertyValuesHolder(lottieView, lottieScaleUpX, lottieScaleUpY).apply {
                    duration = 1700
                    interpolator = AccelerateInterpolator()
                }

                val textFadeOut = ObjectAnimator.ofFloat(textView, View.ALPHA, 1f, 0f).apply {
                    duration = 300
                    interpolator = AccelerateInterpolator()
                }

                // Play both scaling animations together
                AnimatorSet().apply {
                    playTogether(lottieScale, textFadeOut)
                    addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(anim: Animator) {
                            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                            finish()
                        }
                    })
                    start()
                }
            }
        })

        // Start the Lottie animation
        lottieView.playAnimation()
    }


}
