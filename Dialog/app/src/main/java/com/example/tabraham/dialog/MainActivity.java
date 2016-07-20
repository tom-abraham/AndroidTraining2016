package com.example.tabraham.dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button buttonDialog;
    EditText editTextDate;
    EditText editTexttime;
    Calendar mCalendar ;
    int mDay,mMonth,mYear,mHour,mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDialog = (Button) findViewById(R.id.Alert);
        editTextDate= (EditText) findViewById(R.id.editTextDate);
        editTexttime= (EditText) findViewById(R.id.editTextTime);

        buttonDialog.setOnClickListener(this);
        editTextDate.setOnClickListener(this);
        editTexttime.setOnClickListener(this);
        mCalendar = Calendar.getInstance();
        mDay= mCalendar.get(Calendar.DAY_OF_MONTH);
        mMonth= mCalendar.get(Calendar.MONTH);
        mYear= mCalendar.get(Calendar.YEAR);
        mHour=mCalendar.get(Calendar.HOUR_OF_DAY);
        mMinute=mCalendar.get(Calendar.MINUTE);

        updateDate();
        updateTime();
    }

    private void updateTime() {
        StringBuilder DateString = new StringBuilder();
        DateString.append(mHour).append(":").append(mMinute);
        editTexttime.setText(DateString.toString());

    }

    private void updateDate() {
        StringBuilder DateString = new StringBuilder();
        DateString.append(mDay).append(":").append(mMonth +1).append(":").append(mYear);
        editTextDate.setText(DateString.toString());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.Alert:
                showAlert();
                break;
            case R.id.editTextTime:
                Toast.makeText(MainActivity.this, "Clicked time", Toast.LENGTH_SHORT).show();
                new TimePickerDialog(MainActivity.this, mTimeListener,mHour,mMinute,true).show();

                break;
            case R.id.editTextDate:
                new DatePickerDialog(MainActivity.this,mDateListener,mYear,mMonth,mDay).show();
                break;
        }
    }

    DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear= year;mMonth= monthOfYear;mDay= dayOfMonth;
            updateDate();

        }
    };
    TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mHour= hourOfDay;
            mMinute= minute;
            updateTime();


        }
    };

    private void showAlert() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Application not responding");
        alertBuilder.setMessage("dialogs with package name com.example.tabraham.dialog not responding ");
        alertBuilder.setPositiveButton("Wait", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "wait clicked", Toast.LENGTH_SHORT).show();
            }
        });
        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        alertBuilder.setNeutralButton("Later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Close Later", Toast.LENGTH_SHORT).show();
            }
        });
        alertBuilder.setCancelable(false);
        alertBuilder.create().show();
    }
}
