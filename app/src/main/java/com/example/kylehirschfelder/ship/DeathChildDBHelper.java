package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 1/9/16.
 */
public class DeathChildDBHelper extends SQLiteOpenHelper {

    public static final int database_version = 1;

    public static final String MOTHER_VILLAGE = "mother_village" ;
    public static final String MOTHER_VILLAGE_ID = "mother_village_id" ;

    public static final String VILLAGE_OF_BIRTH = "village_of_birth" ;
    public static final String VILLAGE_OF_BIRTH_ID = "village_of_birth_id" ;

    public static final String ID = "_id" ;

    public static final String NAME = "name" ;
    public static final String MEMBER_ID = "member_id" ;
    public static final String FAMILY_ID = "family_id" ;
    public static final String HOUSE_ID = "house_id" ;
    public static final String VILLAGE_ID  = "village_id";
    public static final String BIRTH_DATE = "birth_date" ;
    public static final String DEATH_DATE = "death_date" ;

    public static final String AGE = "age" ;
    public static final String STILL_BIRTH = "still_birth" ;

    public static final String VILLAGE_OF_DEATH = "village_of_death" ;
    public static final String VILLAGE_OF_DEATH_ID = "village_of_death_id" ;


    public static final String HEALTH_MESSENGER = "health_messenger" ;
    public static final String HEALTH_MESSENGER_ID = "health_messenger_id";
    public static final String HEALTH_MESSENGER_DATE = "health_messenger_date" ;

    public static final String GUIDE_NAME = "guide_name" ;
    public static final String GUIDE_ID = "guide_id" ;
    public static final String GUIDE_TEST_DATE = "guide_test_date" ;

    public static final String DATABASE_NAME = "SEARCH5";
    public static final String TABLE_NAME = "ChildDeathInfo";

    public String CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME+
            "("+

            ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MOTHER_VILLAGE + " TEXT,"+
            MOTHER_VILLAGE_ID +" TEXT,"+

            VILLAGE_OF_BIRTH+" TEXT,"+
            VILLAGE_OF_BIRTH_ID+" TEXT,"+

            VILLAGE_ID+ " TEXT," +
            NAME+" TEXT,"+
            FAMILY_ID+" TEXT,"+
            HOUSE_ID+" TEXT,"+
            MEMBER_ID+" TEXT," +

            BIRTH_DATE+" TEXT,"+
            DEATH_DATE+" TEXT,"+
            AGE +" TEXT,"+
            STILL_BIRTH +" TEXT,"+

            VILLAGE_OF_DEATH+" TEXT,"+
            VILLAGE_OF_DEATH_ID+" TEXT,"+

            HEALTH_MESSENGER+" TEXT,"+
            HEALTH_MESSENGER_ID+" TEXT,"+
            HEALTH_MESSENGER_DATE+" TEXT,"+
            GUIDE_NAME+" TEXT,"+
            GUIDE_ID+" TEXT,"+
            GUIDE_TEST_DATE+")";

    public DeathChildDBHelper(Context context) {
        super(context, DATABASE_NAME, null, database_version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }}
