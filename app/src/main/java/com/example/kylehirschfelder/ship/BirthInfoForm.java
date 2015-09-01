package com.example.kylehirschfelder.ship;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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

import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kylehirschfelder.ship.Translation;

public class BirthInfoForm extends ActionBarActivity {

        Birth birth = new Birth();
        Translation TR = new Translation();
        Context context = this;
        BirthInfoDBHelper DB = new BirthInfoDBHelper(context);
        Spinner villageBlockSpinner, villageNameSpinner, villageOfBirthBlockSpinner, villageOfBirthSpinner;
        EditText deliveryName, healthMessenger, healthMessengerID, guideName, guideId;
        RadioButton[] villageOfBirthPlace = new RadioButton[6], pregnancyTime = new RadioButton[6], fadPresence = new RadioButton[2],
                gender = new RadioButton[2];
        CheckBox[] deliveryMethod = new CheckBox[5];
        DatePicker birthDate, healthMessengerDate, guideTestDate;
        ArrayAdapter  villageOfBirthAdapter;
        TextView motherVillageId, villageOfBirthId;
        Button submit;
        int vSpinId, vobSpinId, flag, midwifeFlag = 0;
        String vSpin, vobSpin, temp;
        String[] tempArray1, tempArray2;
      ArrayAdapter villageNameAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_birth_info_form);
            deliveryName = (EditText) findViewById(R.id.midwifeName);
            deliveryName.setVisibility(View.GONE);
            healthMessenger = (EditText) findViewById(R.id.healthMessengerName);
            healthMessengerID = (EditText) findViewById(R.id.healthMessengerId);
            guideName = (EditText) findViewById(R.id.guideName);
            guideId = (EditText) findViewById(R.id.guideId);

            birthDate = (DatePicker) findViewById(R.id.birthDate);

            villageBlockSpinner = (Spinner)findViewById(R.id.villageBlockSpinner);
            final ArrayAdapter villageBlockAdapter = ArrayAdapter.createFromResource(this,R.array.block_array,android.R.layout.simple_spinner_dropdown_item);
            villageBlockSpinner.setAdapter(villageBlockAdapter);

            villageNameSpinner = (Spinner)findViewById(R.id.villageNameSpinner);
            villageNameAdapter = ArrayAdapter.createFromResource(this,R.array.dot,android.R.layout.simple_spinner_dropdown_item);
            villageNameSpinner.setAdapter(villageNameAdapter);

            motherVillageId = (TextView) findViewById(R.id.motherVillageId);
            motherVillageId.setVisibility(View.GONE);
            villageOfBirthId = (TextView)findViewById(R.id.villageOfBirthId);
            villageOfBirthId.setVisibility(View.GONE);

            birth.setBirthDate("00-00-0000");



            villageBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vSpin = villageBlockSpinner.getSelectedItem().toString();
                    switch (vSpin) {
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
                    Toast.makeText(getApplicationContext(), "Nothing Selected. Maath", Toast.LENGTH_LONG).show();
                }
            });

            villageNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vSpinId = position;
                    switch(vSpin){
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

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(getApplicationContext(), "Nothing Selected. Maath", Toast.LENGTH_LONG).show();

                }
            }

            );











            villageOfBirthBlockSpinner = (Spinner)findViewById(R.id.villageOfBirthBlockSpinner);
            final ArrayAdapter villageOfBirthBlockAdapter = ArrayAdapter.createFromResource(this,R.array.block_array,android.R.layout.simple_spinner_dropdown_item);
            villageOfBirthBlockSpinner.setAdapter(villageOfBirthBlockAdapter);
            villageOfBirthSpinner = (Spinner)findViewById(R.id.villageOfBirthSpinner);
            villageOfBirthAdapter = ArrayAdapter.createFromResource(this,R.array.dot,android.R.layout.simple_spinner_dropdown_item);
            villageOfBirthSpinner.setAdapter(villageOfBirthAdapter);
            villageOfBirthBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vobSpin = villageOfBirthBlockSpinner.getSelectedItem().toString();
                    switch(vobSpin){
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
                    Toast.makeText(getApplicationContext(), "Nothing Selected. Maath", Toast.LENGTH_LONG).show();
                }
            });
            villageOfBirthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vobSpinId = position;
                    Log.println(Log.ASSERT, "", vobSpin);
                    switch(vobSpin){
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
                    Toast.makeText(getApplicationContext(), "Nothing Selected. Maath", Toast.LENGTH_LONG).show();
                }
            });






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

            submit = (Button) findViewById(R.id.add_mem_b);


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
                birth.setChildGender("0");
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

        public void save_click(View view) {
            temp = "";
            for (int i = 0; i < 5; i++) {
                if ( deliveryMethod[i].isChecked())
                    temp = temp + '1';
                else
                    temp = temp + '0';
            }
            birth.setDeliveryMethod(temp);
            birth.setMotherVillage(TR.Letter_M2E(vSpin));
            birth.setMotherVillageID(motherVillageId.getText().toString());
            birth.setMotherName(TR.Letter_E2M("poorvaa"));
       //     birth.setFamilyID("1");
         //   birth.setHouseID("1");
           // birth.setChildID("1");
            birth.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
            birth.setVillageOfBirth(TR.Letter_M2E(vobSpin));
            birth.setVillageOfBirthID(villageOfBirthId.getText().toString());
            if(midwifeFlag == 1)
                birth.setDeliveryName(TR.Letter_M2E(deliveryName.getText().toString()));
            else
                birth.setDeliveryName("null");
            birth.setHealthMessenger(TR.Letter_M2E(healthMessenger.getText().toString()));
            birth.setHealthMessengerId(healthMessengerID.getText().toString());
            birth.setGuideName(TR.Letter_M2E(guideName.getText().toString()));
            birth.setGuideId(guideId.getText().toString());
            birth.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
            birth.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));


   //         Log.println(Log.ASSERT, "mvname", birth.getMotherVillage());
     //       Log.println(Log.ASSERT, "mvnameid", birth.getMotherVillageID());
       //     Log.println(Log.ASSERT, "mname", birth.getMotherName());
//            Log.println(Log.ASSERT, "fid", birth.getFamilyID());
  //          Log.println(Log.ASSERT, "hid", birth.getHouseID());
    //        Log.println(Log.ASSERT, "cid", birth.getChildID());
      /*      Log.println(Log.ASSERT, "bd", birth.getBirthDate());
            Log.println(Log.ASSERT, "vobname", birth.getVillageOfBirth());
            Log.println(Log.ASSERT, "vobnum", birth.getVillageOfBirthID());
            Log.println(Log.ASSERT, "vobplace", birth.getVillageOfBirthPlace());
            Log.println(Log.ASSERT, "delname", birth.getDeliveryName());
            Log.println(Log.ASSERT, "delmeth", birth.getDeliveryMethod());
            Log.println(Log.ASSERT, "gen", birth.getChildGender());
            Log.println(Log.ASSERT, "preg", birth.getPregnancyTime());
            Log.println(Log.ASSERT, "fad", birth.getFadPresence());
            Log.println(Log.ASSERT, "hname", birth.getHealthMessenger());
            Log.println(Log.ASSERT, "hnum", birth.getHealthMessengerId());
            Log.println(Log.ASSERT, "hdate", birth.getHealthMessengerDate());
            Log.println(Log.ASSERT, "gname", birth.getGuideName());
            Log.println(Log.ASSERT, "gnum", birth.getGuideId());
            Log.println(Log.ASSERT, "gdate", birth.getGuideTestDate());*/


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
                Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
                DB.insert(birth);
                finish();
          //  }

               // displayalert();

        }


        public void displayalert() {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Fill in all entries")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
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



