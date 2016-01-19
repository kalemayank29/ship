package com.example.kylehirschfelder.ship;

import java.util.Date;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class Prescription {

    int id;
    String date;
    int member_id, family_id, medicine_id;
    int dose_days, dose_quantity;

    public Prescription(){

    }

    public Prescription(int id, String date, int member_id, int family_id, int medicine_id, int dose_days, int dose_quantity) {
        this.id = id;
        this.date = date;
        this.member_id = member_id;
        this.family_id = family_id;
        this.medicine_id = medicine_id;
        this.dose_days = dose_days;
        this.dose_quantity = dose_quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getFamily_id() {
        return family_id;
    }

    public void setFamily_id(int family_id) {
        this.family_id = family_id;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getDose_days() {
        return dose_days;
    }

    public void setDose_days(int dose_days) {
        this.dose_days = dose_days;
    }

    public int getDose_quantity() {
        return dose_quantity;
    }

    public void setDose_quantity(int dose_quantity) {
        this.dose_quantity = dose_quantity;
    }
}