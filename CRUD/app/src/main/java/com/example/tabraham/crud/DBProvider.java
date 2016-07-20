package com.example.tabraham.crud;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tabraham on 13/7/16.
 */
public class DBProvider extends ContentProvider {

    private static final int MATCH_INDEX_EMPLOYEE_INFO = 1;
    private static final UriMatcher mUriMatcher;

    private static  final Map<String,String> employeeProjection;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AppConstants.AUTHORITY, EmployeeInfo.TABLE_NAME, MATCH_INDEX_EMPLOYEE_INFO);
        employeeProjection = new HashMap<>();
        employeeProjection.put(EmployeeInfo._ID,EmployeeInfo._ID);
        employeeProjection.put(EmployeeInfo.EMPLOYEE_NAME,EmployeeInfo.EMPLOYEE_NAME);
        employeeProjection.put(EmployeeInfo.EMPLOYEE_PHONE_NUMBER,EmployeeInfo.EMPLOYEE_PHONE_NUMBER);
        employeeProjection.put(EmployeeInfo.EMPLOYEE_ADDRESS,EmployeeInfo.EMPLOYEE_ADDRESS);

    }

    DBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        dbHelper.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        switch (findUriIdex(uri)) {
            case MATCH_INDEX_EMPLOYEE_INFO: {
                builder.setTables(EmployeeInfo.TABLE_NAME);
                builder.setProjectionMap(employeeProjection);
            }


        }
        Cursor curser = builder.query(readableDatabase,projection,selection,selectionArgs,null,null,sortOrder);
        getContext().getContentResolver().notifyChange(uri, null);
        return curser;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        switch (findUriIdex(uri)) {
            case MATCH_INDEX_EMPLOYEE_INFO:

                sqLiteDatabase.insert(EmployeeInfo.TABLE_NAME, null, values);
                getContext().getContentResolver().notifyChange(uri, null);
                return uri;
        }
        return null;
    }

    private int findUriIdex(Uri uri) {
        return mUriMatcher.match(uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        switch (findUriIdex(uri)) {
            case MATCH_INDEX_EMPLOYEE_INFO:

                sqLiteDatabase.delete(EmployeeInfo.TABLE_NAME, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                return 0;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        switch (findUriIdex(uri)) {
            case MATCH_INDEX_EMPLOYEE_INFO:

                sqLiteDatabase.update(EmployeeInfo.TABLE_NAME,values, where, whereArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                return 0;
        }
        return 0;

    }


}
