package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by mayank on 12/24/15.
 */
public class DeathAdultDataInterface {
    private SQLiteDatabase database;
    private DeathAdultDBHelper dbHelper;

    public DeathAdultDataInterface(Context context) {
        dbHelper = new DeathAdultDBHelper(context);
    }

    /******* LOGISTICAL FUNCTIONS FOR DATABASE **************/
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public void close() throws SQLException {
        dbHelper.close();
    }
    /***************** END ***********************/

    public void insert(DeathAdult death) {

        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
       // cv.put(dbHelper.VILLAGE_OF_BIRTH, death.getVillageOfBirth());
        //cv.put(dbHelper.VILLAGE_OF_BIRTH_ID, death.getVillageOfBirthID());


        cv.put(dbHelper.NAME, death.getName());
        cv.put(dbHelper.FAMILY_ID, death.getFamilyID());
        cv.put(dbHelper.HOUSE_ID, death.getHouseID());
        cv.put(dbHelper.MEMBER_ID, death.getMemberID());
        cv.put(dbHelper.VILLAGE_ID,death.getVillageId());
        cv.put(dbHelper.BIRTH_DATE, death.getBirthDate());
        cv.put(dbHelper.DEATH_DATE, death.getDeathDate());
        cv.put(dbHelper.AGE, death.getAge());

        cv.put(dbHelper.VILLAGE_OF_DEATH, death.getVillageOfDeath());
        cv.put(dbHelper.VILLAGE_OF_DEATH_ID, death.getVillageOfDeathID());

        cv.put(dbHelper.VILLAGE_OF_STAY, death.getVillageStay());
        cv.put(dbHelper.VILLAGE_OF_STAY_ID, death.getVillageStayId());

        cv.put(dbHelper.HEALTH_MESSENGER, death.getHealthMessenger());
        cv.put(dbHelper.HEALTH_MESSENGER_ID, death.getHealthMessengerId());
        cv.put(dbHelper.HEALTH_MESSENGER_DATE, death.getHealthMessengerDate());
        cv.put(dbHelper.GUIDE_NAME, death.getGuideName());
        cv.put(dbHelper.GUIDE_ID, death.getGuideId());
        cv.put(dbHelper.GUIDE_TEST_DATE, death.getGuideTestDate());

        long z = SQ.insert(DeathAdultDBHelper.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
    }



    public DeathAdult getInfo(int mem_id,int village_id){
        DeathAdult death = new DeathAdult();
        Cursor c;
        SQLiteDatabase SQ = dbHelper.getReadableDatabase();
        String selection = "member_id=? AND village_id=?";
        String[] selectionArgs = new String[]{String.valueOf(mem_id),String.valueOf(village_id)};
        c = SQ.query(DeathAdultDBHelper.TABLE_NAME, null,  selection, selectionArgs, null, null, null, null);
        c.moveToFirst();
        
        death.setName(c.getString(0));
        death.setFamilyID(c.getString(1));
        death.setHouseID(c.getString(2));
        death.setMemberID(c.getString(3));
        death.setVillageId(c.getString(4));
        death.setBirthDate(c.getString(5));
        death.setDeathDate(c.getString(6));
        death.setAge(c.getString(7));
        death.setVillageStay(c.getString(8));
        death.setVillageStayId(c.getString(9));
        death.setVillageOfDeath(c.getString(10));
        death.setVillageOfDeathID(c.getString(11));
        death.setHealthMessenger(c.getString(12));
        death.setHealthMessengerId(c.getString(13));
        death.setHealthMessengerDate(c.getString(14));
        death.setGuideName(c.getString(15));
        death.setGuideId(c.getString(16));
        death.setGuideTestDate(c.getString(17));
        return death;
    }

    public void drop(){
        SQLiteDatabase SQ = dbHelper.getWritableDatabase();
        SQ.execSQL("DROP TABLE IF EXISTS " + dbHelper.TABLE_NAME);
    }
}
