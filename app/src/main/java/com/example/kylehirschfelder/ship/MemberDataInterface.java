package com.example.kylehirschfelder.ship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylehirschfelder on 7/23/15.
 */
public class MemberDataInterface {
    private SQLiteDatabase database;
    private MemberDbHelper dbHelper;
    public long result;

    public MemberDataInterface(Context context){
        dbHelper = new MemberDbHelper(context);
    }

    public void open() throws SQLException {

        database = dbHelper.getWritableDatabase();

    }

    public void openRead() throws SQLException {

        database = dbHelper.getReadableDatabase();

    }

    public void close() throws SQLException {
        dbHelper.close();
    }

    public long createMember(Member element, int cur) throws SQLException {
        this.open();

        ContentValues value = new ContentValues();
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.FAMILY_HEAD_ID, element.getFamilyHeadId());
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.CHILD_ID, element.getChildId());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());

        long newRowId = -1;

        if(cur == 0) {
            newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);
        }
        else if(cur == 1){
            newRowId = this.database.insert(dbHelper.TABLE_MEMBERCUR, null, value);
        }
        this.close();
        return newRowId;
    }

    public Member getMember(int id, int cur) throws SQLException{
        this.openRead();

        Member element = new Member();

        Cursor c = null;
        String selection = "_id=?";
        String[] selectionArgs = new String[] { String.valueOf(id)};
        if(cur == 0)
            c = database.query(MemberDbHelper.TABLE_MEMBER,null,selection,selectionArgs,null,null,null);
        else if(cur == 1)
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR,null,selection,selectionArgs,null,null,null);

        c.moveToFirst();
        element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
        element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
        element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
        element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_ID)));
        element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
        element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
        element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
        element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
        element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
        element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
        element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
        element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));

        this.close();

        return element;

    }

    public List<Member> getAllMembers(int cur){
        List<Member> memberList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = null;
        if(cur == 0)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER, null);
        else if(cur ==1)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR, null);

        Log.println(Log.ASSERT, "CURSOR SIZE: ", String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3),Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11));
                element.setMemberId(Integer.parseInt(cursor.getString(0)));
                memberList.add(element);

                Log.println(Log.ASSERT,"head", String.valueOf(element.getFamilyHeadId()));


            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return memberList;
    }

    public int getMemberCount(int cur){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;

        if(cur == 0)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER, null);
        else if(cur ==1)
            cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR, null);

        int c = cursor.getCount();
        db.close();
        cursor.close();
        return c;
    }

    public void update(Member element,int id) throws SQLException {

        this.open();
        ContentValues value = new ContentValues();

        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.FAMILY_HEAD_ID, element.getFamilyHeadId());
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.CHILD_ID, element.getChildId());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());

        long result = -1;
        result = database.update(dbHelper.TABLE_MEMBER, value, dbHelper.MEMBER_ID + " = ?",
                new String[] { String.valueOf(id)});
        this.close();

    }

    public void deleteMember(Member element){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(dbHelper.TABLE_MEMBER, dbHelper.MEMBER_ID + "=?", new String[] {String.valueOf(element.getMemberId())});
        db.close();
    }

    public int getFamilyHeadId(int familyId, int cur){
        int familyHeadId;

        Cursor c = null;
        String selection = "familyId=? AND familyHeadId=?";
        String[] selectionArgs = new String[] { String.valueOf(familyId), "1"};
        if(cur == 0)
            c = database.query(MemberDbHelper.TABLE_MEMBER,null,selection,selectionArgs,null,null,null);
        else if(cur == 1)
            c = database.query(MemberDbHelper.TABLE_MEMBERCUR,null,selection,selectionArgs,null,null,null);

        c.moveToFirst();

        familyHeadId = c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID));
        return familyHeadId;
    }

    public List<Member> getAllFamilyHeads(){
        List<Member> headList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBERCUR + " WHERE family_head_id = 1", null);
        if(cursor.moveToFirst()){
            do{
                Member element = new Member(
                        Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3),Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8),
                        cursor.getString(9), cursor.getString(10),
                        cursor.getString(11));
                element.setMemberId(Integer.parseInt(cursor.getString(0)));
                headList.add(element);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return headList;
    }

    public void deleteAllTables(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + dbHelper.TABLE_MEMBER);
        db.execSQL("DELETE FROM " + dbHelper.TABLE_MEMBERCUR);
        db.close();
    }

    public List<Member> getFamilyList(int familyId) throws SQLException {
        this.openRead();

        //Member element = new Member();
        Log.println(Log.ASSERT,"familyid", String.valueOf(familyId));
        List<Member> memberFamList = new ArrayList<Member>();
        Cursor c = null;
        String selection = "family_id=?";
        String[] selectionArgs = new String[]{String.valueOf(familyId)};

        c = database.query(MemberDbHelper.TABLE_MEMBERCUR, null, selection, selectionArgs, null, null, null);

        if (c.moveToFirst()) {
            do {
                Member element = new Member();
                element.setName(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.NAME)));
                element.setMemberId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.MEMBER_ID)));
                element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_ID)));
                element.setFamilyHeadId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_HEAD_ID)));
                element.setAge(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.AGE)));
                element.setChildId(c.getInt(c.getColumnIndexOrThrow(MemberDbHelper.CHILD_ID)));
                element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.MARRIAGE_STATUS)));
                element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.FAMILY_PLAN)));
                element.setEducation(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.EDUCATION)));
                element.setLiteracy(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.LITERACY)));
                element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_ARR)));
                element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(MemberDbHelper.WEDDING_DEPT)));
                Log.println(Log.ASSERT, "Log", "Looping");
                memberFamList.add(element);
            }
            while (c.moveToNext());

        }
        this.close();
        return memberFamList;
    }
}