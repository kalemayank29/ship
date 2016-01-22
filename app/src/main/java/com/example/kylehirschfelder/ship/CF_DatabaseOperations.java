package com.example.kylehirschfelder.ship;

import com.example.kylehirschfelder.ship.CF_TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TableRow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mayank on 8/7/15.
 */
public class CF_DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;

    public String CREATE_QUERY = "CREATE TABLE "+
            CF_TableData.TableInfo.TABLE_NAME+"("+
            TableInfo.HOUSE_ID+" INTEGER PRIMARY KEY," +
            TableInfo.CASTE+" TEXT," +
            TableInfo.RELIGION+" TEXT,"+
            TableInfo.P_BUSINESS+" TEXT,"+
            TableInfo.A_BUSINESS_1 +" TEXT," +
            TableInfo.A_BUSINESS_2 +" TEXT," +
            TableInfo.A_BUSINESS_3 +" TEXT," +
            TableInfo.DRY_LAND_A +" TEXT," +
          //  TableInfo.DRY_LAND_G +" TEXT," +
            TableInfo.WET_LAND_A +" TEXT," +
            //TableInfo.WET_LAND_G +" TEXT," +
            TableInfo.WALL+" TEXT,"+
            TableInfo.ROOF+" TEXT,"+
            TableInfo.ELECTRICITY+ " TEXT,"+
            TableInfo.HOUSE_OWNER+" TEXT," +
            TableInfo.TOILET +" TEXT,"+
            TableInfo.TOILET_USE +" TEXT,"+
            TableInfo.COOKING+" TEXT,"+
            TableInfo.KITCHEN+" TEXT," +
            TableInfo.WATER +" TEXT,"+
            TableInfo.THING +" TEXT,"+
            TableInfo.ANIMALS+" TEXT,"+
            TableInfo.DATE + " TEXT," +
            TableInfo.OLD_HOUSE_ID+" TEXT," +
            TableInfo.FLAG + " INTEGER )";

    public String CREATE_QUERY_S = "CREATE TABLE "+

            CF_TableData.TableInfo.TABLE_S_NAME+"("+
            TableInfo.HOUSE_ID+" INTEGER PRIMARY KEY," +
            TableInfo.CASTE+" TEXT," +
            TableInfo.RELIGION+" TEXT,"+
            TableInfo.P_BUSINESS+" TEXT,"+
            TableInfo.A_BUSINESS_1 +" TEXT," +
            TableInfo.A_BUSINESS_2 +" TEXT," +
            TableInfo.A_BUSINESS_3 +" TEXT," +
            TableInfo.DRY_LAND_A +" TEXT," +
            //  TableInfo.DRY_LAND_G +" TEXT," +
            TableInfo.WET_LAND_A +" TEXT," +
            //TableInfo.WET_LAND_G +" TEXT," +
            TableInfo.WALL+" TEXT,"+
            TableInfo.ROOF+" TEXT,"+
            TableInfo.ELECTRICITY+ " TEXT,"+
            TableInfo.HOUSE_OWNER+" TEXT," +
            TableInfo.TOILET +" TEXT,"+
            TableInfo.TOILET_USE +" TEXT,"+
            TableInfo.COOKING+" TEXT,"+
            TableInfo.KITCHEN+" TEXT," +
            TableInfo.WATER +" TEXT,"+
            TableInfo.THING +" TEXT,"+
            TableInfo.ANIMALS+" TEXT,"+
            TableInfo.DATE + " TEXT," +
            TableInfo.OLD_HOUSE_ID+" TEXT," +
            TableInfo.FLAG + " INTEGER )";



    public CF_DatabaseOperations(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        sdb.execSQL(CREATE_QUERY_S);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public void insert(Census census, int selector) {

        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        // cv.put(TableInfo.HOUSE_ID, census.getHouseID());
        cv.put(TableInfo.CASTE, census.getCaste());
        cv.put(TableInfo.RELIGION, census.getReligion());
        cv.put(TableInfo.P_BUSINESS, census.getpBusiness());
        cv.put(TableInfo.A_BUSINESS_1, census.getaBusiness1());
        cv.put(TableInfo.A_BUSINESS_2, census.getaBusiness2());
        cv.put(TableInfo.A_BUSINESS_3, census.getaBusiness3());
        cv.put(TableInfo.DRY_LAND_A, census.getDrylandA());
      //  cv.put(TableInfo.DRY_LAND_G, census.getDrylandG());
        cv.put(TableInfo.WET_LAND_A, census.getWetlandA());
        //cv.put(TableInfo.WET_LAND_G, census.getWetlandG());
        cv.put(TableInfo.WALL, census.getWall());
        cv.put(TableInfo.ROOF, census.getRoof());
        cv.put(TableInfo.ELECTRICITY, census.getElectricity());
        cv.put(TableInfo.HOUSE_OWNER, census.getHouseOwner());
        cv.put(TableInfo.TOILET, census.getToilet());
        cv.put(TableInfo.TOILET_USE, census.getToiletUse());
        cv.put(TableInfo.COOKING, census.getCooking());
        cv.put(TableInfo.KITCHEN, census.getKitchen());
        cv.put(TableInfo.WATER, census.getWater());
        cv.put(TableInfo.THING, census.getThing());
        cv.put(TableInfo.ANIMALS, census.getAnimal());
        cv.put(TableInfo.DATE, census.getDate());
        cv.put(TableInfo.OLD_HOUSE_ID, census.getOldHouseID());
        cv.put(TableInfo.FLAG, 1);

        long z;

        if(selector == 0)
            z = SQ.insert(TableInfo.TABLE_S_NAME, null, cv);

        if(selector == 1)
            z = SQ.insert(TableInfo.TABLE_NAME, null, cv);

       // Log.println(Log.ASSERT, "LOG", String.valueOf(z));
        //Log.println(Log.ASSERT, "LOG", );

        SQ.close();
    }

    public Census getInfo(int id, int selector){
        Census census = new Census();
        Cursor c;
        SQLiteDatabase SQ = this.getReadableDatabase();
        String selection = "_id=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        if(selector == 1)
            c = SQ.query(TableInfo.TABLE_NAME, null,  selection, selectionArgs, null, null, null, null);



        else
            c = SQ.query(TableInfo.TABLE_S_NAME, null,  selection, selectionArgs, null, null, null, null);


        if(c.moveToFirst()) {
            census.setHouseID(c.getString(0));
            census.setCaste(c.getString(1));
            // census.setReligion(census.getReligionParse());
            census.setReligion(c.getString(2));
            census.setpBusiness(c.getString(3));
            census.setaBusiness1(c.getString(4));
            census.setaBusiness2(c.getString(5));
            census.setaBusiness3(c.getString(6));
            census.setDrylandA(c.getString(7));
            //   census.setDrylandG(c.getString(8));
            census.setWetlandA(c.getString(8));
            // census.setWetlandG(c.getString(9));
            Log.println(Log.ASSERT, "f", c.getString(9));

            census.setWall(c.getString(9));
            census.setRoof(c.getString(10));
            census.setElectricity(c.getString(11));
            census.setHouseOwner(c.getString(12));
            census.setToilet(c.getString(13));
            census.setToiletUse(c.getString(14));
            census.setCooking(c.getString(15));
            census.setKitchen(c.getString(16));
            census.setWater(c.getString(17));
            census.setThing(c.getString(18));
            census.setAnimal(c.getString(19));
            census.setOldHouseID(c.getString(20));
        }
        return census;

    }

    /*public Cursor getInformation(CF_DatabaseOperations dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableInfo.NHID, TableInfo.NFID, TableInfo.CASTE, TableInfo.RELIGION,
                TableInfo.FHB, TableInfo.JAMEEN, TableInfo.WALL, TableInfo.ROOF,
                TableInfo.ELECTRICITY, TableInfo.HOUSE, TableInfo.WASHROOM, TableInfo.WASHROOM_USE,
                TableInfo.COOKING, TableInfo.KITCHEN, TableInfo.WATER,
                TableInfo.VASTU, TableInfo.ANIMALS, TableInfo.OHID, TableInfo.OFID};
        Cursor CR = SQ.query(TableInfo.TABLE_NAME,coloumns, null, null, null, null, null);
        return CR;
    } */
  /*  public void deleteUser(CF_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p,
                           String q, String r, String s, String t, String u, String v, String w, String x) {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {g};

        SQ.delete(TableInfo.TABLE_NAME, selection, args);
        SQ.close();
    }*/

    /*public void updateUser(CF_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p,
                           String q, String r, String s) {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo.NHID, a);
        values.put(TableInfo.CASTE, c);
        values.put(TableInfo.RELIGION, d);
        values.put(TableInfo.FHB, e);
        values.put(TableInfo.JAMEEN, f);
        values.put(TableInfo.WALL, g);
        values.put(TableInfo.ROOF, h);
        values.put(TableInfo.ELECTRICITY, i);
        values.put(TableInfo.HOUSE, j);
        values.put(TableInfo.WASHROOM, k);
        values.put(TableInfo.WASHROOM_USE, l);
        values.put(TableInfo.COOKING, m);
        values.put(TableInfo.KITCHEN, n);
        values.put(TableInfo.WATER, o);
        values.put(TableInfo.VASTU, p);
        values.put(TableInfo.ANIMALS, q);
        values.put(TableInfo.OHID, r);
        values.put(TableInfo.OFID, s);
        String selection = TableInfo.NFID + " = ?";
        String args[] = {b};
        SQ.update(TableInfo.TABLE_NAME, values, selection, args);
        SQ.close();
    }*/

    public void updateUser(Census census, int selector) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.HOUSE_ID, census.getHouseID());
        cv.put(TableInfo.CASTE, census.getCaste());
        cv.put(TableInfo.RELIGION, census.getReligion());
        cv.put(TableInfo.P_BUSINESS, census.getpBusiness());
        cv.put(TableInfo.A_BUSINESS_1, census.getaBusiness1());
        cv.put(TableInfo.A_BUSINESS_2, census.getaBusiness2());
        cv.put(TableInfo.A_BUSINESS_3, census.getaBusiness3());
        cv.put(TableInfo.DRY_LAND_A, census.getDrylandA());
    //    cv.put(TableInfo.DRY_LAND_G, census.getDrylandG());
        cv.put(TableInfo.WET_LAND_A, census.getWetlandA());
      //  cv.put(TableInfo.WET_LAND_G, census.getWetlandG());
        cv.put(TableInfo.WALL, census.getWall());
        cv.put(TableInfo.ROOF, census.getRoof());
        cv.put(TableInfo.ELECTRICITY, census.getElectricity());
        cv.put(TableInfo.HOUSE_OWNER, census.getHouseOwner());
        cv.put(TableInfo.TOILET, census.getToilet());
        cv.put(TableInfo.TOILET_USE, census.getToiletUse());
        cv.put(TableInfo.COOKING, census.getCooking());
        cv.put(TableInfo.KITCHEN, census.getKitchen());
        cv.put(TableInfo.WATER, census.getWater());
        cv.put(TableInfo.THING, census.getThing());
        cv.put(TableInfo.ANIMALS, census.getAnimal());
        cv.put(TableInfo.OLD_HOUSE_ID, census.getOldHouseID());
        String selection = TableInfo.HOUSE_ID + " LIKE ?";
        String[] args = {census.getHouseID()};
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = " + g, null);

        if(selector == 0)
         DB.update(TableInfo.TABLE_S_NAME, cv, selection, args);
        else
            DB.update(TableInfo.TABLE_NAME, cv, selection, args);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = '" + g + "'", null);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID +" = ? " + g , new String[] {g});
        DB.close();


    }


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

    public Census getRecent(int selector){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        if(selector == 0)
            c = db.rawQuery("SELECT * FROM " + TableInfo.TABLE_S_NAME + " ORDER BY _id DESC LIMIT 1",null);
        else
            c = db.rawQuery("SELECT * FROM " + TableInfo.TABLE_NAME + " ORDER BY _id DESC LIMIT 1",null);

        c.moveToFirst();
        Census census = new Census();
        census.setHouseID(c.getString(0));
        census.setCaste(c.getString(1));
        census.setReligion(c.getString(2));
        census.setpBusiness(c.getString(3));
        census.setaBusiness1(c.getString(4));
        census.setaBusiness2(c.getString(5));
        census.setaBusiness3(c.getString(6));
        census.setDrylandA(c.getString(7));
        //census.setDrylandG(c.getString(8));
        census.setWetlandA(c.getString(8));
        //census.setWetlandG(c.getString(10));
        census.setWall(c.getString(9));
        Log.println(Log.ASSERT, "f", c.getString(9));
        census.setRoof(c.getString(10));
        census.setElectricity(c.getString(11));
        census.setHouseOwner(c.getString(12));
        census.setToilet(c.getString(13));
        census.setToiletUse(c.getString(14));
        census.setCooking(c.getString(15));
        census.setKitchen(c.getString(16));
        census.setWater(c.getString(17));
        census.setThing(c.getString(18));
        census.setAnimal(c.getString(19));
        census.setDate(c.getString(20));
        census.setOldHouseID(c.getString(21));

        db.close();
        return census;
    }

    public List<Census> getUnsynced(int selector){
        SQLiteDatabase db = this.getWritableDatabase();

        List<Census> censusList = new ArrayList<Census>();
        Cursor c = null;

        // SQL query: Select all where family_id matches.
        String selection = "flag=?";
        String[] selectionArgs = new String[]{String.valueOf(1)};

        if(selector == 0)
            c = db.query(TableInfo.TABLE_S_NAME, null, selection, selectionArgs, null, null, null);
        else if(selector == 1)
            c = db.query(TableInfo.TABLE_NAME, null, selection, selectionArgs, null, null, null);


        if (c.moveToFirst()) {
            do {
                Census census = new Census();
                census.setHouseID(c.getString(0));
                census.setCaste(c.getString(1));
                census.setReligion(c.getString(2));
                census.setpBusiness(c.getString(3));
                census.setaBusiness1(c.getString(4));
                census.setaBusiness2(c.getString(5));
                census.setaBusiness3(c.getString(6));
                census.setDrylandA(c.getString(7));
                //census.setDrylandG(c.getString(8));
                census.setWetlandA(c.getString(8));
                //census.setWetlandG(c.getString(10));
                census.setWall(c.getString(9));
                Log.println(Log.ASSERT, "f", c.getString(9));
                census.setRoof(c.getString(10));
                census.setElectricity(c.getString(11));
                census.setHouseOwner(c.getString(12));
                census.setToilet(c.getString(13));
                census.setToiletUse(c.getString(14));
                census.setCooking(c.getString(15));
                census.setKitchen(c.getString(16));
                census.setWater(c.getString(17));
                census.setThing(c.getString(18));
                census.setAnimal(c.getString(19));
                census.setDate(c.getString(20));
                census.setOldHouseID(c.getString(21));

                censusList.add(census);
            }
            while (c.moveToNext());

        }
       db.close();
        return censusList;

    }

    public void setAllSync(int selector) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = null;

        // SQL query: Select all where family_id matches.
        String selection = "flag=?";
        String[] selectionArgs = new String[]{String.valueOf(1)};

        if(selector == 0)
            c = db.query(TableInfo.TABLE_S_NAME, null, selection, selectionArgs, null, null, null);
        else if(selector == 1)
            c = db.query(TableInfo.TABLE_NAME, null, selection, selectionArgs, null, null, null);

        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndexOrThrow(TableInfo.HOUSE_ID));
                if(selector == 0)
                    db.execSQL("UPDATE " + TableInfo.TABLE_S_NAME + " SET flag=0" + " WHERE _id="+id+"");
                else if(selector == 1)
                    db.execSQL("UPDATE " + TableInfo.TABLE_NAME + " SET flag=0" + " WHERE _id="+id+"");

            }
            while (c.moveToNext());

        }

        db.close();
    }

    public void deleteAllCensus(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TableInfo.TABLE_S_NAME);   // deletes all members from table.
        db.close();
    }

    public void deleteAllMCensus(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TableInfo.TABLE_NAME);   // deletes all members from table.
        db.close();
    }

    public void setAutoIncr(){
        SQLiteDatabase SQ = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
         cv.put(TableInfo.HOUSE_ID, "22");
        SQ.insert(TableInfo.TABLE_NAME, null, cv);
        this.deleteAllMCensus();

    }

    public void getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
         c = db.rawQuery("SELECT * FROM " + TableInfo.TABLE_NAME , null);
        if(c.moveToFirst()){
            do{
                Log.println(Log.ASSERT,"houseid",c.getString(0));
                Log.println(Log.ASSERT,"flag",c.getString(22));
            }while(c.moveToNext());
        }
    }

    public ArrayList<HashMap<String,String>> toHashList(List<Census> censusList, HashMap<String,String> village) {
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        list.add(village);

        for (Census temp:censusList) {

            HashMap<String,String> pairs = new HashMap<String,String>();

            pairs.put("houseId",String.valueOf(temp.getHouseID()));
            pairs.put("caste", String.valueOf(temp.getCaste()));
            pairs.put("religion", String.valueOf(temp.getReligion()));
            pairs.put("p_business", String.valueOf(temp.getpBusiness()));
            pairs.put("a_business_1", temp.getaBusiness1());
            pairs.put("a_business_2", String.valueOf(temp.getaBusiness2()));
            pairs.put("a_business_3",String.valueOf(temp.getaBusiness3()));
            pairs.put("dry_land_a",String.valueOf(temp.getDrylandA()));
            pairs.put("wet_land_a", temp.getWetlandA());
            pairs.put("wall", temp.getWall());
            pairs.put("roof", temp.getRoof());
            pairs.put("electricity", temp.getElectricity());
            pairs.put("house_owner", temp.getHouseOwner());
            pairs.put("toilet", temp.getToilet());
            pairs.put("toilet_use", temp.getToiletUse());
            pairs.put("cooking", temp.getCooking());
            pairs.put("kitchen", temp.getKitchen());
            pairs.put("water", temp.getWater());
            pairs.put("thing", temp.getThing());
            pairs.put("animals", temp.getAnimal());
            pairs.put("date", temp.getDate());
            pairs.put("old_house_id", temp.getOldHouseID());
            list.add(pairs);
        }

        return list;
    }
}