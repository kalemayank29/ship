package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

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
}
