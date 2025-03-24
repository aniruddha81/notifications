package com.aroy81.notifications_himanshu_gaur

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

const val DEFAULT_ID = "DEFAULT_ID"
const val DEFAULT_NAME = "DEFAULT_NAME"

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(DEFAULT_ID,DEFAULT_NAME, NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}