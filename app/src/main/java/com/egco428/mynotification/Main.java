package com.egco428.mynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button SendNotification ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SendNotification = (Button)findViewById(R.id.sendnotification_btn);

        SendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this,NotificationReseverActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(Main.this,(int)System.currentTimeMillis(),intent,0);

                NotificationCompat.Action callAction = new NotificationCompat.Action(R.drawable.ic_call,"Call",pIntent).build();
                NotificationCompat.Action settingAction = new NotificationCompat.Action(R.drawable.ic_setting,"Setting",pIntent).build();
                NotificationCompat.Action warningAction = new NotificationCompat.Action(R.drawable.ic_warning,"Warning",pIntent).build();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(Main.this);
                builder.setSmallIcon(R.drawable.ic_message);
                builder.setContentTitle("New Message from Test@example.com");
                builder.setContentText("This is a text message ?");
                builder.addAction(callAction);
                builder.addAction(settingAction);
                builder.addAction(warningAction);
                builder.setWhen(System.currentTimeMillis()+10);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());


            }
        });
    }
}
