package com.example.kylehirschfelder.ship;

/**
 * Created by kylehirschfelder on 1/9/16.
 */
public class Symptoms {

    int prescr_id;
    int village_id;
    String symptoms;

    public Symptoms(){

    }

    public Symptoms(int prescr_id, int village_id, String symptoms) {
        this.prescr_id = prescr_id;
        this.village_id = village_id;
        this.symptoms = symptoms;
    }

    public int getPrescr_id() {
        return prescr_id;
    }

    public void setPrescr_id(int prescr_id) {
        this.prescr_id = prescr_id;
    }

    public int getVillage_id() {
        return village_id;
    }

    public void setVillage_id(int village_id) {
        this.village_id = village_id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}