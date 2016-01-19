package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 1/16/16.
 */
public class TransDBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "drug",
            TABLE_TRANS = "transTable",
            KEY_ID = "_id",
            KEY_VILLAGEID = "village_id",
            KEY_DATE = "date",
            KEY_MEDICINEID = "medicine_id",
            KEY_CHANGE = "change",
            KEY_TOTAL = "total",
            KEY_EXPIRY_DATE = "expiry_date";

    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_TRANS + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_VILLAGEID + " INT, "
            + KEY_DATE + " TEXT, "
            + KEY_MEDICINEID + " INT, "
            + KEY_CHANGE + " INT, "
            + KEY_TOTAL + " INT, "
            + KEY_EXPIRY_DATE + " TEXT " + ")";


    public TransDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANS);
        onCreate(sqLiteDatabase);
    }
}
