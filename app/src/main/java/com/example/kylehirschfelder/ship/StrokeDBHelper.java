package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import com.example.kylehirschfelder.ship.StrokeDB.TableInfo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StrokeDBHelper extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ TableInfo.TABLE_NAME+
            "("+ 
            TableInfo.STROKE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            TableInfo.FAMILY_ID+" TEXT,"+
            TableInfo.INF_ID + " TEXT,"+
            TableInfo.ARM+" TEXT,"+
            TableInfo.SIDE+" TEXT,"+
            TableInfo.FACE+" TEXT,"+
            TableInfo.TALK+" TEXT," +
            TableInfo.PART+" TEXT,"+
            TableInfo.SUDDEN+" TEXT,"+
            TableInfo.HOURS+" TEXT,"+
            TableInfo.CANCER+" TEXT," +
            TableInfo.TUMOR+" TEXT"+
            ")";


    public StrokeDBHelper(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public long insert(Stroke stroke) {

        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TableInfo.FAMILY_ID, stroke.getFamilyId());
        cv.put(TableInfo.INF_ID, stroke.getInfId());
        cv.put(TableInfo.ARM, stroke.getArm());
        cv.put(TableInfo.SIDE, stroke.getSide());
        cv.put(TableInfo.FACE, stroke.getFace());
        cv.put(TableInfo.TALK, stroke.getTalk());
        cv.put(TableInfo.PART, stroke.getPart());
        cv.put(TableInfo.SUDDEN, stroke.getSudden());
        cv.put(TableInfo.HOURS, stroke.getHours());
        cv.put(TableInfo.CANCER, stroke.getCancer());
        cv.put(TableInfo.TUMOR, stroke.getTumor());
        long z = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        SQ.close();
        return z;
    }



    public Stroke getInfo(int id){
        Stroke stroke = new Stroke();
        Cursor c;
        SQLiteDatabase SQ = this.getReadableDatabase();
        String selection = "_id=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        c = SQ.query(TableInfo.TABLE_NAME, null,  selection, selectionArgs, null, null, null, null);
        c.moveToFirst();
        stroke.setFamilyId(c.getString(1));
        stroke.setInfId(c.getString(2));
        stroke.setArm(c.getString(3));
        stroke.setSide(c.getString(4));
        stroke.setFace(c.getString(5));
        stroke.setTalk(c.getString(6));
        stroke.setPart(c.getString(7));
        stroke.setSudden(c.getString(8));
        stroke.setHours(c.getString(9));
        stroke.setCancer(c.getString(10));
        stroke.setTumor(c.getString(11));
        System.out.println(stroke.getFamilyId());
        System.out.println(stroke.getInfId());
        System.out.println(stroke.getArm());
        System.out.println(stroke.getSide());
        System.out.println(stroke.getFace());
        System.out.println(stroke.getTalk());
        System.out.println(stroke.getPart());
        System.out.println(stroke.getSudden());
        System.out.println(stroke.getHours());
        System.out.println(stroke.getCancer());
        System.out.println(stroke.getTumor());
        return stroke;

    }/*

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM BirthInfo;", null);
    }

    public List<Birth> getAll(){

        List<Birth> birthList = new ArrayList<Birth>();
        SQLiteDatabase SQ = this.getReadableDatabase();

        Cursor c;
        c = SQ.rawQuery("SELECT * FROM " + TableInfo.TABLE_NAME , null);

        if(c.moveToFirst()){
            do{
                Birth birth = new Birth();

                birth.setMotherVillage(c.getString(0));
                birth.setChildID(c.getString(1));
                birth.setMotherVillageID(c.getString(2));
                birth.setMotherName(c.getString(3));
                birth.setFamilyID(c.getString(4));
                birth.setHouseID(c.getString(5));
                birth.setMemberId(c.getString(6));
                birth.setBirthDate(c.getString(7));
                birth.setVillageOfBirth(c.getString(8));
                birth.setVillageOfBirthID(c.getString(9));
                birth.setVillageOfBirthPlace(c.getString(10));
                birth.setDeliveryName(c.getString(11));
                birth.setDeliveryMethod(c.getString(12));
                birth.setChildGender(c.getString(13));
                birth.setPregnancyTime(c.getString(14));
                birth.setFadPresence(c.getString(15));
                birth.setHealthMessenger(c.getString(16));
                birth.setHealthMessengerId(c.getString(17));
                birth.setHealthMessengerDate(c.getString(18));
                birth.setGuideName(c.getString(19));
                birth.setGuideId(c.getString(20));
                birth.setGuideTestDate(c.getString(21));
                birth.setVillageId(c.getString(22));
                birthList.add(birth);

            }
            while(c.moveToNext());
        }


        return birthList;

    }


/*    public void deleteUser(BirthInfoDBHelper DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p)
    {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {d};

        SQ.delete(TableInfo.TABLE_NAME, selection, args);
        SQ.close();
    }*/

    public void update(Stroke stroke) {
        SQLiteDatabase SQ = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.FAMILY_ID, stroke.getFamilyId());
        cv.put(TableInfo.INF_ID, stroke.getInfId());
        cv.put(TableInfo.ARM, stroke.getArm());
        cv.put(TableInfo.SIDE, stroke.getSide());
        cv.put(TableInfo.FACE, stroke.getFace());
        cv.put(TableInfo.TALK, stroke.getTalk());
        cv.put(TableInfo.PART, stroke.getPart());
        cv.put(TableInfo.SUDDEN, stroke.getSudden());
        cv.put(TableInfo.HOURS, stroke.getHours());
        cv.put(TableInfo.CANCER, stroke.getCancer());
        cv.put(TableInfo.TUMOR, stroke.getTumor());
        SQ.update(TableInfo.TABLE_NAME, cv, TableInfo.STROKE_ID + "=" + stroke.getStrokeId(), null);
        SQ.close();
    }

/*    public void updateUser(DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                             String h,String i,String j, String k, String l,String m,String n, String o, String p) {
        SQLiteDatabase DB = DOP.getWritableDatabase();
        Log.e("", p);
        ContentValues values = new ContentValues();
        values.put(TableInfo.MV_NAME, a);
        values.put(TableInfo.MV_NUM, b);
        values.put(TableInfo.VOB_NAME, c);
        values.put(TableInfo.VOB_NUM, d);
        values.put(TableInfo.CF_NAME, e);
        values.put(TableInfo.C_ID, f);
        values.put(TableInfo.H_NUM, h);
        values.put(TableInfo.BD, i);
        values.put(TableInfo.DD, j);
        values.put(TableInfo.AATOD, k);
        values.put(TableInfo.VOD_NAME, l);
        values.put(TableInfo.VOD_NUM, m);
        values.put(TableInfo.HD_NAME, n);
        values.put(TableInfo.HDD, o);
        values.put(TableInfo.MMKCKD, p);
        String selection = TableInfo.MMKCKD + " LIKE ?";
        String[] args = {g};
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = " + g, null);
        DB.update(TableInfo.TABLE_NAME, values, selection, args);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = '" + g + "'", null);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID +" = ? " + g , new String[] {g});
        DB.close();


    }
*/

/*    public Cursor getUserPass(DatabaseOperations DOP)
    {
        Log.e("CURSOR", "PROBLEM IN CURSOR0");
        SQLiteDatabase SQ = DOP.getReadableDatabase();
        //SQLiteDatabase SQ;
        //SQ = SQLiteDatabase.openOrCreateDatabase(TableInfo.DATABASE_NAME, null, null);
        Log.e("CURSOR", "PROBLEM IN CURSOR1");


        Log.e("CURSOR", "PROBLEM IN CURSOR2");
        Cursor CR = SQ.query(TableInfo.TABLE_NAME, null, null, null, null, null, null);
        Log.e("CURSOR", "PROBLEM IN CURSOR3");

        return CR;

    }
*/

}

