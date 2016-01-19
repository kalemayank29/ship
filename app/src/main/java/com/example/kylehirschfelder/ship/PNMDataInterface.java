package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by mayank on 12/26/15.
 */
public class PNMDataInterface {
    private SQLiteDatabase database;
    private PNMDbHelper dbHelper;
    public long result;

    public PNMDataInterface(Context context){
        dbHelper = new PNMDbHelper(context);
    }


    /******* LOGISTICAL FUNCTIONS FOR DATABASE **************/
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void openRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public void close() throws SQLException {
        dbHelper.close();
    }
    /***************** END ***********************/

    public long createPNM(PNM element, int cur) throws SQLException {
        this.open();

        long newRowId = -1;

        ContentValues value = new ContentValues();
        value.put(dbHelper.MEMBER_ID, element.getId());
        value.put(dbHelper.NAME, element.getName());
  //      value.put(dbHelper.COUGH, element.getCough());
        value.put(dbHelper.COUGH_DAYS, element.getCoughDays());
  //      value.put(dbHelper.GASP, element.getGaspDays());
        value.put(dbHelper.GASP_DAYS, element.getGaspDays());
    //    value.put(dbHelper.FEVER, element.getFever());
        value.put(dbHelper.FEVER_DAYS, element.getFeverDays());
  //      value.put(dbHelper.FIT, element.getFit());
        value.put(dbHelper.FIT_DAYS, element.getFitDays());
   //     value.put(dbHelper.FAINT, element.getFaint());
        value.put(dbHelper.FAINT_DAYS, element.getFaintDays());
        value.put(dbHelper.MILK, element.getMilk());
        value.put(dbHelper.MILK_DAYS, element.getMilkDays());
        value.put(dbHelper.MILK_HOURS, element.getMilkHours());
   //     value.put(dbHelper.MEASLES, element.getMeasles());
        value.put(dbHelper.MEASLES_DAYS, element.getMeaslesDays());
   //     value.put(dbHelper.VOMIT, element.getVomit());
        value.put(dbHelper.VOMIT_DAYS, element.getVomitDays());
        value.put(dbHelper.BIRTH_MONTHS, element.getBirthMonths());
        value.put(dbHelper.CONSC, element.getConscious());
        value.put(dbHelper.PULSE_RATE, element.getPulseRate());
        value.put(dbHelper.CHEST, element.getChest());
        value.put(dbHelper.BREATH, element.getBreath());
        value.put(dbHelper.WEAK, element.getWeak());
        value.put(dbHelper.DEHYDRATE, element.getDehydrate());
        value.put(dbHelper.MEASLES_COND, element.getMeaslesCondition());
        value.put(dbHelper.FEVER_COUNT, element.getFeverCount());
        value.put(dbHelper.STRYDER, element.getStryder());
        value.put(dbHelper.EXHALE, element.getExhale());
        value.put(dbHelper.SHORT_BREATH, element.getShortBreath());
        value.put(dbHelper.COMMENTS, element.getComments());





        if(cur == 0)
            newRowId = this.database.insert(dbHelper.TABLE_PNM, null, value);
        else{
            //value.put(dbHelper.FLAG, 1);
            newRowId = this.database.insert(dbHelper.TABLE_PNMCUR, null, value);
        }


        this.close();
        return newRowId;
    }

}
