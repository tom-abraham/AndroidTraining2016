package com.example.tabraham.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("TA-> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("TA-> onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("TA-> onPause()");
        System.out.println("TA-> onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("TA-> onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("TA-> onDestroy()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("TA-> onRestart()");

    }
}
