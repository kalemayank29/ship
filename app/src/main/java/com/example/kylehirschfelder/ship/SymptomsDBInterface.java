package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class SymptomsDBInterface {

    private SQLiteDatabase database;
    private SymptomsDBHelper dbHelper;


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }


    public void close() throws SQLException {
        dbHelper.close();
    }


    public SymptomsDBInterface(Context context){
        dbHelper = new SymptomsDBHelper(context);
    }


    public void insertSymptom(int prescription_id){


    }
}