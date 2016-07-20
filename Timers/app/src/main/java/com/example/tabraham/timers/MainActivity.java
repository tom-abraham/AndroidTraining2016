package com.example.tabraham.timers;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    String mEditTextString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button);;
        mEditText=(EditText)findViewById(R.id.editText);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int timevalue = Integer.parseInt(mEditText.getText().toString());
                initializeTimer(timevalue);
            }
        });
        }
    void initializeTimer(final int timevalue)
    {
        CountDownTimer timer= new CountDownTimer(timevalue *1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mEditText.setText((new Long(millisUntilFinished/1000).toString()));

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Timer closed",Toast.LENGTH_LONG);

            }
        }.start();
    }

    }

