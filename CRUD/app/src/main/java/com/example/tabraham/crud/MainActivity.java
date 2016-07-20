package com.example.tabraham.crud;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Create Retrival Update Delete
//ListActivity,CA.CP,DB
public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button mButtonDelete;
    Button mButtonInsert;
    Button mButtonUpdate;
    Button mButtonRetrieve;
    EditText mEditTextName;
    EditText mEditTextPhone;
    EditText mEditTextAddress;
    long phoneNumber;
    String name;
    String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextName = (EditText) findViewById(R.id.editText);
        mEditTextPhone = (EditText) findViewById(R.id.editTextPhone);
        mEditTextAddress = (EditText) findViewById(R.id.editTextAddress);
        mButtonDelete = (Button) findViewById(R.id.buttonDelete);
        mButtonInsert = (Button) findViewById(R.id.buttonInsert);
        mButtonRetrieve = (Button) findViewById(R.id.buttonReteive);
        mButtonUpdate = (Button) findViewById(R.id.buttonUpdate);
        mButtonUpdate.setOnClickListener(this);
        mButtonInsert.setOnClickListener(this);
        mButtonRetrieve.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.buttonInsert:
                Toast.makeText(MainActivity.this, "Clicked Insert", Toast.LENGTH_SHORT).show();
                name = mEditTextName.getText().toString();
                Toast.makeText(MainActivity.this, "Name: "+name, Toast.LENGTH_SHORT).show();
                phoneNumber  = Long.parseLong(mEditTextPhone.getText().toString());
                Toast.makeText(MainActivity.this, "phoneNumber: "+phoneNumber, Toast.LENGTH_SHORT).show();
                address = mEditTextAddress.getText().toString();
                Toast.makeText(MainActivity.this, "Address: "+address, Toast.LENGTH_SHORT).show();
                ContentValues contentValues = new ContentValues();
                contentValues.put(EmployeeInfo.EMPLOYEE_NAME,name);
                contentValues.put(EmployeeInfo.EMPLOYEE_PHONE_NUMBER,phoneNumber);
                contentValues.put(EmployeeInfo.EMPLOYEE_ADDRESS,address);
                getContentResolver().insert(EmployeeInfo.EMPLOYEE_URI,contentValues);
                break;
            case R.id.buttonDelete:
                Toast.makeText(MainActivity.this, "Clicked Delete", Toast.LENGTH_SHORT).show();
                name = mEditTextName.getText().toString();
                Toast.makeText(MainActivity.this, "Dalete key Name: "+name, Toast.LENGTH_SHORT).show();
                String what = EmployeeInfo.EMPLOYEE_NAME+" = '"+name+"'";
                System.out.println("TA->delete : "+what);
                getContentResolver().delete(EmployeeInfo.EMPLOYEE_URI,what,null);
                break;
            case R.id.buttonReteive:
                Toast.makeText(MainActivity.this, "Clicked Retrieve name :"+ name, Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(this, DataRetrival.class);
                startActivity(mIntent);
                break;
            case R.id.buttonUpdate:
                Toast.makeText(MainActivity.this, "Clicked Insert", Toast.LENGTH_SHORT).show();
                name = mEditTextName.getText().toString();
                Toast.makeText(MainActivity.this, "Name: "+name, Toast.LENGTH_SHORT).show();
                phoneNumber  = Integer.parseInt(mEditTextPhone.getText().toString());
                Toast.makeText(MainActivity.this, "phoneNumber: "+phoneNumber, Toast.LENGTH_SHORT).show();
                address = mEditTextAddress.getText().toString();
                Toast.makeText(MainActivity.this, "Address: "+address, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Clicked Update:"+ name, Toast.LENGTH_SHORT).show();
                ContentValues mContentValues = new ContentValues();
                mContentValues.put(EmployeeInfo.EMPLOYEE_PHONE_NUMBER,phoneNumber);
                mContentValues.put(EmployeeInfo.EMPLOYEE_ADDRESS,address);
                String where = EmployeeInfo.EMPLOYEE_NAME+" = '"+name+"'";
                System.out.println("TA->querry: "+where);
                getContentResolver().update(EmployeeInfo.EMPLOYEE_URI,mContentValues,where,null);


                break;
        }

    }
}
