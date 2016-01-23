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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLException;

public class DeathAdultForm extends AppCompatActivity {

    TextView memberId, villageName, villageId, familyId, houseId;
    MemberDataInterface memInterface;
    EditText name, age;
    Spinner villageStayBlockSpinner, villageStayNameSpinner;
    Spinner villageDeathBlockSpinner, villageDeathNameSpinner;
    
    ArrayAdapter villageStayNameAdapter;
    ArrayAdapter villageDeathNameAdapter;

    DeathAdult adult = new DeathAdult();
    Translation translate = new Translation();
    String vSpin, vodSpin;
    DatePicker birthDate, deathDate;
    
    TextView villageStayId,villageDeathId;
    String[] tempArray1,tempArray2;
    int vSpinId,vodSpinId,memId,resident,curVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_adult_form);

        Translation translation = new Translation();

        //adult.setMemberID(String.valueOf(memId));

        MemberDataInterface dInterface = new MemberDataInterface(getApplicationContext());
        birthDate = (DatePicker) findViewById(R.id.BirthDate);
        deathDate = (DatePicker) findViewById(R.id.DeathDate);

        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();


        resident = Integer.parseInt(getIntent().getStringExtra("resident"));

        name = (EditText) findViewById(R.id.Name);
        age = (EditText) findViewById(R.id.Age);
        memberId = (TextView) findViewById(R.id.PersonId);


        familyId = (TextView) findViewById(R.id.FamilyId);
        houseId = (TextView) findViewById(R.id.HouseId);


        villageStayId = (TextView) findViewById(R.id.VillageStayId);
        villageDeathId = (TextView) findViewById(R.id.VillageDeathId);

        if (resident == 1) {
            try {
                memId = Integer.parseInt(getIntent().getStringExtra("index"));
                Member member = dInterface.getMember(memId, curVillage,1);
                adult.setName(translation.Letter_E2M(member.getName()));
                adult.setMemberID(String.valueOf(member.getMemberId()));
                adult.setFamilyID(String.valueOf(member.getFamilyId()));
                adult.setHouseID(String.valueOf(member.getHouseId()));

                name.setText(adult.getName());
                name.setEnabled(false);
                memberId.setText(adult.getMemberID());
                familyId.setText(adult.getFamilyID());
                houseId.setText(adult.getHouseID());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(resident == 0){
            memId = Integer.parseInt(getIntent().getStringExtra("index"));
            adult.setMemberID("-1");
            Member member = null;
            try {
                member = dInterface.getMember(memId, curVillage,1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            adult.setFamilyID(String.valueOf(member.getFamilyId()));
            adult.setHouseID(String.valueOf(member.getHouseId()));

            memberId.setText(adult.getMemberID());
            familyId.setText(adult.getFamilyID());
            houseId.setText(adult.getHouseID());

        }
        else{
            memId = -1;
            Log.println(Log.ASSERT, "A", String.valueOf(memId));

            adult.setMemberID("-1");
            adult.setFamilyID(String.valueOf("-1"));
            adult.setHouseID(String.valueOf("-1"));

            memberId.setText(adult.getMemberID());
            familyId.setText(adult.getFamilyID());
            houseId.setText(adult.getHouseID());

            memberId.setEnabled(false);
            familyId.setEnabled(false);
            houseId.setEnabled(false);
        }

        memId = Integer.parseInt(adult.getMemberID());
        Log.println(Log.ASSERT, "B", String.valueOf(memId));


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



        
      /*  memInterface = new MemberDataInterface(getApplicationContext());
        int memId = Integer.parseInt(getIntent().getStringExtra("index"));
        try {
            Member element = memInterface.getMember(memId,1);
            name.setText(translation.Letter_E2M(element.getName()));
            memberId.setText(Integer.toString(element.getMemberId()));
            villageName.setText("TODO");
            villageId.setText("TODO");
            familyId.setText(Integer.toString(element.getFamilyId()));
            houseId.setText(Integer.toString(element.getHouseId()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

    }
    public void save_click(View view) throws SQLException {
//        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
      /*  if (resident == 1) {
            String nameI = getIntent().getStringExtra("name");
            adult.setName(nameI);
            name.setText(translate.Letter_E2M(adult.getName()));
            name.setEnabled(false);
        } else {
            adult.setName(translate.Letter_M2E(name.getText().toString()));
        }*/

        /*

        private String villageStay, villageStayId, villageId;
    private String name, memberID, familyID, houseID, birthDate, deathDate,
                    age, villageOfDeath,
                    villageOfDeathID,healthMessenger, healthMessengerId,
                    healthMessengerDate, guideName, guideId, guideTestDate;

         */


        adult.setVillageStay(translate.Letter_M2E(vSpin));

        Log.println(Log.ASSERT, "setVillageStay", vSpin);

        adult.setVillageStayId(villageStayId.getText().toString());

        adult.setName(translate.Letter_M2E(name.getText().toString()));
//        adult.setName(name.getText().toString());

        adult.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
        Log.println(Log.ASSERT, "Date", adult.getBirthDate());

        adult.setDeathDate(deathDate.getDayOfMonth() + "-" + (deathDate.getMonth() + 1) + "-" + deathDate.getYear());

        if(age.getText().toString().isEmpty()) {
            adult.setAge(GetDate.getDate(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(),
                    deathDate.getYear(), deathDate.getMonth(), deathDate.getDayOfMonth()));
        }
        else
            adult.setAge(age.getText().toString() + "-0-0");

        adult.setVillageOfDeath(translate.Letter_M2E(vodSpin));

        Log.println(Log.ASSERT, "setVillageDeath", vodSpin);

        adult.setVillageOfDeathID(villageDeathId.getText().toString());

        ///****** CHANGE *****//
        adult.setHealthMessenger("XYZ");
        adult.setHealthMessengerId("1");
        adult.setGuideName("XYZ");
        adult.setGuideId("1");
        ///*******CHANGE*******//


        adult.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        adult.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));

        adult.setVillageId(String.valueOf(curVillage));


        DeathAdultDataInterface deathInterface = new DeathAdultDataInterface(getApplicationContext());

        //     if(flag == 0) {
       // Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
        //DB.insert   (birth);
       // MemberDataInterface memInterface = new MemberDataInterface(getApplicationContext());
       // Translation translation = new Translation();



        //Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
        String deathFlag = deathInterface.insert(adult);
        DeathAdult recent = deathInterface.getRecent();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String deathShared = preferences.getString("deathA","default");

        deathShared += deathFlag;
        Log.println(Log.ASSERT,"flagA", deathShared);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("deathA", deathShared);
        editor.commit();

        Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DeathAdultView.class);
        intent.putExtra("mem_id", String.valueOf(memId));
        intent.putExtra("resident", String.valueOf(resident));
        intent.putExtra("index", adult.getMemberID());
        intent.putExtra("_id", String.valueOf(recent.getId()));
        Log.println(Log.ASSERT,"index",String.valueOf(adult.getMemberID()));
        startActivity(intent);
        finish();
        //  }

        // displayalert();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_death_adult_form, menu);
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
