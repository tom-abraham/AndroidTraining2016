package com.example.tabraham.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by tabraham on 27/6/16.
 */
public class MyIntentService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("TA-> IntentService onHandleIntent");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("TA-> IntentService onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        System.out.println("TA-> IntentService onStart");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("TA-> IntentService onDestroy");

    }
}
