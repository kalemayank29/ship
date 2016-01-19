package com.example.kylehirschfelder.ship;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class Transaction {

    int village_id;
    String date;
    int medicine_id;
    int change;
    int total;
    String expiryDate;

    public Transaction(){

    }

    public Transaction(int village_id, String date, int medicine_id, int change, int total, String expiryDate) {
        this.village_id = village_id;
        this.date = date;
        this.medicine_id = medicine_id;
        this.change = change;
        this.total = total;
        this.expiryDate = expiryDate;
    }

    public int getVillage_id() {
        return village_id;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setVillage_id(int village_id) {
        this.village_id = village_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}