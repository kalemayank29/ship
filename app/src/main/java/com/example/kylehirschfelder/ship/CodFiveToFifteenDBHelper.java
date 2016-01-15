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
public class CodFiveToFifteenDBHelper extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ CodFiveToFifteenDB.TableInfo.TABLE_NAME+
            "( " + CodFiveToFifteenDB.TableInfo.FAMILY_HEAD_NAME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FAMILY_HEAD_CODE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_PERSON_NAME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_PERSON_CODE + " INTEGER PRIMARY KEY, " +
            CodFiveToFifteenDB.TableInfo.DEATH_MOTHER_NAME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_MOTHER_CODE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_NAME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_CODE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_RELATION + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_VICINITY + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_AGE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANSWERER_GENDER + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_AGE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_GENDER + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_FAMILY_HEAD_RELATION + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_ADDRESS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_DATE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_PLACE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_REASON + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_ACCIDENT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DEATH_ACCIDENT_HOW + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BIRTH_APPEARANCE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.LESS_PREGNANCY_TIME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.PREGNANCY_TIME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREAST_FEEDING + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREAST_FEEDING_HALT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.SICK_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FEVER + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FEVER_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FEVER_SHIVER + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FIT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FAINT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.STIFFNISS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.NECK_STIFFNESS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DIARRHEA + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DIARRHEA_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.STOOL_BLOOD + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.LIQUID + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.COUGH + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.COUGH_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.COUGH_HOW + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREATH_PROBLEM + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREATH_PROBLEM_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREATH_SPEED + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.MUCUS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BREATH_WHISTLE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.ANTIBIOTICS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.STOMACH_ACHE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.STOMACH_ACHE_WHERE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.STOMACH_BLOAT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.VOMIT + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.VOMIT_DAYS + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.EYES_YELLOW + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.SKIN_RASH + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.RASH_WHERE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.RASH_MEASLES + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.SICKLY_APPEARANCE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.YELLOW_APPEARANCE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.FREQUENTLY_SICK + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.SICK_TIMES + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.SYMPTOMS_ACCOMPANIED + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.CHANGE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.BCG + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.POLIO_DOSE + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.MEASLES_INJECTION + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.WRITTEN_DESCRIPTION + " TEXT, " + CodFiveToFifteenDB.TableInfo.ANSWERER_QUALITY + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.INTERVIEWER_NAME + " TEXT, " +
            CodFiveToFifteenDB.TableInfo.DATE + " TEXT" + ")";

    public CodFiveToFifteenDBHelper(Context context) {
        super(context, CodFiveToFifteenDB.TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2) {
        // TODO Auto-generated method stub
        sdb.execSQL("DROP TABLE IF EXISTS " + CodFiveToFifteenDB.TableInfo.TABLE_NAME);
        onCreate(sdb);


    }

    public void insert(CodFiveToFifteen cod5to15) {

        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CodFiveToFifteenDB.TableInfo.FAMILY_HEAD_NAME, cod5to15.getFamilyHeadName());
        cv.put(CodFiveToFifteenDB.TableInfo.FAMILY_HEAD_CODE, cod5to15.getFamilyHeadCode());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_PERSON_NAME, cod5to15.getDeathPersonName());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_PERSON_CODE, cod5to15.getDeathPersonCode());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_MOTHER_NAME, cod5to15.getDeathMotherName());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_MOTHER_CODE, cod5to15.getDeathMotherCode());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_NAME, cod5to15.getAnswererName());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_CODE, cod5to15.getAnswererCode());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_RELATION, cod5to15.getAnswererRelation());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_VICINITY, cod5to15.getAnswererVicinity());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_AGE, cod5to15.getAnswererAge());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_GENDER, cod5to15.getAnswererGender());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_AGE, cod5to15.getDeathAge());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_GENDER, cod5to15.getDeathGender());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_FAMILY_HEAD_RELATION, cod5to15.getDeathFamilyHeadRelation());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_ADDRESS, cod5to15.getDeathAddress());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_DATE, cod5to15.getDeathDate());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_PLACE, cod5to15.getDeathPlace());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_REASON, cod5to15.getDeathReason());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_ACCIDENT, cod5to15.getDeathAccident());
        cv.put(CodFiveToFifteenDB.TableInfo.DEATH_ACCIDENT_HOW, cod5to15.getDeathAccidentHow());
        cv.put(CodFiveToFifteenDB.TableInfo.BIRTH_APPEARANCE, cod5to15.getBirthAppearance());
        cv.put(CodFiveToFifteenDB.TableInfo.LESS_PREGNANCY_TIME, cod5to15.getLessPregnancyTime());
        cv.put(CodFiveToFifteenDB.TableInfo.PREGNANCY_TIME, cod5to15.getPregnancyTime());
        cv.put(CodFiveToFifteenDB.TableInfo.BREAST_FEEDING, cod5to15.getBreastFeeding());
        cv.put(CodFiveToFifteenDB.TableInfo.BREAST_FEEDING_HALT, cod5to15.getBreastFeedingHalt());
        cv.put(CodFiveToFifteenDB.TableInfo.SICK_DAYS, cod5to15.getSickDays());
        cv.put(CodFiveToFifteenDB.TableInfo.FEVER, cod5to15.getFever());
        cv.put(CodFiveToFifteenDB.TableInfo.FEVER_DAYS, cod5to15.getFeverDays());
        cv.put(CodFiveToFifteenDB.TableInfo.FEVER_SHIVER, cod5to15.getFeverShiver());
        cv.put(CodFiveToFifteenDB.TableInfo.FIT, cod5to15.getFit());
        cv.put(CodFiveToFifteenDB.TableInfo.FAINT, cod5to15.getFaint());
        cv.put(CodFiveToFifteenDB.TableInfo.STIFFNISS, cod5to15.getStiffness());
        cv.put(CodFiveToFifteenDB.TableInfo.NECK_STIFFNESS, cod5to15.getNeckStiffness());
        cv.put(CodFiveToFifteenDB.TableInfo.DIARRHEA, cod5to15.getDiarrhea());
        cv.put(CodFiveToFifteenDB.TableInfo.DIARRHEA_DAYS, cod5to15.getDiarrheaDays());
        cv.put(CodFiveToFifteenDB.TableInfo.STOOL_BLOOD, cod5to15.getStoolBlood());
        cv.put(CodFiveToFifteenDB.TableInfo.LIQUID, cod5to15.getLiquid());
        cv.put(CodFiveToFifteenDB.TableInfo.COUGH, cod5to15.getCough());
        cv.put(CodFiveToFifteenDB.TableInfo.COUGH_DAYS, cod5to15.getCoughDays());
        cv.put(CodFiveToFifteenDB.TableInfo.COUGH_HOW, cod5to15.getCoughHow());
        cv.put(CodFiveToFifteenDB.TableInfo.BREATH_PROBLEM, cod5to15.getBreathProblem());
        cv.put(CodFiveToFifteenDB.TableInfo.BREATH_PROBLEM_DAYS, cod5to15.getBreathProblemDays());
        cv.put(CodFiveToFifteenDB.TableInfo.BREATH_SPEED, cod5to15.getBreathSpeed());
        cv.put(CodFiveToFifteenDB.TableInfo.MUCUS, cod5to15.getMucus());
        cv.put(CodFiveToFifteenDB.TableInfo.BREATH_WHISTLE, cod5to15.getBreathWhistle());
        cv.put(CodFiveToFifteenDB.TableInfo.ANTIBIOTICS, cod5to15.getAntibiotics());
        cv.put(CodFiveToFifteenDB.TableInfo.STOMACH_ACHE, cod5to15.getStomachAche());
        cv.put(CodFiveToFifteenDB.TableInfo.STOMACH_ACHE_WHERE, cod5to15.getStomachAcheWhere());
        cv.put(CodFiveToFifteenDB.TableInfo.STOMACH_BLOAT, cod5to15.getStomachBloat());
        cv.put(CodFiveToFifteenDB.TableInfo.VOMIT, cod5to15.getVomit());
        cv.put(CodFiveToFifteenDB.TableInfo.VOMIT_DAYS, cod5to15.getVomitDays());
        cv.put(CodFiveToFifteenDB.TableInfo.EYES_YELLOW, cod5to15.getEyesYellow());
        cv.put(CodFiveToFifteenDB.TableInfo.SKIN_RASH, cod5to15.getSkinRash());
        cv.put(CodFiveToFifteenDB.TableInfo.RASH_WHERE, cod5to15.getRashWhere());
        cv.put(CodFiveToFifteenDB.TableInfo.RASH_MEASLES, cod5to15.getRashMeasles());
        cv.put(CodFiveToFifteenDB.TableInfo.SICKLY_APPEARANCE, cod5to15.getSicklyAppearance());
        cv.put(CodFiveToFifteenDB.TableInfo.YELLOW_APPEARANCE, cod5to15.getYellowAppearance());
        cv.put(CodFiveToFifteenDB.TableInfo.FREQUENTLY_SICK, cod5to15.getFrequentlySick());
        cv.put(CodFiveToFifteenDB.TableInfo.SICK_TIMES, cod5to15.getSickTimes());
        cv.put(CodFiveToFifteenDB.TableInfo.SYMPTOMS_ACCOMPANIED, cod5to15.getSymptomsAccompanied());
        cv.put(CodFiveToFifteenDB.TableInfo.CHANGE, cod5to15.getCHANGE());
        cv.put(CodFiveToFifteenDB.TableInfo.BCG, cod5to15.getBCG());
        cv.put(CodFiveToFifteenDB.TableInfo.POLIO_DOSE, cod5to15.getPolioDose());
        cv.put(CodFiveToFifteenDB.TableInfo.MEASLES_INJECTION, cod5to15.getMeaslesInjection());
        cv.put(CodFiveToFifteenDB.TableInfo.WRITTEN_DESCRIPTION, cod5to15.getWrittenDescription());
        cv.put(CodFiveToFifteenDB.TableInfo.ANSWERER_QUALITY, cod5to15.getAnswererQuality());
        cv.put(CodFiveToFifteenDB.TableInfo.INTERVIEWER_NAME, cod5to15.getInterviewerName());
        cv.put(CodFiveToFifteenDB.TableInfo.DATE, cod5to15.getDate());

        long z = SQ.insert(CodFiveToFifteenDB.TableInfo.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
    }



    public CodFiveToFifteen getInfo(String deathPersonCode){

        CodFiveToFifteen cod5to15 = new CodFiveToFifteen();
        SQLiteDatabase SQ = this.getReadableDatabase();
        Cursor c = null;
        c = SQ.rawQuery("SELECT * FROM " + CodFiveToFifteenDB.TableInfo.TABLE_NAME + " WHERE " + CodFiveToFifteenDB.TableInfo.DEATH_PERSON_CODE + " = " + deathPersonCode, null);
        c.moveToFirst();
        int i = 0;
        cod5to15.setFamilyHeadName(c.getString(i++));
        cod5to15.setFamilyHeadCode(c.getString(i++));
        cod5to15.setDeathPersonName(c.getString(i++));
        cod5to15.setDeathPersonCode(c.getString(i++));
        cod5to15.setDeathMotherName(c.getString(i++));
        cod5to15.setDeathMotherCode(c.getString(i++));
        cod5to15.setAnswererName(c.getString(i++));
        cod5to15.setAnswererCode(c.getString(i++));
        cod5to15.setAnswererRelation(c.getString(i++));
        cod5to15.setAnswererVicinity(c.getString(i++));
        cod5to15.setAnswererAge(c.getString(i++));
        cod5to15.setAnswererGender(c.getString(i++));
        cod5to15.setDeathAge(c.getString(i++));
        cod5to15.setDeathFamilyHeadRelation(c.getString(i++));
        cod5to15.setDeathAddress(c.getString(i++));
        cod5to15.setDeathPlace(c.getString(i++));
        cod5to15.setDeathReason(c.getString(i++));
        cod5to15.setDeathAccident(c.getString(i++));
        cod5to15.setDeathAccidentHow(c.getString(i++));
        cod5to15.setBirthAppearance(c.getString(i++));
        cod5to15.setLessPregnancyTime(c.getString(i++));
        cod5to15.setPregnancyTime(c.getString(i++));
        cod5to15.setBreastFeeding(c.getString(i++));
        cod5to15.setBreastFeedingHalt(c.getString(i++));
        cod5to15.setSickDays(c.getString(i++));
        cod5to15.setFever(c.getString(i++));
        cod5to15.setFeverDays(c.getString(i++));
        cod5to15.setFeverShiver(c.getString(i++));
        cod5to15.setFaint(c.getString(i++));
        cod5to15.setStiffness(c.getString(i++));
        cod5to15.setNeckStiffness(c.getString(i++));
        cod5to15.setDiarrhea(c.getString(i++));
        cod5to15.setDiarrheaDays(c.getString(i++));
        cod5to15.setStoolBlood(c.getString(i++));
        cod5to15.setLiquid(c.getString(i++));
        cod5to15.setCough(c.getString(i++));
        cod5to15.setCoughDays(c.getString(i++));
        cod5to15.setCoughHow(c.getString(i++));
        cod5to15.setBreathProblem(c.getString(i++));
        cod5to15.setBreathProblemDays(c.getString(i++));
        cod5to15.setBreathSpeed(c.getString(i++));
        cod5to15.setMucus(c.getString(i++));
        cod5to15.setBreathWhistle(c.getString(i++));
        cod5to15.setAntibiotics(c.getString(i++));
        cod5to15.setStomachAche(c.getString(i++));
        cod5to15.setStomachAcheWhere(c.getString(i++));
        cod5to15.setStomachBloat(c.getString(i++));
        cod5to15.setVomit(c.getString(i++));
        cod5to15.setVomitDays(c.getString(i++));
        cod5to15.setEyesYellow(c.getString(i++));
        cod5to15.setSkinRash(c.getString(i++));
        cod5to15.setRashWhere(c.getString(i++));
        cod5to15.setRashMeasles(c.getString(i++));
        cod5to15.setSicklyAppearance(c.getString(i++));
        cod5to15.setYellowAppearance(c.getString(i++));
        cod5to15.setFrequentlySick(c.getString(i++));
        cod5to15.setSickTimes(c.getString(i++));
        cod5to15.setSymptomsAccompanied(c.getString(i++));
        cod5to15.setCHANGE(c.getString(i++));
        cod5to15.setBCG(c.getString(i++));
        cod5to15.setPolioDose(c.getString(i++));
        cod5to15.setMeaslesInjection(c.getString(i++));
        cod5to15.setWrittenDescription(c.getString(i++));
        cod5to15.setAnswererQuality(c.getString(i++));
        cod5to15.setInterviewerName(c.getString(i++));
        cod5to15.setDate(c.getString(i++));


        return cod5to15;

    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM CodFiveToFifteen;", null);
    }
}
