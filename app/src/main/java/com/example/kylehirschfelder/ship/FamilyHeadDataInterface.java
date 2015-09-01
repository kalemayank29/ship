package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by mayank on 8/10/15.
 */
public class FamilyHeadDataInterface {
    private SQLiteDatabase database;
    private FamilyHeadDbHelper dbHelper;
    public long result;

    public FamilyHeadDataInterface(Context context){
        dbHelper = new FamilyHeadDbHelper(context);
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
     * @return long result with row number. Inserts param in the right tables.
     * @throws SQLException
     */
    public long createMember(Member element) throws SQLException {
        this.open();

        long newRowId = -1;

        ContentValues value = new ContentValues();
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.FAMILY_HEAD_BOOL, element.getFamilyHeadId());        // Is family Head?
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.CHILD_ID,element.getChildId());
        value.put(dbHelper.CHILD_DATE,element.getChildDate());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());
        value.put(dbHelper.FLAG, 1);

            newRowId = this.database.insert(dbHelper.TABLE_FAMILY_HEAD, null, value);


        this.close();
        return newRowId;
    }

    public Member getRecent() throws SQLException {
        this.openRead();
        Cursor c = null;

            c = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_FAMILY_HEAD + " ORDER BY _id DESC LIMIT 1",null);

        Member element = new Member();

        if (c.moveToFirst()) {
            element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
            element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
            element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
            element.setHouseId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.HOUSE_ID)));
            element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_BOOL)));
            element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
            element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
            element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_DATE)));
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
}
