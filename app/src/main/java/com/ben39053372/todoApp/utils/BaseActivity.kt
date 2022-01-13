package com.ben39053372.todoApp.utils

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ben39053372.todoApp.services.MainService
import timber.log.Timber

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Activity onCreate")

        Intent(this, MainService::class.java).also { intent ->
            startService(intent)
        }
    }
}