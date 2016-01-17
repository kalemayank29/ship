package com.example.kylehirschfelder.ship;

/**
 * Created by poorwa on 11/8/15.
 */


    import com.example.kylehirschfelder.ship.BirthInfoDB.TableInfo;
    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteDatabase.CursorFactory;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.provider.SyncStateContract.Columns;
    import android.util.Log;

    import java.util.ArrayList;
    import java.util.List;

public class BirthInfoDBHelper extends SQLiteOpenHelper {
        public static final int database_version = 1;
        public String CREATE_QUERY = "CREATE TABLE "+ BirthInfoDB.TableInfo.TABLE_NAME+
                "("+ BirthInfoDB.TableInfo.MOTHER_VILLAGE+" TEXT,"+
                TableInfo.CHILD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableInfo.MOTHER_VILLAGE_ID+" TEXT," +
                TableInfo.MOTHER_NAME+" TEXT,"+
                TableInfo.FAMILY_ID+" TEXT,"+
                TableInfo.HOUSE_ID + " TEXT,"+
                TableInfo.MEMBER_ID +" INTEGER," +
                TableInfo.BIRTH_DATE+" TEXT,"+
                TableInfo.VILLAGE_OF_BIRTH+" TEXT,"+
                TableInfo.VILLAGE_OF_BIRTH_ID+" TEXT,"+
                TableInfo.VILLAGE_OF_BIRTH_PLACE+" TEXT,"+
                TableInfo.DELIVERY_NAME+" TEXT," +
                TableInfo.DELIVERY_METHOD+" TEXT,"+
                TableInfo.CHILD_GENDER+" TEXT,"+
                TableInfo.PREGNANCY_TIME+" TEXT,"+
                TableInfo.FAD_PRESENCE+" TEXT," +
                TableInfo.HEALTH_MESSENGER+" TEXT,"+
                TableInfo.HEALTH_MESSENGER_ID+" TEXT,"+
                TableInfo.HEALTH_MESSENGER_DATE+" TEXT,"+
                TableInfo.GUIDE_NAME+" TEXT,"+
                TableInfo.GUIDE_ID+" TEXT,"+
                TableInfo.GUIDE_TEST_DATE+ " TEXT," +
                TableInfo.VILLAGE_ID + " TEXT"+

                ")";


        public BirthInfoDBHelper(Context context) {
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

        public String insert(Birth birth) {

            SQLiteDatabase SQ = this.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put(TableInfo.MOTHER_VILLAGE, birth.getMotherVillage());
            cv.put(TableInfo.MOTHER_VILLAGE_ID, birth.getMotherVillageID());
            cv.put(TableInfo.MOTHER_NAME, birth.getMotherName());
            cv.put(TableInfo.FAMILY_ID, birth.getFamilyID());
            cv.put(TableInfo.HOUSE_ID, birth.getHouseID());
            cv.put(TableInfo.MEMBER_ID, Integer.parseInt(birth.getMemberId()));
            cv.put(TableInfo.BIRTH_DATE, birth.getBirthDate());
            cv.put(TableInfo.VILLAGE_OF_BIRTH, birth.getVillageOfBirth());
            cv.put(TableInfo.VILLAGE_OF_BIRTH_ID, birth.getVillageOfBirthID());
            cv.put(TableInfo.VILLAGE_OF_BIRTH_PLACE, birth.getVillageOfBirthPlace());
            cv.put(TableInfo.DELIVERY_NAME, birth.getDeliveryName());
            cv.put(TableInfo.DELIVERY_METHOD, birth.getDeliveryMethod());
            cv.put(TableInfo.CHILD_GENDER, birth.getChildGender());
            cv.put(TableInfo.PREGNANCY_TIME, birth.getPregnancyTime());
            cv.put(TableInfo.FAD_PRESENCE, birth.getFadPresence());
            cv.put(TableInfo.HEALTH_MESSENGER, birth.getHealthMessenger());
            cv.put(TableInfo.HEALTH_MESSENGER_ID, birth.getHealthMessengerId());
            cv.put(TableInfo.HEALTH_MESSENGER_DATE, birth.getHealthMessengerDate());
            cv.put(TableInfo.GUIDE_NAME, birth.getGuideName());
            cv.put(TableInfo.GUIDE_ID, birth.getGuideId());
            cv.put(TableInfo.GUIDE_TEST_DATE, birth.getGuideTestDate());
            cv.put(TableInfo.VILLAGE_ID, birth.getVillageId());

            long z = SQ.insert(TableInfo.TABLE_NAME, null, cv);
            Log.println(Log.ASSERT, "LOG", String.valueOf(z));
            SQ.close();

            Birth recent = getRecent();
           String flag = "." + String.valueOf(recent.getChildID()) + "-0";
            Log.println(Log.ASSERT,"flag",flag);

            return flag;
        }

    public Birth getRecent(){

        SQLiteDatabase SQ = this.getReadableDatabase();
        Cursor c = null;


            c = SQ.rawQuery("SELECT * FROM " + TableInfo.TABLE_NAME + " ORDER BY child_id DESC LIMIT 1",null);

        Birth birth = new Birth();

        if (c.moveToFirst()) {

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
        }


        return birth;

    }


        public Birth getInfo(int id){
            Birth birth = new Birth();
            Cursor c;
            SQLiteDatabase SQ = this.getReadableDatabase();
            Log.println(Log.ASSERT,"id",String.valueOf(id));
            String selection = "child_id=?";
            String[] selectionArgs = new String[]{String.valueOf(id)};
            c = SQ.query(TableInfo.TABLE_NAME, null,  selection, selectionArgs, null, null, null, null);
            c.moveToFirst();

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
            return birth;

        }


    public void updateUser(Birth birth) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.MOTHER_VILLAGE, birth.getMotherVillage());
        cv.put(TableInfo.MOTHER_VILLAGE_ID, birth.getMotherVillageID());
        cv.put(TableInfo.MOTHER_NAME, birth.getMotherName());
        cv.put(TableInfo.FAMILY_ID, birth.getFamilyID());
        cv.put(TableInfo.HOUSE_ID, birth.getHouseID());
        cv.put(TableInfo.MEMBER_ID, Integer.parseInt(birth.getMemberId()));
        cv.put(TableInfo.BIRTH_DATE, birth.getBirthDate());
        cv.put(TableInfo.VILLAGE_OF_BIRTH, birth.getVillageOfBirth());
        cv.put(TableInfo.VILLAGE_OF_BIRTH_ID, birth.getVillageOfBirthID());
        cv.put(TableInfo.VILLAGE_OF_BIRTH_PLACE, birth.getVillageOfBirthPlace());
        cv.put(TableInfo.DELIVERY_NAME, birth.getDeliveryName());
        cv.put(TableInfo.DELIVERY_METHOD, birth.getDeliveryMethod());
        cv.put(TableInfo.CHILD_GENDER, birth.getChildGender());
        cv.put(TableInfo.PREGNANCY_TIME, birth.getPregnancyTime());
        cv.put(TableInfo.FAD_PRESENCE, birth.getFadPresence());
        cv.put(TableInfo.HEALTH_MESSENGER, birth.getHealthMessenger());
        cv.put(TableInfo.HEALTH_MESSENGER_ID, birth.getHealthMessengerId());
        cv.put(TableInfo.HEALTH_MESSENGER_DATE, birth.getHealthMessengerDate());
        cv.put(TableInfo.GUIDE_NAME, birth.getGuideName());
        cv.put(TableInfo.GUIDE_ID, birth.getGuideId());
        cv.put(TableInfo.GUIDE_TEST_DATE, birth.getGuideTestDate());
        cv.put(TableInfo.VILLAGE_ID, birth.getVillageId());
        //String selection = TableInfo.CHILD_ID + " WHERE ?";
      //  String[] args = {birth.getChildID()};
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = " + g, null);


          //  DB.update(BirthInfoDB.TableInfo.TABLE_NAME, cv, selection, args);
        DB.update(BirthInfoDB.TableInfo.TABLE_NAME, cv, TableInfo.CHILD_ID + "=" + birth.getChildID(), null);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = '" + g + "'", null);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID +" = ? " + g , new String[] {g});
        DB.close();


    }
    
    

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM BirthInfo;", null);
    }

        public List<Birth> getAll(){

            List<Birth> birthList = new ArrayList<Birth>();
            SQLiteDatabase SQ = this.getReadableDatabase();

            Cursor c;
            c = SQ.rawQuery("SELECT * FROM " + BirthInfoDB.TableInfo.TABLE_NAME , null);

            if(c.moveToFirst()){
                do{
                    Birth birth = new Birth();

                    birth.setMotherVillage(c.getString(0));
                    birth.setChildID(c.getString(1));
                    birth.setMotherVillageID(c.getString(2));
                    birth.setMotherName(c.getString(3));
                    birth.setFamilyID(c.getString(4));
                    Log.println(Log.ASSERT,"famid",birth.getFamilyID());
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

   /* public void updateUser(BirthInfoDBHelper DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p, String q) {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.MV_NAME, a);
        cv.put(TableInfo.MV_NUM, b);
        cv.put(TableInfo.M_NAME, c);
        cv.put(TableInfo.F_ID, d);
        cv.put(TableInfo.H_NUM, e);
        cv.put(TableInfo.C_ID, f);
        cv.put(TableInfo.BD, g);
        cv.put(TableInfo.VOB_NAME, h);
        cv.put(TableInfo.VOB_NUM, i);
        cv.put(TableInfo.B_NAME, j);
        cv.put(TableInfo.B_METHOD, k);
        cv.put(TableInfo.C_G, l);
        cv.put(TableInfo.P_T, m);
        cv.put(TableInfo.F_M, n);
        cv.put(TableInfo.HM_NAME, o);
        cv.put(TableInfo.HM_DATE, p);
        cv.put(TableInfo.MMKCKD, q);
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {d};
        SQ.update(TableInfo.TABLE_NAME, cv, selection, args);
        SQ.close();
    }*/

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

