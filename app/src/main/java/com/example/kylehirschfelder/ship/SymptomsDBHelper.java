package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class SymptomsDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "drugInventory",
            TABLE_PRESCRIPTION = "prescriptionTable",
            KEY_PRESCID = "prescr_id",
            KEY_VILLAGEID = "village_id",
            KEY_SYMPTOMS = "symptoms";

    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_PRESCRIPTION + " ("
            + KEY_PRESCID + " INT PRIMARY KEY, "
            + KEY_VILLAGEID + " INT, "
            + KEY_SYMPTOMS + " TEXT" + ")";

    public SymptomsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRESCRIPTION);
        onCreate(sqLiteDatabase);
    }
}