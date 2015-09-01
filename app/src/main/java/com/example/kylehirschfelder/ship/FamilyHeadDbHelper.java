package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 8/10/15.
 */
public class FamilyHeadDbHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "searchVillages";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_FAMILY_HEAD = "family";

    public static final String MEMBER_ID = "_id";
    public static final String FAMILY_ID = "family_id";
    public static final String HOUSE_ID = "house_id";
    public static final String FAMILY_HEAD_BOOL = "family_head";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String CHILD_ID = "child_id";
    public static final String CHILD_DATE = "child_date";
    public static final String MARRIAGE_STATUS = "m_status";
    public static final String FAMILY_PLAN = "family_plan";
    public static final String EDUCATION = "education";
    public static final String LITERACY = "literacy";
    public static final String WEDDING_DEPT = "wed_left";
    public static final String WEDDING_ARR = "wed_came";
    public static final String FLAG = "flag";


    //SQL to create local table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_FAMILY_HEAD + " (" +
                    MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FAMILY_ID + " INTEGER NOT NULL, " +
                    HOUSE_ID + " INTEGER NOT NULL, " +
                    FAMILY_HEAD_BOOL + " INTEGER NOT NULL," +
                    NAME + " TEXT," +
                    AGE + " INTEGER, " +
                    CHILD_ID + " INTEGER," +
                    CHILD_DATE + " INTEGER," +
                    MARRIAGE_STATUS + " TEXT," +
                    FAMILY_PLAN + " TEXT," +
                    EDUCATION + " TEXT, " +
                    LITERACY + " TEXT, " +
                    WEDDING_ARR + " TEXT, " +
                    WEDDING_DEPT + " TEXT, " +
                    FLAG + " INTEGER" +
                    ")";

    // Flag 1 = NOT TRANSFERRED.


    public FamilyHeadDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FAMILY_HEAD);
        onCreate(sqLiteDatabase);
    }
}
