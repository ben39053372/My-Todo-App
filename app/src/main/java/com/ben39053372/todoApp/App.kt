package com.ben39053372.todoApp

import com.ben39053372.todoApp.ui.todo.TodoDatabase
import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.room.Room
import timber.log.Timber
import com.ben39053372.todoApp.utils.MyLogTree

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initLogger()

        createNotificationChannel()

    }

    private fun initLogger() {
        // init timber
        if (BuildConfig.DEBUG) {
            Timber.plant(MyLogTree)
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(getString(R.string.CHANNEL_ID), name, importance).apply {
                    description = descriptionText
                }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            Timber.i("Create Notification Channel name: $name description: $descriptionText")
        }
    }

    private fun createRoom(applicationContext: Context) {
        Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java, "database-name"
        ).build()
    }

}