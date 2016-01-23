package com.example.kylehirschfelder.ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**** MEMBER CLASS *****
 *  Unique Id and primary key constraint is memberId.
 *  Family Id is assigned as Member Id of the family head using CleanUp.
 *  House Id is only assigned first to member head on house (census) data creation.
 *  ^^ The fuck do i do about this?
 *  13 private variables. 6 int, 7 String types.
 */

public class Member {
    private int memberId;
    private int familyId;
    private int familyHeadId;
    private String name;
    private int age;
    private int sex;
    private int houseId;
    private int childId;
    private int villageId;
    private String childDate;
    private String marriageStatus;
    private String familyPlan;
    private String education;
    private String literacy;
    private String weddingArr;
    private String weddingDept;

    public Member() {

    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public Member(int familyId, int houseId, int familyHeadId, String name, int age,int sex, int childId, String childDate, String marriageStatus, String familyPlan, String education, String literacy, String weddingArr, String weddingDept,int villageId) {

        this.familyId = familyId;
        this.houseId = houseId;
        this.childId = childId;
        this.childDate = childDate;
        this.familyHeadId = familyHeadId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.marriageStatus = marriageStatus;
        this.familyPlan = familyPlan;
        this.education = education;
        this.literacy = literacy;
        this.weddingArr = weddingArr;
        this.villageId = villageId;
        this.weddingDept = weddingDept;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getFamilyPlan() {
        return familyPlan;
    }

    public void setFamilyPlan(String familyPlan) {
        this.familyPlan = familyPlan;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getFamilyHeadId() {
        return familyHeadId;
    }

    public void setFamilyHeadId(int familyHeadId) {
        this.familyHeadId = familyHeadId;
    }

    public String getLiteracy() {
        return literacy;
    }

    public void setLiteracy(String literacy) {
        this.literacy = literacy;
    }

    public String getWeddingArr() {
        return weddingArr;
    }

    public void setWeddingArr(String weddingArr) {
        this.weddingArr = weddingArr;
    }

    public void setMarriageParse(String string){
        switch (string) {
            case "विवाहित":
                marriageStatus = "1";
                break;
            case "अविवाहित":
                marriageStatus = "2";
                break;
            case "विधुर":
                marriageStatus = "3";
                break;
            case "विधवा":
                marriageStatus = "4";
                break;
            case "घटस्फोट":
                marriageStatus = "5";
                break;
        }
    }


    public String getMarriageParse() {
        String marriageStatus="";
        switch (this.marriageStatus) {
            case "1":
                marriageStatus = "विवाहित";
                break;
            case "2":
                marriageStatus = "अविवाहित";
                break;
            case "3":
                marriageStatus = "विधुर";
                break;
            case "4":
                marriageStatus = "विधवा";
                break;
            case "5":
                marriageStatus = "घटस्फोट";
                break;
        }
        return marriageStatus;
    }

    public void setLiteracyParse(String string){
        if(string.equals("हो"))
            literacy = "1";
        else
            literacy = "0";
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildDate() {
        return childDate;
    }

    public void setChildDate(String childDate) {
        this.childDate = childDate;
    }

    public String getLiteracyParse(){
        String literacy="";
        if(this.literacy.equals("1"))
            literacy = "हो";
        else
            literacy = "नाही";
        return literacy;
    }

    public void getFamilyPlanParse(String string){
        if(string.equals("1"))
            familyPlan = "हो";
        else
            familyPlan = "नाही";
    }


    public void setFamilyPlanParse(String string){
        if(string.equals("हो"))
            familyPlan = "1";
        else
            familyPlan = "0";
    }

    public String getWeddingDept() {
        return weddingDept;
    }

    public void setWeddingDept(String weddingDept) {
        this.weddingDept = weddingDept;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public void getEducationParse(String string) {
        switch (string) {
            case "0":
                education = "अशिक्षित";
                break;
            case "1":
                education = "१ ली";
                break;
            case "2":
                education = "२ री";
                break;
            case "3":
                education = "३ री";
                break;
            case "4":
                education = "४ थी";
                break;
            case "5":
                education = "५ वी";
                break;
            case "6":
                education = "६ वी";
                break;
            case "7":
                education = "७ वी";
                break;
            case "8":
                education = "८ वी";
                break;
            case "9":
                education = "९ वी";
                break;
            case "10":
                education = "१० वी";
                break;
            case "11":
                education = "११ वी";
                break;
            case "12":
                education = "१२ वी";
                break;
            case "13":
                education = "B.A";
                break;
            case "14":
                education = "B.Sc";
                break;
            case "15":
                education = "B.Com";
                break;
            case "16":
                education = "M.A";
                break;
            case "17":
                education = "M.Sc";
                break;
            case "18":
                education = "M.Com";
                break;
            case "19":
                education = "इतर";
                break;
        }
    }

   /* public void setMarriageParse(String string){
        switch (string) {
            case "विवाहित":
                marriage = "1";
                break;
            case "अविवाहित":
                marriage = "2";
                break;
            case "विधुर":
                marriage = "3";
                break;
            case "विधवा":
                marriage = "4";
                break;
            case "घटस्फोट":
                marriage = "5";
                break;
        }
    }


    public void getMarriageParse(String string) {
        switch (string) {
            case "1":
                marriage = "विवाहित";
                break;
            case "2":
                marriage = "अविवाहित";
                break;
            case "3":
                marriage = "विधुर";
                break;
            case "4":
                marriage = "विधवा";
                break;
            case "5":
                marriage = "घटस्फोट";
                break;
        }
    }

    public void getLiteracyParse(String string){
        if(string.equals("हो"))
            litaracy = "1";
        else
            literacy = "0";
    }

    public void setLiteracyParse(String string){
        if(string.equals("1"))
            litaracy = "हो";
        else
            literacy = "नाही";
    }

    public void setFamilyPlanParse(String string){
        if(string.equals("1"))
            familyPlanning = "हो";
        else
            familyPlanning = "नाही";
    }


    public void getFamilyPlanParse(String string){
        if(string.equals("हो"))
            familyPlanning = "1";
        else
            familyPlannning = "0";
    }*/

}
