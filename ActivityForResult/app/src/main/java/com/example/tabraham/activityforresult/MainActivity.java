package com.example.tabraham.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTextMainData;
    Button mButton;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMainData = (TextView) findViewById(R.id.textViewMainData);
        mButton = (Button) findViewById(R.id.buttonMainClick);
        i = new Intent(this,ResultActivity.class);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(i,100);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"call back invoked",Toast.LENGTH_LONG).show();
        mTextMainData.setText(data.getStringExtra("STRING_KEY"));
    }
}
