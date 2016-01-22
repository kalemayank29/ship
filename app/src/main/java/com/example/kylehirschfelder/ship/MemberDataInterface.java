package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/***
 * Member Data Interface:
 * - SQLiteDatabase type : database
 * - MemberDBHelper type : dbHelper
 *
 *  database is the object to interact with for manipulating SQLite database.
 *  dbHelper is the object needed for table TAGS. Also initialize dataase and get details.
 *
 */

public class MemberDataInterface {
    private SQLiteDatabase database;
    private MemberDbHelper dbHelper;
    public long result;
    public MemberDataInterface(Context context){
        dbHelper = new MemberDbHelper(context);
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




    /**
     * Create a new member in required table.
     * @param element
     * @param cur
     * @return long result with row number. Inserts param in the right tables.
     * @throws SQLException
     */
    public String createMember(Member element, int cur) throws SQLException {
        this.open();
        String flag="";

        long newRowId = -1;

        Member result = getLastMember(element.getVillageId());

        if(result == null){
            element.setMemberId(1);
            element.setFamilyId(1);
            element.setHouseId(1);
        }
        else{
            element.setMemberId(result.getMemberId() + 1);
            if(element.getFamilyHeadId() == 1){
                element.setFamilyId(element.getMemberId());
                element.setHouseId(result.getMemberId() + 1);
            }
            else{
                Member head = getLastHead(element.getVillageId());
                //Log.println(Log.ASSERT,"memberdhead",String.valueOf(element.getMemberId()));
                element.setFamilyId(head.getMemberId());
                element.setHouseId(head.getHouseId());
            }

        }

        ContentValues value = new ContentValues();
        if(cur!=0) value.put(dbHelper.MEMBER_ID, element.getMemberId());
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.SEX,element.getSex());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        value.put(dbHelper.VILLAGE_ID,element.getVillageId());
        //value.put(dbHelper.FLAG, 1);

        if(cur == 0)
            newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);
       else{
           // value.put(dbHelper.FLAG, 1);
            newRowId = this.database.insert(dbHelper.TABLE_MEMBERCUR, null, value);
            flag = "." + String.valueOf(element.getMemberId()) + "-0";
        }


        this.close();
        return flag;
    }

    public String child(Member element, int cur) throws SQLException {
        this.open();
        String flag="";

        long newRowId = -1;

        Member result = getLastMember(element.getVillageId());


            element.setMemberId(result.getMemberId() + 1);



        ContentValues value = new ContentValues();
        value.put(dbHelper.MEMBER_ID, element.getMemberId());
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.SEX,element.getSex());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        value.put(dbHelper.VILLAGE_ID,element.getVillageId());
       // value.put(dbHelper.FLAG, 1);

        if(cur == 0)
            newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);
        else{
           // value.put(dbHelper.FLAG, 1);
            newRowId = this.database.insert(dbHelper.TABLE_MEMBERCUR, null, value);
            flag = "." + String.valueOf(element.getMemberId()) + "-0";
        }


        this.close();
        return flag;
    }

    public long createMemberTemp(Member element, int cur) throws SQLException {
        this.open();

        long newRowId = -1;

        ContentValues value = new ContentValues();
        //value.put(dbHelper.MEMBER_ID, element.getMemberId());
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.SEX,element.getSex());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        value.put(dbHelper.VILLAGE_ID,element.getVillageId());
       // value.put(dbHelper.FLAG, 1);

        if(cur == 0)
            newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);
        else{
            //value.put(dbHelper.FLAG, 1);
            newRowId = this.database.insert(dbHelper.TABLE_MEMBERCUR, null, value);
        }


        this.close();
        return newRowId;
    }

    public long createVillMember(Member element, int cur) throws SQLException {
        this.open();

        long newRowId = -1;

        ContentValues value = new ContentValues();
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.SEX,element.getSex());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        value.put(dbHelper.VILLAGE_ID, 3);
       // value.put(dbHelper.FLAG, 1);

        if(cur == 0)
            newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);
        else{
           // value.put(dbHelper.FLAG, 1);
            newRowId = this.database.insert(dbHelper.TABLE_MEMBERCUR, null, value);
        }


        this.close();
        return newRowId;
    }





    /*
     * Select member by unique member id.
     * @param id
     * @param cur
     * @return Member matched with id
     * @throws SQLException
     */
    public Member getMember(int id, int village_id, int cur) throws SQLException{
        this.openRead();

        Log.println(Log.ASSERT,String.valueOf(id),String.valueOf(village_id));

        Member element = new Member();
        Cursor c = null;
        String selection = "_id=? AND village_id=?";     //unique member id
        String[] selectionArgs = new String[] { String.valueOf(id),String.valueOf(village_id)};

        if(cur == 0)
            c = database.query(MemberDbHelper.TABLE_MEMBER,null,selection,selectionArgs,null,null,null);
        else
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR,null,selection,selectionArgs,null,null,null);

        c.moveToFirst();
        element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
        element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
        element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
        element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.HOUSE_ID)));
        element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_BOOL)));
        element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
        element.setSex(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.SEX)));
        element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
        element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_DATE)));
        element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
        element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
        element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
        element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
        element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
        element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));

        this.close();
        return element;
    }




    /**
     * Get Member List of all members in table.
     * @param cur {0: Scratch, 1: Curated}
     * @return Member List
     ****/
    public List<Member> getAllMembers(int cur){

        List<Member> memberList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();         // Don't know why we need a writable db.
        Cursor cursor = null;

        if(cur == 0)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER , null);
        else
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR , null);


       // Log.println(Log.ASSERT, "CURSOR SIZE: ", String.valueOf(cursor.getCount()));

        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11), cursor.getString(12),cursor.getString(13),cursor.getString(14),Integer.parseInt(cursor.getString(16)));

                element.setMemberId(Integer.parseInt(cursor.getString(0)));     // Done separately because of constructor
                memberList.add(element);

                Log.println(Log.ASSERT,String.valueOf(element.getFamilyId()), String.valueOf(element.getName()));
            }
            while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return memberList;
    }



    /**
     * Get number of members in table. Useful for testing and verification purposes.
     * @param cur
     * @return
     */
    public int getMemberCount(int cur){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        int c;

        if(cur == 0)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER, null);
        else
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR, null);

        c = cursor.getCount();

        db.close();
        cursor.close();

        return c;
    }

    public List<Member> getIdByName(String name){

        List<Member> memberList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();         // Don't know why we need a writable db.
        Cursor cursor = null;
        cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE name LIKE '" + name + "%'", null);


        //Log.println(Log.ASSERT, "CURSOR SIZE: ", String.valueOf(cursor.getCount()));

        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11), cursor.getString(12),cursor.getString(13),cursor.getString(14),Integer.parseInt(cursor.getString(16)));

                element.setMemberId(Integer.parseInt(cursor.getString(0)));     // Done separately because of constructor
                memberList.add(element);

                //  Log.println(Log.ASSERT,"head", String.valueOf(element.getFamilyHeadId()));
            }
            while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return memberList;
    }



    /**
     * Updates the member. Only from Scratch since Member should not be updatable from curated.
     * @param element
     * @param id        Separate id param to identify member. Can this be improved??
     * @throws SQLException
     *
     * TODO: Change params to be cleaner. Also, return long result ?
     */
    public void update(Member element,int id, int cur) throws SQLException {
        this.open();

        long result = -1;
        ContentValues value = new ContentValues();

        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.SEX,element.getSex());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        //value.put(dbHelper.FLAG, 1);

        if(cur == 0)
            result = database.update(dbHelper.TABLE_MEMBER, value, dbHelper.MEMBER_ID + " = ?",
                new String[] { String.valueOf(id)});
        else
            result = database.update(dbHelper.TABLE_MEMBERCUR, value, dbHelper.MEMBER_ID + " = ?",
                    new String[] { String.valueOf(id)});

        Log.println(Log.ASSERT,"update result",String.valueOf(result));
        this.close();

    }


    /******** DELETE MEMBER FUNCTION WITH MEMBER ID ****************/
    public void deleteMember(Member element){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(dbHelper.TABLE_MEMBER, dbHelper.MEMBER_ID + "=?", new String[] {String.valueOf(element.getMemberId())});
        db.close();
    }
    /**************************************************************/


    /**
     * Get Family Head based on family Id. <WAT> MORE WAT </WAT>
     * @param familyId
     * @param cur ---- table selection.
     * @return  ------ int Family Head Id
     * @throws SQLException
     */
    public int getFamilyHeadId(int familyId, int cur) throws SQLException {
        this.openRead();

        int familyHeadId;
        Cursor c = null;

        // SQL query. get unique one row with family id match and boolean family_head:true
        String selection = "family_id=? AND family_head=?";
        String[] selectionArgs = new String[] { String.valueOf(familyId), "1"};     // family id, YES(1) for head.

        if(cur == 0)
            c = database.query(MemberDbHelper.TABLE_MEMBER,null,selection,selectionArgs,null,null,null);
        else
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR,null,selection,selectionArgs,null,null,null);

        c.moveToFirst();        // Reset cursor after retrieval


        // Member id of family head is the family id. Get Member Id column of family head from cursor.
        familyHeadId = c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID));
        return familyHeadId;
    }



    /**
     * Family Head list is only to be retrieved from Curated.
     *
     * @return Returns list of Members: All are family heads.
     */
    public List<Member> getAllFamilyHeads(int cur, int curVillage){

        List<Member> headList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = null;

        // Simple SEQUEL query: select all members for family_head: true
        if(cur == 0)
             cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER + " WHERE family_head = 1 AND village_id = "+ curVillage + " ORDER BY family_id", null);
        else
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE family_head = 1 AND village_id = "+ curVillage + " ORDER BY family_id", null);
           // cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE family_head = 1 ORDER BY name", null);

        if(cursor.moveToFirst()){
            do{

                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11), cursor.getString(12),cursor.getString(13),cursor.getString(14),Integer.parseInt(cursor.getString(16)));

                element.setMemberId(Integer.parseInt(cursor.getString(0)));         // Constructor enforced
                headList.add(element);
            }
            while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return headList;
    }


    /*********** DELETE ALL FROM TABLES *****************/
    public void deleteAllTables(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + dbHelper.TABLE_MEMBER);   // deletes all members from table.

        db.close();
    }
    /***********************************************/


    /**
     * Returns a family based on the family id. Retrieve all Members, match family id.
     *
     * @param familyId
     * @return   -------- Member List of Family.
     * @throws SQLException
     */
    public List<Member> getFamilyList(int familyId, int cur,int curVillage) throws SQLException {
        this.openRead();


        List<Member> memberFamList = new ArrayList<Member>();
        Cursor c = null;

        // SQL query: Select all where family_id matches.
        String selection = "family_id=? AND village_id=?";
        String[] selectionArgs = new String[]{String.valueOf(familyId),String.valueOf(curVillage)};

        if(cur == 0)
             c = database.query(MemberDbHelper.TABLE_MEMBER, null, selection, selectionArgs, null, null, null);

        else if(cur == 1)
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR, null, selection, selectionArgs, null, null, null);


        if (c.moveToFirst()) {
            do {
                Member element = new Member();
                element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
                element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
                element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
                element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.HOUSE_ID)));
                element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_BOOL)));
                element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
                element.setSex(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.SEX)));
                element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
                element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_DATE)));
                element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
                element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
                element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
                element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
                element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
                element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));

                memberFamList.add(element);
            }
            while (c.moveToNext());

        }
        this.close();
        return memberFamList;
    }

    /**
     * Returns a family based on the family id. Retrieve female Members, match family id.
     *
     * @param familyId
     * @return   -------- Member List of Family.
     * @throws SQLException
     */
    public List<Member> getFemaleFamilyList(int familyId, int cur) throws SQLException {
        this.openRead();


        List<Member> memberFamList = new ArrayList<Member>();
        Cursor c = null;

        // SQL query: Select all where family_id matches.
        String selection = "family_id=?";
        String[] selectionArgs = new String[]{String.valueOf(familyId)};

        if(cur == 0)
            c = database.query(MemberDbHelper.TABLE_MEMBER, null, selection, selectionArgs, null, null, null);

        else if(cur == 1)
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR, null, selection, selectionArgs, null, null, null);


        if (c.moveToFirst()) {
            do {
                Member element = new Member();
                if(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.SEX))==2){
                    element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
                    element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
                    element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
                    element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.HOUSE_ID)));
                    element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.VILLAGE_ID)));
                    element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_BOOL)));
                    element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
                    element.setSex(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.SEX)));
                    element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
                    element.setChildDate(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_DATE)));
                    element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
                    element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
                    element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
                    element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
                    element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
                    element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));
                    memberFamList.add(element);
                }

            }
            while (c.moveToNext());

        }
        this.close();
        return memberFamList;
    }


    /**
     * <EXTREME CODE SORCEREY> Clean up family id based on inserted family heads. </EXTREME CODE SORCEREY>
     * Gets all members in table. (Scratch)
     * SIDE NOTE: Family Id is -1 only for recently inserted member heads since you need to specify family id to insert a normal member.
     * If member has family_id as -1, set family_id to be member_id.
     * Family ID is the Member ID of Family head.
     * Update table.
     *
     * Big-O complexity: O(n).
     * TODO: Reduce time complexity. Maybe.
     * @throws SQLException
     */
    public void cleanFamilyId(int cur,int curVillage) throws SQLException {
        List<Member> memberList;
        memberList = getAllMembers(cur);

        for (Member element: memberList
             ) {
            if(element.getFamilyId() == -1){
                //Log.println(Log.ASSERT,"logclean", String.valueOf(element.getMemberId()));
                element.setFamilyId(element.getMemberId());
                update(element,element.getMemberId(),cur);
            }
        }
    }


    /** FUNCTION WAS MOVED FROM MEMBER CLASS
     *
     * Convert Member to HashMap of String,String.
     * Useful for WiFiDirect transfers of Data. Is called before serializing data into byte streams.
     * @param memberList
     * @return --------- Array List of Member Hash maps.
     */

    public ArrayList<HashMap<String,String>> toHashList(List<Member> memberList, HashMap<String,String> village) {
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        list.add(village);

        for (Member temp:memberList) {

            HashMap<String,String> pairs = new HashMap<String,String>();
            pairs.put("memberId",String.valueOf(temp.getMemberId()));
            pairs.put("familyId", String.valueOf(temp.getFamilyId()));
            pairs.put("houseId", String.valueOf(temp.getHouseId()));
            pairs.put("familyHeadId", String.valueOf(temp.getFamilyId()));
            pairs.put("name", temp.getName());
            pairs.put("age", String.valueOf(temp.getAge()));
            pairs.put("sex",String.valueOf(temp.getSex()));
            pairs.put("child_id",String.valueOf(temp.getChildId()));
            pairs.put("child_date",String.valueOf(temp.getChildDate()));
            pairs.put("marriageStatus", temp.getMarriageStatus());
            pairs.put("familyPlan", temp.getFamilyPlan());
            pairs.put("education", temp.getEducation());
            pairs.put("literacy", temp.getLiteracy());
            pairs.put("weddingArr", temp.getWeddingArr());
            pairs.put("weddingDept", temp.getWeddingDept());
            list.add(pairs);
        }

        return list;
    }


    public Member getRecent(int cur) throws SQLException {
        this.openRead();
        Cursor c = null;

        if(cur == 0)
            c = database.rawQuery("SELECT * FROM " + MemberDbHelper.TABLE_MEMBER + " ORDER BY _id DESC LIMIT 1",null);
        else if(cur == 1)
            c = database.rawQuery("SELECT * FROM " + MemberDbHelper.TABLE_MEMBERCUR + " ORDER BY _id DESC LIMIT 1",null);

        Member element = new Member();

        if (c.moveToFirst()) {
            element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
            element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
            element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
            element.setVillageId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.VILLAGE_ID)));
            element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.HOUSE_ID)));
            element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_BOOL)));
            element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
            element.setSex(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.SEX)));
            element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
            element.setChildDate(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_DATE)));
            element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
            element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
            element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
            element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
            element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
            element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));

        }
        this.close();
        return element;

    }

    public String getHeadFromHouse(int houseId) throws SQLException {
        this.openRead();
        String head;
        Cursor c = null;

        // SQL query. get unique one row with family id match and boolean family_head:true
        String selection = "house_id=? AND family_head=?";
        String[] selectionArgs = new String[] { String.valueOf(houseId), "1"};     // family id, YES(1) for head.

            c = database.query(MemberDbHelper.TABLE_MEMBERCUR,null,selection,selectionArgs,null,null,null);

        c.moveToFirst();        // Reset cursor after retrieval

        // Member id of family head is the family id. Get Member Id column of family head from cursor.
        head = c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME));
        this.close();
        return head;
    }

    public Member getLastMember(int village){

        Member result = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();         // Don't know why we need a writable db.
        Cursor cursor = null;

            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE village_id = " + village + " ORDER BY _id DESC limit 1" , null);


        //Log.println(Log.ASSERT, "CURSOR SIZE: ", String.valueOf(cursor.getCount()));

        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11), cursor.getString(12),cursor.getString(13),cursor.getString(14),Integer.parseInt(cursor.getString(16)));

                element.setMemberId(Integer.parseInt(cursor.getString(0)));     // Done separately because of constructor
                //  Log.println(Log.ASSERT,"head", String.valueOf(element.getFamilyHeadId()));
                result = element;
            }
            while(cursor.moveToNext());
        }

        cursor.close();

        return result;
    }

    public Member getLastHead(int village){

        Member result = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();         // Don't know why we need a writable db.
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE family_head = 1 AND village_id = " + village + " ORDER BY _id DESC limit 1" , null);


        //Log.println(Log.ASSERT, "CURSOR SIZE: ", String.valueOf(cursor.getCount()));

        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11), cursor.getString(12),cursor.getString(13),cursor.getString(14),Integer.parseInt(cursor.getString(16)));

                element.setMemberId(Integer.parseInt(cursor.getString(0)));     // Done separately because of constructor
                //  Log.println(Log.ASSERT,"head", String.valueOf(element.getFamilyHeadId()));
                result = element;
            }
            while(cursor.moveToNext());
        }

        cursor.close();

        return result;
    }




}