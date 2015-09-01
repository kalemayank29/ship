package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by mayank on 8/7/15.
 */
public class CF_TableData {

    public CF_TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String DATABASE_NAME = "newDatabase";
        public static final String TABLE_NAME = "censusF";
        public static final String TABLE_S_NAME = "censusS";

        public static final String HOUSE_ID = "_id";
        public static final String CASTE= "caste";
        public static final String RELIGION = "religion";
        public static final String P_BUSINESS = "p_business";
        public static final String A_BUSINESS_1 = "a_bus_1";
        public static final String A_BUSINESS_2= "a_bus_2";
        public static final String A_BUSINESS_3 = "a_bus_3";
        public static final String DRY_LAND_A = "dry_land_a";
        //public static final String DRY_LAND_G = "dry_land_g";
        public static final String WET_LAND_A = "wet_land_a";
        //public static final String WET_LAND_G = "wet_land_g";
        public static final String WALL = "wall";
        public static final String ROOF = "roof";
        public static final String ELECTRICITY = "electricity";
        public static final String HOUSE_OWNER = "house";
        public static final String TOILET = "toilet";
        public static final String TOILET_USE = "toilet_use";
        public static final String COOKING = "cooking";
        public static final String KITCHEN = "kitchen";
        public static final String WATER = "water";
        public static final String THING = "thing";
        public static final String ANIMALS = "animals";
        public static final String DATE = "date";
        public static final String OLD_HOUSE_ID = "old_house";
        public static final String FLAG = "flag";
    }

}