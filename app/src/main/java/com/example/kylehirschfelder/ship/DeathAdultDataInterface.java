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
 * Created by mayank on 12/24/15.
 */
public class DeathAdultDataInterface  {
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

    public String insert(DeathAdult death) {

        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
       // cv.put(dbHelper.VILLAG_OF_BIRTH, death.getVillageOfBirth());
        //cv.put(dbHelper.VILLAGE_OF_BIRTH_ID, death.getVillageOfBirthID());

        Log.println(Log.ASSERT,"DBANME",death.getName());


        cv.put(dbHelper.NAME, death.getName());
        cv.put(dbHelper.FAMILY_ID, death.getFamilyID());
        cv.put(dbHelper.HOUSE_ID, death.getHouseID());
        cv.put(dbHelper.MEMBER_ID, death.getMemberID());
        cv.put(dbHelper.VILLAGE_ID, death.getVillageId());
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

        DeathAdult recent = getRecent();
        String flag = "." + String.valueOf(recent.getId()) + "-0";
        Log.println(Log.ASSERT,"flagDEATHADULT",flag);

        SQ.close();

        return flag;
    }



    public DeathAdult getInfo(int id) {
        DeathAdult death = new DeathAdult();
        Cursor c = null;
        SQLiteDatabase SQ = dbHelper.getReadableDatabase();

        c = SQ.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME + " WHERE _id = '" + id + "'", null);
        c.moveToFirst();
        int i = 0;
      //c.moveToFirst();

        death.setName(c.getString(i++));
        death.setFamilyID(c.getString(i++));
        death.setHouseID(c.getString(i++));
        death.setMemberID(c.getString(i++));
        death.setVillageId(c.getString(i++));
        death.setBirthDate(c.getString(i++));
        death.setDeathDate(c.getString(i++));
        death.setAge(c.getString(i++));

        death.setVillageStay(c.getString(i++));
        death.setVillageStayId(c.getString(i++));
        death.setVillageOfDeath(c.getString(i++));
        death.setVillageOfDeathID(c.getString(i++));

        death.setHealthMessenger(c.getString(i++));
        death.setHealthMessengerId(c.getString(i++));
        death.setHealthMessengerDate(c.getString(i++));
        death.setGuideName(c.getString(i++));
        death.setGuideId(c.getString(i++));
        death.setGuideTestDate(c.getString(i++));

        death.setId(Integer.parseInt(c.getString(i++)));

        return death;

    }

    public DeathAdult getRecent(){

        SQLiteDatabase SQ = dbHelper.getReadableDatabase();
        Cursor c = null;


        c = SQ.rawQuery("SELECT * FROM " + DeathAdultDBHelper.TABLE_NAME + " ORDER BY _id DESC LIMIT 1",null);

        DeathAdult death = new DeathAdult();

        if (c.moveToFirst()) {
            int i = 0;
            death.setName(c.getString(i++));
            death.setFamilyID(c.getString(i++));
            death.setHouseID(c.getString(i++));
            death.setMemberID(c.getString(i++));
            death.setVillageId(c.getString(i++));
            death.setBirthDate(c.getString(i++));
            death.setDeathDate(c.getString(i++));
            death.setAge(c.getString(i++));

            death.setVillageOfDeath(c.getString(i++));
            death.setVillageOfDeathID(c.getString(i++));

            death.setVillageStay(c.getString(i++));
            death.setVillageStayId(c.getString(i++));

            death.setHealthMessenger(c.getString(i++));
            death.setHealthMessengerId(c.getString(i++));
            death.setHealthMessengerDate(c.getString(i++));
            death.setGuideName(c.getString(i++));
            death.setGuideId(c.getString(i++));
            death.setGuideTestDate(c.getString(i++));

            death.setId(Integer.parseInt(c.getString(i++)));
        }


        return death;

    }

    public void update(DeathAdult death) {

        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        String selection = "_id=?";
        String[] args = {String.valueOf(death.getId())};

        cv.put(dbHelper.ID,death.getId());
        cv.put(dbHelper.NAME, death.getName());
        cv.put(dbHelper.FAMILY_ID, death.getFamilyID());
        cv.put(dbHelper.HOUSE_ID, death.getHouseID());
        cv.put(dbHelper.MEMBER_ID, death.getMemberID());
        cv.put(dbHelper.VILLAGE_ID, death.getVillageId());
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

        SQ.update(dbHelper.TABLE_NAME, cv, selection, args);
        SQ.close();
    }

    public List<DeathAdult> getAll(){

        List<DeathAdult> deathList = new ArrayList<DeathAdult>();
        SQLiteDatabase SQ = dbHelper.getWritableDatabase();

        Cursor c;
        c = SQ.rawQuery("SELECT * FROM " + DeathAdultDBHelper.TABLE_NAME , null);

        if(c.moveToFirst()){
            do{
                DeathAdult death = new DeathAdult();
                int i=0;
                death.setName(c.getString(i++));
                death.setFamilyID(c.getString(i++));
                death.setHouseID(c.getString(i++));
                death.setMemberID(c.getString(i++));
                death.setVillageId(c.getString(i++));
                death.setBirthDate(c.getString(i++));
                death.setDeathDate(c.getString(i++));
                death.setAge(c.getString(i++));

                death.setVillageOfDeath(c.getString(i++));
                death.setVillageOfDeathID(c.getString(i++));

                death.setVillageStay(c.getString(i++));
                death.setVillageStayId(c.getString(i++));

                death.setHealthMessenger(c.getString(i++));
                death.setHealthMessengerId(c.getString(i++));
                death.setHealthMessengerDate(c.getString(i++));
                death.setGuideName(c.getString(i++));
                death.setGuideId(c.getString(i++));
                death.setGuideTestDate(c.getString(i++));

                death.setId(Integer.parseInt(c.getString(i++)));

                deathList.add(death);

            }
            while(c.moveToNext());
        }


        return deathList;

    }
}
