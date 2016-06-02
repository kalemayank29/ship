package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by poorwa on 12/1/16.
 */
public class CodFifteenForm extends AppCompatActivity {

    EditText familyHeadName, villageName, houseId, familyId, deathName,
    informantName, informantRelation, informantAge,
    deathAge, deathFamilyHeadRelation, deathAddress, deathAddressTime, supervisorName,
    informantDiagnosis, routineMedicine, deathSmokingDays, deathAlcoholDays, informantDetails;

    Spinner marriageStatus, education, deathPlace;
    ArrayAdapter marriageAdapter, educationAdapter, deathAdapter;

    Context context = this;

    RadioGroup informantGender, workOutside, workOutsideTime, bloodPressure,
    heartProblem, paralysis, diabetes, typhoid, AIDS, cancer, asthma, otherIllness, informantVicinity,
    extremeWeightLoss, deathSmoking, deathHookah, deathTobacco, deathBrushTeeth, deathAlcohol,
    deathNonVeg, informantSmoking, informantHookah, informantTobacco, informantBrushTeeth,
    informantAlcohol, informantNonVeg, deathPregnant,
    death42Birth, death42Pregnant, deathGender, informantQuality;

    String dbPregnant = "-1", db42Birth = "-1", db42Pregnant = "-1";

    TextView deathDate, date;

    LinearLayout womenLayout;



    Date d;

    TextView dateOfForm;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_fifteen);

        familyHeadName = (EditText) findViewById(R.id.familyHeadName);

        villageName = (EditText) findViewById(R.id. villageName);

        houseId = (EditText) findViewById(R.id. houseId);

        familyId = (EditText) findViewById(R.id. familyId);

        deathName = (EditText) findViewById(R.id. deathName);

        informantName = (EditText) findViewById(R.id. informantName);

        informantRelation = (EditText) findViewById(R.id. informantRelation);

        informantAge = (EditText) findViewById(R.id. informantAge);

        deathAge = (EditText) findViewById(R.id. deathAge);

        deathFamilyHeadRelation = (EditText) findViewById(R.id. deathFamilyHeadRelation);

        deathAddress = (EditText) findViewById(R.id. deathAddress);

        deathAddressTime = (EditText) findViewById(R.id. deathAddressTime);

        informantDiagnosis = (EditText) findViewById(R.id. informantDiagnosis);

        routineMedicine = (EditText) findViewById(R.id. routineMedicine);

        deathSmokingDays = (EditText) findViewById(R.id. deathSmokingDays);

        deathGender = (RadioGroup) findViewById(R.id.deathGender);

        marriageStatus = (Spinner) findViewById(R.id.marriageStatus);
        marriageAdapter = ArrayAdapter.createFromResource(context, R.array.marriage_array, android.R.layout.simple_spinner_dropdown_item);
        marriageStatus.setAdapter(marriageAdapter);

        education = (Spinner) findViewById(R.id.education);
        educationAdapter = ArrayAdapter.createFromResource(context, R.array.education_array, android.R.layout.simple_spinner_dropdown_item);
        education.setAdapter(educationAdapter);

        deathPlace = (Spinner) findViewById(R.id.deathPlace);
        deathAdapter = ArrayAdapter.createFromResource(context, R.array.death_place_array, android.R.layout.simple_spinner_dropdown_item);
        deathPlace.setAdapter(deathAdapter);

        familyHeadName = (EditText) findViewById(R.id.familyHeadName);

        villageName = (EditText) findViewById(R.id. villageName);

        houseId = (EditText) findViewById(R.id. houseId);

        familyId = (EditText) findViewById(R.id. familyId);

        deathName = (EditText) findViewById(R.id. deathName);

        informantName = (EditText) findViewById(R.id. informantName);

        informantRelation = (EditText) findViewById(R.id. informantRelation);

        informantAge = (EditText) findViewById(R.id. informantAge);

        deathAge = (EditText) findViewById(R.id. deathAge);

        deathFamilyHeadRelation = (EditText) findViewById(R.id. deathFamilyHeadRelation);

        deathAddress = (EditText) findViewById(R.id. deathAddress);

        deathAddressTime = (EditText) findViewById(R.id. deathAddressTime);

        informantDiagnosis = (EditText) findViewById(R.id. informantDiagnosis);

        routineMedicine = (EditText) findViewById(R.id. routineMedicine);

        deathSmokingDays
                = (EditText) findViewById(R.id. deathSmokingDays
        );

        marriageStatus = (Spinner) findViewById(R.id.marriageStatus);

        education = (Spinner) findViewById(R.id. education);

        deathPlace
                = (Spinner) findViewById(R.id. deathPlace
        );

        informantGender = (RadioGroup) findViewById(R.id.informantGender);

        workOutside = (RadioGroup) findViewById(R.id.workOutside);

        workOutsideTime = (RadioGroup) findViewById(R.id.workOutsideTime);

        bloodPressure = (RadioGroup) findViewById(R.id.bloodPressure);

        heartProblem = (RadioGroup) findViewById(R.id.heartProblem);

        paralysis = (RadioGroup) findViewById(R.id.paralysis);

        diabetes = (RadioGroup) findViewById(R.id.diabetes);

        typhoid = (RadioGroup) findViewById(R.id.typhoid);

        AIDS = (RadioGroup) findViewById(R.id.AIDS);

        cancer = (RadioGroup) findViewById(R.id.cancer);

        asthma = (RadioGroup) findViewById(R.id.asthma);

        otherIllness = (RadioGroup) findViewById(R.id.otherIllness);

        informantVicinity = (RadioGroup) findViewById(R.id.informantVicinity);

        extremeWeightLoss = (RadioGroup) findViewById(R.id.extremeWeightLoss);

        deathSmoking = (RadioGroup) findViewById(R.id.deathSmoking);

        deathHookah = (RadioGroup) findViewById(R.id.deathHookah);

        deathTobacco = (RadioGroup) findViewById(R.id.deathTobacco);

        deathBrushTeeth = (RadioGroup) findViewById(R.id.deathBrushTeeth);

        deathAlcohol = (RadioGroup) findViewById(R.id.deathAlcohol);

        deathAlcoholDays = (EditText) findViewById(R.id.deathAlcoholDays);

        deathNonVeg = (RadioGroup) findViewById(R.id.deathNonVeg);

        informantSmoking = (RadioGroup) findViewById(R.id.informantSmoking);

        informantHookah = (RadioGroup) findViewById(R.id.informantHookah);

        informantTobacco = (RadioGroup) findViewById(R.id.informantTobacco);

        informantBrushTeeth = (RadioGroup) findViewById(R.id.informantBrushTeeth);

        informantAlcohol = (RadioGroup) findViewById(R.id.informantAlcohol);

        informantNonVeg = (RadioGroup) findViewById(R.id.informantNonVeg);

        deathPregnant = (RadioGroup) findViewById(R.id.deathPregnant);

        death42Birth = (RadioGroup) findViewById(R.id.death42Birth);

        death42Pregnant = (RadioGroup) findViewById(R.id.death42Pregnant);

        informantDetails = (EditText) findViewById(R.id.informantDetails);

        dateOfForm = (TextView) findViewById(R.id.dateOfForm);

        deathDate = (TextView) findViewById(R.id.deathDate);
        date = (TextView) findViewById(R.id.date);
        supervisorName = (EditText) findViewById(R.id.supervisorName);
        informantQuality = (RadioGroup) findViewById(R.id.informantQuality);

        womenLayout = (LinearLayout) findViewById(R.id.womenLayout);

        save = (Button) findViewById(R.id.saveButton);

        d = new Date();
        Translation translation = new Translation();
        final SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        dateOfForm.setText(translation.Number_E2M(dateFormat.format(d)));
        deathDate.setText(translation.Number_E2M(dateFormat.format(d)));
        date.setText(translation.Number_E2M(dateFormat.format(d)));

        deathGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (deathAge.getText().toString().isEmpty()) {
                    Toast.makeText(context, "Fill Age First", Toast.LENGTH_SHORT).show();
                    radioGroup.clearCheck();
                } else {
                    if (deathGender.indexOfChild(findViewById(deathGender.getCheckedRadioButtonId())) == 1) {
                        if (Integer.parseInt(deathAge.getText().toString()) > 14 && Integer.parseInt(deathAge.getText().toString()) < 50) {
                            womenLayout.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CodFifteen cod15 = new CodFifteen();
                // familyHeadName
                cod15.setFamilyHeadName("X");
                // villageName
                cod15.setVillageName("X");
                // houseId
                cod15.setHouseId("X");
                // familyId
                cod15.setFamilyId("1");
                // deathName
                cod15.setDeathName("X");
                cod15.setFormDate(dateFormat.format(d));
                cod15.setInformantName(informantName.getText().toString());
                cod15.setInformantRelation(informantRelation.getText().toString());
                cod15.setInformantVicinity(String.valueOf(informantVicinity.indexOfChild(findViewById(informantVicinity.getCheckedRadioButtonId()))));
                cod15.setInformantAge(informantAge.getText().toString());
                cod15.setInformantGender(String.valueOf(informantGender.indexOfChild(findViewById(informantGender.getCheckedRadioButtonId()))));
                cod15.setDeathAge(deathAge.getText().toString());
                // deathGender
                cod15.setDeathGender("0");
                cod15.setMarriageStatus(String.valueOf(marriageStatus.getSelectedItemPosition()));
                cod15.setWorkOutside(String.valueOf(workOutside.indexOfChild(findViewById(workOutside.getCheckedRadioButtonId()))));
                cod15.setWorkOutsideTime(String.valueOf(workOutsideTime.indexOfChild(findViewById(workOutsideTime.getCheckedRadioButtonId()))));
                // deathDate
                cod15.setEducation(String.valueOf(education.getSelectedItemPosition()));
                cod15.setDeathFamilyHeadRelation(deathFamilyHeadRelation.getText().toString());
                cod15.setDeathDate("X");
                cod15.setDeathPlace(String.valueOf(deathPlace.getSelectedItemPosition()));
                cod15.setDeathAddress(deathAddress.getText().toString());
                cod15.setDeathAddressTime(deathAddressTime.getText().toString());
                cod15.setInformantDiagnosis(informantDiagnosis.getText().toString());
                cod15.setBloodPressure(String.valueOf(bloodPressure.indexOfChild(findViewById(bloodPressure.getCheckedRadioButtonId()))));
                cod15.setHeartProblem(String.valueOf(heartProblem.indexOfChild(findViewById(heartProblem.getCheckedRadioButtonId()))));
                cod15.setParalysis(String.valueOf(paralysis.indexOfChild(findViewById(paralysis.getCheckedRadioButtonId()))));
                cod15.setDiabetes(String.valueOf(diabetes.indexOfChild(findViewById(diabetes.getCheckedRadioButtonId()))));
                cod15.setTyphoid(String.valueOf(typhoid.indexOfChild(findViewById(typhoid.getCheckedRadioButtonId()))));
                cod15.setAIDS(String.valueOf(AIDS.indexOfChild(findViewById(AIDS.getCheckedRadioButtonId()))));
                cod15.setCancer(String.valueOf(cancer.indexOfChild(findViewById(cancer.getCheckedRadioButtonId()))));
                cod15.setAsthma(String.valueOf(asthma.indexOfChild(findViewById(asthma.getCheckedRadioButtonId()))));
                cod15.setOtherIllness(String.valueOf(otherIllness.indexOfChild(findViewById(otherIllness.getCheckedRadioButtonId()))));
                cod15.setExtremeWeightLoss(String.valueOf(extremeWeightLoss.indexOfChild(findViewById(extremeWeightLoss.getCheckedRadioButtonId()))));
                cod15.setRoutineMedicine(routineMedicine.getText().toString());
                cod15.setDeathSmoking(String.valueOf(deathSmoking.indexOfChild(findViewById(deathSmoking.getCheckedRadioButtonId()))));
                cod15.setInformantSmoking(String.valueOf(informantSmoking.indexOfChild(findViewById(informantSmoking.getCheckedRadioButtonId()))));
                cod15.setDeathSmokingDays(deathSmokingDays.getText().toString());
                cod15.setDeathHookah(String.valueOf(deathHookah.indexOfChild(findViewById(deathHookah.getCheckedRadioButtonId()))));
                cod15.setInformantHookah(String.valueOf(informantHookah.indexOfChild(findViewById(informantHookah.getCheckedRadioButtonId()))));
                cod15.setDeathTobacco(String.valueOf(deathTobacco.indexOfChild(findViewById(deathTobacco.getCheckedRadioButtonId()))));
                cod15.setInformantTobacco(String.valueOf(informantTobacco.indexOfChild(findViewById(informantTobacco.getCheckedRadioButtonId()))));
                cod15.setDeathBrushTeeth(String.valueOf(deathBrushTeeth.indexOfChild(findViewById(deathBrushTeeth.getCheckedRadioButtonId()))));
                cod15.setInformantBrushTeeth(String.valueOf(informantBrushTeeth.indexOfChild(findViewById(informantBrushTeeth.getCheckedRadioButtonId()))));
                cod15.setDeathAlcohol(String.valueOf(deathAlcohol.indexOfChild(findViewById(deathAlcohol.getCheckedRadioButtonId()))));
                cod15.setInformantAlcohol(String.valueOf(informantAlcohol.indexOfChild(findViewById(informantAlcohol.getCheckedRadioButtonId()))));
                cod15.setDeathAlcoholDays(deathAlcoholDays.getText().toString());
                cod15.setDeathNonVeg(String.valueOf(deathNonVeg.indexOfChild(findViewById(deathNonVeg.getCheckedRadioButtonId()))));
                cod15.setInformantNonVeg(String.valueOf(informantNonVeg.indexOfChild(findViewById(informantNonVeg.getCheckedRadioButtonId()))));
                if (womenLayout.getVisibility() == View.VISIBLE) {
                    dbPregnant = (String.valueOf(deathPregnant.indexOfChild(findViewById(deathPregnant.getCheckedRadioButtonId()))));
                    db42Birth = (String.valueOf(death42Birth.indexOfChild(findViewById(death42Birth.getCheckedRadioButtonId()))));
                    db42Pregnant = String.valueOf(death42Pregnant.indexOfChild(findViewById(death42Pregnant.getCheckedRadioButtonId())));
                }
                cod15.setDeathPregnant(dbPregnant);
                cod15.setDeath42Birth(db42Birth);
                cod15.setDeath42Pregnant(db42Pregnant);
                cod15.setInformantDetails(informantDetails.getText().toString());
                cod15.setInformantQuality(String.valueOf(informantQuality.indexOfChild(findViewById(informantQuality.getCheckedRadioButtonId()))));
                cod15.setSupervisorName(String.valueOf(supervisorName.getText()));
                cod15.setDate(dateFormat.format(d));

                CodFifteenDBHelper cod15db = new CodFifteenDBHelper(context);
                cod15db.insert(cod15);

                Intent intent = new Intent(context, CodFifteenView.class);
                startActivity(intent);


            }
        });


    }
}
