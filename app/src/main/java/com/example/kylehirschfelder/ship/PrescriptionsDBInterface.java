package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class PrescriptionsDBInterface {

    private SQLiteDatabase database;
    private SQLiteDatabase inventoryDatabase;
    private PrescriptionsDBHelper dbHelper;
    private MedicineInventoryDBInterface inventoryDbInterface;


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }


    public void close() throws SQLException {
        dbHelper.close();
    }

    public PrescriptionsDBInterface(Context context){
        dbHelper = new PrescriptionsDBHelper(context);
    }


    //returns number of prescriptions in DB
    public int getPrescriptionCount() throws SQLException{

        this.openRead();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_PRESCRIPTION, null);
        int c = cursor.getCount();
        this.close();
        cursor.close();
        return c;
    }

    //puts a new prescription in the database
    public long insertPrescription(Prescription prescription,Context context) throws SQLException {

        this.open();

        //need to subtract dose_days * dose_quant from total and update the ID
        int dose_days = prescription.getDose_days();
        int dose_quantity = prescription.getDose_quantity();
        int total = dose_days * dose_quantity;
        int med_id = prescription.getMedicine_id();
        inventoryDbInterface = new MedicineInventoryDBInterface(context);
        //subtract the prescription total from the inventory database based on the medicine ID
        Medicine medicine = inventoryDbInterface.getMedicineFromId(med_id);
        if(medicine.getQuantity() < total)
            Toast.makeText(context, "तेवढे औषध उपलब्ध नाहीत ", Toast.LENGTH_LONG).show();
        else {
            total = medicine.getQuantity() - total;
            medicine.setQuantity(total);
            inventoryDbInterface.subtractQuantity(medicine);

            long newRowId = -1;

            ContentValues value = new ContentValues();
            //value.put(dbHelper.KEY_ID, prescription.getId());
            value.put(dbHelper.KEY_DATE, String.valueOf(prescription.getDate()));
            value.put(dbHelper.KEY_MEMBERID, prescription.getMember_id());
            value.put(dbHelper.KEY_FAMILYID, prescription.getFamily_id());
            value.put(dbHelper.KEY_MEDICINEID, prescription.getMedicine_id());
            value.put(dbHelper.KEY_DOSEDAYS, prescription.getDose_days());
            value.put(dbHelper.KEY_DOSEQUANTITY, prescription.getDose_quantity());
            newRowId = this.database.insert(dbHelper.TABLE_PRESCRIPTION, null, value);


            this.close();

            return newRowId;
        }
        return 0;
    }


    //Passing in the member_id returns the prescription object associated with that ID in the database
    public Prescription getMemberIdPrescription(int member_id) throws SQLException{

        Prescription prescription = new Prescription();
        Cursor cursor;

        this.openRead();
        String selection = "_id=?";
        String[] selectionArgs = new String[]{String.valueOf(member_id)};
        cursor = database.query(dbHelper.TABLE_PRESCRIPTION, null, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();

        prescription.setId(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_ID)));
        prescription.setDate(cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.KEY_DATE)));
        prescription.setMember_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_MEMBERID)));
        prescription.setFamily_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_FAMILYID)));
        prescription.setMedicine_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_MEDICINEID)));
        prescription.setDose_days(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_DOSEDAYS)));
        prescription.setDose_quantity(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_DOSEQUANTITY)));


        return prescription;
    }


    //Passing in the medicine_id returns the prescription object associated with that ID in the database
    public Prescription getMedicineIdPrescription(int medicine_id) throws SQLException{

        Prescription prescription = new Prescription();
        Cursor cursor;
        this.openRead();
        String selection = "_id=?";
        String[] selectionArgs = new String[]{String.valueOf(medicine_id)};
        cursor = database.query(dbHelper.TABLE_PRESCRIPTION, null, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();

        prescription.setId(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_ID)));
        prescription.setDate(cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.KEY_DATE)));
        prescription.setMember_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_MEMBERID)));
        prescription.setFamily_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_FAMILYID)));
        prescription.setMedicine_id(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_MEDICINEID)));
        prescription.setDose_days(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_DOSEDAYS)));
        prescription.setDose_quantity(cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.KEY_DOSEQUANTITY)));

        return prescription;
    }
}