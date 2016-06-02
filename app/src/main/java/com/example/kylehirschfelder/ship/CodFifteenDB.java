package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by poorwa on 14/1/16.
 */
public class CodFifteenDB {
    public CodFifteenDB()
    {

    }



    public static abstract class TableInfo implements BaseColumns {
        public static final String FAMILY_HEAD_NAME = "family_head_name"; // EditText
        public static final String VILLAGE_NAME = "village_name"; // EditText
        public static final String HOUSE_ID = "house_id"; // RadioButton
        public static final String FAMILY_ID = "family_id"; // EditText
        public static final String DEATH_NAME = "death_name"; // EditText
        public static final String FORM_DATE = "form_date"; // EditText
        public static final String INFORMANT_NAME = "informant_name"; // EditText
        public static final String INFORMANT_RELATION = "informant_relation"; // EditText
        public static final String INFORMANT_VICINITY = "informant_vicinity"; // EditText
        public static final String INFORMANT_AGE = "informant_age"; // EditText
        public static final String INFORMANT_GENDER = "informant_gender"; // EditText
        public static final String DEATH_AGE = "death_age"; // DatePicker
        public static final String DEATH_GENDER = "death_gender"; // EditText////
        public static final String MARRIAGE_STATUS = "marriage_status";
        public static final String WORK_OUTSIDE = "work_outside"; // RadioButton
        public static final String WORK_OUTSIDE_TIME = "work_outside_time"; // RadioButton
        public static final String EDUCATION = "education"; // RadioButton
        public static final String DEATH_FAMILY_HEAD_RELATION = "death_family_head_relation"; // RadioButton
        public static final String DEATH_DATE = "death_date"; // EditText
        public static final String DEATH_PLACE = "death_place"; // EditText
        public static final String DEATH_ADDRESS = "death_address"; // RadioButton
        public static final String DEATH_ADDRESS_TIME = "death_address_time";
        public static final String INFORMANT_DIAGNOSIS = "informant_diagnosis";
        public static final String BLOOD_PRESSURE = "blood_pressure"; // DatePicker
        public static final String HEART_PROBLEM = "heart_problem"; // EditText
        public static final String PARALYSIS = "paralysis"; // DatePicker
        public static final String DIABETES = "diabetes"; // DatePicker
        public static final String TYPHOID = "typhoid"; // DatePicker
        public static final String AIDS = "aids"; // DatePicker
        public static final String CANCER = "cancer"; // DatePicker
        public static final String ASTHMA = "asthma"; // DatePicker
        public static final String OTHER_ILLNESS = "other_illness"; // DatePicker
        public static final String EXTREME_WEIGHT_LOSS = "extreme_weight_loss"; // DatePicker
        public static final String ROUTINE_MEDICINE = "routine_medicine"; // DatePicker
        public static final String DEATH_SMOKING = "death_smoking"; // DatePicker
        public static final String INFORMANT_SMOKING = "informant_smoking"; // DatePicker
        public static final String DEATH_SMOKING_DAYS = "death_smoking_days"; // DatePicker
        public static final String DEATH_HOOKAH = "death_hookah"; // DatePicker
        public static final String INFORMANT_HOOKAH = "informant_hookah"; // DatePicker
        public static final String DEATH_TOBACCO = "death_tobacco"; // DatePicker
        public static final String INFORMANT_TOBACCO = "informant_tobacco"; // DatePicker
        public static final String DEATH_BRUSH_TEETH = "death_brush_teeth"; // DatePicker
        public static final String INFORMANT_BRUSH_TEETH = "informant_brush_teeth"; // DatePicker
        public static final String DEATH_ALCOHOL = "death_alcohol"; // DatePicker
        public static final String INFORMANT_ALCOHOL = "informant_alcohol"; // DatePicker
        public static final String DEATH_ALCOHOL_DAYS = "death_alcohol_days"; // DatePicker
        public static final String DEATH_NON_VEG = "death_non_veg"; // DatePicker
        public static final String INFORMANT_NON_VEG = "informant_non_veg"; // DatePicker
        public static final String DEATH_PREGNANT = "death_pregnant"; // DatePicker
        public static final String DEATH_42_BIRTH = "death_42_birth"; // DatePicker
        public static final String DEATH_42_PREGNANT = "death_42_pregnant"; // RadioButton
        public static final String INFORMANT_DETAILS = "informant_details"; // DatePicker
        public static final String INFORMANT_QUALITY = "informant_quality"; // RadioButton
        public static final String SUPERVISOR_NAME = "supervisor_name"; // EditText
        public static final String DATE = "date"; // EditText
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "CodFifteen";
    }
}
