package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class TransactionDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "drugInventory",
            TABLE_TRANSACTION = "transactionTable",
            KEY_ID = "_id",
            KEY_VILLAGEID = "village_id",
            KEY_DATE = "date",
            KEY_MEDICINEID = "medicine_id",
            KEY_CHANGE = "change",
            KEY_TOTAL = "total",
            KEY_EXPIRY_DATE = "expiry_date";

    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_TRANSACTION + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_VILLAGEID + " INTEGER, "
            + KEY_DATE + " TEXT, "
            + KEY_MEDICINEID + " INTEGER, "
            + KEY_CHANGE + " INTEGER, "
            + KEY_TOTAL + " INTEGER, "
            + KEY_EXPIRY_DATE + " TEXT " + ")";

    public TransactionDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
        onCreate(sqLiteDatabase);
    }
}