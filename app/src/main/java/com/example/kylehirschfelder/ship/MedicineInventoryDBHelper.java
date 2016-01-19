package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylehirschfelder on 12/23/15.
 */
public class MedicineInventoryDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "drugInventory",
                    TABLE_INVENTORY = "medicineInventoryTable",
                    KEY_MEDICINEID = "medicine_id",
                    KEY_NAME = "name",
                    KEY_QUANTITY = "quantity";

    private static final String TABLE_CREATE = "CREATE TABLE "
                    + TABLE_INVENTORY + " ("
                    + KEY_MEDICINEID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_NAME + " TEXT, "
                    + KEY_QUANTITY + " INTEGER " + ")";


    public MedicineInventoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        onCreate(sqLiteDatabase);
    }
}