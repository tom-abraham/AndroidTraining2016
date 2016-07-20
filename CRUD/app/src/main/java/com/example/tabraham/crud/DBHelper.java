package com.example.tabraham.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tabraham on 13/7/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, AppConstants.DB_NAME, null, AppConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createEmplyeeTable());


    }

    private String createEmplyeeTable() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table " + EmployeeInfo.TABLE_NAME);
        stringBuilder.append("(");
        stringBuilder.append("'" + EmployeeInfo._ID + "' integer primary key autoincrement not null,");
        stringBuilder.append("'" + EmployeeInfo.EMPLOYEE_NAME + "' varchar,");
        stringBuilder.append("'" + EmployeeInfo.EMPLOYEE_PHONE_NUMBER + "' varchar,");
        stringBuilder.append("'" + EmployeeInfo.EMPLOYEE_ADDRESS + "" + "' varchar");
        stringBuilder.append(")");
        System.out.println("querry is : " + stringBuilder);

        return stringBuilder.toString();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
