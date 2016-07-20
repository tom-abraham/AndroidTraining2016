package com.example.tabraham.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by tabraham on 22/6/16.
 */
public class ThirdActivity extends Activity{

    EditText mEditTextData;
    Button button;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        i = new Intent();
        mEditTextData=(EditText)findViewById(R.id.editTextThirdActivityData);
        button = (Button) findViewById(R.id.buttonThirdActivityClick);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String temp = mEditTextData.getText().toString();
                                          i.putExtra("STRING_KEY_THIRD",temp);
                                          setResult(0,i);
                                          finish();
                                      }
                                  }
        );
    }
}
