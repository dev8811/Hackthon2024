package com.example.hackthon24

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay for a few seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start MainActivity after the splash screen
            startActivity(Intent(this, MainActivity::class.java))
            // Finish the splash activity so it can't be returned to
            finish()
        }, 500) // 3000 milliseconds = 3 seconds
    }
}
