package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_COD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        findViewById(R.id.btn11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long trigerTime = System.currentTimeMillis()+(15000);
                // 5minute = 3000000   bkggy
                Intent iBroadcast= new Intent(MainActivity.this,MyReciever.class);

                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_COD,iBroadcast,PendingIntent.FLAG_UPDATE_CURRENT);


                alarmManager.set(AlarmManager.RTC_WAKEUP,trigerTime,pi);
            }
        });


    }
}