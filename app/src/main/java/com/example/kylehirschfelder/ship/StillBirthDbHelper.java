package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mayank on 1/15/16.
 */
public class StillBirthDbHelper extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ StillBirthDB.TableInfo.TABLE_NAME+
            "( " + StillBirthDB.TableInfo.MOTHER_NAME + " TEXT, " +
            StillBirthDB.TableInfo.FATHER_NAME + " TEXT, " +
            StillBirthDB.TableInfo.GENDER + " TEXT, " +
            StillBirthDB.TableInfo.PLACE_OF_DEATH + " TEXT, " +
            StillBirthDB.TableInfo.VILLAGE_OF_CHILD + " TEXT, " +
            StillBirthDB.TableInfo.VILLAGE_OF_CHILD_ID + " TEXT, " +
            StillBirthDB.TableInfo.VILLAGE_OF_DEATH + " TEXT, " +
            StillBirthDB.TableInfo.VILLAGE_OF_DEATH_ID + " TEXT, " +
            StillBirthDB.TableInfo.OTHER_VILLAGE_OF_DEATH_ID + " TEXT, " +
            StillBirthDB.TableInfo.HOUSE_ID + " TEXT, " +
            StillBirthDB.TableInfo.FAMILY_ID + " TEXT, " +
            StillBirthDB.TableInfo.BIRTH_DEATH_DATE + " TEXT, " +
            StillBirthDB.TableInfo.HOURS_ALIVE + " TEXT, " +
            StillBirthDB.TableInfo.PREGNANCY_MONTHS + " TEXT, " +
            StillBirthDB.TableInfo.PLACE_OF_BIRTH + " TEXT, " +
            StillBirthDB.TableInfo.BIRTHED_BY_WHOM + " TEXT, " +
            StillBirthDB.TableInfo.ALIVE + " TEXT, " +
            StillBirthDB.TableInfo.APPEARANCE + " TEXT, " +
            StillBirthDB.TableInfo.HOW_CHILD_DIED + " TEXT, " +
            StillBirthDB.TableInfo.DIAGNOSIS + " TEXT, " +
            StillBirthDB.TableInfo.DIAGNOSIS_DATE + " TEXT, " +
            StillBirthDB.TableInfo.DOCTOR_DIAGNOSIS + " TEXT, " +
            StillBirthDB.TableInfo.DOCTOR_DIAGNOSIS_DATE + " TEXT" + ")";

    public StillBirthDbHelper(Context context) {
        super(context, StillBirthDB.TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2) {
        // TODO Auto-generated method stub
        sdb.execSQL("DROP TABLE IF EXISTS " + StillBirthDB.TableInfo.TABLE_NAME);
        onCreate(sdb);


    }

    public void insert(StillBirth stillBirth) {



        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(StillBirthDB.TableInfo.MOTHER_NAME, stillBirth.getMother());
        cv.put(StillBirthDB.TableInfo.FATHER_NAME, stillBirth.getFather());
        cv.put(StillBirthDB.TableInfo.GENDER, stillBirth.getGender());
        cv.put(StillBirthDB.TableInfo.PLACE_OF_DEATH, stillBirth.getDeath());
        cv.put(StillBirthDB.TableInfo.VILLAGE_OF_CHILD, stillBirth.getChildVillage());
        cv.put(StillBirthDB.TableInfo.VILLAGE_OF_CHILD_ID, stillBirth.getChildVillageId());
        cv.put(StillBirthDB.TableInfo.VILLAGE_OF_DEATH, stillBirth.getDeathVillage());
        cv.put(StillBirthDB.TableInfo.VILLAGE_OF_DEATH_ID, stillBirth.getDeathVillageId());
        cv.put(StillBirthDB.TableInfo.OTHER_VILLAGE_OF_DEATH_ID, stillBirth.getOtherDeathVillage());
        cv.put(StillBirthDB.TableInfo.HOUSE_ID, stillBirth.getHouseId());
        cv.put(StillBirthDB.TableInfo.FAMILY_ID, stillBirth.getFamilyId());
        cv.put(StillBirthDB.TableInfo.BIRTH_DEATH_DATE, stillBirth.getBirthDeathDate());
        cv.put(StillBirthDB.TableInfo.HOURS_ALIVE, stillBirth.getHoursAlive());
        cv.put(StillBirthDB.TableInfo.PREGNANCY_MONTHS, stillBirth.getPregnancyMonths());
        cv.put(StillBirthDB.TableInfo.PLACE_OF_BIRTH, stillBirth.getBirthPlace());
        cv.put(StillBirthDB.TableInfo.BIRTHED_BY_WHOM, stillBirth.getBirthWhom());
        cv.put(StillBirthDB.TableInfo.ALIVE, stillBirth.getAlive());
        cv.put(StillBirthDB.TableInfo.APPEARANCE, stillBirth.getAppearance());
        cv.put(StillBirthDB.TableInfo.HOW_CHILD_DIED, stillBirth.getHowChildDied());
        cv.put(StillBirthDB.TableInfo.DIAGNOSIS, stillBirth.getDiagnosis());
        cv.put(StillBirthDB.TableInfo.DIAGNOSIS_DATE, stillBirth.getDiagnosisDate());
        cv.put(StillBirthDB.TableInfo.DOCTOR_DIAGNOSIS, stillBirth.getDoctorDiagnosis());
        cv.put(StillBirthDB.TableInfo.DOCTOR_DIAGNOSIS_DATE, stillBirth.getDoctorDiagnosisDate());

        long z = SQ.insert(StillBirthDB.TableInfo.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
    }



    public StillBirth getInfo(String birthDeathDate){

        StillBirth stillBirth = new StillBirth();
        SQLiteDatabase SQ = this.getReadableDatabase();
        Cursor c = null;
        c = SQ.rawQuery("SELECT * FROM " + StillBirthDB.TableInfo.TABLE_NAME + " WHERE " + StillBirthDB.TableInfo.BIRTH_DEATH_DATE + " LIKE '" + birthDeathDate + "'", null);
        c.moveToFirst();
        int i = 0;

        while(i < 23) {
            Log.println(Log.ASSERT, "C", c.getString(i++));
        }
        i = 0;
        stillBirth.setMother(c.getString(i++));
        stillBirth.setFather(c.getString(i++));
        stillBirth.setGender(c.getString(i++));
        stillBirth.setDeath(c.getString(i++));
        stillBirth.setChildVillage(c.getString(i++));
        stillBirth.setChildVillageId(c.getString(i++));
        stillBirth.setDeathVillage(c.getString(i++));
        stillBirth.setDeathVillageId(c.getString(i++));
        stillBirth.setOtherDeathVillage(c.getString(i++));
        stillBirth.setHouseId(c.getString(i++));
        stillBirth.setFamilyId(c.getString(i++));
        stillBirth.setBirthDeathDate(c.getString(i++));
        stillBirth.setHoursAlive(c.getString(i++));
        stillBirth.setPregnancyMonths(c.getString(i++));
        stillBirth.setBirthPlace(c.getString(i++));
        stillBirth.setBirthWhom(c.getString(i++));
        stillBirth.setAlive(c.getString(i++));
        stillBirth.setAppearance(c.getString(i++));
        stillBirth.setHowChildDied(c.getString(i++));
        stillBirth.setDiagnosis(c.getString(i++));
        stillBirth.setDiagnosisDate(c.getString(i++));
        stillBirth.setDoctorDiagnosis(c.getString(i++));
        stillBirth.setDoctorDiagnosisDate(c.getString(i++));

        /*
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
         */

        return stillBirth;

    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM StillBirth;", null);
    }
    /*

    public List<StillBirth> getAll(){
        List<StillBirth> stillBirthList = new ArrayList<StillBirth>();
        SQLiteDatabase SQ = this.getReadableDatabase();

        Cursor c;
        c = SQ.rawQuery("SELECT * FROM " + StillBirthDB.TableInfo.TABLE_NAME , null);

        if(c.moveToFirst()){
            do{
                StillBirth stillBirth = new StillBirth();

                stillBirth.setMotherVillage(c.getString(0));
                stillBirth.setChildID(c.getString(1));
                stillBirth.setMotherVillageID(c.getString(2));
                stillBirth.setMotherName(c.getString(3));
                stillBirth.setFamilyID(c.getString(4));
                stillBirth.setHouseID(c.getString(5));
                stillBirth.setMemberId(c.getString(6));
                stillBirth.setBirthDate(c.getString(7));
                stillBirth.setVillageOfBirth(c.getString(8));
                stillBirth.setVillageOfBirthID(c.getString(9));
                stillBirth.setVillageOfBirthPlace(c.getString(10));
                stillBirth.setDeliveryName(c.getString(11));
                stillBirth.setDeliveryMethod(c.getString(12));
                stillBirth.setChildGender(c.getString(13));
                stillBirth.setPregnancyTime(c.getString(14));
                stillBirth.setFadPresence(c.getString(15));
                stillBirth.setHealthMessenger(c.getString(16));
                stillBirth.setHealthMessengerId(c.getString(17));
                stillBirth.setHealthMessengerDate(c.getString(18));
                stillBirth.setGuideName(c.getString(19));
                stillBirth.setGuideId(c.getString(20));
                stillBirth.setGuideTestDate(c.getString(21));
                stillBirthList.add(stillBirth);

            }
            while(c.moveToNext());
        }


        return stillBirthList;

    } */
}
