package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DrugDBHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "drugManager",
            TABLE_DRUG = "drugTable",
            KEY_ID = "_id",
            KEY_GENERIC = "generic",
            KEY_BRAND = "brand",
            KEY_FORMULA = "formula",
            KEY_CLASS = "class",
            KEY_COLOR = "color",
            KEY_SHAPE = "shape";

    public DrugDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("In onCreate", " Here");
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_DRUG + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_GENERIC + " VARCHAR, "
                + KEY_BRAND + " VARCHAR, "
                + KEY_FORMULA + " VARCHAR, "
                + KEY_CLASS + " VARCHAR, "
                + KEY_COLOR + " VARCHAR, "
                + KEY_SHAPE + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRUG);
        onCreate(db);
    }

    public void createDrug(Drug element){
        Log.e("Made it to create drug ", element.get_brand().toString());
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(KEY_ID, element.get_id());
        values.put(KEY_GENERIC, element.get_generic());
        values.put(KEY_BRAND, element.get_brand());
        values.put(KEY_FORMULA, element.get_formula());
        values.put(KEY_CLASS, element.get_class());
        values.put(KEY_COLOR, element.get_color());
        values.put(KEY_SHAPE, element.get_shape());

        db.insert(TABLE_DRUG, null, values);
        db.close();
    }

    public int getDrugCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_DRUG, null);
        int c = cursor.getCount();
        db.close();
        cursor.close();
        return c;
    }

    public List<Drug> getAllDrugs(){
        List<Drug> drugList = new ArrayList<Drug>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_DRUG, null);

        if(cursor.moveToFirst()){
            do{
                Drug element = new Drug(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                        cursor.getString(6));
                drugList.add(element);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return drugList;
    }

    public void deleteDrug(Drug drug){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_DRUG, KEY_ID + "=?", new String[] {String.valueOf(drug.get_id())});
        db.close();
    }


    public Drug getDrug(int id){
        SQLiteDatabase db = getWritableDatabase();
        Drug element = new Drug();

        String selection = "_id=?";
        String[] selectionArgs = new String[] { String.valueOf(id)};
        Cursor c = db.query(DrugDBHandler.TABLE_DRUG,null,selection,selectionArgs,null,null,null);
        c.moveToFirst();

        element.set_id(c.getInt(c.getColumnIndexOrThrow(DrugDBHandler.KEY_ID)));
        element.set_generic(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_GENERIC)));
        element.set_brand(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_BRAND)));
        element.set_class(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_CLASS)));
        element.set_formula(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_FORMULA)));
        element.set_color(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_COLOR)));
        element.set_shape(c.getString(c.getColumnIndexOrThrow(DrugDBHandler.KEY_SHAPE)));

        this.close();

        return element;

    }

    public void deleteAllTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DRUG);
    }


}

