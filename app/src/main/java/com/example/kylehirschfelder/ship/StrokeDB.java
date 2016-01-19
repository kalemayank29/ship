package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by Nandans on 17-Jan-16.
 */
public class StrokeDB {




    public StrokeDB()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String STROKE_ID = "_id" ;//2spinners
        public static final String FAMILY_ID = "family_id" ;//tv
        public static final String INF_ID = "inf_id" ;//tv
        public static final String ARM = "arm" ;//tv
        public static final String SIDE  = "side" ;//
        public static final String FACE = "face" ;
        public static final String TALK = "talk" ;
        public static final String PART = "part" ;//dp
        public static final String SUDDEN = "sudden" ;//2 spinners
        public static final String HOURS = "hours" ;//tv
        public static final String CANCER = "cancer" ;//rb
        public static final String TUMOR = "tumor" ;//et
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "StrokeData";
    }

}

