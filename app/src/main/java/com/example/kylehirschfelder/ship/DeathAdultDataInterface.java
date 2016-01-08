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



    /*public DeathAdult getInfo(int id){
        Birth birth = new Birth();
        Cursor c;
        SQLiteDatabase SQ = this.getReadableDatabase();
        String selection = "_id=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        c = SQ.query(BirthInfoDB.TableInfo.TABLE_NAME, null,  selection, selectionArgs, null, null, null, null);
        c.moveToFirst();
        birth.setMotherVillage(c.getString(0));
        birth.setMotherVillageID(c.getString(1));
        birth.setMotherName(c.getString(2));
        birth.setFamilyID(c.getString(3));
        birth.setHouseID(c.getString(4));
        birth.setChildID(c.getString(5));
        birth.setBirthDate(c.getString(6));
        birth.setVillageOfBirth(c.getString(7));
        birth.setVillageOfBirthID(c.getString(8));
        birth.setVillageOfBirthPlace(c.getString(9));
        birth.setDeliveryName(c.getString(10));
        birth.setDeliveryMethod(c.getString(11));
        birth.setChildGender(c.getString(12));
        birth.setPregnancyTime(c.getString(13));
        birth.setFadPresence(c.getString(14));
        birth.setHealthMessenger(c.getString(15));
        birth.setHealthMessengerId(c.getString(16));
        birth.setHealthMessengerDate(c.getString(17));
        birth.setGuideName(c.getString(18));
        birth.setGuideId(c.getString(19));
        birth.setGuideTestDate(c.getString(20));
        return birth;

    }*/
}
