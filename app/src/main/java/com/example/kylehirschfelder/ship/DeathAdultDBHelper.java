package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mayank on 12/24/15.
 */
public class DeathAdultDBHelper extends SQLiteOpenHelper{

        public static final int database_version = 1;


       // public static final String VILLAGE_OF_BIRTH = "village_of_birth" ;//2 spinners
       // public static final String VILLAGE_OF_BIRTH_ID = "village_of_birth_id" ;//tv

        public static final String NAME = "name" ;//tv
        public static final String MEMBER_ID = "member_id" ;//
        public static final String FAMILY_ID = "family_id" ;//tv
        public static final String HOUSE_ID = "house_id" ;//tv
        public static final String VILLAGE_ID  = "village_id";
        public static final String BIRTH_DATE = "birth_date" ;//dp
        public static final String DEATH_DATE = "death_date" ;//dp
        public static final String ID = "_id";
        public static final String AGE = "age" ;//dp

        public static final String VILLAGE_OF_DEATH = "village_of_death" ;//2 spinners
        public static final String VILLAGE_OF_DEATH_ID = "village_of_death_id" ;//tv

        public static final String VILLAGE_OF_STAY = "village_of_stay" ;//2 spinners
        public static final String VILLAGE_OF_STAY_ID = "village_of_stay_id" ;//tv

        public static final String HEALTH_MESSENGER = "health_messenger" ;//et
        public static final String HEALTH_MESSENGER_ID = "health_messenger_id";//et
        public static final String HEALTH_MESSENGER_DATE = "health_messenger_date" ;//dp

        public static final String GUIDE_NAME = "guide_name" ;//et
        public static final String GUIDE_ID = "guide_id" ;//et
        public static final String GUIDE_TEST_DATE = "guide_test_date" ;//dp

        public static final String DATABASE_NAME = "SEARCH1";
        public static final String TABLE_NAME = "AdultDeathInfo";

        public String CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME+
                "("+
                NAME+" TEXT,"+
                FAMILY_ID+" TEXT,"+
                HOUSE_ID+" TEXT,"+
                MEMBER_ID+" TEXT," +
                VILLAGE_ID+ " TEXT," +
                BIRTH_DATE+" TEXT,"+
                DEATH_DATE+" TEXT,"+
                AGE +" TEXT,"+

                VILLAGE_OF_STAY+" TEXT,"+
                VILLAGE_OF_STAY_ID+" TEXT,"+

                VILLAGE_OF_DEATH+" TEXT,"+
                VILLAGE_OF_DEATH_ID+" TEXT,"+

                HEALTH_MESSENGER+" TEXT,"+
                HEALTH_MESSENGER_ID+" TEXT,"+
                HEALTH_MESSENGER_DATE+" TEXT,"+
                GUIDE_NAME+" TEXT,"+
                GUIDE_ID+" TEXT,"+
                GUIDE_TEST_DATE+ " TEXT, " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                ")";

        public DeathAdultDBHelper(Context context) {
            super(context, DATABASE_NAME, null, database_version);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }


    }


