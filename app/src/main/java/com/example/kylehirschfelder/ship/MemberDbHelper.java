package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemberDbHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "village.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_MEMBER = "member";
    public static final String TABLE_MEMBERCUR = "memberCur";
    public static final String MEMBER_ID = "_id";
    public static final String FAMILY_ID = "family_id";
    public static final String HOUSE_ID = "house_id";
    public static final String FAMILY_HEAD_BOOL = "family_head_id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String CHILD_ID = "child_id";
    public static final String MARRIAGE_STATUS = "m_status";
    public static final String FAMILY_PLAN = "family_plan";
    public static final String EDUCATION = "education";
    public static final String LITERACY = "literacy";
    public static final String WEDDING_DEPT = "wed_left";
    public static final String WEDDING_ARR = "wed_came";


    //SQL to create table
    private static final String MEMBER_CREATE =
            "CREATE TABLE " + TABLE_MEMBER + " (" +
                    MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FAMILY_ID + " INTEGER NOT NULL, " +
                    HOUSE_ID + " INTEGER NOT NULL, " +
                    FAMILY_HEAD_BOOL + " INTEGER NOT NULL," +
                    NAME + " TEXT NOT NULL," +
                    AGE + " INTEGER NOT NULL, " +
                    CHILD_ID + " INTEGER, " +
                    MARRIAGE_STATUS + " VARCHAR NOT NULL," +
                    FAMILY_PLAN + " VARCHAR NOT NULL," +
                    EDUCATION + " VARCHAR NOT NULL, " +
                    LITERACY + " VARCHAR NOT NULL, " +
                    WEDDING_ARR + " TEXT, " +
                    WEDDING_DEPT + " TEXT " +
                    ")";

    private static final String MEMBER_CREATECUR =
            "CREATE TABLE " + TABLE_MEMBERCUR + " (" +
                    MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FAMILY_ID + " INTEGER NOT NULL, " +
                    HOUSE_ID + " INTEGER NOT NULL, " +
                    FAMILY_HEAD_BOOL + " INTEGER NOT NULL," +
                    NAME + " TEXT NOT NULL," +
                    AGE + " INTEGER NOT NULL, " +
                    CHILD_ID + " INTEGER, " +
                    MARRIAGE_STATUS + " VARCHAR NOT NULL," +
                    FAMILY_PLAN + " VARCHAR NOT NULL," +
                    EDUCATION + " VARCHAR NOT NULL, " +
                    LITERACY + " VARCHAR NOT NULL, " +
                    WEDDING_ARR + " TEXT, " +
                    WEDDING_DEPT + " TEXT " +
                    ")";


    public MemberDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MEMBER_CREATE);
        sqLiteDatabase.execSQL(MEMBER_CREATECUR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBERCUR);
        onCreate(sqLiteDatabase);
    }
}

