package com.example.tabraham.crud;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;

/**
 * Created by tabraham on 14/7/16.
 */
public class DataRetrival extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Cursor mCurser = getContentResolver().query(EmployeeInfo.EMPLOYEE_URI, new String[]{EmployeeInfo._ID, EmployeeInfo.EMPLOYEE_NAME, EmployeeInfo.EMPLOYEE_PHONE_NUMBER, EmployeeInfo.EMPLOYEE_ADDRESS}, null, null, null);
        startManagingCursor(mCurser);
        String[] from = new String[]{EmployeeInfo._ID, EmployeeInfo.EMPLOYEE_NAME, EmployeeInfo.EMPLOYEE_PHONE_NUMBER, EmployeeInfo.EMPLOYEE_ADDRESS};
        int[] to = new int[]{R.id.textViewId,R.id.textViewName,R.id.textViewNumber,R.id.textViewAddress};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.raw_item,mCurser,from,to);
        this.setListAdapter(simpleCursorAdapter);
        }
    }

