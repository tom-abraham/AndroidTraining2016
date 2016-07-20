package com.example.tabraham.smssender;

import android.Manifest;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mPhoneNumber;
    EditText mMessage;
    Button mSendButtton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhoneNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        mMessage = (EditText)findViewById(R.id.editTextMessage);
        mSendButtton = (Button)findViewById(R.id.buttonSendSms);
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.M)
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        mSendButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = mPhoneNumber.getText().toString() ;
                String message = mMessage.getText().toString();

                System.out.println("TA-> phone number Entered is : "+phoneNumber);
                System.out.println("TA-> message Entered is : "+message);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber,null,message,null,null);
//                smsManager.sendTextMessage("+5556", null, "Bus will be at your door in 30 seconds", null, null);
                System.out.println("TA-> Send message: ");


            }
        });


    }
}
