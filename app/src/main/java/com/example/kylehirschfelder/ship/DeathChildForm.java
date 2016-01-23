package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class DeathChildForm extends AppCompatActivity {
    TextView memberId, villageName, villageId, familyId, houseId;
    MemberDataInterface memInterface;
    EditText name, age;
    Spinner villageStayBlockSpinner, villageStayNameSpinner,villageBirthBlockSpinner, villageBirthNameSpinner;
    Spinner villageDeathBlockSpinner, villageDeathNameSpinner;
    RadioGroup stillBirth;

    ArrayAdapter villageStayNameAdapter;
    ArrayAdapter villageDeathNameAdapter;
    ArrayAdapter villageBirthNameAdapter;

    DeathChild child = new DeathChild();
    Translation translate = new Translation();
    String vSpin, vodSpin,vobSpin;
    DatePicker birthDate, deathDate;

    TextView villageStayId,villageDeathId,villageBirthId;
    String[] tempArray1,tempArray2,tempArray3;
    int vSpinId,vodSpinId,memId,resident,curVillage,vobSpinId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_child_form);

        Translation translation = new Translation();
        memId = Integer.parseInt(getIntent().getStringExtra("index"));

        //Log.println(Log.ASSERT,"memidintent", String.valueOf(memberId));
        MemberDataInterface dInterface = new MemberDataInterface(getApplicationContext());
        birthDate = (DatePicker) findViewById(R.id.BirthDate);
        deathDate = (DatePicker) findViewById(R.id.DeathDate);

        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        name = (EditText) findViewById(R.id.Name);
        //name.setText(translation.Letter_E2M("nandan"));
        age = (EditText) findViewById(R.id.Age);
        memberId = (TextView) findViewById(R.id.PersonId);
       // memberId.setText("1");
        // villageName = (TextView) findViewById(R.id.VillageName);
        // villageId = (TextView) findViewById(R.id.VillageId);
        //curVillage = 1;
        familyId = (TextView) findViewById(R.id.FamilyId);
        houseId = (TextView) findViewById(R.id.HouseId);
        villageStayId = (TextView) findViewById(R.id.VillageStayId);
        villageDeathId = (TextView) findViewById(R.id.VillageDeathId);
        villageBirthId = (TextView) findViewById(R.id.VillageBirthId);
        stillBirth = (RadioGroup) findViewById(R.id.stillBirth);
        
        if (resident == 1) {
            try {
                Member member = dInterface.getMember(memId,curVillage,1);
                child.setName(translation.Letter_E2M(member.getName()));
                child.setMemberID(String.valueOf(member.getMemberId()));
                child.setFamilyID(String.valueOf(member.getFamilyId()));
                child.setHouseID(String.valueOf(member.getHouseId()));

                name.setText(child.getName());
                name.setEnabled(false);
                memberId.setText(child.getMemberID());
                familyId.setText(child.getFamilyID());
                houseId.setText(child.getHouseID());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(resident == 0){
            try {
                Member member = dInterface.getMember(memId,curVillage, 1);
                child.setMemberID(String.valueOf(-1));
                child.setFamilyID(String.valueOf(member.getFamilyId()));
                child.setHouseID(String.valueOf(member.getHouseId()));

                memberId.setText(child.getMemberID());
                familyId.setText(child.getFamilyID());
                houseId.setText(child.getHouseID());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        else {
            child.setMemberID("-1");
            child.setFamilyID(String.valueOf("-1"));
            child.setHouseID(String.valueOf("-1"));

            memberId.setText(child.getMemberID());
            familyId.setText(child.getFamilyID());
            houseId.setText(child.getHouseID());

            memberId.setEnabled(false);
            familyId.setEnabled(false);
            houseId.setEnabled(false);
            
        }


        villageStayBlockSpinner = (Spinner) findViewById(R.id.villageStayBlockSpinner);
        final ArrayAdapter villageStayBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageStayBlockSpinner.setAdapter(villageStayBlockAdapter);

        villageStayNameSpinner = (Spinner) findViewById(R.id.villageStayNameSpinner);
        villageStayNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageStayNameSpinner.setAdapter(villageStayNameAdapter);


        villageDeathBlockSpinner = (Spinner) findViewById(R.id.villageDeathBlockSpinner);
        final ArrayAdapter villageDeathBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageDeathBlockSpinner.setAdapter(villageDeathBlockAdapter);

        villageDeathNameSpinner = (Spinner) findViewById(R.id.villageDeathNameSpinner);
        villageDeathNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);

        villageBirthBlockSpinner = (Spinner) findViewById(R.id.villageBirthBlockSpinner);
        final ArrayAdapter villageBirthBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageBirthBlockSpinner.setAdapter(villageBirthBlockAdapter);

        villageBirthNameSpinner = (Spinner) findViewById(R.id.villageBirthNameSpinner);
        villageBirthNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
        

        villageStayBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vSpin = villageStayBlockSpinner.getSelectedItem().toString();
                switch (vSpin) {
                    case "non-resident":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.non_resident, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                    case "गडचिरोली":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gadchiroli_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                    case "धानोरा":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dhanori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                    case "कारवाफा":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.kaarvaafa_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                    case "आरमोरी":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.aarmori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                    case "चामोर्शी":
                        villageStayNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chamorshi_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });

        villageStayNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vSpinId = position;
                switch (vSpin) {
                    case "non-resident":
                        tempArray1 = getResources().getStringArray(R.array.non_resident_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                    case "गडचिरोली":
                        tempArray1 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                    case "धानोरा":
                        tempArray1 = getResources().getStringArray(R.array.dhanori_villageId_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                    case "कारवाफा":
                        tempArray1 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                    case "आरमोरी":
                        tempArray1 = getResources().getStringArray(R.array.aarmori_villageId_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                    case "चामोर्शी":
                        tempArray1 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                        villageStayId.setText(tempArray1[vSpinId]);
                        break;
                }
                villageStayId.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();

            }
        });


        villageDeathBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vodSpin = villageDeathBlockSpinner.getSelectedItem().toString();
                switch (vodSpin) {
                    case "non-resident":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.non_resident, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                    case "गडचिरोली":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gadchiroli_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                    case "धानोरा":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dhanori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                    case "कारवाफा":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.kaarvaafa_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                    case "आरमोरी":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.aarmori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                    case "चामोर्शी":
                        villageDeathNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chamorshi_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });

        villageDeathNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vodSpinId = position;
                switch (vodSpin) {
                    case "non-resident":
                        tempArray2 = getResources().getStringArray(R.array.non_resident_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                    case "गडचिरोली":
                        tempArray2 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                    case "धानोरा":
                        tempArray2 = getResources().getStringArray(R.array.dhanori_villageId_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                    case "कारवाफा":
                        tempArray2 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                    case "आरमोरी":
                        tempArray2 = getResources().getStringArray(R.array.aarmori_villageId_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                    case "चामोर्शी":
                        tempArray2 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                        villageDeathId.setText(tempArray2[vodSpinId]);
                        break;
                }
                villageDeathId.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();

            }
        });

        
                                        //****** VILLAGE BIRTH  //****** 
                                        //******************************\\
                                        //******************************\\
                                        //******************************\\
                                        //******************************\\
                                        //******************************\\
                                        //******************************\\


        villageBirthBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vobSpin = villageBirthBlockSpinner.getSelectedItem().toString();
                switch (vobSpin) {
                    case "non-resident":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.non_resident, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                    case "गडचिरोली":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gadchiroli_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                    case "धानोरा":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dhanori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                    case "कारवाफा":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.kaarvaafa_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                    case "आरमोरी":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.aarmori_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                    case "चामोर्शी":
                        villageBirthNameAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chamorshi_block_array, android.R.layout.simple_spinner_dropdown_item);
                        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();
            }
        });

        villageBirthNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vobSpinId = position;
                switch (vobSpin) {
                    case "non-resident":
                        tempArray3 = getResources().getStringArray(R.array.non_resident_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                    case "गडचिरोली":
                        tempArray3 = getResources().getStringArray(R.array.gadchiroli_villageId_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                    case "धानोरा":
                        tempArray3 = getResources().getStringArray(R.array.dhanori_villageId_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                    case "कारवाफा":
                        tempArray3 = getResources().getStringArray(R.array.kaarvaafa_villageId_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                    case "आरमोरी":
                        tempArray3 = getResources().getStringArray(R.array.aarmori_villageId_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                    case "चामोर्शी":
                        tempArray3 = getResources().getStringArray(R.array.chamorshi_villageId_array);
                        villageBirthId.setText(tempArray3[vobSpinId]);
                        break;
                }
                villageBirthId.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected. ", Toast.LENGTH_LONG).show();

            }
        });
    

      

    }
    public void save_click(View view) throws SQLException {
 /*       resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        if (resident == 1) {
            String nameI = getIntent().getStringExtra("name");
            child.setName(nameI);
            name.setText(translate.Letter_E2M(child.getName()));
            name.setEnabled(false);
        } else {
            child.setName(translate.Letter_M2E(name.getText().toString()));
        }*/

        /*

        private String motherVillage, motherVillageID, villageOfBirth, villageOfBirthID;
    private String villageId;
    private String name, memberID, familyID, houseID, birthDate, deathDate,
            age,                                                                // Should we split into months days years and hours
            stillBirth, villageOfDeath, villageOfDeathID,healthMessenger, healthMessengerId,
            healthMessengerDate, guideName, guideId, guideTestDate;

         */


        child.setMotherVillage(translate.Letter_M2E(vSpin));
        child.setMotherVillageID(villageStayId.getText().toString());

        child.setVillageOfBirth(translate.Letter_M2E(vobSpin));
        child.setVillageOfBirthID(villageBirthId.getText().toString());

        child.setVillageId(String.valueOf(curVillage));
        child.setName(translate.Letter_M2E(name.getText().toString()));
       // child.setMemberID("1");
        //child.setFamilyID("1");
        //child.setHouseID("1");
        // child.setChildID("1");
        child.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
        child.setDeathDate(deathDate.getDayOfMonth() + "-" + (deathDate.getMonth() + 1) + "-" + deathDate.getYear());
        if(child.getBirthDate().equals(child.getDeathDate()) && String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))).equals('0')){
            child.setAge(age.getText().toString() + "-0-0");
        }
        else
            child.setAge(GetDate.getDate(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(),
                    deathDate.getYear(), deathDate.getMonth(), deathDate.getDayOfMonth()));

        child.setVillageOfDeath(translate.Letter_M2E(vodSpin));
        child.setVillageOfDeathID(villageDeathId.getText().toString());
        child.setStillBirth(String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))));

        Log.println(Log.ASSERT, "AGE", child.getAge());
        child.setStillBirth(String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))));
        child.setVillageOfDeath(translate.Letter_M2E(vodSpin));
        child.setVillageOfDeathID(villageDeathId.getText().toString());

        child.setHealthMessenger("XYZ");
        child.setHealthMessengerId("1");
        child.setGuideName("XYZ");
        child.setGuideId("1");

        child.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        child.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        child.setVillageId(String.valueOf(curVillage));
        //  child.setVillageId(String.valueOf(curVillage));

        DeathChildDataInterface deathInterface = new DeathChildDataInterface(getApplicationContext());

        //     if(flag == 0) {
        Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
        //DB.insert   (birth);
        MemberDataInterface memInterface = new MemberDataInterface(getApplicationContext());
        // Translation translation = new Translation();



        //Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
        deathInterface.insert(child);

        finish();

        child = deathInterface.getRecent();

         Intent intent = new Intent(this, DeathChildView.class);
        intent.putExtra("name", child.getName());
        intent.putExtra("index", String.valueOf(child.getId()));
        intent.putExtra("resident", String.valueOf(resident));
        Log.println(Log.ASSERT,"index",String.valueOf(child.getId()));
        startActivity(intent);
        finish();

        //  }

        // displayalert();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_death_child_form, menu);
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
