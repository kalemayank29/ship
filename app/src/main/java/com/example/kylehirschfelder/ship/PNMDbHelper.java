package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 12/26/15.
 */
public class PNMDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "searchVillage";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_PNM = "pnm";
    public static final String TABLE_PNMCUR = "pnmcur";

    public static final String MEMBER_ID = "_id";
    public static final String NAME = "_id";
 //   public static final String COUGH = "cough";
    public static final String COUGH_DAYS = "cough_days";
//    public static final String GASP = "gasp";
    public static final String GASP_DAYS = "gasp_days";
//    public static final String FEVER = "fever";
    public static final String FEVER_DAYS = "fever_days";
 //   public static final String FIT = "fit";
    public static final String FIT_DAYS = "fit_days";
//    public static final String FAINT = "faint";
    public static final String FAINT_DAYS = "faint_days";
    public static final String MILK = "milk";
    public static final String MILK_DAYS = "milk_days";
    public static final String MILK_HOURS = "milk_hours";
//    public static final String MEASLES = "measles";
    public static final String MEASLES_DAYS = "measles_days";
//    public static final String VOMIT = "vomit";
    public static final String VOMIT_DAYS = "vomit_days";
    public static final String BIRTH_MONTHS = "birth_months";
    public static final String CONSC = "conscious";
    public static final String PULSE_RATE = "pulse_rate";
    public static final String CHEST = "chest";
    public static final String BREATH = "breath";
    public static final String WEAK = "gasp";
    public static final String DEHYDRATE = "dehydrate";
    public static final String MEASLES_COND = "measles_cond";
    public static final String FEVER_COUNT = "fever_count";
    public static final String STRYDER = "stryder";
    public static final String EXHALE = "exhale";
    public static final String SHORT_BREATH = "short_breath";
    public static final String COMMENTS = "comments";

    private static final String PNM_CREATE =
            "CREATE TABLE" + TABLE_PNM + " ("+
                    MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
   //                 COUGH + " INTEGER, " +
                    COUGH_DAYS + " INTEGER, " +
   //                 GASP + " INTEGER, " +
                    GASP_DAYS + " INTEGER, " +
   //                 FEVER + " INTEGER, " +
                    FEVER_DAYS + " INTEGER, " +
    //                FIT + " INTEGER, " +
                    FIT_DAYS + " INTEGER, " +
    //                FAINT + " INTEGER, " +
                    FAINT_DAYS + " INTEGER, " +
                    MILK + " INTEGER, " +
                    MILK_DAYS + " INTEGER, " +
                    MILK_HOURS + " INTEGER, " +
     //               MEASLES + " INTEGER, " +
                    MEASLES_DAYS + " INTEGER, " +
      //              VOMIT + " INTEGER, " +
                    VOMIT_DAYS + " INTEGER, " +
                    BIRTH_MONTHS + " INTEGER, " +
                    CONSC + " INTEGER, " +
                    PULSE_RATE + " INTEGER, " +
                    CHEST + " INTEGER, " +
                    BREATH + " INTEGER, " +
                    WEAK + " INTEGER, " +
                    DEHYDRATE + " INTEGER, " +
                    MEASLES_COND + " INTEGER, " +
                    FEVER_COUNT + " INTEGER, " +
                    STRYDER + " INTEGER, " +
                    EXHALE + " INTEGER, " +
                    SHORT_BREATH + " INTEGER, " +
                    COMMENTS + " TEXT, " +
                    ")";

    private static final String PNMCUR_CREATE =
            "CREATE TABLE" + TABLE_PNMCUR + " ("+
                    MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
        //            COUGH + " INTEGER, " +
                    COUGH_DAYS + " INTEGER, " +
        //            GASP + " INTEGER, " +
                    GASP_DAYS + " INTEGER, " +
        //            FEVER + " INTEGER, " +
                    FEVER_DAYS + " INTEGER, " +
         //           FIT + " INTEGER, " +
                    FIT_DAYS + " INTEGER, " +
          //          FAINT + " INTEGER, " +
                    FAINT_DAYS + " INTEGER, " +
                    MILK + " INTEGER, " +
                    MILK_DAYS + " INTEGER, " +
                    MILK_HOURS + " INTEGER, " +
         //           MEASLES + " INTEGER, " +
                    MEASLES_DAYS + " INTEGER, " +
         //           VOMIT + " INTEGER, " +
                    VOMIT_DAYS + " INTEGER, " +
                    BIRTH_MONTHS + " INTEGER, " +
                    CONSC + " INTEGER, " +
                    PULSE_RATE + " INTEGER, " +
                    CHEST + " INTEGER, " +
                    BREATH + " INTEGER, " +
                    WEAK + " INTEGER, " +
                    DEHYDRATE + " INTEGER, " +
                    MEASLES_COND + " INTEGER, " +
                    FEVER_COUNT + " INTEGER, " +
                    STRYDER + " INTEGER, " +
                    EXHALE + " INTEGER, " +
                    SHORT_BREATH + " INTEGER, " +
                    COMMENTS + " TEXT, " +
                    ")";

    public PNMDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PNM_CREATE);
        sqLiteDatabase.execSQL(PNMCUR_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PNM);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PNMCUR);
        onCreate(sqLiteDatabase);
    }
}
