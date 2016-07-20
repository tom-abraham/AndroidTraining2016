package com.example.tabraham.crud;

import android.net.Uri;
import android.provider.BaseColumns;

import java.io.File;

/**
 * Created by tabraham on 13/7/16.
 */
public interface EmployeeInfo extends BaseColumns{
    public static final String TABLE_NAME = "EmployeeTable";
    public static final String EMPLOYEE_NAME = "name";
    public static final String EMPLOYEE_PHONE_NUMBER = "phoneNumber";
    public static final String EMPLOYEE_ADDRESS = "address";

    public static final Uri EMPLOYEE_URI = Uri.parse("content://"+AppConstants.AUTHORITY+ File.separator+TABLE_NAME);



}
