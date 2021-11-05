package com.ben39053372.myandroidtemplate.UI.SplashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ben39053372.myandroidtemplate.UI.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        splashScreen.setOnExitAnimationListener {
            it.remove()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}