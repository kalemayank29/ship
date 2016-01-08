package com.example.kylehirschfelder.ship;

/**
 * Created by poorwa on 11/8/15.
 */
public class Birth {

        private String motherVillage, motherVillageID, motherName, familyID, houseID, childID, birthDate, memberId,
                villageOfBirth, villageOfBirthID, villageOfBirthPlace,  deliveryName, deliveryMethod, childGender, pregnancyTime,
                fadPresence, healthMessenger, healthMessengerId, healthMessengerDate, guideName, guideId, guideTestDate, villageId;

        public Birth() {

        }

        public Birth(String motherVillage, String motherVillageID, String motherName, String familyID, String houseID,
                     String childID, String birthDate, String villageOfBirth, String villageOfBirthID, String villageOfBirthPlace,
                     String deliveryName, String deliveryMethod, String childGender, String pregnancyTime,
                     String fadPresence, String healthMessenger, String healthMessengerId, String healthMessengerDate,
                     String guideName, String guideId, String guideTestDate,String villageId) {

            this.motherVillage = motherVillage;
            this.motherVillageID = motherVillageID;
            this.motherName = motherName;
            this.familyID = familyID;
            this.houseID = houseID;
            this.childID = childID;
            this.birthDate = birthDate;
            this.villageOfBirth = villageOfBirth;
            this.villageOfBirthID = villageOfBirthID;
            this.villageOfBirthPlace = villageOfBirthPlace;
            this.deliveryName = deliveryName;
            this.deliveryMethod = deliveryMethod;
            this.childGender = childGender;
            this.pregnancyTime = pregnancyTime;
            this.fadPresence = fadPresence;
            this.healthMessenger = healthMessenger;
            this.healthMessengerId = healthMessengerId;
            this.healthMessengerDate = healthMessengerDate;
            this.guideName = guideName;
            this.guideId = guideId;
            this.guideTestDate = guideTestDate;
            this.villageId = villageId;
        }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMotherVillage() {
            return motherVillage;
        }

        public void setMotherVillage(String motherVillage) {
            this.motherVillage = motherVillage;
        }

        public String getMotherVillageID() {
            return motherVillageID;
        }

        public void setMotherVillageID(String motherVillageID) {
            this.motherVillageID = motherVillageID;
        }

        public String getMotherName() {
            return motherName;
        }

        public void setMotherName(String motherName) {
            this.motherName = motherName;
        }

        public String getFamilyID() {
            return familyID;
        }

        public void setFamilyID(String familyID) {
            this.familyID = familyID;
        }
        public String getHouseID() {
            return houseID;
        }

        public void setHouseID(String houseID) {
            this.houseID = houseID;
        }

        public String getChildID() {
            return childID;
        }

        public void setChildID(String childID) {
            this.childID = childID;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getVillageOfBirth() {
            return villageOfBirth;
        }

        public void setVillageOfBirth(String villageOfBirth) {
            this.villageOfBirth = villageOfBirth;
        }

        public String getVillageOfBirthID() {
            return villageOfBirthID;
        }

        public void setVillageOfBirthID(String villageOfBirthID) {
            this.villageOfBirthID = villageOfBirthID;
        }

        public String getVillageOfBirthPlace() {
            return villageOfBirthPlace;
        }

        public void setVillageOfBirthPlace(String villageOfBirthPlace) {
            this.villageOfBirthPlace = villageOfBirthPlace;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        public void setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
        }

        public String getDeliveryMethod() {
            return deliveryMethod;
        }

        public void setDeliveryMethod(String deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
        }

        public String getChildGender() {
            return childGender;
        }

        public void setChildGender(String childGender) {
            this.childGender = childGender;
        }

        public String getPregnancyTime() {
            return pregnancyTime;
        }

        public void setPregnancyTime(String pregnancyTime) {
            this.pregnancyTime = pregnancyTime;
        }

        public String getFadPresence() {
            return fadPresence;
        }

        public void setFadPresence(String fadPresence) {
            this.fadPresence = fadPresence;
        }


        public String getHealthMessenger() {
            return healthMessenger;
        }

        public void setHealthMessenger(String healthMessenger) {
            this.healthMessenger = healthMessenger;
        }

        public String getHealthMessengerId() {
            return healthMessengerId;
        }

        public void setHealthMessengerId(String healthMessengerId) {
            this.healthMessengerId = healthMessengerId;
        }

        public String getHealthMessengerDate() {
            return healthMessengerDate;
        }

        public void setHealthMessengerDate(String healthMessengerDate) {
            this.healthMessengerDate = healthMessengerDate;
        }


        public String getGuideName() {
            return guideName;
        }

        public void setGuideName(String guideName) {
            this.guideName = guideName;
        }

        public String getGuideId() {
            return guideId;
        }

        public void setGuideId(String guideId) {
            this.guideId = guideId;
        }

        public String getGuideTestDate() {
            return guideTestDate;
        }

        public void setGuideTestDate(String guideTestDate) {
            this.guideTestDate = guideTestDate;
        }

}
