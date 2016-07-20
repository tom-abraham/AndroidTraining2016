package com.example.tabraham.activitytobroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by tabraham on 4/7/16.
 */
public  class MyReciever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equalsIgnoreCase("android.intent.action.Button1"))
        {
            Toast.makeText(context,"TA-> recieved from Button1",Toast.LENGTH_LONG).show();

        }
        else if(intent.getAction().equalsIgnoreCase("android.intent.action.Button2"))

        {
            Toast.makeText(context,"TA-> recieved from Button2",Toast.LENGTH_LONG).show();

        }
        else if(intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED"))

        {
            Toast.makeText(context,"TA-> Boot completed",Toast.LENGTH_LONG).show();
            System.out.println("TA-> Boot completed");

        }
        else if(intent.getAction().equalsIgnoreCase("android.intent.action.CAMERA_BUTTON"))

        {
            Toast.makeText(context,"TA->  CAMERA_BUTTON",Toast.LENGTH_LONG).show();
            System.out.println("TA->  CAMERA_BUTTON");

        }


    }
}
