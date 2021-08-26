package com.lunathemes.travelnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lunathemes.travelnews.R
import android.content.Intent
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.lunathemes.travelnews.MainActivity
import com.lunathemes.travelnews.IntroScreen

class IntroScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_screen_layout)
        val welcomeimage = findViewById<View>(R.id.splash_IV) as ImageView
        welcomeimage.setImageResource(R.drawable.splash_intro)
        Handler().postDelayed({
            val mainintent = Intent(this@IntroScreen, MainActivity::class.java)
            startActivity(mainintent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 1500
    }
}