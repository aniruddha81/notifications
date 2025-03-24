package com.aroy81.notifications_himanshu_gaur

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

const val GROUP = "group"

fun groupNotification(context: Context) {
    val notification = NotificationCompat.Builder(context, DEFAULT_ID)
        .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("hudai").setGroup(GROUP)
        .setContentText("shauwaaaaaaaaaaaa").build()

    val notification2 = NotificationCompat.Builder(context, DEFAULT_ID)
        .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("dhon").setGroup(GROUP)
        .setContentText("vodaaaaaaaaaa").build()

    val groupBuilder = NotificationCompat.Builder(context, DEFAULT_ID)
        .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("grouped title")
        .setContentText("grouped text").setGroup(GROUP).setGroupSummary(true).build()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).apply {
                notify(1, notification)
                notify(2, notification2)
                notify(3, groupBuilder)
            }
        }
    } else {
        NotificationManagerCompat.from(context).apply {
            notify(1, notification)
            notify(2, notification2)
            notify(3, groupBuilder)
        }
    }
}