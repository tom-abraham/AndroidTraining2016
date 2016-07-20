package com.example.tabraham.sharedpreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mButtonSave;
    Button mButtonClear;
    EditText mEditTextInt;
    EditText mEditTextString;
    int mInt;
    String mString;
    SharedPreferences mPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonSave = (Button) findViewById(R.id.buttonSave);
        mButtonClear = (Button) findViewById(R.id.buttonClear);
        mEditTextInt = (EditText) findViewById(R.id.editText);
        mEditTextString = (EditText) findViewById(R.id.editText2);
        mButtonSave.setOnClickListener(this);
        mButtonClear.setOnClickListener(this);

        mPreferences = getSharedPreferences("shared_preference", Context.MODE_PRIVATE);
        checkStatus();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSave:
                Toast.makeText(MainActivity.this, "TA-> save button pressed", Toast.LENGTH_SHORT).show();
                 mInt =Integer.parseInt(mEditTextInt.getText().toString());
                 mString =mEditTextString.getText().toString();
                mPreferences.edit().putString("STRING_PREF_KEY",mString).commit();
                mPreferences.edit().putInt("INT_PREF_KEY",mInt).commit();
                mPreferences.edit().putBoolean("ENABLE",true).commit();
                checkStatus();



                break;
            case R.id.buttonClear:
                Toast.makeText(MainActivity.this, "TA-> clear button pressed", Toast.LENGTH_SHORT).show();
                mPreferences.edit().clear().commit();
//                mPreferences.edit().remove("STRING_PREF_KEY").commit();

                checkStatus();

                break;
        }

    }
    public void checkStatus() {
        if(!mPreferences.getBoolean("ENABLE",false) ){
            mButtonClear.setEnabled(false);
            mButtonSave.setEnabled(true);
            mEditTextInt.setEnabled(true);
            mEditTextString.setEnabled(true);
        }
        else
        {
            mButtonClear.setEnabled(true);
            mButtonSave.setEnabled(false);
            mEditTextInt.setEnabled(false);
            mEditTextString.setEnabled(false);
        }
    }
}
