package com.example.tabraham.alarmapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by tabraham on 4/7/16.
 */
public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "alarm", Toast.LENGTH_LONG).show();
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("LostBoys").setContentText("Hey Guys").build();
        nm.notify(12345, notification);
        Vibrator vm = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vm.vibrate(5*1000);
    }
}
