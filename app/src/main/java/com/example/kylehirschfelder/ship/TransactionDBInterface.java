package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class TransactionDBInterface {

    private SQLiteDatabase database;
    private TransDBHelper dbHelper;
    private MedicineInventoryDBInterface medInterface;


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }


    public void close() throws SQLException {
        dbHelper.close();
    }


    public TransactionDBInterface(Context context) {
        dbHelper = new TransDBHelper(context);
        medInterface = new MedicineInventoryDBInterface(context);
    }


    //puts a new medicine in the database
    public long createTransaction(Transaction transaction) throws SQLException {

        this.open();
        long newRowId = -1;

        ContentValues value = new ContentValues();
        value.put(dbHelper.KEY_VILLAGEID, transaction.getVillage_id());
        value.put(dbHelper.KEY_DATE, transaction.getDate());
        value.put(dbHelper.KEY_MEDICINEID, transaction.getMedicine_id());
        value.put(dbHelper.KEY_CHANGE, transaction.getChange());

        Medicine medicine = medInterface.getMedicineFromId(transaction.getMedicine_id());
        medInterface.addQuantity(medicine,transaction.getChange());
        medicine = medInterface.getMedicineFromId(transaction.getMedicine_id());

        value.put(dbHelper.KEY_TOTAL, medicine.getQuantity());
        value.put(dbHelper.KEY_EXPIRY_DATE, transaction.getExpiryDate());
        newRowId = this.database.insert(dbHelper.TABLE_TRANS, null, value);

       // Log.println(Log.ASSERT, "YO", String.valueOf(transaction.getChange()));

        this.close();
        return newRowId;
    }


    public List<Transaction> getAllTransactions() throws SQLException {

        List<Transaction> transactionList = new ArrayList<Transaction>();

        this.open();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_TRANS, null);

            if (cursor.moveToFirst()) {
                do {
                    Transaction element = new Transaction(Integer.parseInt(cursor.getString(0)),
                            (cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                            Integer.parseInt(cursor.getString(4)), cursor.getString(5));

                    transactionList.add(element);

                } while (cursor.moveToNext());
            }

        cursor.close();
        database.close();
        return transactionList;
    }


    //Takes two dates passed in as arguments and searches the database for any transaction that
    //occurred between the dates
    public List<Transaction> getTransactionDates(Date firstDate, Date secondDate) throws SQLException {

        List<Transaction> transactionList = new ArrayList<Transaction>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dbDate1;

        this.open();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_TRANS, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Transaction element = new Transaction(Integer.parseInt(cursor.getString(0)),
                            (cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                            Integer.parseInt(cursor.getString(4)), cursor.getString(5));

                    dbDate1 = sdf.parse(element.getDate());
                    if (dbDate1.after(firstDate) && dbDate1.before(secondDate))
                        transactionList.add(element);

                } while (cursor.moveToNext());
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cursor.close();
        database.close();
        return transactionList;
    }


    //Takes two dates passed in as arguments and searches the database for any transaction that
    //occurred between the dates and match the given ID
    public List<Transaction> getTransactionIdDates(Date firstDate, Date secondDate, int id) throws SQLException {

        List<Transaction> transactionList = new ArrayList<Transaction>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date dbDate1;

        this.open();
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_TRANS, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Transaction element = new Transaction(Integer.parseInt(cursor.getString(0)),
                            (cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                            Integer.parseInt(cursor.getString(4)), cursor.getString(5));

                    dbDate1 = sdf.parse(element.getDate());
                    //cursor.getInt(0) should get the autoincrementing id
                    if (dbDate1.after(firstDate) && dbDate1.before(secondDate) && cursor.getInt(0) == id)
                        transactionList.add(element);

                } while (cursor.moveToNext());
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cursor.close();
        database.close();
        return transactionList;
    }
}