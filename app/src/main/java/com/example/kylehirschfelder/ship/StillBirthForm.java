package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class StillBirthForm extends AppCompatActivity {

    Context context = this;

    EditText motherName, fatherName;
    String mother, father;

    RadioGroup genderGroup;
    RadioButton male, female;
    String gender;

    RadioGroup deathGroup;
    RadioButton home, searchHospital, nurseQuarters, PHC, other;
    String death;

    EditText childVillageText;
    String childVillage;
    EditText childVillageIdText;
    String childVillageId;
    EditText deathVillageText;
    String deathVillage;
    EditText deathVillageIdText;
    String deathVillageId;

    EditText otherDeathVillageText;
    String otherDeathVillage;
    EditText houseIdText;
    String houseId;
    EditText familyIdText;
    String familyId;

    DatePicker birthDeathDatePicker;
    String birthDeathDate;

    EditText hoursText;
    String hoursAlive;

    RadioGroup pregnancyGroup;
    RadioButton less7, m7, m8, m8d21, m9, doNotKnow;
    String pregnancyMonths;

    RadioGroup birthPlaceGroup;
    RadioButton homeBirth, hospitalBirth, roadBirth, otherBirth;
    String birthPlace;

    RadioGroup birthGroup;
    RadioButton midwife, relatives, nurse, doctor, others;
    String birthWhom;

    RadioGroup aliveGroup;
    RadioButton aliveYes, aliveNo;
    String alive;

    RadioGroup appearanceGroup;
    RadioButton wrinkled, healthy;
    String appearance;

    EditText howChildDiedText;
    String howChildDied;

    EditText diagnosisText;
    String diagnosis;

    DatePicker diagnosisDatePicker;
    String diagnosisDate;

    EditText doctorDiagnosisText;
    String doctorDiagnosis;

    DatePicker doctorDiagnosisDatePicker;
    String doctorDiagnosisDate;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_still_birth_form);

        motherName = (EditText) findViewById(R.id.motherName);
        fatherName = (EditText) findViewById(R.id.fatherName);

        genderGroup = (RadioGroup) findViewById(R.id.gender);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        deathGroup = (RadioGroup) findViewById(R.id.deathGroup);
        home = (RadioButton) findViewById(R.id.home);
        searchHospital = (RadioButton) findViewById(R.id.searchHospital);
        nurseQuarters = (RadioButton) findViewById(R.id.nurseQuarters);
        PHC = (RadioButton) findViewById(R.id.PHC);
        other = (RadioButton) findViewById(R.id.other);

        childVillageText = (EditText) findViewById(R.id.childVillageName);
        childVillageIdText = (EditText) findViewById(R.id.childVillageId);
        deathVillageText = (EditText) findViewById(R.id.deathVillageName);
        deathVillageIdText = (EditText) findViewById(R.id.deathVillageId);
        otherDeathVillageText = (EditText) findViewById(R.id.otherDeathVillage);
        houseIdText = (EditText) findViewById(R.id.HouseId);
        familyIdText = (EditText) findViewById(R.id.FamilyId);

        birthDeathDatePicker = (DatePicker) findViewById(R.id.birthDeathDate);

        hoursText = (EditText) findViewById(R.id.hours);

        pregnancyGroup = (RadioGroup) findViewById(R.id.pregnancyGroup);
        less7 = (RadioButton) findViewById(R.id.less7);
        m7 = (RadioButton) findViewById(R.id.m7);
        m8 = (RadioButton) findViewById(R.id.m8);
        m8d21 = (RadioButton) findViewById(R.id.m8d21);
        m9 = (RadioButton) findViewById(R.id.m9);
        doNotKnow = (RadioButton) findViewById(R.id.doNotKnow);

        birthPlaceGroup = (RadioGroup) findViewById(R.id.birthPlaceGroup);
        homeBirth = (RadioButton) findViewById(R.id.homeBirth);
        hospitalBirth = (RadioButton) findViewById(R.id.hospitalBirth);
        roadBirth = (RadioButton) findViewById(R.id.roadBirth);
        otherBirth = (RadioButton) findViewById(R.id.otherBirth);

        birthGroup = (RadioGroup) findViewById(R.id.birthGroup);
        midwife = (RadioButton) findViewById(R.id.midwife);
        relatives = (RadioButton) findViewById(R.id.relatives);
        nurse = (RadioButton) findViewById(R.id.nurse);
        doctor = (RadioButton) findViewById(R.id.doctor);
        others = (RadioButton) findViewById(R.id.others);

        aliveGroup = (RadioGroup) findViewById(R.id.aliveGroup);
        aliveYes = (RadioButton) findViewById(R.id.aliveYes);
        aliveNo = (RadioButton) findViewById(R.id.aliveNo);

        appearanceGroup = (RadioGroup) findViewById(R.id.appearanceGroup);
        wrinkled = (RadioButton) findViewById(R.id.wrinkled);
        healthy = (RadioButton) findViewById(R.id.healthy);

        howChildDiedText = (EditText) findViewById(R.id.howChildDied);

        diagnosisText = (EditText) findViewById(R.id.diagnosis);
        diagnosisDatePicker = (DatePicker) findViewById(R.id.diagnosisDate);

        doctorDiagnosisText = (EditText) findViewById(R.id.doctorDiagnosis);
        doctorDiagnosisDatePicker = (DatePicker) findViewById(R.id.doctorDiagnosisDate);

        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StillBirth stillBirth = new StillBirth();
                mother = motherName.getText().toString();
                stillBirth.setMother(mother);
                father = fatherName.getText().toString();
                stillBirth.setFather(father);
                childVillage = childVillageText.getText().toString();
                stillBirth.setChildVillage(childVillage);
                childVillageId = childVillageIdText.getText().toString();
                stillBirth.setChildVillageId(childVillageId);
                deathVillage = deathVillageText.getText().toString();
                stillBirth.setDeathVillage(deathVillage);
                deathVillageId = deathVillageIdText.getText().toString();
                stillBirth.setDeathVillageId(deathVillageId);
                otherDeathVillage = otherDeathVillageText.getText().toString();
                stillBirth.setOtherDeathVillage(otherDeathVillage);
                houseId = houseIdText.getText().toString();
                stillBirth.setHouseId(houseId);
                familyId = familyIdText.getText().toString();
                stillBirth.setFamilyId(familyId);
                howChildDied = howChildDiedText.getText().toString();
                stillBirth.setHowChildDied(howChildDied);
                hoursAlive = hoursText.getText().toString();
                stillBirth.setHoursAlive(hoursAlive);
                diagnosis = diagnosisText.getText().toString();
                stillBirth.setDiagnosis(diagnosis);
                doctorDiagnosis = doctorDiagnosisText.getText().toString();
                stillBirth.setDoctorDiagnosis(doctorDiagnosis);
                birthDeathDate = birthDeathDatePicker.getDayOfMonth() + "-" + (birthDeathDatePicker.getMonth() + 1) + "-" + birthDeathDatePicker.getYear();
                stillBirth.setBirthDeathDate(birthDeathDate);
                Log.println(Log.ASSERT, "Correct?", stillBirth.getBirthDeathDate());
                diagnosisDate = diagnosisDatePicker.getDayOfMonth() + "-" + (diagnosisDatePicker.getMonth() + 1) + "-" + diagnosisDatePicker.getYear();
                stillBirth.setDiagnosisDate(diagnosisDate);
                doctorDiagnosisDate = doctorDiagnosisDatePicker.getDayOfMonth() + "-" + (doctorDiagnosisDatePicker.getMonth() + 1) + "-" + doctorDiagnosisDatePicker.getYear();
                stillBirth.setDoctorDiagnosisDate(doctorDiagnosisDate);

                stillBirth.setGender(gender);
                stillBirth.setDeath(death);
                stillBirth.setPregnancyMonths(pregnancyMonths);
                stillBirth.setBirthPlace(birthPlace);
                stillBirth.setBirthWhom(birthWhom);
                stillBirth.setAlive(alive);
                stillBirth.setAppearance(appearance);
                StillBirthDbHelper stillBirthDbHelper = new StillBirthDbHelper(context);
                stillBirthDbHelper.insert(stillBirth);
//                stillBirth = stillBirthDbHelper.getInfo(birthDeathDate);
  //              Log.println(Log.ASSERT, "Correct?", stillBirth.getBirthDeathDate());

                Intent intent = new Intent(getBaseContext(), PNMForm_ask.class);
                startActivity(intent);
            }
        });

    }

    public void select(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.male:
                if(checked) {
                    gender = "M";
                }
                else
                    gender = "F";
                break;
            case R.id.female:
                if(checked) {
                    gender = "F";
                }
                else {
                    gender = "M";
                }
                break;

            case R.id.home:
                if(checked) {
                    death = "10000";
                }
                break;
            case R.id.searchHospital:
                if(checked) {
                    death = "01000";
                }
                break;
            case R.id.nurseQuarters:
                if(checked) {
                    death = "00100";
                }
                break;
            case R.id.PHC:
                if(checked) {
                    death = "00010";
                }
                break;
            case R.id.other:
                if(checked) {
                    death = "00001";
                }
                break;

            case R.id.less7:
                if(checked) {
                    pregnancyMonths = "100000";
                }
                break;
            case R.id.m7:
                if(checked) {
                    pregnancyMonths = "010000";

                }
                break;
            case R.id.m8:
                if(checked) {
                    pregnancyMonths = "001000";
                }
                break;
            case R.id.m8d21:
                if(checked) {
                    pregnancyMonths = "000100";

                }
                break;
            case R.id.m9:
                if(checked) {
                    pregnancyMonths = "000010";
                }
                break;
            case R.id.doNotKnow:
                if(checked) {
                    pregnancyMonths = "000001";
                }
                break;

            case R.id.homeBirth:
                if(checked) {
                    birthPlace = "1000";
                }
                break;
            case R.id.hospitalBirth:
                if(checked) {
                    birthPlace = "0100";
                }
                break;
            case R.id.roadBirth:
                if(checked) {
                    birthPlace = "0010";
                }
                break;
            case R.id.otherBirth:
                if(checked) {
                    birthPlace = "0001";
                }
                break;

            case R.id.midwife:
                if(checked) {
                    birthWhom = "10000";
                }
                break;
            case R.id.relatives:
                if(checked) {
                    birthWhom = "10000";
                }
                break;
            case R.id.nurse:
                if(checked) {
                    birthWhom = "10000";
                }
                break;
            case R.id.doctor:
                if(checked) {
                    birthWhom = "10000";
                }
                break;
            case R.id.others:
                if(checked) {
                    birthWhom = "10000";
                }
                break;

            case R.id.aliveYes:
                if(checked) {
                    alive = "1";
                }
                else
                    alive = "0";
                break;
            case R.id.aliveNo:
                if(checked) {
                    alive = "0";
                }
                else
                    alive = "1";
                break;

            case R.id.wrinkled:
                if(checked) {
                    appearance = "1";
                }
                break;
            case R.id.healthy:
                if(checked) {
                    appearance = "0";
                }
                break;
        }

    }

}
