package com.example.kylehirschfelder.ship;

import android.app.Application;

/**
 * Created by mayank on 1/11/16.
 */
public class CodOneFive {

    private static CodOneFive mInstance = null;

    private int member_id, family_id, village_id;
    private String name, gender, child_village, child_village_id, death_place,
            birth_date, death_date, age, fem_health_worker, birth_time, size, death_accident, measles, measles_days,
            death_age, measles_three_days, measles_fever, measles_cough, measles_eyes, measles_gone, measles_water,
            malntr_growth, malntr_weight, malntr_swelling, malntr_milk, malntr_milk_bott, malntr_food, malntr_meal,
            malntr_poop, malntr_poop_times, malntr_days, malntr_health, malntr_play, malntr_blind, malntr_satvi_CHANGE,
            malntr_premature, breath_cough, breath_asthama, breath_cough_days, breath_asthama_days, breath_mucus,
            breath_fever, breath_CHANGE_kanvhavat, breath_cough_long, cough_face, cough_sound, cough_vomit, cough_whoop,
            cough_whoop_spread, cough_dose, dysentry_loose, dysentry_loose_times, dysentry_blood, dysentry_days,
            dysentry_water, dysentry_vomit, dysentry_thirst, dysentry_eyes, dysentry_skull, dysentry_urine,
            dysentry_urine_color, dysentry_milk, brain_fever, brain_unconsc, brain_fit, brain_ear, brain_neck,
            brain_vomit, brain_CHANGE_krog, brain_milk, brain_teeth, brain_others;

    private void CodOneFive(){
    }

    public static CodOneFive getInstance(){
        if(mInstance == null){
            mInstance = new CodOneFive();
        }
        return mInstance;
    }

    public String getMalntr_blind() {
        return malntr_blind;
    }

    public void setMalntr_blind(String malntr_blind) {
        this.malntr_blind = malntr_blind;
    }

    public static CodOneFive getmInstance() {
        return mInstance;
    }

    public static void setmInstance(CodOneFive mInstance) {
        CodOneFive.mInstance = mInstance;
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

    public int getVillage_id() {
        return village_id;
    }

    public void setVillage_id(int village_id) {
        this.village_id = village_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getChild_village() {
        return child_village;
    }

    public void setChild_village(String child_village) {
        this.child_village = child_village;
    }

    public String getChild_village_id() {
        return child_village_id;
    }

    public void setChild_village_id(String child_village_id) {
        this.child_village_id = child_village_id;
    }

    public String getDeath_place() {
        return death_place;
    }

    public void setDeath_place(String death_place) {
        this.death_place = death_place;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDeath_date() {
        return death_date;
    }

    public void setDeath_date(String death_date) {
        this.death_date = death_date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFem_health_worker() {
        return fem_health_worker;
    }

    public void setFem_health_worker(String fem_health_worker) {
        this.fem_health_worker = fem_health_worker;
    }

    public String getBirth_time() {
        return birth_time;
    }

    public void setBirth_time(String birth_time) {
        this.birth_time = birth_time;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDeath_accident() {
        return death_accident;
    }

    public void setDeath_accident(String death_accident) {
        this.death_accident = death_accident;
    }

    public String getMeasles() {
        return measles;
    }

    public void setMeasles(String measles) {
        this.measles = measles;
    }

    public String getMeasles_days() {
        return measles_days;
    }

    public void setMeasles_days(String measles_days) {
        this.measles_days = measles_days;
    }

    public String getDeath_age() {
        return death_age;
    }

    public void setDeath_age(String death_age) {
        this.death_age = death_age;
    }

    public String getMeasles_three_days() {
        return measles_three_days;
    }

    public void setMeasles_three_days(String measles_three_days) {
        this.measles_three_days = measles_three_days;
    }

    public String getMeasles_fever() {
        return measles_fever;
    }

    public void setMeasles_fever(String measles_fever) {
        this.measles_fever = measles_fever;
    }

    public String getMeasles_cough() {
        return measles_cough;
    }

    public void setMeasles_cough(String measles_cough) {
        this.measles_cough = measles_cough;
    }

    public String getMeasles_eyes() {
        return measles_eyes;
    }

    public void setMeasles_eyes(String measles_eyes) {
        this.measles_eyes = measles_eyes;
    }

    public String getMeasles_gone() {
        return measles_gone;
    }

    public void setMeasles_gone(String measles_gone) {
        this.measles_gone = measles_gone;
    }

    public String getMeasles_water() {
        return measles_water;
    }

    public void setMeasles_water(String measles_water) {
        this.measles_water = measles_water;
    }

    public String getMalntr_growth() {
        return malntr_growth;
    }

    public void setMalntr_growth(String malntr_growth) {
        this.malntr_growth = malntr_growth;
    }

    public String getMalntr_weight() {
        return malntr_weight;
    }

    public void setMalntr_weight(String malntr_weight) {
        this.malntr_weight = malntr_weight;
    }

    public String getMalntr_swelling() {
        return malntr_swelling;
    }

    public void setMalntr_swelling(String malntr_swelling) {
        this.malntr_swelling = malntr_swelling;
    }

    public String getMalntr_milk() {
        return malntr_milk;
    }

    public void setMalntr_milk(String malntr_milk) {
        this.malntr_milk = malntr_milk;
    }

    public String getMalntr_milk_bott() {
        return malntr_milk_bott;
    }

    public void setMalntr_milk_bott(String malntr_milk_bott) {
        this.malntr_milk_bott = malntr_milk_bott;
    }

    public String getMalntr_food() {
        return malntr_food;
    }

    public void setMalntr_food(String malntr_food) {
        this.malntr_food = malntr_food;
    }

    public String getMalntr_meal() {
        return malntr_meal;
    }

    public void setMalntr_meal(String malntr_meal) {
        this.malntr_meal = malntr_meal;
    }

    public String getMalntr_poop() {
        return malntr_poop;
    }

    public void setMalntr_poop(String malntr_poop) {
        this.malntr_poop = malntr_poop;
    }

    public String getMalntr_poop_times() {
        return malntr_poop_times;
    }

    public void setMalntr_poop_times(String malntr_poop_times) {
        this.malntr_poop_times = malntr_poop_times;
    }

    public String getMalntr_days() {
        return malntr_days;
    }

    public void setMalntr_days(String malntr_days) {
        this.malntr_days = malntr_days;
    }

    public String getMalntr_health() {
        return malntr_health;
    }

    public void setMalntr_health(String malntr_health) {
        this.malntr_health = malntr_health;
    }

    public String getMalntr_play() {
        return malntr_play;
    }

    public void setMalntr_play(String malntr_play) {
        this.malntr_play = malntr_play;
    }

    public String getMalntr_satvi_CHANGE() {
        return malntr_satvi_CHANGE;
    }

    public void setMalntr_satvi_CHANGE(String malntr_satvi_CHANGE) {
        this.malntr_satvi_CHANGE = malntr_satvi_CHANGE;
    }

    public String getMalntr_premature() {
        return malntr_premature;
    }

    public void setMalntr_premature(String malntr_premature) {
        this.malntr_premature = malntr_premature;
    }

    public String getBreath_cough() {
        return breath_cough;
    }

    public void setBreath_cough(String breath_cough) {
        this.breath_cough = breath_cough;
    }

    public String getBreath_asthama() {
        return breath_asthama;
    }

    public void setBreath_asthama(String breath_asthama) {
        this.breath_asthama = breath_asthama;
    }

    public String getBreath_cough_days() {
        return breath_cough_days;
    }

    public void setBreath_cough_days(String breath_cough_days) {
        this.breath_cough_days = breath_cough_days;
    }

    public String getBreath_asthama_days() {
        return breath_asthama_days;
    }

    public void setBreath_asthama_days(String breath_asthama_days) {
        this.breath_asthama_days = breath_asthama_days;
    }

    public String getBreath_mucus() {
        return breath_mucus;
    }

    public void setBreath_mucus(String breath_mucus) {
        this.breath_mucus = breath_mucus;
    }

    public String getBreath_fever() {
        return breath_fever;
    }

    public void setBreath_fever(String breath_fever) {
        this.breath_fever = breath_fever;
    }

    public String getBreath_CHANGE_kanvhavat() {
        return breath_CHANGE_kanvhavat;
    }

    public void setBreath_CHANGE_kanvhavat(String breath_CHANGE_kanvhavat) {
        this.breath_CHANGE_kanvhavat = breath_CHANGE_kanvhavat;
    }

    public String getBreath_cough_long() {
        return breath_cough_long;
    }

    public void setBreath_cough_long(String breath_cough_long) {
        this.breath_cough_long = breath_cough_long;
    }

    public String getCough_face() {
        return cough_face;
    }

    public void setCough_face(String cough_face) {
        this.cough_face = cough_face;
    }

    public String getCough_sound() {
        return cough_sound;
    }

    public void setCough_sound(String cough_sound) {
        this.cough_sound = cough_sound;
    }

    public String getCough_vomit() {
        return cough_vomit;
    }

    public void setCough_vomit(String cough_vomit) {
        this.cough_vomit = cough_vomit;
    }

    public String getCough_whoop() {
        return cough_whoop;
    }

    public void setCough_whoop(String cough_whoop) {
        this.cough_whoop = cough_whoop;
    }

    public String getCough_whoop_spread() {
        return cough_whoop_spread;
    }

    public void setCough_whoop_spread(String cough_whoop_spread) {
        this.cough_whoop_spread = cough_whoop_spread;
    }

    public String getCough_dose() {
        return cough_dose;
    }

    public void setCough_dose(String cough_dose) {
        this.cough_dose = cough_dose;
    }

    public String getDysentry_loose() {
        return dysentry_loose;
    }

    public void setDysentry_loose(String dysentry_loose) {
        this.dysentry_loose = dysentry_loose;
    }

    public String getDysentry_loose_times() {
        return dysentry_loose_times;
    }

    public void setDysentry_loose_times(String dysentry_loose_times) {
        this.dysentry_loose_times = dysentry_loose_times;
    }

    public String getDysentry_blood() {
        return dysentry_blood;
    }

    public void setDysentry_blood(String dysentry_blood) {
        this.dysentry_blood = dysentry_blood;
    }

    public String getDysentry_days() {
        return dysentry_days;
    }

    public void setDysentry_days(String dysentry_days) {
        this.dysentry_days = dysentry_days;
    }

    public String getDysentry_water() {
        return dysentry_water;
    }

    public void setDysentry_water(String dysentry_water) {
        this.dysentry_water = dysentry_water;
    }

    public String getDysentry_vomit() {
        return dysentry_vomit;
    }

    public void setDysentry_vomit(String dysentry_vomit) {
        this.dysentry_vomit = dysentry_vomit;
    }

    public String getDysentry_thirst() {
        return dysentry_thirst;
    }

    public void setDysentry_thirst(String dysentry_thirst) {
        this.dysentry_thirst = dysentry_thirst;
    }

    public String getDysentry_eyes() {
        return dysentry_eyes;
    }

    public void setDysentry_eyes(String dysentry_eyes) {
        this.dysentry_eyes = dysentry_eyes;
    }

    public String getDysentry_skull() {
        return dysentry_skull;
    }

    public void setDysentry_skull(String dysentry_skull) {
        this.dysentry_skull = dysentry_skull;
    }

    public String getDysentry_urine() {
        return dysentry_urine;
    }

    public void setDysentry_urine(String dysentry_urine) {
        this.dysentry_urine = dysentry_urine;
    }

    public String getDysentry_urine_color() {
        return dysentry_urine_color;
    }

    public void setDysentry_urine_color(String dysentry_urine_color) {
        this.dysentry_urine_color = dysentry_urine_color;
    }

    public String getDysentry_milk() {
        return dysentry_milk;
    }

    public void setDysentry_milk(String dysentry_milk) {
        this.dysentry_milk = dysentry_milk;
    }

    public String getBrain_fever() {
        return brain_fever;
    }

    public void setBrain_fever(String brain_fever) {
        this.brain_fever = brain_fever;
    }

    public String getBrain_unconsc() {
        return brain_unconsc;
    }

    public void setBrain_unconsc(String brain_unconsc) {
        this.brain_unconsc = brain_unconsc;
    }

    public String getBrain_fit() {
        return brain_fit;
    }

    public void setBrain_fit(String brain_fit) {
        this.brain_fit = brain_fit;
    }

    public String getBrain_ear() {
        return brain_ear;
    }

    public void setBrain_ear(String brain_ear) {
        this.brain_ear = brain_ear;
    }

    public String getBrain_neck() {
        return brain_neck;
    }

    public void setBrain_neck(String brain_neck) {
        this.brain_neck = brain_neck;
    }

    public String getBrain_vomit() {
        return brain_vomit;
    }

    public void setBrain_vomit(String brain_vomit) {
        this.brain_vomit = brain_vomit;
    }

    public String getBrain_CHANGE_krog() {
        return brain_CHANGE_krog;
    }

    public void setBrain_CHANGE_krog(String brain_CHANGE_krog) {
        this.brain_CHANGE_krog = brain_CHANGE_krog;
    }

    public String getBrain_milk() {
        return brain_milk;
    }

    public void setBrain_milk(String brain_milk) {
        this.brain_milk = brain_milk;
    }

    public String getBrain_teeth() {
        return brain_teeth;
    }

    public void setBrain_teeth(String brain_teeth) {
        this.brain_teeth = brain_teeth;
    }

    public String getBrain_others() {
        return brain_others;
    }

    public void setBrain_others(String brain_others) {
        this.brain_others = brain_others;
    }
}
