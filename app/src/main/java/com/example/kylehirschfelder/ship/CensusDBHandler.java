package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylehirschfelder on 7/27/15.
 */
public class CensusDBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "formManager1",
            TABLE_CENSUS = "census",
            KEY_HOUSEID = "_id",
            KEY_CASTE = "caste",
            KEY_PBUS = "p_bus",
            KEY_ABUS1 = "a_bus_1",
            KEY_ABUS2 = "a_bus_2",
            KEY_ABUS3 = "a_bus_3",
            KEY_WALL = "wall",
            KEY_ROOF = "roof",
            KEY_ELECTRICITY = "electricity",
            KEY_HOUSEOWNER = "house_owner",
            KEY_TOILETUSE = "toilet_use",
            KEY_TOILET = "toilet",
            KEY_COOK = "cook",
            KEY_KITCHEN = "kitchen",
            KEY_WATER = "water",
            KEY_DATE = "date",
            KEY_RELIGION = "religion";

    public CensusDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_CENSUS + "("
                + KEY_HOUSEID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_CASTE + " VARCHAR, "
                + KEY_RELIGION + " VARCHAR, "
                + KEY_PBUS + " VARCHAR, "
                + KEY_ABUS1 + " VARCHAR, "
                + KEY_ABUS2 + " VARCHAR, "
                + KEY_ABUS3 + " VARCHAR, "
                + KEY_WALL + " VARCHAR, "
                + KEY_ROOF + " VARCHAR, "
                + KEY_ELECTRICITY + " VARCHAR, "
                + KEY_HOUSEOWNER + " VARCHAR, "
                + KEY_TOILET + " VARCHAR, "
                + KEY_TOILETUSE + " VARCHAR, "
                + KEY_COOK + " VARCHAR, "
                + KEY_KITCHEN + " VARCHAR, "
                + KEY_WATER + " VARCHAR, "
                + KEY_DATE + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CENSUS);
        onCreate(db);
    }

    public void createCensus(Census census) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_HOUSEID, census.get_houseId());
        values.put(KEY_CASTE, census.get_caste());
        values.put(KEY_RELIGION, census.get_religion());
        values.put(KEY_PBUS, census.get_pbus());
        values.put(KEY_ABUS1, census.get_abus1());
        values.put(KEY_ABUS2, census.get_abus2());
        values.put(KEY_ABUS3, census.get_abus3());
        values.put(KEY_WALL, census.get_wall());
        values.put(KEY_ROOF, census.get_roof());
        values.put(KEY_COOK, census.get_cook());
        values.put(KEY_ELECTRICITY, census.get_electricity());
        values.put(KEY_HOUSEOWNER, census.get_houseowner());
        values.put(KEY_TOILET, census.get_toilet());
        values.put(KEY_TOILETUSE, census.get_toiletuse());
        values.put(KEY_WATER, census.get_water());
        values.put(KEY_DATE, census.get_date());

        db.insert(TABLE_CENSUS, null, values);
        db.close();
    }
    /*
    public void deleteContact(Census census) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_CENSUS, KEY_FAMID + "=?", new String[]{String.valueOf(census.get_famid())});
        db.close();
    }
    */

    public int getCensusCount() {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CENSUS, null);
        int c = cursor.getCount();
        db.close();
        cursor.close();
        return c;
    }

    public List<Census> getAllCensus() {
        List<Census> censusList = new ArrayList<Census>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CENSUS, null);

        if (cursor.moveToFirst()) {
            do {
                Census element = new Census(Integer.parseInt(cursor.getString(0)),  cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                        cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13),
                        cursor.getString(14), cursor.getString(15), cursor.getString(16));
                censusList.add(element);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return censusList;
    }


    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CENSUS, null, null);
        db.close();
    }

    public Census getRecent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CENSUS + " ORDER BY _id DESC LIMIT 1",null);
        cursor.moveToFirst();
        Census element = new Census(Integer.parseInt(cursor.getString(0)),  cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13),
                cursor.getString(14), cursor.getString(15), cursor.getString(16));
        return element;
    }
}
