package com.example.signuploginrealtime

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 5000 // 5 seconds
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize MediaPlayer with the splash sound
        mediaPlayer = MediaPlayer.create(this, R.raw.splash_sound)

        val logoImageView = findViewById<ImageView>(R.id.logoImageView)

        // Create fade-out animation
        val fadeOutAnimation = AlphaAnimation(1.0f, 0.0f)
        fadeOutAnimation.duration = 5000 // 5 seconds
        fadeOutAnimation.fillAfter = true
        fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                // Start main activity after animation ends
                startActivity(Intent(this@SplashScreenActivity, SignupActivity::class.java))
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        // Apply animation to logo
        logoImageView.startAnimation(fadeOutAnimation)

        // Play the splash sound
        mediaPlayer.start()

        // Delay to simulate splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            // Stop the sound when the delay is over
            mediaPlayer.stop()
            // Start main activity after delay
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }, SPLASH_DELAY)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release MediaPlayer when the activity is destroyed
        mediaPlayer.release()
    }
}
