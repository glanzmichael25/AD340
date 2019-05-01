package com.navigationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    //declares variables
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }
    //creates notification channels
    private void createNotificationChannels(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel1 = new NotificationChannel(
                        CHANNEL_1_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH);
                channel1.setDescription("This is Channel 1");

                NotificationChannel channel2 = new NotificationChannel(
                        CHANNEL_2_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH);
                channel2.setDescription("This is Channel 2");

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel1);
                manager.createNotificationChannel(channel2);

            }
        }
    }
