package com.example.tabraham.arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/*
Adapters: Array,cursor,Base
 */
public class MainActivity extends AppCompatActivity {
    Spinner mSpinner;
    String[] mStringArray=new String[]{"Bangalore","Delhi","Chennai","Kolkata"};
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner)findViewById(R.id.spinner);
        mSpinner.setPrompt("Select Cities");



//        mArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,mStringArray);
        mArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_layout,R.id.textViewData,mStringArray);
        mSpinner.setAdapter(mArrayAdapter);
        mSpinner.setSelection(2);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Positions= "+position, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Item= "+mSpinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing= "+mSpinner.getSelectedItem(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
