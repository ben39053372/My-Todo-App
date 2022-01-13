package com.ben39053372.todoApp.services

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ben39053372.todoApp.R
import com.ben39053372.todoApp.ui.MainActivity
import com.ben39053372.todoApp.utils.BaseService


/**
 * ## Notification
 * * for send a basic notification
 * * go to main activity by default when notification click
 * - intent must have:
 *      1. title
 *      2. contentText
 */
class NotificationService : BaseService() {

    override val threadName: String = "Notification Service Thread"

    override fun onRun(data: Bundle) {
        val intent = Intent(this@NotificationService, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        with(NotificationManagerCompat.from(this@NotificationService)) {
            notify(
                1,
                NotificationCompat.Builder(this@NotificationService, getString(R.string.CHANNEL_ID))
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle(data.getString("title")?:"Title")
                    .setContentText(data.getString("contentText")?:"ContentText")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setContentIntent(PendingIntent.getActivity(this@NotificationService, 0,
                        intent,PendingIntent.FLAG_IMMUTABLE
                    ))
                    .setAutoCancel(true)
                    .build()
            )
        }
    }
}