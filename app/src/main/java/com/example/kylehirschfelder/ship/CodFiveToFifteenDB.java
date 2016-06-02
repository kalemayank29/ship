package com.example.kylehirschfelder.ship;

import android.provider.BaseColumns;

/**
 * Created by mayank on 1/15/16.
 */
public class CodFiveToFifteenDB {
    public CodFiveToFifteenDB()
    {

    }



    public static abstract class TableInfo implements BaseColumns
    {
        public static final String FAMILY_HEAD_NAME = "family_head_name" ; // EditText
        public static final String FAMILY_HEAD_CODE = "family_head_code" ; // EditText
        public static final String DEATH_PERSON_NAME = "death_person_name" ; // RadioButton
        public static final String DEATH_PERSON_CODE = "death_person_code" ; // EditText
        public static final String DEATH_MOTHER_NAME = "death_mother_name"; // EditText
        public static final String DEATH_MOTHER_CODE = "death_mother_code"; // EditText
        public static final String ANSWERER_NAME = "answerer_name" ; // EditText
        public static final String ANSWERER_CODE = "answerer_code" ; // EditText
        public static final String ANSWERER_RELATION = "answerer_relation" ; // EditText
        public static final String ANSWERER_VICINITY = "answerer_vicinity" ; // EditText
        public static final String ANSWERER_AGE = "answerer_age" ; // EditText
        public static final String ANSWERER_GENDER = "answerer_gender" ; // DatePicker
        public static final String DEATH_AGE = "death_age" ; // EditText////
        public static final String DEATH_GENDER = "death_gender" ; // EditText////
        public static final String DEATH_FAMILY_HEAD_RELATION = "death_family_head_relation" ; // RadioButton
        public static final String DEATH_ADDRESS = "death_address" ; // RadioButton
        public static final String DEATH_DATE = "death_date" ; // RadioButton
        public static final String DEATH_PLACE = "death_place" ; // RadioButton
        public static final String DEATH_REASON = "death_reason" ; // RadioButton
        public static final String DEATH_ACCIDENT = "death_accident" ; // EditText
        public static final String DEATH_ACCIDENT_HOW = "death_accident_how" ; // EditText
        public static final String BIRTH_APPEARANCE = "birth_appearance" ; // DatePicker
        public static final String LESS_PREGNANCY_TIME = "less_pregnancy_time"; // EditText
        public static final String PREGNANCY_TIME = "pregnancy_time" ; // DatePicker
        public static final String BREAST_FEEDING = "breast_feeding" ; // DatePicker
        public static final String BREAST_FEEDING_HALT = "breast_feeding_halt" ; // DatePicker
        public static final String SICK_DAYS = "sick_days" ; // DatePicker
        public static final String FEVER = "fever" ; // DatePicker
        public static final String FEVER_DAYS = "fever_days" ; // DatePicker
        public static final String FEVER_SHIVER = "fever_shiver" ; // DatePicker
        public static final String FIT = "fit" ; // DatePicker
        public static final String FAINT = "faint" ; // DatePicker
        public static final String STIFFNISS = "stiffness" ; // DatePicker
        public static final String NECK_STIFFNESS = "neck_stiffness" ; // DatePicker
        public static final String DIARRHEA = "diarrhea" ; // DatePicker
        public static final String DIARRHEA_DAYS = "diarrhea_days" ; // DatePicker
        public static final String STOOL_BLOOD = "stool_blood" ; // DatePicker
        public static final String LIQUID = "liquid" ; // DatePicker
        public static final String COUGH = "cough" ; // DatePicker
        public static final String COUGH_DAYS = "cough_days" ; // DatePicker
        public static final String COUGH_HOW = "cough_how" ; // DatePicker
        public static final String BREATH_PROBLEM = "breath_problem" ; // DatePicker
        public static final String BREATH_PROBLEM_DAYS = "breath_problem_days" ; // DatePicker
        public static final String BREATH_SPEED = "breath_speed" ; // DatePicker
        public static final String MUCUS = "mucus" ; // DatePicker
        public static final String BREATH_WHISTLE = "breath_whistle" ; // DatePicker
        public static final String ANTIBIOTICS = "antibiotics" ; // RadioButton
        public static final String STOMACH_ACHE = "stomach_ache" ; // RadioButton
        public static final String STOMACH_ACHE_WHERE = "stomach_ache_where" ; // EditText
        public static final String STOMACH_BLOAT = "stomach_bloat" ; // EditText
        public static final String VOMIT = "vomit" ; // DatePicker
        public static final String VOMIT_DAYS = "vomit_days"; // EditText
        public static final String EYES_YELLOW = "eyes_yellow" ; // DatePicker
        public static final String SKIN_RASH = "skin_rash" ; // DatePicker
        public static final String RASH_WHERE = "rash_where" ; // DatePicker
        public static final String RASH_MEASLES = "rash_measles" ; // DatePicker
        public static final String SICKLY_APPEARANCE = "sickly_appearance" ; // DatePicker
        public static final String YELLOW_APPEARANCE = "yellow_appearance" ; // DatePicker
        public static final String FREQUENTLY_SICK = "frequently_sick" ; // DatePicker
        public static final String SICK_TIMES = "sick_times" ; // DatePicker
        public static final String SYMPTOMS_ACCOMPANIED = "symptoms_accompanied" ; // DatePicker
        public static final String CHANGE = "change" ; // DatePicker
        public static final String BCG = "bcg" ; // DatePicker
        public static final String POLIO_DOSE = "polio_dose" ; // DatePicker
        public static final String MEASLES_INJECTION = "measles_injection" ; // DatePicker
        public static final String WRITTEN_DESCRIPTION = "measles_description" ; // DatePicker
        public static final String ANSWERER_QUALITY = "answerer_quality" ; // DatePicker
        public static final String INTERVIEWER_NAME = "interviewer_name" ; // DatePicker
        public static final String DATE = "date" ; // DatePicker
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "CodFiveToFifteen";
    }
}
