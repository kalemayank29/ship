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
 * Created by mayank on 1/9/16.
 */
public class DeathChildDataInterface {
    private SQLiteDatabase database;
    private DeathChildDBHelper dbHelper;

    public DeathChildDataInterface(Context context) {
        dbHelper = new DeathChildDBHelper(context);
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

    public void insert(DeathChild death) {

        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.MOTHER_VILLAGE, death.getMotherVillage());
        cv.put(dbHelper.MOTHER_VILLAGE_ID, death.getMotherVillageID());

         cv.put(dbHelper.VILLAGE_OF_BIRTH, death.getVillageOfBirth());
        cv.put(dbHelper.VILLAGE_OF_BIRTH_ID, death.getVillageOfBirthID());

        cv.put(dbHelper.VILLAGE_ID, death.getVillageId());
        cv.put(dbHelper.NAME, death.getName());
        cv.put(dbHelper.FAMILY_ID, death.getFamilyID());
        cv.put(dbHelper.HOUSE_ID, death.getHouseID());
        cv.put(dbHelper.MEMBER_ID, death.getMemberID());
        cv.put(dbHelper.BIRTH_DATE, death.getBirthDate());
        cv.put(dbHelper.DEATH_DATE, death.getDeathDate());
        cv.put(dbHelper.AGE, death.getAge());
        cv.put(dbHelper.STILL_BIRTH, death.getStillBirth());

        cv.put(dbHelper.VILLAGE_OF_DEATH, death.getVillageOfDeath());
        cv.put(dbHelper.VILLAGE_OF_DEATH_ID, death.getVillageOfDeathID());

        cv.put(dbHelper.HEALTH_MESSENGER, death.getHealthMessenger());
        cv.put(dbHelper.HEALTH_MESSENGER_ID, death.getHealthMessengerId());
        cv.put(dbHelper.HEALTH_MESSENGER_DATE, death.getHealthMessengerDate());
        cv.put(dbHelper.GUIDE_NAME, death.getGuideName());
        cv.put(dbHelper.GUIDE_ID, death.getGuideId());
        cv.put(dbHelper.GUIDE_TEST_DATE, death.getGuideTestDate());

        long z = SQ.insert(DeathChildDBHelper.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
    }

    public DeathChild getInfo(int id) {
        DeathChild death = new DeathChild();
        SQLiteDatabase SQ = dbHelper.getReadableDatabase();
        Cursor c = null;
        c = SQ.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME + " WHERE _id = " + id, null);
        c.moveToFirst();

        int i = 0;

        while(c.moveToPosition(i)){
            Log.println(Log.ASSERT,String.valueOf(i),c.getString(i));
            i++;
        }
        i=0;
        c.moveToFirst();

        death.setId(Integer.parseInt(c.getString(i++)));
        death.setMotherVillage(c.getString(i++));
        death.setMotherVillageID(c.getString(i++));
        death.setVillageOfBirth(c.getString(i++));
        death.setVillageOfBirthID(c.getString(i++));
        death.setVillageId(c.getString(i++));
        death.setName(c.getString(i++));
        death.setFamilyID(c.getString(i++));
        death.setHouseID(c.getString(i++));
        death.setMemberID(c.getString(i++));
        death.setBirthDate(c.getString(i++));
        death.setDeathDate(c.getString(i++));
        death.setAge(c.getString(i++));
        death.setStillBirth(c.getString(i++));
        death.setVillageOfDeath(c.getString(i++));
        death.setVillageOfDeathID(c.getString(i++));
        death.setHealthMessenger(c.getString(i++));
        death.setHealthMessengerId(c.getString(i++));
        death.setHealthMessengerDate(c.getString(i++));
        death.setGuideName(c.getString(i++));
        death.setGuideId(c.getString(i++));
        death.setGuideTestDate(c.getString(i++));

        return death;
    }

    public void update(DeathChild death) {
        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.ID, death.getId());

        cv.put(dbHelper.MOTHER_VILLAGE, death.getMotherVillage());
        cv.put(dbHelper.MOTHER_VILLAGE_ID, death.getMotherVillageID());

        cv.put(dbHelper.VILLAGE_OF_BIRTH, death.getVillageOfBirth());
        cv.put(dbHelper.VILLAGE_OF_BIRTH_ID, death.getVillageOfBirthID());

        cv.put(dbHelper.VILLAGE_ID, death.getVillageId());
        cv.put(dbHelper.NAME, death.getName());
        cv.put(dbHelper.FAMILY_ID, death.getFamilyID());
        cv.put(dbHelper.HOUSE_ID, death.getHouseID());
        cv.put(dbHelper.MEMBER_ID, death.getMemberID());
        cv.put(dbHelper.BIRTH_DATE, death.getBirthDate());
        cv.put(dbHelper.DEATH_DATE, death.getDeathDate());
        cv.put(dbHelper.AGE, death.getAge());
        cv.put(dbHelper.STILL_BIRTH, death.getStillBirth());

        cv.put(dbHelper.VILLAGE_OF_DEATH, death.getVillageOfDeath());
        cv.put(dbHelper.VILLAGE_OF_DEATH_ID, death.getVillageOfDeathID());

        cv.put(dbHelper.HEALTH_MESSENGER, death.getHealthMessenger());
        cv.put(dbHelper.HEALTH_MESSENGER_ID, death.getHealthMessengerId());
        cv.put(dbHelper.HEALTH_MESSENGER_DATE, death.getHealthMessengerDate());
        cv.put(dbHelper.GUIDE_NAME, death.getGuideName());
        cv.put(dbHelper.GUIDE_ID, death.getGuideId());
        cv.put(dbHelper.GUIDE_TEST_DATE, death.getGuideTestDate());

        SQ.update(dbHelper.TABLE_NAME, cv, dbHelper.ID + " = " + death.getId(), null);

    }

    public DeathChild getRecent(){

        SQLiteDatabase SQ = dbHelper.getReadableDatabase();
        Cursor c = null;


        c = SQ.rawQuery("SELECT * FROM " + DeathChildDBHelper.TABLE_NAME + " ORDER BY _id DESC LIMIT 1",null);

        DeathChild death = new DeathChild();

        if (c.moveToFirst()) {
            int i = 0;
            death.setId(Integer.parseInt(c.getString(i++)));
            death.setMotherVillage(c.getString(i++));
            death.setMotherVillageID(c.getString(i++));
            death.setVillageOfBirth(c.getString(i++));
            death.setVillageOfBirthID(c.getString(i++));
            death.setVillageId(c.getString(i++));
            death.setName(c.getString(i++));
            death.setFamilyID(c.getString(i++));
            death.setHouseID(c.getString(i++));
            death.setMemberID(c.getString(i++));
            death.setBirthDate(c.getString(i++));
            death.setDeathDate(c.getString(i++));
            death.setAge(c.getString(i++));
            death.setStillBirth(c.getString(i++));
            death.setVillageOfDeath(c.getString(i++));
            death.setVillageOfDeathID(c.getString(i++));
            death.setHealthMessenger(c.getString(i++));
            death.setHealthMessengerId(c.getString(i++));
            death.setHealthMessengerDate(c.getString(i++));
            death.setGuideName(c.getString(i++));
            death.setGuideId(c.getString(i++));
            death.setGuideTestDate(c.getString(i++));
        }


        return death;

    }

    public List<DeathChild> getAll(){

        List<DeathChild> deathList = new ArrayList<DeathChild>();
        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        Cursor c;
        c = SQ.rawQuery("SELECT * FROM " + DeathChildDBHelper.TABLE_NAME , null);

        if(c.moveToFirst()){
            do{
                DeathChild death = new DeathChild();
                int i=0;

                death.setId(Integer.parseInt(c.getString(i++)));
                death.setMotherVillage(c.getString(i++));
                death.setMotherVillageID(c.getString(i++));
                death.setVillageOfBirth(c.getString(i++));
                death.setVillageOfBirthID(c.getString(i++));
                death.setVillageId(c.getString(i++));
                death.setName(c.getString(i++));
                death.setFamilyID(c.getString(i++));
                death.setHouseID(c.getString(i++));
                death.setMemberID(c.getString(i++));
                death.setBirthDate(c.getString(i++));
                death.setDeathDate(c.getString(i++));
                death.setAge(c.getString(i++));
                death.setStillBirth(c.getString(i++));
                death.setVillageOfDeath(c.getString(i++));
                death.setVillageOfDeathID(c.getString(i++));
                death.setHealthMessenger(c.getString(i++));
                death.setHealthMessengerId(c.getString(i++));
                death.setHealthMessengerDate(c.getString(i++));
                death.setGuideName(c.getString(i++));
                death.setGuideId(c.getString(i++));
                death.setGuideTestDate(c.getString(i++));

                deathList.add(death);

            }
            while(c.moveToNext());
        }


        return deathList;

    }


}
