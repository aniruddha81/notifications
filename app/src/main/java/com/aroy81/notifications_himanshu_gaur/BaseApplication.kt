package com.aroy81.notifications_himanshu_gaur

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

const val SILENT_ID = "silent_id"
const val SILENT_NAME = "silent_name"

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(SILENT_ID,SILENT_NAME, NotificationManager.IMPORTANCE_LOW)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}