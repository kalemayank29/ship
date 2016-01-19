package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class PrescriptionsDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "drugInventory",
            TABLE_PRESCRIPTION = "prescriptionTable",
            KEY_ID = "_id",
            KEY_DATE = "date",
            KEY_MEMBERID = "member_id",
            KEY_FAMILYID = "family_id",
            KEY_MEDICINEID = "medicine_id",
            KEY_DOSEDAYS = "dose_days",
            KEY_DOSEQUANTITY = "dose_quantity";

    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_PRESCRIPTION + " ("
            + KEY_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + KEY_DATE + " TEXT, "
            + KEY_MEMBERID + " INT, "
            + KEY_FAMILYID + " INT, "
            + KEY_MEDICINEID + " INT, "
            + KEY_DOSEDAYS + " INT, "
            + KEY_DOSEQUANTITY + " INT" + ")";

    public PrescriptionsDBHelper(Context context) {
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