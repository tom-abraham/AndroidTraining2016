package com.example.tabraham.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mAlarm;
    Intent i;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlarm= (Button)findViewById(R.id.button);
        am=(AlarmManager) getSystemService(Context.ALARM_SERVICE);

        mAlarm.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(MainActivity.this, "clicked Alarm", Toast.LENGTH_SHORT).show();
                i= new Intent(MainActivity.this,MyReciever.class);

                PendingIntent pIntent=PendingIntent.getBroadcast(getApplicationContext(),123,i,PendingIntent.FLAG_ONE_SHOT);
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10*1000,pIntent);
        }
    }
}
