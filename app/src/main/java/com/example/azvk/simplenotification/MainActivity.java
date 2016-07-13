package com.example.azvk.simplenotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import static com.example.azvk.simplenotification.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static int ID = 2602;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);//prevent notification to show up in onCreate
    }

    public void buttonClicked(android.view.View view){
        //Build notification
        notification.setSmallIcon(R.drawable.filehippo_icon);
        notification.setTicker("Ticker example");
        notification.setWhen(System.currentTimeMillis());//time to appear
        notification.setContentTitle("Title example");
        notification.setContentText("Main body text example");

        //when click on notification
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //build notification and cancel it
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(ID, notification.build());
    }
}
