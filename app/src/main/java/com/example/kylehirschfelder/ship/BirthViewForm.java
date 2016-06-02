package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BirthViewForm extends AppCompatActivity {

  //  int id;
    Translation TR = new Translation();

    TextView spinner1, spinner2, spinner3, spinner4;
    Spinner villageBlockSpinner, villageNameSpinner, villageOfBirthBlockSpinner, villageOfBirthSpinner;
    EditText deliveryName, healthMessenger, healthMessengerID, guideName, guideId,motherName;
    RadioButton[] villageOfBirthPlace = new RadioButton[6], pregnancyTime = new RadioButton[6], fadPresence = new RadioButton[2],
            gender = new RadioButton[2];
    CheckBox[] deliveryMethod = new CheckBox[5];
    DatePicker birthDate, guideTestDate;
    ArrayAdapter villageOfBirthAdapter;
    TextView motherVillageId, villageOfBirthId, healthMessengerDate;
    Button submit;
    int vSpinId, vobSpinId, flag, midwifeFlag = 0;
    String vSpin, vobSpin, temp;
    String[] tempArray1, tempArray2, temp1, temp2;
    ArrayAdapter villageNameAdapter;
    Birth birth;

    int villageOfBirthPosition = 0;
    int motherVillagePosition = 0;
    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_info_form);
        BirthInfoDBHelper birthDBHelper = new BirthInfoDBHelper(getApplicationContext());
        id =Integer.parseInt(getIntent().getStringExtra("index"));

        birth = birthDBHelper.getInfo(id);

        /*Pending
        *villageId
        * resident nonresident
        * guideDate in supervisor birth form
        * last 6 fields in form
        * */

        spinner1 = (TextView) findViewById(R.id.spinner1);
        spinner2 = (TextView) findViewById(R.id.spinner2);
        spinner3 = (TextView) findViewById(R.id.spinner3);
        spinner4 = (TextView) findViewById(R.id.spinner4);

        deliveryMethod[0] = (CheckBox)findViewById(R.id.midwife);
        deliveryMethod[1] = (CheckBox)findViewById(R.id.nurse);
        deliveryMethod[2] = (CheckBox)findViewById(R.id.relatives);
        deliveryMethod[3] = (CheckBox)findViewById(R.id.doctor);
        deliveryMethod[4] = (CheckBox)findViewById(R.id.other);


        villageOfBirthPlace[0] = (RadioButton)findViewById(R.id.villageOfBirthPlace0);
        villageOfBirthPlace[1] = (RadioButton)findViewById(R.id.villageOfBirthPlace1);
        villageOfBirthPlace[2] = (RadioButton)findViewById(R.id.villageOfBirthPlace2);
        villageOfBirthPlace[3] = (RadioButton)findViewById(R.id.villageOfBirthPlace3);
        villageOfBirthPlace[4] = (RadioButton)findViewById(R.id.villageOfBirthPlace4);
        villageOfBirthPlace[5] = (RadioButton)findViewById(R.id.villageOfBirthPlace5);

        gender[0] = (RadioButton)findViewById(R.id.boy);
        gender[1] = (RadioButton)findViewById(R.id.girl);

        fadPresence[0] = (RadioButton)findViewById(R.id.yesFemale);
        fadPresence[1] = (RadioButton)findViewById(R.id.noFemale);

        pregnancyTime[0] = (RadioButton)findViewById(R.id.less7);
        pregnancyTime[1] = (RadioButton)findViewById(R.id.m7);
        pregnancyTime[2] = (RadioButton)findViewById(R.id.m8);
        pregnancyTime[3] = (RadioButton)findViewById(R.id.m8d21);
        pregnancyTime[4] = (RadioButton)findViewById(R.id.m9);
        pregnancyTime[5] = (RadioButton)findViewById(R.id.doesNotKnow);

        deliveryName = (EditText) findViewById(R.id.midwifeName);
        deliveryName.setVisibility(View.GONE);
        healthMessenger = (EditText) findViewById(R.id.healthMessengerName);
        healthMessengerID = (EditText) findViewById(R.id.healthMessengerId);
        healthMessengerDate = (TextView) findViewById(R.id.healthMessengerDate);
        guideName = (EditText) findViewById(R.id.guideName);
        guideId = (EditText) findViewById(R.id.guideId);
        motherName = (EditText) findViewById(R.id.motherName);
        birthDate = (DatePicker) findViewById(R.id.birthDate);

        motherVillageId = (TextView) findViewById(R.id.motherVillageId);

        villageOfBirthId = (TextView)findViewById(R.id.villageOfBirthId);
        villageOfBirthBlockSpinner = (Spinner)findViewById(R.id.villageOfBirthBlockSpinner);
        villageOfBirthSpinner = (Spinner)findViewById(R.id.villageOfBirthSpinner);

        // translate = new Translation();
        villageNameSpinner = (Spinner)findViewById(R.id.villageNameSpinner);

        villageBlockSpinner = (Spinner)findViewById(R.id.villageBlockSpinner);



        final ArrayAdapter villageBlockAdapter = ArrayAdapter.createFromResource(this,R.array.block_array,android.R.layout.simple_spinner_dropdown_item);
        villageBlockSpinner.setAdapter(villageBlockAdapter);
        villageNameAdapter = ArrayAdapter.createFromResource(this,R.array.dot,android.R.layout.simple_spinner_dropdown_item);
        villageNameSpinner.setAdapter(villageNameAdapter);


      /*  int blockPosition = villageBlockAdapter.getPosition(TR.Letter_E2M(birth.getMotherVillage()));
        villageBlockSpinner.setSelection(blockPosition);
        String motherVillageID = birth.getMotherVillageID();*/


        switch (villageBlockAdapter.getPosition(TR.Letter_E2M(birth.getMotherVillage()))) {
            case 1:
                tempArray1 = getResources().getStringArray(R.array.non_resident);
                tempArray2 = getResources().getStringArray(R.array.non_resident_array);
                break;
            case 2:
                tempArray1 = getResources().getStringArray(R.array.gadchiroli_block_array);
                tempArray2 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                break;
            case 3:
                tempArray1 = getResources().getStringArray(R.array.dhanori_block_array);
                tempArray2 = getResources().getStringArray(R.array.dhanori_villageId_array);
                break;
            case 4:
                tempArray1 = getResources().getStringArray(R.array.kaarvaafa_block_array);
                tempArray2 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                break;
            case 5:
                tempArray1 = getResources().getStringArray(R.array.aarmori_block_array);
                tempArray2 = getResources().getStringArray(R.array.aarmori_villageId_array);
                break;
            case 6:
                tempArray1 = getResources().getStringArray(R.array.chamorshi_block_array);
                tempArray2 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                break;

        }


        for(int i = 0; i < tempArray2.length; i++) {
            if(birth.getMotherVillageID().equals(tempArray2[i])) {
                motherVillagePosition = i;
                break;
            }
        }
        villageBlockSpinner.setVisibility(View.GONE);
        villageNameSpinner.setVisibility(View.GONE);
        spinner1.setText(TR.Letter_E2M(birth.getMotherVillage()));
        spinner2.setText(tempArray1[motherVillagePosition]);
        motherVillageId.setText(birth.getMotherVillageID());


        spinner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                villageBlockSpinner.setVisibility(View.VISIBLE);
                villageNameSpinner.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
            }
        });
        spinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                villageBlockSpinner.setVisibility(View.VISIBLE);
                villageNameSpinner.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
            }
        });

      //  villageNameSpinner.setSelection(motherVillagePosition);



        final ArrayAdapter villageOfBirthBlockAdapter = ArrayAdapter.createFromResource(this,R.array.block_array,android.R.layout.simple_spinner_dropdown_item);
        villageOfBirthBlockSpinner.setAdapter(villageOfBirthBlockAdapter);
        villageOfBirthAdapter = ArrayAdapter.createFromResource(this,R.array.dot,android.R.layout.simple_spinner_dropdown_item);
        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
       /* int birthBlockPosition = villageOfBirthBlockAdapter.getPosition(TR.Letter_E2M(birth.getVillageOfBirth()));
        villageOfBirthBlockSpinner.setSelection(birthBlockPosition);*/

        switch (villageOfBirthBlockAdapter.getPosition(TR.Letter_E2M(birth.getVillageOfBirth()))) {
            case 1:
                tempArray1 = getResources().getStringArray(R.array.non_resident);
                tempArray2 = getResources().getStringArray(R.array.non_resident_array);
                break;
            case 2:
                tempArray1 = getResources().getStringArray(R.array.gadchiroli_block_array);
                tempArray2 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                break;
            case 3:
                tempArray1 = getResources().getStringArray(R.array.dhanori_block_array);
                tempArray2 = getResources().getStringArray(R.array.dhanori_villageId_array);
                break;
            case 4:
                tempArray1 = getResources().getStringArray(R.array.kaarvaafa_block_array);
                tempArray2 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                break;
            case 5:
                tempArray1 = getResources().getStringArray(R.array.aarmori_block_array);
                tempArray2 = getResources().getStringArray(R.array.aarmori_villageId_array);
                break;
            case 6:
                tempArray1 = getResources().getStringArray(R.array.chamorshi_block_array);
                tempArray2 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                break;

        }


        for(int i = 0; i < tempArray2.length; i++) {
            if(birth.getVillageOfBirthID().equals(tempArray2[i])) {
                villageOfBirthPosition = i;
                break;
            }
        }

   /*     villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
        villageOfBirthSpinner.setSelection(villageOfBirthPosition);*/

        villageOfBirthBlockSpinner.setVisibility(View.GONE);
        villageOfBirthSpinner.setVisibility(View.GONE);
        spinner3.setText(TR.Letter_E2M(birth.getVillageOfBirth()));
        spinner4.setText(tempArray1[villageOfBirthPosition]);
        villageOfBirthId.setText((birth.getVillageOfBirthID()));


        spinner3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                villageOfBirthBlockSpinner.setVisibility(View.VISIBLE);
                villageOfBirthSpinner.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
            }
        });
        spinner4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                villageOfBirthBlockSpinner.setVisibility(View.VISIBLE);
                villageOfBirthSpinner.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
            }
        });


       /* String date = birth.getBirthDate();
        int year, month, day;
        Log.println(Log.ASSERT, "Date", date);
        day = Integer.parseInt(date.substring(0, 2));
        Log.println(Log.ASSERT, "Day", String.valueOf(day));
        int index = 0;
        if(date.charAt(4) == '-') {
            index = 4;
        }
        month = Integer.parseInt(date.substring(3, index++)) - 1;
        Log.println(Log.ASSERT, "Month", String.valueOf(month));
        year = Integer.parseInt(date.substring(index, date.length()));
        Log.println(Log.ASSERT, "Year", String.valueOf(year));
        birthDate.updateDate(year, month, day);
        year = GetDate.getYears(birth.getBirthDate());
        month = GetDate.getMonths(birth.getBirthDate());
        day = GetDate.getDays(birth.getBirthDate());

*/
        motherName.setText(TR.Letter_E2M(birth.getMotherName()));
//        Log.println(Log.ASSERT, "villageBirthPlace", birth.getVillageOfBirthPlace());
        villageOfBirthPlace[Integer.parseInt(birth.getVillageOfBirthPlace()) - 1].setChecked(true);

        // birth.setBirthDate("00-00-0000");
        // resident = Integer.parseInt(getIntent().getStringExtra("resident"));
 /*       String familyId = getIntent().getStringExtra("index");
        String houseId = getIntent().getStringExtra("house");

*/

//        deliveryName.setText(TR.Letter_E2M(birth.getDeliveryName()));
//          deliveryMethod[Integer.parseInt(birth)]
        deliveryMethodSet(birth.getDeliveryMethod());

        pregnancyTime[(Integer.parseInt(birth.getPregnancyTime())) - 1].setChecked(true);

        gender[(Integer.parseInt(birth.getChildGender())) - 1].setChecked(true);

        if((Integer.parseInt(birth.getFadPresence())) == 0)
            fadPresence[1].setChecked(true);
        else
            fadPresence[0].setChecked(true);
        healthMessenger.setText(TR.Letter_E2M(birth.getHealthMessenger()));
        healthMessengerID.setText(birth.getHealthMessengerId());
        healthMessengerDate.setText(birth.getHealthMessengerDate());
        healthMessengerDate.setVisibility(View.VISIBLE);


     /*   if(resident == 1){
            String name = getIntent().getStringExtra("name");
            birth.setMotherName(name);
            motherName.setText(translate.Letter_E2M(birth.getMotherName()));
            motherName.setEnabled(false);
        }*/


       guideName.setText(TR.Letter_E2M(birth.getGuideName()));
        guideId.setText(birth.getGuideId());


        villageBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vSpin = villageBlockSpinner.getSelectedItem().toString();
                    switch (vSpin) {
                        case "non-resident":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.non_resident, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                        case "गडचिरोली":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gadchiroli_block_array, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                        case "धानोरा":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dhanori_block_array, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                        case "कारवाफा":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.kaarvaafa_block_array, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                        case "आरमोरी":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.aarmori_block_array, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                        case "चामोर्शी":
                            villageNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chamorshi_block_array, android.R.layout.simple_spinner_dropdown_item);
                            villageNameSpinner.setAdapter(villageNameAdapter);
                            break;
                    }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });


        villageNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     vSpinId = position;

                     Log.println(Log.ASSERT, "VSpin", String.valueOf(vSpinId));
                     if(position != motherVillagePosition) {

                         switch (vSpin) {
                             case "non-resident":
                                 tempArray1 = getResources().getStringArray(R.array.non_resident_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                             case "गडचिरोली":
                                 tempArray1 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                             case "धानोरा":
                                 tempArray1 = getResources().getStringArray(R.array.dhanori_villageId_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                             case "कारवाफा":
                                 tempArray1 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                             case "आरमोरी":
                                 tempArray1 = getResources().getStringArray(R.array.aarmori_villageId_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                             case "चामोर्शी":
                                 tempArray1 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                                 motherVillageId.setText(tempArray1[vSpinId]);
                                 break;
                         }
                         motherVillageId.setVisibility(View.VISIBLE);
                     }
                 }

                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {
                     Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();

                 }
             }

        );


    //    villageOfBirthBlockSpinner = (Spinner)findViewById(R.id.villageOfBirthBlockSpinner);
 //       villageOfBirthBlockAdapter = ArrayAdapter.createFromResource(this,R.array.block_array,android.R.layout.simple_spinner_dropdown_item);
      //  villageOfBirthBlockSpinner.setAdapter(villageOfBirthBlockAdapter);
     //   villageOfBirthSpinner = (Spinner)findViewById(R.id.villageOfBirthSpinner);



        villageOfBirthBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vobSpin = villageOfBirthBlockSpinner.getSelectedItem().toString();
                switch(vobSpin){
                    case "non-resident":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.non_resident, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageNameAdapter);
                        break;
                    case "गडचिरोली":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gadchiroli_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
                        break;
                    case "धानोरा":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dhanori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
                        break;
                    case "कारवाफा":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.kaarvaafa_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
                        break;
                    case "आरमोरी":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.aarmori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
                        break;
                    case "चामोर्शी":
                        villageOfBirthAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chamorshi_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });
        villageOfBirthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vobSpinId = position;
                Log.println(Log.ASSERT, "", vobSpin);
                switch(vobSpin){
                    case "non-resident":
                        tempArray2 = getResources().getStringArray(R.array.non_resident_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                    case "गडचिरोली":
                        tempArray2 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                    case "धानोरा":
                        tempArray2 = getResources().getStringArray(R.array.dhanori_villageId_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                    case "कारवाफा":
                        tempArray2 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                    case "आरमोरी":
                        tempArray2 = getResources().getStringArray(R.array.aarmori_villageId_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                    case "चामोर्शी":
                        tempArray2 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                        villageOfBirthId.setText(tempArray2[vobSpinId]);
                        break;
                }
                villageOfBirthId.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });









        submit = (Button) findViewById(R.id.add_mem_b);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = "";
                for (int i = 0; i < 5; i++) {
                    if ( deliveryMethod[i].isChecked())
                        temp = temp + '1';
                    else
                        temp = temp + '0';
                }
                birth.setDeliveryMethod(temp);
            /*    if(resident == 1){
                    String name = getIntent().getStringExtra("name");
                    birth.setMotherName(name);
                    motherName.setText(translate.Letter_E2M(birth.getMotherName()));
                    motherName.setEnabled(false);
                }
                else{
                    birth.setMotherName(translate.Letter_M2E(motherName.getText().toString()));
                }*/

                if(vSpin!=null){
                    birth.setMotherVillage(TR.Letter_M2E(vSpin));
                }

                birth.setMotherVillageID(motherVillageId.getText().toString());
                //     birth.setFamilyID("1");
                //   birth.setHouseID("1");
                // birth.setChildID("1");
                birth.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
                if(vobSpin!=null)
                    birth.setVillageOfBirth(TR.Letter_M2E(vobSpin));
                birth.setVillageOfBirthID(villageOfBirthId.getText().toString());

                if(midwifeFlag == 1)
                    birth.setDeliveryName(TR.Letter_M2E(deliveryName.getText().toString()));
                else
                    birth.setDeliveryName("null");

             /*   SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                String vhw = prefs.getString("vhw","default");
                String supervisor = prefs.getString("supervisor","default");
                String vhwId = prefs.getString("vhwId","-1");
                String supervisorId = prefs.getString("supervisorId","-1");

                birth.setHealthMessenger(TR.Letter_M2E(vhw));
                birth.setHealthMessengerId(vhwId);
                birth.setGuideName(TR.Letter_M2E(supervisor));
                birth.setGuideId(supervisorId);
                birth.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
                birth.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));*/

           //     birth.setVillageId(String.valueOf(curVillage));

                if(birth.getMotherVillage().equals("----")) {
                    flag = 1;
                }
                else if(birth.getMotherVillageID().equals("")) {
                    flag = 1;
                }
                else if(birth.getMotherName().isEmpty()) {
                    flag = 1;
                }
       /*     else if (birth.getFamilyID().isEmpty()) {
                flag = 1;
            }
            else if (birth.getHouseID().isEmpty()) {
                flag = 1;
            }*/
                else if ((birth.getBirthDate().equals("00-00-0000"))) {
                    flag = 1;
                }
                else if ((birth.getVillageOfBirth().equals("----"))) {
                    flag = 1;
                }
                else if ((birth.getVillageOfBirthID().isEmpty())) {
                    flag = 1;
                }
                else if((birth.getVillageOfBirthPlace().isEmpty())) {
                    flag = 1;
                }
                else if (midwifeFlag == 1 &&(birth.getDeliveryName().isEmpty())) {
                    flag = 1;
                }
                else if(birth.getDeliveryMethod().equals("00000")) {
                    flag = 1;
                }
                else if(birth.getChildGender().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getPregnancyTime().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getFadPresence().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getHealthMessenger().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getHealthMessengerId().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getGuideName().isEmpty()) {
                    flag = 1;
                }
                else if(birth.getGuideId().isEmpty()) {
                    flag = 1;
                }

                //     if(flag == 0) {
           /*     Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
                //DB.insert   (birth);
                MemberDataInterface memInterface = new MemberDataInterface(getApplicationContext());
                Translation translation = new Translation();
                resident = Integer.parseInt(getIntent().getStringExtra("resident"));

                if(resident == 1){
                    Log.println(Log.ASSERT,"CHECK",birth.getFamilyID());
                    Member member = new Member(Integer.parseInt(birth.getFamilyID()),Integer.parseInt(birth.getHouseID()) ,0, translation.Letter_M2E("CHILD"), 0,Integer.parseInt(birth.getChildGender()), -1, "-1",
                            "0","0", "0", "0", "0", "0",curVillage);
                    memInterface.child(member, 1);
                    member = memInterface.getRecent(1);
                    Log.println(Log.ASSERT,String.valueOf(member.getFamilyId()),String.valueOf(member.getMemberId()));
                    birth.setMemberId(String.valueOf(member.getMemberId()));
                }
                else if (resident == 0){
                    birth.setMemberId("-1");
                }*/

                //Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
            /*    String birthFlag =  DB.insert(birth);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String birthShared = preferences.getString("birth","default");

                birthShared += birthFlag;
                Log.println(Log.ASSERT,"falg", birthShared);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("birth", birthShared);
                editor.commit();*/


          /*  Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
            Log.println(Log.ASSERT,"village_id","4");
            Log.println(Log.ASSERT,"house_id", String.valueOf(birth.getHouseID()));
            Log.println(Log.ASSERT,"family_id", String.valueOf(birth.getFamilyID()));
            Log.println(Log.ASSERT,"mother_name",String.valueOf(birth.getMotherName()));
            Log.println(Log.ASSERT,"dob", String.valueOf(birth.getBirthDate()));
            Log.println(Log.ASSERT,"mother_vill_name", String.valueOf(birth.getMotherVillage()));
            Log.println(Log.ASSERT,"mother_vill_id", String.valueOf(birth.getMotherVillageID()));
            Log.println(Log.ASSERT,"vill_of_birth",String.valueOf(birth.getVillageOfBirth()));
            Log.println(Log.ASSERT,"vill_of_birth_id", String.valueOf(birth.getVillageOfBirthID()));
            Log.println(Log.ASSERT,"vill_of_birth_place",String.valueOf(birth.getVillageOfBirthPlace()));
            Log.println(Log.ASSERT,"delivery_name", String.valueOf(birth.getDeliveryName()));
            Log.println(Log.ASSERT,"delivery_method", String.valueOf(birth.getDeliveryMethod()));
            Log.println(Log.ASSERT,"gender", String.valueOf(birth.getChildGender()));
            Log.println(Log.ASSERT,"preg_time", String.valueOf(birth.getPregnancyTime()));
            Log.println(Log.ASSERT,"fad", String.valueOf(birth.getFadPresence()));
            Log.println(Log.ASSERT,"messenger_name", String.valueOf(birth.getHealthMessenger()));
            Log.println(Log.ASSERT,"messenger_id", String.valueOf(birth.getHealthMessengerId()));
            Log.println(Log.ASSERT,"messenger_date", String.valueOf(birth.getHealthMessengerDate()));
            Log.println(Log.ASSERT,"guide_name", String.valueOf(birth.getGuideName()));
            Log.println(Log.ASSERT,"guide_id", String.valueOf(birth.getGuideId()));
            Log.println(Log.ASSERT,"guide_date", String.valueOf(birth.getGuideTestDate()));*/
                BirthInfoDBHelper birthDBHelper = new BirthInfoDBHelper(getApplicationContext());
                birthDBHelper.updateUser(birth);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String birthShared = preferences.getString("birth","default");

                List<Integer> ids = new ArrayList<Integer>();
                ids.add(id);
                Upload upload = new Upload("URL");
                String birthResult = upload.updateFlags(ids,1,birthShared);

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("birth",birthResult );
                editor.commit();
               Intent intent = new Intent(getApplicationContext(), BirthSupervisor.class);
                startActivity(intent);
               finish();

                //  }

                // displayalert();
            }
        });


    }

    public void midwifeClick(View view){
        if(deliveryMethod[0].isChecked()){
            deliveryName.setVisibility(View.VISIBLE);
            midwifeFlag = 1;
        }
        else{
            deliveryName.setText("");
            deliveryName.setVisibility(View.GONE);
            midwifeFlag = 0;
        }
    }

    public void radioClick(View view) {
        String tag = (String) view.getTag();
        switch(tag) {
            case "yes":
                fadPresence[1].setChecked(false);
                birth.setFadPresence("1");
                break;
            case "no":
                fadPresence[0].setChecked(false);
                birth.setFadPresence("0");
                break;
            case "boy":
                gender[1].setChecked(false);
                birth.setChildGender("1");
                break;
            case "girl":
                gender[0].setChecked(false);
                birth.setChildGender("2");
                break;
            case "villageOfBirthPlace0":
                villageOfBirthPlace[1].setChecked(false);
                villageOfBirthPlace[2].setChecked(false);
                villageOfBirthPlace[3].setChecked(false);
                villageOfBirthPlace[4].setChecked(false);
                villageOfBirthPlace[5].setChecked(false);
                birth.setVillageOfBirthPlace("1");
                break;
            case "villageOfBirthPlace1":
                villageOfBirthPlace[0].setChecked(false);
                villageOfBirthPlace[2].setChecked(false);
                villageOfBirthPlace[3].setChecked(false);
                villageOfBirthPlace[4].setChecked(false);
                villageOfBirthPlace[5].setChecked(false);
                birth.setVillageOfBirthPlace("2");
                break;
            case "villageOfBirthPlace2":
                villageOfBirthPlace[0].setChecked(false);
                villageOfBirthPlace[1].setChecked(false);
                villageOfBirthPlace[3].setChecked(false);
                villageOfBirthPlace[4].setChecked(false);
                villageOfBirthPlace[5].setChecked(false);
                birth.setVillageOfBirthPlace("3");
                break;
            case "villageOfBirthPlace3":
                villageOfBirthPlace[0].setChecked(false);
                villageOfBirthPlace[1].setChecked(false);
                villageOfBirthPlace[2].setChecked(false);
                villageOfBirthPlace[4].setChecked(false);
                villageOfBirthPlace[5].setChecked(false);
                birth.setVillageOfBirthPlace("4");
                break;
            case "villageOfBirthPlace4":
                villageOfBirthPlace[0].setChecked(false);
                villageOfBirthPlace[1].setChecked(false);
                villageOfBirthPlace[2].setChecked(false);
                villageOfBirthPlace[3].setChecked(false);
                villageOfBirthPlace[5].setChecked(false);
                birth.setVillageOfBirthPlace("5");
                break;
            case "villageOfBirthPlace5":
                villageOfBirthPlace[0].setChecked(false);
                villageOfBirthPlace[1].setChecked(false);
                villageOfBirthPlace[2].setChecked(false);
                villageOfBirthPlace[3].setChecked(false);
                villageOfBirthPlace[4].setChecked(false);
                birth.setVillageOfBirthPlace("6");
                break;
            case "less7":
                pregnancyTime[1].setChecked(false);
                pregnancyTime[2].setChecked(false);
                pregnancyTime[3].setChecked(false);
                pregnancyTime[4].setChecked(false);
                pregnancyTime[5].setChecked(false);
                birth.setPregnancyTime("1");
                break;
            case "m7":
                pregnancyTime[0].setChecked(false);
                pregnancyTime[2].setChecked(false);
                pregnancyTime[3].setChecked(false);
                pregnancyTime[4].setChecked(false);
                pregnancyTime[5].setChecked(false);
                birth.setPregnancyTime("2");
                break;
            case "m8":
                pregnancyTime[0].setChecked(false);
                pregnancyTime[1].setChecked(false);
                pregnancyTime[3].setChecked(false);
                pregnancyTime[4].setChecked(false);
                pregnancyTime[5].setChecked(false);
                birth.setPregnancyTime("3");
                break;
            case "m8d21":
                pregnancyTime[0].setChecked(false);
                pregnancyTime[1].setChecked(false);
                pregnancyTime[2].setChecked(false);
                pregnancyTime[4].setChecked(false);
                pregnancyTime[5].setChecked(false);
                birth.setPregnancyTime("4");
                break;
            case "m9":
                pregnancyTime[0].setChecked(false);
                pregnancyTime[1].setChecked(false);
                pregnancyTime[2].setChecked(false);
                pregnancyTime[3].setChecked(false);
                pregnancyTime[5].setChecked(false);
                birth.setPregnancyTime("5");
                break;
            case "doesNotKnow":
                pregnancyTime[0].setChecked(false);
                pregnancyTime[1].setChecked(false);
                pregnancyTime[2].setChecked(false);
                pregnancyTime[3].setChecked(false);
                pregnancyTime[4].setChecked(false);
                birth.setPregnancyTime("6");
                break;

            default:
                break;
        }
    }

    private void deliveryMethodSet(String delivery){
        for(int i = 0; i < 5; i++){
            if(delivery.charAt(i) == '1') {
                deliveryMethod[i].setChecked(true);
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birth_view_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}