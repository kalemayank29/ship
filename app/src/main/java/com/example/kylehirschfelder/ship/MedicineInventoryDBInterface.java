package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylehirschfelder on 12/23/15.
 */

public class MedicineInventoryDBInterface {

    public SQLiteDatabase database;
    public MedicineInventoryDBHelper dbHelper;


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }


    public void close() throws SQLException {
        dbHelper.close();
    }


    public MedicineInventoryDBInterface(Context context){
        dbHelper = new MedicineInventoryDBHelper(context);
    }


    //puts a new medicine in the database
    public long createMedicine(Medicine medicine) throws SQLException {

        this.open();
        long newRowId = -1;

        ContentValues value = new ContentValues();
       // value.put(dbHelper.KEY_MEDICINEID, medicine.getId());
        value.put(dbHelper.KEY_NAME, medicine.getName());
        value.put(dbHelper.KEY_QUANTITY,medicine.getQuantity());
      //  value.put(dbHelper.KEY_VILLAGEID, medicine.getVillageId());
        newRowId = this.database.insert(dbHelper.TABLE_INVENTORY, null, value);

        this.close();
        return newRowId;
    }


    //returns the count of medicine. Not sure if useful, but implemented
    public int getMedicineCount() throws SQLException{

        this.openRead();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_INVENTORY, null);
        int c = cursor.getCount();
        database.close();
        this.close();
        return c;
    }


    //populates a list with the medicine from the Table Inventory
    public List<Medicine> getAllMedicine() throws SQLException {

        List<Medicine> medicineList = new ArrayList<Medicine>();
        this.open();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_INVENTORY, null);

        if(cursor.moveToFirst()){
            do{
                Medicine element = new Medicine(cursor.getString(0), cursor.getString(1));
                element.setQuantity(Integer.parseInt(cursor.getString(2)));
                medicineList.add(element);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        database.close();
        this.close();
        return medicineList;
    }


    //removes a specific medicine from the table. Will only remove if quantity = 0
    public void removeMedicine(Medicine medicine) throws SQLException {

        this.open();
        database.delete(dbHelper.TABLE_INVENTORY, dbHelper.KEY_MEDICINEID + "=?", new String[] {String.valueOf(medicine.getId())});
        database.close();
    }


    //Takes a medicine object to update, the desired quantity, and the name of the drug to be updated
    public void addQuantity(Medicine medicine, int newQuantity) throws SQLException{

        this.open();
        ContentValues cv = new ContentValues();
        int oldQuantity = medicine.getQuantity();
        medicine.setQuantity(oldQuantity + newQuantity);
        cv.put("medicine_id", medicine.getId());
        cv.put("name", medicine.getName());
        cv.put("quantity", String.valueOf(medicine.getQuantity()));
     //   cv.put("village_id", medicine.getVillageId());

        Log.println(Log.ASSERT,"quant", String.valueOf(medicine.getQuantity()));
        database.update(dbHelper.TABLE_INVENTORY, cv, dbHelper.KEY_MEDICINEID + "= " + medicine.getId(), null);
        this.close();
        database.close();
    }

    //Takes a medicine object to update, the desired quantity to remove, and the name of the drug to be updated
    //When using this method, make sure that if oldQuantity-newQuantity = -(quantity), set quantity to 0.
    public void subtractQuantity(Medicine medicine) throws SQLException{

      //  Medicine medicine = new Medicine();
        //Cursor cursor = null;

        this.open();

        //Calling add quantity if changeQuantity is already negative since then you're just adding a negative quantity to "remove" it
       // this.addQuantity(medicine, changeQuantity, medicine.getName());
        ContentValues cv = new ContentValues();
        cv.put("medicine_id", medicine.getId());
        cv.put("name", medicine.getName());
        cv.put("quantity", String.valueOf(medicine.getQuantity()));
      //  cv.put("village_id", medicine.getVillageId());

        database.update(dbHelper.TABLE_INVENTORY, cv, dbHelper.KEY_MEDICINEID + "=" + medicine.getId(), null);
        database.close();
        this.close();
    }


    public Medicine getMedicineFromId(int medicine_id) throws SQLException{

        Medicine medicine = new Medicine();
        Cursor cursor = null;

        this.openRead();
        String selection = "medicine_id=?";
        String[] selectionArgs = new String[]{String.valueOf(medicine_id)};
        cursor = database.query(dbHelper.TABLE_INVENTORY, null, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();
        medicine.setId(cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.KEY_MEDICINEID)));
        medicine.setQuantity(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_QUANTITY)));
        medicine.setName(cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.KEY_NAME)));
   //     medicine.setVillageId(cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.KEY_VILLAGEID)));
        this.close();
        cursor.close();
        return medicine;
    }


    //use to retrieve the id associated with the name selected from the spinner
    public String getIdFromMedicine(String medicine_name) throws SQLException{

        String idFromMedicine;
        Cursor cursor = null;

       // Log.println(Log.ASSERT,"name",medicine_name);
        this.openRead();

        String selection = "name=?";
        String[] selectionArgs = new String[]{medicine_name};
        cursor = database.query(dbHelper.TABLE_INVENTORY, null, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();
        Log.println(Log.ASSERT,"Cursor size", String.valueOf(cursor.getCount()));

        //selects the id associated with the name that is passed in the function
        idFromMedicine = cursor.getString(0);
        Log.println(Log.ASSERT,"Cursor size", idFromMedicine);

        this.close();
        cursor.close();
        return idFromMedicine;
    }


    //Used to get the labels to populate the spinner
    public List<String> getAllLabels() throws SQLException{
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + dbHelper.TABLE_INVENTORY;

        this.openRead();
        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        //database.close();
        this.close();
        // returning lables
        return labels;
    }


    //deletes tables, only use for debugging
    public void deleteAllTables() throws SQLException {

        this.open();
        database.execSQL("DELETE FROM " + dbHelper.TABLE_INVENTORY);
        database.close();
    }
}