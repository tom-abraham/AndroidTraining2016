package com.example.tabraham.activitytobroadcastreciever;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mSendBroadcast;
    Button mSendSpecificBroadcast;
    Button mImplicitIntent;
    Button mButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendBroadcast = (Button) findViewById(R.id.button1);
        mSendSpecificBroadcast = (Button) findViewById(R.id.button2);
        mImplicitIntent = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);

        mSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyReciever.class);
                i.setAction("android.intent.action.Button1");
                sendBroadcast(i);
            }
        });

        mSendSpecificBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyReciever.class);
                i.setAction("android.intent.action.Button2");
                sendBroadcast(i);
            }
        });

        mImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);

            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+919686236026"));
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    System.out.println("TA-> calling ");
                    startActivity(i);

                }
                else
                {
                    System.out.println("TA-> else calling ");
                    startActivity(i);
                }
            }
        });
    }
}
