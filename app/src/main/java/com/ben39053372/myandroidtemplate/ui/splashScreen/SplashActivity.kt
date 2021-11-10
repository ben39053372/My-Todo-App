package com.ben39053372.myandroidtemplate.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ben39053372.myandroidtemplate.ui.MainActivity

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