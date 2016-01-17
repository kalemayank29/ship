package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StillBirthForm extends AppCompatActivity {

    Context context = this;
    Spinner motherSpinner,fatherSpinner;

    EditText motherName, fatherName;
    String mother, father;

    RadioGroup genderGroup;
    RadioButton male, female;
    String gender;

    RadioGroup deathGroup;
    RadioButton home, searchHospital, nurseQuarters, PHC, other;
    String death;

    int resident = -1;

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
    TextView birthDeathText;
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
    TextView diagnosisDateText;
    String doctorDiagnosis;

    DatePicker doctorDiagnosisDatePicker;
    String doctorDiagnosisDate;

    MemberDataInterface memberDataInterface;
    Translation transalte = new Translation();
    Button save;
    int famId,curVillage;

    DeathChild child = new DeathChild();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_still_birth_form);

        memberDataInterface = new MemberDataInterface(getApplicationContext());

        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        try {
            Log.println(Log.ASSERT, "", GetDate.getDate());
            StillBirthDbHelper dbHelper = new StillBirthDbHelper(getApplicationContext());
            dbHelper.getInfo(GetDate.getDate());

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        motherName = (EditText) findViewById(R.id.motherName);
        fatherName = (EditText) findViewById(R.id.fatherName);

        DeathChildDataInterface childDataInterface = new DeathChildDataInterface(getApplicationContext());
        child = childDataInterface.getInfo(Integer.parseInt(getIntent().getStringExtra("index")));

        motherSpinner = (Spinner) findViewById(R.id.motherSpinner);
        fatherSpinner = (Spinner) findViewById(R.id.fatherSpinner);

        famId = Integer.parseInt(getIntent().getStringExtra("fam_id"));

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

        birthDeathText = (TextView) findViewById(R.id.birthDeathText);

        hoursText = (EditText) findViewById(R.id.hoursj);

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
        diagnosisDateText = (TextView) findViewById(R.id.diagnosisDateText);

        diagnosisDatePicker = (DatePicker) findViewById(R.id.diagnosisDate);

        doctorDiagnosisText = (EditText) findViewById(R.id.doctorDiagnosis);
        doctorDiagnosisDatePicker = (DatePicker) findViewById(R.id.doctorDiagnosisDate);

        save = (Button) findViewById(R.id.save);

        resident = Integer.parseInt(getIntent().getStringExtra("resident"));

        if(resident != 3) {

            try {
                List<Member> mothers = memberDataInterface.getFamilyList(famId, 1, curVillage);
                List<String> motherNames = new ArrayList<String>();
                for (Member element : mothers
                        ) {
                    if (element.getSex() == 2)
                        motherNames.add(transalte.Letter_E2M(element.getName()));
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, motherNames);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                motherSpinner.setAdapter(dataAdapter);
                List<Member> fathers = memberDataInterface.getFamilyList(famId, 1, curVillage);
                List<String> fatherNames = new ArrayList<String>();
                for (Member element : fathers
                        ) {
                    if (element.getSex() == 1)
                        fatherNames.add(transalte.Letter_E2M(element.getName()));
                }
                dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, fatherNames);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                fatherSpinner.setAdapter(dataAdapter);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            houseIdText.setText(child.getHouseID());
            familyIdText.setText(child.getFamilyID());
        }

        else {
            motherName.setVisibility(View.VISIBLE);
            fatherName.setVisibility(View.VISIBLE);
            motherSpinner.setVisibility(View.GONE);
            fatherSpinner.setVisibility(View.GONE);
            houseIdText.setText("-1");
            familyIdText.setText("-1");
        }




        childVillageText.setText(transalte.Letter_E2M(child.getVillageOfBirth()));
        childVillageIdText.setText(child.getVillageOfBirthID());
        deathVillageText.setText(transalte.Letter_E2M(child.getVillageOfDeath()));
        deathVillageIdText.setText(child.getVillageOfDeathID());
        birthDeathText.setText(transalte.Number_E2M(child.getBirthDate()));
        diagnosisDateText.setText(transalte.Number_E2M(GetDate.getDate()));




        // Creating adapter for spinner




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StillBirth stillBirth = new StillBirth();
                if(motherSpinner.getVisibility() == View.GONE) {
                    mother = motherName.getText().toString();
                    father = fatherName.getText().toString();
                }
                else {
                    mother = motherSpinner.getSelectedItem().toString();
                    father = fatherName.getText().toString();
                }
                stillBirth.setMother(mother);
                stillBirth.setFather(father);
                stillBirth.setChildVillage(child.getVillageOfBirth());
                stillBirth.setChildVillageId(child.getVillageOfBirthID());
                stillBirth.setDeathVillage(child.getVillageOfDeath());
                stillBirth.setDeathVillageId(child.getVillageOfDeathID());
                otherDeathVillage = otherDeathVillageText.getText().toString();
                stillBirth.setOtherDeathVillage(otherDeathVillage);
                stillBirth.setHouseId(child.getHouseID());
                stillBirth.setFamilyId(child.getFamilyID());
                howChildDied = howChildDiedText.getText().toString();
                stillBirth.setHowChildDied(howChildDied);
  //              hoursAlive = hoursText.getText().toString();
                stillBirth.setHoursAlive("0");
                diagnosis = diagnosisText.getText().toString();
                stillBirth.setDiagnosis(diagnosis);
                doctorDiagnosis = doctorDiagnosisText.getText().toString();
                stillBirth.setDoctorDiagnosis(doctorDiagnosis);
                stillBirth.setBirthDeathDate(child.getBirthDate());
                diagnosisDate = GetDate.getDate();
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
//
//                Intent intent = new Intent(getBaseContext(), PNMForm_ask.class);
//                startActivity(intent);
                finish();
            }
        });

    }

    public void select(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.male:
                if(checked) {
                    gender = "0";
                }
                else
                    gender = "1";
                break;
            case R.id.female:
                if(checked) {
                    gender = "0";
                }
                else {
                    gender = "1";
                }
                break;

            case R.id.home:
                if(checked) {
                    death = "0";
                }
                break;
            case R.id.searchHospital:
                if(checked) {
                    death = "1";
                }
                break;
            case R.id.nurseQuarters:
                if(checked) {
                    death = "2";
                }
                break;
            case R.id.PHC:
                if(checked) {
                    death = "3";
                }
                break;
            case R.id.other:
                if(checked) {
                    death = "4";
                }
                break;

            case R.id.less7:
                if(checked) {
                    pregnancyMonths = "0";
                }
                break;
            case R.id.m7:
                if(checked) {
                    pregnancyMonths = "1";

                }
                break;
            case R.id.m8:
                if(checked) {
                    pregnancyMonths = "2";
                }
                break;
            case R.id.m8d21:
                if(checked) {
                    pregnancyMonths = "3";

                }
                break;
            case R.id.m9:
                if(checked) {
                    pregnancyMonths = "4";
                }
                break;
            case R.id.doNotKnow:
                if(checked) {
                    pregnancyMonths = "5";
                }
                break;

            case R.id.homeBirth:
                if(checked) {
                    birthPlace = "0";
                }
                break;
            case R.id.hospitalBirth:
                if(checked) {
                    birthPlace = "1";
                }
                break;
            case R.id.roadBirth:
                if(checked) {
                    birthPlace = "2";
                }
                break;
            case R.id.otherBirth:
                if(checked) {
                    birthPlace = "3";
                }
                break;

            case R.id.midwife:
                if(checked) {
                    birthWhom = "0";
                }
                break;
            case R.id.relatives:
                if(checked) {
                    birthWhom = "1";
                }
                break;
            case R.id.nurse:
                if(checked) {
                    birthWhom = "2";
                }
                break;
            case R.id.doctor:
                if(checked) {
                    birthWhom = "3";
                }
                break;
            case R.id.others:
                if(checked) {
                    birthWhom = "4";
                }
                break;

            case R.id.aliveYes:
                if(checked) {
                    alive = "0";
                }
                else
                    alive = "1";
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
                    appearance = "0";
                }
                break;
            case R.id.healthy:
                if(checked) {
                    appearance = "1";
                }
                break;
        }

    }

}
