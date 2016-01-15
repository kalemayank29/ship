package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by mayank on 1/15/16.
 */
public class StillBirthDB {
    public StillBirthDB()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String MOTHER_NAME = "mother_name" ; // EditText
        public static final String FATHER_NAME = "father_name" ; // EditText
        public static final String GENDER = "gender" ; // RadioButton
        public static final String PLACE_OF_DEATH = "place_of_death" ; // EditText
        public static final String VILLAGE_OF_CHILD = "village_of_child"; // EditText
        public static final String VILLAGE_OF_CHILD_ID = "village_of_child_id"; // EditText
        public static final String VILLAGE_OF_DEATH = "village_of_death" ; // EditText
        public static final String VILLAGE_OF_DEATH_ID = "village_of_death_id" ; // EditText
        public static final String OTHER_VILLAGE_OF_DEATH_ID = "other_village_of_death_id" ; // EditText
        public static final String HOUSE_ID = "house_id" ; // EditText
        public static final String FAMILY_ID = "family_id" ; // EditText
        public static final String BIRTH_DEATH_DATE = "birth_death_date" ; // DatePicker
        public static final String HOURS_ALIVE = "hours_alive" ; // EditText
        public static final String PREGNANCY_MONTHS = "pregnancy_months" ; // RadioButton
        public static final String PLACE_OF_BIRTH = "place_of_birth" ; // RadioButton
        public static final String BIRTHED_BY_WHOM = "birthed_by_whom" ; // RadioButton
        public static final String ALIVE = "alive" ; // RadioButton
        public static final String APPEARANCE = "appearance" ; // RadioButton
        public static final String HOW_CHILD_DIED = "how_child_died" ; // EditText
        public static final String DIAGNOSIS = "diagnosis" ; // EditText
        public static final String DIAGNOSIS_DATE = "diagnosis_date" ; // DatePicker
        public static final String DOCTOR_DIAGNOSIS = "doctor_diagnosis"; // EditText
        public static final String DOCTOR_DIAGNOSIS_DATE = "doctor_diagnosis_date" ; // DatePicker
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "StillBirth";
    }
}
