package com.aroy81.notifications_himanshu_gaur

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun actionNotification(context: Context) {

    val intent = Intent(context, ReplyReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_IMMUTABLE)

    val notification = NotificationCompat.Builder(context, DEFAULT_ID)
        .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("action")
        .setContentText("actionooooooooooooooo")
        .addAction(R.drawable.ic_launcher_background, "reply", pendingIntent).build()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(1, notification)
        }
    } else {
        NotificationManagerCompat.from(context).notify(1, notification)
    }
}

class ReplyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "reply clicked", Toast.LENGTH_SHORT).show()
    }
}