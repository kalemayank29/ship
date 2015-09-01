package com.example.kylehirschfelder.ship;

import android.util.Log;

import java.util.BitSet;

import static android.text.TextUtils.split;

public class Census {
    private String houseID, caste, religion, pBusiness, aBusiness1, aBusiness2, aBusiness3,
            wetlandA, drylandA, wall, roof, electricity, houseOwner, toilet,
            toiletUse, cooking, kitchen, water, thing, animal, date, oldHouseID;

    // newFamilyID, oldFamilyID nako ugach

    public Census() {
    }

    public Census( String caste, String religion, String pBusiness, String aBusiness1, String aBusiness2, String aBusiness3, String wetlandA, String drylandA, String wall, String roof, String electricity, String houseOwner, String toilet, String toiletUse, String cooking, String kitchen, String water, String thing, String animal, String date, String oldHouseID) {
        //  this.houseID = houseID;
        this.caste = caste;
        this.religion = religion;
        this.pBusiness = pBusiness;
        this.aBusiness1 = aBusiness1;
        this.aBusiness2 = aBusiness2;
        this.aBusiness3 = aBusiness3;
        this.wetlandA = wetlandA;
    //    this.wetlandG = wetlandG;
        this.drylandA = drylandA;
      //  this.drylandG = drylandG;
        this.wall = wall;
        this.roof = roof;
        this.electricity = electricity;
        this.houseOwner = houseOwner;
        this.toilet = toilet;
        this.toiletUse = toiletUse;
        this.cooking = cooking;
        this.kitchen = kitchen;
        this.water = water;
        this.thing = thing;
        this.animal = animal;
        this.date = date;
        this.oldHouseID = oldHouseID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligion() {
        return religion;
    }

    public String getReligionParse() {
        String parse = "";
        switch(this.religion) {
            case "1":
                parse = "हिंदू";
                break;
            case "2":
                parse = "मुसलमान";
                break;
            case "4":
                parse = "ख्रिश्चन";
                break;
            case "8":
                parse = "शीख";
                break;
            case "16":
                parse = "जैन";
                break;
            case "32":
                parse = "बौद्ध";
                break;
            default:
                return "---";
        }
        return parse;
    }

    public void setReligionParse(String parse) {

        switch(parse) {
            case "हिंदू":
                this.religion = "1";
                break;
            case "मुसलमान":
                this.religion = "2";
                break;
            case "ख्रिश्चन":
                this.religion = "4";
                break;
            case "शीख":
                this.religion = "8";
                break;
            case "जैन":
                this.religion = "16";
                break;
            case "बौद्ध":
                this.religion = "32";
                break;
        }
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getpBusiness() {
        return pBusiness;
    }

    public void setpBusiness(String pBusiness) {
        this.pBusiness = pBusiness;
    }

    public String getaBusiness1() {
        return aBusiness1;
    }

    public void setaBusiness1(String aBusiness1) {
        this.aBusiness1 = aBusiness1;
    }

    public String getaBusiness2() {
        return aBusiness2;
    }

    public void setaBusiness2(String aBusiness2) {
        this.aBusiness2 = aBusiness2;
    }

    public String getaBusiness3() {
        return aBusiness3;
    }

    public void setaBusiness3(String aBusiness3) {
        this.aBusiness3 = aBusiness3;
    }

    public String getWetlandA() {
        return wetlandA;
    }

    public void setWetlandA(String wetlandA) {
        this.wetlandA = wetlandA;
    }

   /* public String getWetlandG() {
        return wetlandG;
    }

    public void setWetlandG(String wetlandG) {
        this.wetlandG = wetlandG;
    }
*/
    public String getDrylandA() {
        return drylandA;
    }

    public void setDrylandA(String drylandA) {
        this.drylandA = drylandA;
    }
/*
    public String getDrylandG() {
        return drylandG;
    }

    public void setDrylandG(String drylandG) {
        this.drylandG = drylandG;
    }
*/
    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getToiletUse() {
        return toiletUse;
    }

    public void setToiletUse(String toiletUse) {
        this.toiletUse = toiletUse;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getOldHouseID() {
        return oldHouseID;
    }

    public void setOldHouseID(String oldHouseID) {
        this.oldHouseID = oldHouseID;
    }


}
