package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by poorwa on 14/1/16.
 */





public class CodFifteenDBHelper extends SQLiteOpenHelper {
        public static final int database_version = 1;
        public String CREATE_QUERY = "CREATE TABLE "+ CodFifteenDB.TableInfo.TABLE_NAME+
                "( " + CodFifteenDB.TableInfo.FAMILY_HEAD_NAME + " TEXT, " +
                CodFifteenDB.TableInfo.VILLAGE_NAME + " TEXT, " +
                CodFifteenDB.TableInfo.HOUSE_ID + " TEXT, " +
                CodFifteenDB.TableInfo.FAMILY_ID + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_NAME + " TEXT, " +
                CodFifteenDB.TableInfo.FORM_DATE + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_NAME + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_RELATION + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_VICINITY + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_AGE + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_GENDER + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_AGE + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_GENDER + " TEXT, " +
                CodFifteenDB.TableInfo.MARRIAGE_STATUS + " TEXT, " +
                CodFifteenDB.TableInfo.WORK_OUTSIDE + " TEXT, " +
                CodFifteenDB.TableInfo.WORK_OUTSIDE_TIME + " TEXT, " +
                CodFifteenDB.TableInfo.EDUCATION + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_FAMILY_HEAD_RELATION + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_DATE + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_PLACE + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_ADDRESS + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_ADDRESS_TIME + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_DIAGNOSIS + " TEXT, " +
                CodFifteenDB.TableInfo.BLOOD_PRESSURE + " TEXT, " +
                CodFifteenDB.TableInfo.HEART_PROBLEM + " TEXT, " +
                CodFifteenDB.TableInfo.PARALYSIS + " TEXT, " +
                CodFifteenDB.TableInfo.DIABETES + " TEXT, " +
                CodFifteenDB.TableInfo.TYPHOID + " TEXT, " +
                CodFifteenDB.TableInfo.AIDS + " TEXT, " +
                CodFifteenDB.TableInfo.CANCER + " TEXT, " +
                CodFifteenDB.TableInfo.ASTHMA + " TEXT, " +
                CodFifteenDB.TableInfo.OTHER_ILLNESS + " TEXT, " +
                CodFifteenDB.TableInfo.EXTREME_WEIGHT_LOSS + " TEXT, " +
                CodFifteenDB.TableInfo.ROUTINE_MEDICINE + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_SMOKING + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_SMOKING + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_SMOKING_DAYS + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_HOOKAH + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_HOOKAH + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_TOBACCO + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_TOBACCO + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_BRUSH_TEETH + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_BRUSH_TEETH + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_ALCOHOL + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_ALCOHOL + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_ALCOHOL_DAYS + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_NON_VEG + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_NON_VEG + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_PREGNANT + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_42_BIRTH + " TEXT, " +
                CodFifteenDB.TableInfo.DEATH_42_PREGNANT + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_DETAILS + " TEXT, " +
                CodFifteenDB.TableInfo.INFORMANT_QUALITY + " TEXT, " +
                CodFifteenDB.TableInfo.SUPERVISOR_NAME + " TEXT, " +
                CodFifteenDB.TableInfo.DATE + " TEXT" + ")";

        public CodFifteenDBHelper(Context context) {
        super(context, CodFifteenDB.TableInfo.DATABASE_NAME, null, database_version);
    }

        @Override
        public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
    }

        @Override
        public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2) {
        // TODO Auto-generated method stub
        sdb.execSQL("DROP TABLE IF EXISTS " + CodFifteenDB.TableInfo.TABLE_NAME);
        onCreate(sdb);


    }

    public void insert(CodFifteen cod15) {

        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CodFifteenDB.TableInfo.FAMILY_HEAD_NAME, cod15.getFamilyHeadName());
        cv.put(CodFifteenDB.TableInfo.VILLAGE_NAME, cod15.getVillageName());
        cv.put(CodFifteenDB.TableInfo.HOUSE_ID, cod15.getHouseId());
        cv.put(CodFifteenDB.TableInfo.FAMILY_ID, cod15.getFamilyId());
        cv.put(CodFifteenDB.TableInfo.DEATH_NAME, cod15.getDeathName());
        cv.put(CodFifteenDB.TableInfo.FORM_DATE, cod15.getFormDate());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_NAME, cod15.getInformantName());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_RELATION, cod15.getInformantRelation());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_VICINITY, cod15.getInformantVicinity());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_AGE, cod15.getInformantAge());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_GENDER, cod15.getInformantGender());
        cv.put(CodFifteenDB.TableInfo.DEATH_AGE, cod15.getDeathAge());
        cv.put(CodFifteenDB.TableInfo.DEATH_GENDER, cod15.getDeathGender());
        cv.put(CodFifteenDB.TableInfo.MARRIAGE_STATUS, cod15.getMarriageStatus());
        cv.put(CodFifteenDB.TableInfo.WORK_OUTSIDE, cod15.getWorkOutside());
        cv.put(CodFifteenDB.TableInfo.WORK_OUTSIDE_TIME, cod15.getWorkOutsideTime());
        cv.put(CodFifteenDB.TableInfo.EDUCATION, cod15.getEducation());
        cv.put(CodFifteenDB.TableInfo.DEATH_FAMILY_HEAD_RELATION, cod15.getDeathFamilyHeadRelation());
        cv.put(CodFifteenDB.TableInfo.DEATH_DATE, cod15.getDeathDate());
        cv.put(CodFifteenDB.TableInfo.DEATH_PLACE, cod15.getDeathPlace());
        cv.put(CodFifteenDB.TableInfo.DEATH_ADDRESS, cod15.getDeathAddress());
        cv.put(CodFifteenDB.TableInfo.DEATH_ADDRESS_TIME, cod15.getDeathAddressTime());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_DIAGNOSIS, cod15.getInformantDiagnosis());
        cv.put(CodFifteenDB.TableInfo.BLOOD_PRESSURE, cod15.getBloodPressure());
        cv.put(CodFifteenDB.TableInfo.HEART_PROBLEM, cod15.getHeartProblem());
        cv.put(CodFifteenDB.TableInfo.PARALYSIS, cod15.getParalysis());
        cv.put(CodFifteenDB.TableInfo.DIABETES, cod15.getDiabetes());
        cv.put(CodFifteenDB.TableInfo.TYPHOID, cod15.getTyphoid());
        cv.put(CodFifteenDB.TableInfo.AIDS, cod15.getAIDS());
        cv.put(CodFifteenDB.TableInfo.CANCER, cod15.getCancer());
        cv.put(CodFifteenDB.TableInfo.ASTHMA, cod15.getAsthma());
        cv.put(CodFifteenDB.TableInfo.OTHER_ILLNESS, cod15.getOtherIllness());
        cv.put(CodFifteenDB.TableInfo.EXTREME_WEIGHT_LOSS, cod15.getExtremeWeightLoss());
        cv.put(CodFifteenDB.TableInfo.ROUTINE_MEDICINE, cod15.getRoutineMedicine());
        cv.put(CodFifteenDB.TableInfo.DEATH_SMOKING, cod15.getDeathSmoking());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_SMOKING, cod15.getInformantSmoking());
        cv.put(CodFifteenDB.TableInfo.DEATH_SMOKING_DAYS, cod15.getDeathSmokingDays());
        cv.put(CodFifteenDB.TableInfo.DEATH_HOOKAH, cod15.getDeathHookah());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_HOOKAH, cod15.getInformantHookah());
        cv.put(CodFifteenDB.TableInfo.DEATH_TOBACCO, cod15.getDeathTobacco());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_TOBACCO, cod15.getInformantTobacco());
        cv.put(CodFifteenDB.TableInfo.DEATH_BRUSH_TEETH, cod15.getDeathBrushTeeth());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_BRUSH_TEETH, cod15.getInformantBrushTeeth());
        cv.put(CodFifteenDB.TableInfo.DEATH_ALCOHOL, cod15.getDeathAlcohol());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_ALCOHOL, cod15.getInformantAlcohol());
        cv.put(CodFifteenDB.TableInfo.DEATH_ALCOHOL_DAYS, cod15.getDeathAlcoholDays());
        cv.put(CodFifteenDB.TableInfo.DEATH_NON_VEG, cod15.getDeathNonVeg());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_NON_VEG, cod15.getInformantNonVeg());
        cv.put(CodFifteenDB.TableInfo.DEATH_PREGNANT, cod15.getDeathPregnant());
        cv.put(CodFifteenDB.TableInfo.DEATH_42_BIRTH, cod15.getDeath42Birth());
        cv.put(CodFifteenDB.TableInfo.DEATH_42_PREGNANT, cod15.getDeath42Pregnant());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_DETAILS, cod15.getInformantDetails());
        cv.put(CodFifteenDB.TableInfo.INFORMANT_QUALITY, cod15.getInformantQuality());
        cv.put(CodFifteenDB.TableInfo.SUPERVISOR_NAME, cod15.getSupervisorName());
        cv.put(CodFifteenDB.TableInfo.DATE, cod15.getDate());

        long z = SQ.insert(CodFifteenDB.TableInfo.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
    }



    public CodFifteen getInfo(String familyId){

        CodFifteen cod15 = new CodFifteen();
        SQLiteDatabase SQ = this.getWritableDatabase();
        Cursor c = null;
        c = SQ.rawQuery("SELECT * FROM " + CodFifteenDB.TableInfo.TABLE_NAME + " WHERE " + CodFifteenDB.TableInfo.FAMILY_ID + " = '" + familyId + "' ", null);
        c.moveToFirst();
        int i = 0;
        cod15.setFamilyHeadName(c.getString(i++));
        cod15.setVillageName(c.getString(i++));
        cod15.setHouseId(c.getString(i++));
        cod15.setFamilyId(c.getString(i++));
        cod15.setDeathName(c.getString(i++));
        cod15.setFormDate(c.getString(i++));
        cod15.setInformantName(c.getString(i++));
        cod15.setInformantRelation(c.getString(i++));
        cod15.setInformantVicinity(c.getString(i++));
        cod15.setInformantAge(c.getString(i++));
        cod15.setInformantGender(c.getString(i++));
        cod15.setDeathAge(c.getString(i++));
        cod15.setDeathGender(c.getString(i++));
        cod15.setMarriageStatus(c.getString(i++));
        cod15.setWorkOutside(c.getString(i++));
        cod15.setWorkOutsideTime(c.getString(i++));
        cod15.setEducation(c.getString(i++));
        cod15.setDeathFamilyHeadRelation(c.getString(i++));
        cod15.setDeathDate(c.getString(i++));
        cod15.setDeathPlace(c.getString(i++));
        cod15.setDeathAddress(c.getString(i++));
        cod15.setDeathAddressTime(c.getString(i++));
        cod15.setInformantDiagnosis(c.getString(i++));
        cod15.setBloodPressure(c.getString(i++));
        cod15.setHeartProblem(c.getString(i++));
        cod15.setParalysis(c.getString(i++));
        cod15.setDiabetes(c.getString(i++));
        cod15.setTyphoid(c.getString(i++));
        cod15.setAIDS(c.getString(i++));
        cod15.setCancer(c.getString(i++));
        cod15.setAsthma(c.getString(i++));
        cod15.setOtherIllness(c.getString(i++));
        cod15.setExtremeWeightLoss(c.getString(i++));
        cod15.setRoutineMedicine(c.getString(i++));
        cod15.setDeathSmoking(c.getString(i++));
        cod15.setInformantSmoking(c.getString(i++));
        cod15.setDeathSmokingDays(c.getString(i++));
        cod15.setDeathHookah(c.getString(i++));
        cod15.setInformantHookah(c.getString(i++));
        cod15.setDeathTobacco(c.getString(i++));
        cod15.setInformantTobacco(c.getString(i++));
        cod15.setDeathBrushTeeth(c.getString(i++));
        cod15.setInformantBrushTeeth(c.getString(i++));
        cod15.setDeathAlcohol(c.getString(i++));
        cod15.setInformantAlcohol(c.getString(i++));
        cod15.setDeathAlcoholDays(c.getString(i++));
        cod15.setDeathNonVeg(c.getString(i++));
        cod15.setInformantNonVeg(c.getString(i++));
        cod15.setDeathPregnant(c.getString(i++));
        cod15.setDeath42Birth(c.getString(i++));
        cod15.setDeath42Pregnant(c.getString(i++));
        cod15.setInformantDetails(c.getString(i++));
        cod15.setInformantQuality(c.getString(i++));
        cod15.setSupervisorName(c.getString(i++));
        cod15.setDate(c.getString(i++));

        return cod15;

    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM CodFifteen;", null);
    }
}


