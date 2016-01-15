package com.example.kylehirschfelder.ship;

/**
 * Created by mayank on 1/15/16.
 */

public class CodFiveToFifteen {

    private static CodFiveToFifteen mInstance = null;

    private String familyHeadName;
    private String familyHeadCode;
    private String deathPersonName;
    private String deathPersonCode;
    private String deathMotherName;
    private String deathMotherCode;
    private String answererName;
    private String answererCode;
    private String answererRelation;
    private String answererVicinity;
    private String answererAge;
    private String answererGender;
    private String deathAge;
    private String deathGender;
    private String deathFamilyHeadRelation;
    private String deathAddress;
    private String deathDate;
    private String deathPlace;
    private String deathReason;
    private String deathAccident;
    private String deathAccidentHow;
    private String birthAppearance;
    private String lessPregnancyTime;
    private String pregnancyTime;
    private String breastFeeding;
    private String breastFeedingHalt;
    private String sickDays;
    private String fever;
    private String feverDays;
    private String feverShiver;
    private String fit;
    private String faint;
    private String stiffness;
    private String neckStiffness;
    private String diarrhea;
    private String diarrheaDays;
    private String stoolBlood;
    private String liquid;
    private String cough;
    private String coughDays;
    private String coughHow;
    private String breathProblem;
    private String breathProblemDays;
    private String breathSpeed;
    private String mucus;
    private String breathWhistle;
    private String antibiotics;
    private String stomachAche;
    private String stomachAcheWhere;
    private String stomachBloat;
    private String vomit;
    private String vomitDays;
    private String eyesYellow;
    private String skinRash;
    private String rashWhere;
    private String rashMeasles;
    private String sicklyAppearance;
    private String yellowAppearance;
    private String frequentlySick;
    private String sickTimes;
    private String symptomsAccompanied;
    private String CHANGE;
    private String BCG;
    private String polioDose;
    private String measlesInjection;
    private String writtenDescription;
    private String answererQuality;
    private String interviewerName;
    private String date;

    public CodFiveToFifteen() {

    }
    public static CodFiveToFifteen getInstance(){
        if(mInstance == null)
            mInstance = new CodFiveToFifteen();
        return mInstance;
    }

    public CodFiveToFifteen(String familyHeadName, String familyHeadCode, String deathPersonName, String deathPersonCode, String deathMotherName, String deathMotherCode, String answererName, String answererCode, String answererRelation, String answererVicinity, String answererAge, String answererGender, String deathAge, String deathFamilyHeadRelation, String deathAddress, String deathDate, String deathPlace, String deathReason, String deathAccident, String deathAccidentHow, String birthAppearance, String lessPregnancyTime, String pregnancyTime, String breastFeeding, String breastFeedingHalt, String sickDays, String fever, String feverDays, String feverShiver, String fit, String faint, String stiffness, String neckStiffness, String diarrhea, String diarrheaDays, String stoolBlood, String liquid, String cough, String coughDays, String coughHow, String breathProblem, String breathProblemDays, String breathSpeed, String mucus, String breathWhistle, String antibiotics, String stomachAche, String stomachAcheWhere, String stomachBloat, String vomit, String vomitDays, String eyesYellow, String skinRash, String rashWhere, String rashMeasles, String sicklyAppearance, String yellowAppearance, String frequentlySick, String sickTimes, String symptomsAccompanied, String CHANGE, String BCG, String polioDose, String measlesInjection, String writtenDescription, String answererQuality, String interviewerName, String date) {
        this.familyHeadName = familyHeadName;
        this.familyHeadCode = familyHeadCode;
        this.deathPersonName = deathPersonName;
        this.deathPersonCode = deathPersonCode;
        this.deathMotherName = deathMotherName;
        this.deathMotherCode = deathMotherCode;
        this.answererName = answererName;
        this.answererCode = answererCode;
        this.answererRelation = answererRelation;
        this.answererVicinity = answererVicinity;
        this.answererAge = answererAge;
        this.answererGender = answererGender;
        this.deathAge = deathAge;
        this.deathFamilyHeadRelation = deathFamilyHeadRelation;
        this.deathAddress = deathAddress;
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
        this.deathReason = deathReason;
        this.deathAccident = deathAccident;
        this.deathAccidentHow = deathAccidentHow;
        this.birthAppearance = birthAppearance;
        this.lessPregnancyTime = lessPregnancyTime;
        this.pregnancyTime = pregnancyTime;
        this.breastFeeding = breastFeeding;
        this.breastFeedingHalt = breastFeedingHalt;
        this.sickDays = sickDays;
        this.fever = fever;
        this.feverDays = feverDays;
        this.feverShiver = feverShiver;
        this.fit = fit;
        this.faint = faint;
        this.stiffness = stiffness;
        this.neckStiffness = neckStiffness;
        this.diarrhea = diarrhea;
        this.diarrheaDays = diarrheaDays;
        this.stoolBlood = stoolBlood;
        this.liquid = liquid;
        this.cough = cough;
        this.coughDays = coughDays;
        this.coughHow = coughHow;
        this.breathProblem = breathProblem;
        this.breathProblemDays = breathProblemDays;
        this.breathSpeed = breathSpeed;
        this.mucus = mucus;
        this.breathWhistle = breathWhistle;
        this.antibiotics = antibiotics;
        this.stomachAche = stomachAche;
        this.stomachAcheWhere = stomachAcheWhere;
        this.stomachBloat = stomachBloat;
        this.vomit = vomit;
        this.vomitDays = vomitDays;
        this.eyesYellow = eyesYellow;
        this.skinRash = skinRash;
        this.rashWhere = rashWhere;
        this.rashMeasles = rashMeasles;
        this.sicklyAppearance = sicklyAppearance;
        this.yellowAppearance = yellowAppearance;
        this.frequentlySick = frequentlySick;
        this.sickTimes = sickTimes;
        this.symptomsAccompanied = symptomsAccompanied;
        this.CHANGE = CHANGE;
        this.BCG = BCG;
        this.polioDose = polioDose;
        this.measlesInjection = measlesInjection;
        this.writtenDescription = writtenDescription;
        this.answererQuality = answererQuality;
        this.interviewerName = interviewerName;
        this.date = date;
    }

    public String getDeathGender() {
        return deathGender;
    }

    public void setDeathGender(String deathGender) {
        this.deathGender = deathGender;
    }

    public String getFamilyHeadName() {
        return familyHeadName;
    }

    public void setFamilyHeadName(String familyHeadName) {
        this.familyHeadName = familyHeadName;
    }

    public String getFamilyHeadCode() {
        return familyHeadCode;
    }

    public void setFamilyHeadCode(String familyHeadCode) {
        this.familyHeadCode = familyHeadCode;
    }

    public String getDeathPersonName() {
        return deathPersonName;
    }

    public void setDeathPersonName(String deathPersonName) {
        this.deathPersonName = deathPersonName;
    }

    public String getDeathPersonCode() {
        return deathPersonCode;
    }

    public void setDeathPersonCode(String deathPersonCode) {
        this.deathPersonCode = deathPersonCode;
    }

    public String getDeathMotherName() {
        return deathMotherName;
    }

    public void setDeathMotherName(String deathMotherName) {
        this.deathMotherName = deathMotherName;
    }

    public String getDeathMotherCode() {
        return deathMotherCode;
    }

    public void setDeathMotherCode(String deathMotherCode) {
        this.deathMotherCode = deathMotherCode;
    }

    public String getAnswererName() {
        return answererName;
    }

    public void setAnswererName(String answererName) {
        this.answererName = answererName;
    }

    public String getAnswererCode() {
        return answererCode;
    }

    public void setAnswererCode(String answererCode) {
        this.answererCode = answererCode;
    }

    public String getAnswererRelation() {
        return answererRelation;
    }

    public void setAnswererRelation(String answererRelation) {
        this.answererRelation = answererRelation;
    }

    public String getAnswererVicinity() {
        return answererVicinity;
    }

    public void setAnswererVicinity(String answererVicinity) {
        this.answererVicinity = answererVicinity;
    }

    public String getAnswererAge() {
        return answererAge;
    }

    public void setAnswererAge(String answererAge) {
        this.answererAge = answererAge;
    }

    public String getAnswererGender() {
        return answererGender;
    }

    public void setAnswererGender(String answererGender) {
        this.answererGender = answererGender;
    }

    public String getDeathAge() {
        return deathAge;
    }

    public void setDeathAge(String deathAge) {
        this.deathAge = deathAge;
    }

    public String getDeathFamilyHeadRelation() {
        return deathFamilyHeadRelation;
    }

    public void setDeathFamilyHeadRelation(String deathFamilyHeadRelation) {
        this.deathFamilyHeadRelation = deathFamilyHeadRelation;
    }

    public String getDeathAddress() {
        return deathAddress;
    }

    public void setDeathAddress(String deathAddress) {
        this.deathAddress = deathAddress;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    public String getDeathAccident() {
        return deathAccident;
    }

    public void setDeathAccident(String deathAccident) {
        this.deathAccident = deathAccident;
    }

    public String getDeathAccidentHow() {
        return deathAccidentHow;
    }

    public void setDeathAccidentHow(String deathAccidentHow) {
        this.deathAccidentHow = deathAccidentHow;
    }

    public String getBirthAppearance() {
        return birthAppearance;
    }

    public void setBirthAppearance(String birthAppearance) {
        this.birthAppearance = birthAppearance;
    }

    public String getLessPregnancyTime() {
        return lessPregnancyTime;
    }

    public void setLessPregnancyTime(String lessPregnancyTime) {
        this.lessPregnancyTime = lessPregnancyTime;
    }

    public String getPregnancyTime() {
        return pregnancyTime;
    }

    public void setPregnancyTime(String pregnancyTime) {
        this.pregnancyTime = pregnancyTime;
    }

    public String getBreastFeeding() {
        return breastFeeding;
    }

    public void setBreastFeeding(String breastFeeding) {
        this.breastFeeding = breastFeeding;
    }

    public String getBreastFeedingHalt() {
        return breastFeedingHalt;
    }

    public void setBreastFeedingHalt(String breastFeedingHalt) {
        this.breastFeedingHalt = breastFeedingHalt;
    }

    public String getSickDays() {
        return sickDays;
    }

    public void setSickDays(String sickDays) {
        this.sickDays = sickDays;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getFeverDays() {
        return feverDays;
    }

    public void setFeverDays(String feverDays) {
        this.feverDays = feverDays;
    }

    public String getFeverShiver() {
        return feverShiver;
    }

    public void setFeverShiver(String feverShiver) {
        this.feverShiver = feverShiver;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getFaint() {
        return faint;
    }

    public void setFaint(String faint) {
        this.faint = faint;
    }

    public String getStiffness() {
        return stiffness;
    }

    public void setStiffness(String stiffness) {
        this.stiffness = stiffness;
    }

    public String getNeckStiffness() {
        return neckStiffness;
    }

    public void setNeckStiffness(String neckStiffness) {
        this.neckStiffness = neckStiffness;
    }

    public String getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(String diarrhea) {
        this.diarrhea = diarrhea;
    }

    public String getDiarrheaDays() {
        return diarrheaDays;
    }

    public void setDiarrheaDays(String diarrheaDays) {
        this.diarrheaDays = diarrheaDays;
    }

    public String getStoolBlood() {
        return stoolBlood;
    }

    public void setStoolBlood(String stoolBlood) {
        this.stoolBlood = stoolBlood;
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getCoughDays() {
        return coughDays;
    }

    public void setCoughDays(String coughDays) {
        this.coughDays = coughDays;
    }

    public String getCoughHow() {
        return coughHow;
    }

    public void setCoughHow(String coughHow) {
        this.coughHow = coughHow;
    }

    public String getBreathProblem() {
        return breathProblem;
    }

    public void setBreathProblem(String breathProblem) {
        this.breathProblem = breathProblem;
    }

    public String getBreathProblemDays() {
        return breathProblemDays;
    }

    public void setBreathProblemDays(String breathProblemDays) {
        this.breathProblemDays = breathProblemDays;
    }

    public String getBreathSpeed() {
        return breathSpeed;
    }

    public void setBreathSpeed(String breathSpeed) {
        this.breathSpeed = breathSpeed;
    }

    public String getMucus() {
        return mucus;
    }

    public void setMucus(String mucus) {
        this.mucus = mucus;
    }

    public String getBreathWhistle() {
        return breathWhistle;
    }

    public void setBreathWhistle(String breathWhistle) {
        this.breathWhistle = breathWhistle;
    }

    public String getAntibiotics() {
        return antibiotics;
    }

    public void setAntibiotics(String antibiotics) {
        this.antibiotics = antibiotics;
    }

    public String getStomachAche() {
        return stomachAche;
    }

    public void setStomachAche(String stomachAche) {
        this.stomachAche = stomachAche;
    }

    public String getStomachAcheWhere() {
        return stomachAcheWhere;
    }

    public void setStomachAcheWhere(String stomachAcheWhere) {
        this.stomachAcheWhere = stomachAcheWhere;
    }

    public String getStomachBloat() {
        return stomachBloat;
    }

    public void setStomachBloat(String stomachBloat) {
        this.stomachBloat = stomachBloat;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit;
    }

    public String getVomitDays() {
        return vomitDays;
    }

    public void setVomitDays(String vomitDays) {
        this.vomitDays = vomitDays;
    }

    public String getEyesYellow() {
        return eyesYellow;
    }

    public void setEyesYellow(String eyesYellow) {
        this.eyesYellow = eyesYellow;
    }

    public String getSkinRash() {
        return skinRash;
    }

    public void setSkinRash(String skinRash) {
        this.skinRash = skinRash;
    }

    public String getRashWhere() {
        return rashWhere;
    }

    public void setRashWhere(String rashWhere) {
        this.rashWhere = rashWhere;
    }

    public String getRashMeasles() {
        return rashMeasles;
    }

    public void setRashMeasles(String rashMeasles) {
        this.rashMeasles = rashMeasles;
    }

    public String getSicklyAppearance() {
        return sicklyAppearance;
    }

    public void setSicklyAppearance(String sicklyAppearance) {
        this.sicklyAppearance = sicklyAppearance;
    }

    public String getYellowAppearance() {
        return yellowAppearance;
    }

    public void setYellowAppearance(String yellowAppearance) {
        this.yellowAppearance = yellowAppearance;
    }

    public String getFrequentlySick() {
        return frequentlySick;
    }

    public void setFrequentlySick(String frequentlySick) {
        this.frequentlySick = frequentlySick;
    }

    public String getSickTimes() {
        return sickTimes;
    }

    public void setSickTimes(String sickTimes) {
        this.sickTimes = sickTimes;
    }

    public String getSymptomsAccompanied() {
        return symptomsAccompanied;
    }

    public void setSymptomsAccompanied(String symptomsAccompanied) {
        this.symptomsAccompanied = symptomsAccompanied;
    }

    public String getCHANGE() {
        return CHANGE;
    }

    public void setCHANGE(String CHANGE) {
        this.CHANGE = CHANGE;
    }

    public String getBCG() {
        return BCG;
    }

    public void setBCG(String BCG) {
        this.BCG = BCG;
    }

    public String getPolioDose() {
        return polioDose;
    }

    public void setPolioDose(String polioDose) {
        this.polioDose = polioDose;
    }

    public String getMeaslesInjection() {
        return measlesInjection;
    }

    public void setMeaslesInjection(String measlesInjection) {
        this.measlesInjection = measlesInjection;
    }

    public String getWrittenDescription() {
        return writtenDescription;
    }

    public void setWrittenDescription(String writtenDescription) {
        this.writtenDescription = writtenDescription;
    }

    public String getAnswererQuality() {
        return answererQuality;
    }

    public void setAnswererQuality(String answererQuality) {
        this.answererQuality = answererQuality;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
