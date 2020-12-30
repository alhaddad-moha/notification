package com.hell.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID="mod_ver";
private static final String CHANNEL_NAME="mod ver";
private static final String CHANNEL_DESC="mod Notification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    private void displayNotification()
    {
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.envelope)

		//here you can change it to your message
                .setContentTitle("We miss you")
                .setContentText("enjoy ourApp")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationMgr= NotificationManagerCompat.from(this);
        mNotificationMgr.notify(1,mBuilder.build());

    }
}