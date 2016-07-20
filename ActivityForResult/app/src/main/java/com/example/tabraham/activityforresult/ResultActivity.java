package com.example.tabraham.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by tabraham on 22/6/16.
 */
public class ResultActivity extends Activity{

    EditText mEditTextData;
    Button mButton;
    EditText mEditTextThirdData;
    Button mGoThird;
    Intent i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mEditTextData=(EditText)findViewById(R.id.editTextSecondActivityData);
        mButton = (Button) findViewById(R.id.buttonSecondClick);
        i= new Intent(this,ThirdActivity.class);
        mEditTextThirdData=(EditText)findViewById(R.id.editTextThirdActivityData);
        mGoThird = (Button) findViewById(R.id.buttonThirdClick);
        mButton.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String temp = mEditTextData.getText().toString();
                                          Intent i1 = new Intent();
                                          i1.putExtra("STRING_KEY",temp);
                                          setResult(0,i1);
                                          finish();
                                      }
                                  }
        );
        mGoThird.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           startActivityForResult(i,200);
                                       }
                                   }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"call back invoked",Toast.LENGTH_LONG).show();
        mEditTextThirdData.setText(data.getStringExtra("STRING_KEY_THIRD"));
    }
}
