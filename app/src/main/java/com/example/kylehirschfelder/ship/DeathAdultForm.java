package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    EditText name,age;
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
        memId = Integer.parseInt(getIntent().getStringExtra("index"));
        MemberDataInterface dInterface = new MemberDataInterface(getApplicationContext());
        birthDate = (DatePicker) findViewById(R.id.BirthDate);
        deathDate = (DatePicker) findViewById(R.id.DeathDate);

        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        name = (EditText) findViewById(R.id.Name);
        age = (EditText) findViewById(R.id.Age);
        memberId = (TextView) findViewById(R.id.PersonId);
        // villageName = (TextView) findViewById(R.id.VillageName);
        // villageId = (TextView) findViewById(R.id.VillageId);
        familyId = (TextView) findViewById(R.id.FamilyId);
        houseId = (TextView) findViewById(R.id.HouseId);
        villageStayId = (TextView) findViewById(R.id.VillageStayId);
        villageDeathId = (TextView) findViewById(R.id.VillageDeathId);

        if (resident == 1) {
            try {
                Member member = dInterface.getMember(memId, 1,curVillage);
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
        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        if (resident == 1) {
            String nameI = getIntent().getStringExtra("name");
            adult.setName(nameI);
            name.setText(translate.Letter_E2M(adult.getName()));
            name.setEnabled(false);
        } else {
            adult.setName(translate.Letter_M2E(name.getText().toString()));
        }

        adult.setVillageStay(translate.Letter_M2E(vSpin));
        adult.setVillageStayId(villageStayId.getText().toString());
        //     adult.setFamilyID("1");
        //   adult.setHouseID("1");
        // adult.setChildID("1");
        adult.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
        adult.setDeathDate(deathDate.getDayOfMonth() + "-" + (deathDate.getMonth() + 1) + "-" + deathDate.getYear());
        adult.setVillageOfDeath(translate.Letter_M2E(vodSpin));
        adult.setVillageOfDeathID(villageDeathId.getText().toString());

        adult.setHealthMessenger("XYZ");
        adult.setHealthMessengerId("1");
        adult.setGuideName("XYZ");
        adult.setGuideId("1");
        adult.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        adult.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        adult.setVillageId(String.valueOf(curVillage));
        adult.setAge(age.getText().toString());
        //  adult.setVillageId(String.valueOf(curVillage));

        DeathAdultDataInterface deathInterface = new DeathAdultDataInterface(getApplicationContext());

        //     if(flag == 0) {
        Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
        //DB.insert   (birth);
        MemberDataInterface memInterface = new MemberDataInterface(getApplicationContext());
       // Translation translation = new Translation();


        /*if (resident == 1) {
            Member member = new Member(Integer.parseInt(birth.getFamilyID()), Integer.parseInt(birth.getHouseID()), 0, translation.Letter_M2E("CHILD"), 0, Integer.parseInt(birth.getChildGender()), -1, "-1",
                    "0", "0", "0", "0", "0", "0", curVillage);
            memInterface.createMember(member, 1);
            member = memInterface.getRecent(1);
            birth.setMemberId(String.valueOf(member.getMemberId()));
        } else if (resident == 0) {
            birth.setMemberId("-1");
        }
*/
        //Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
        deathInterface.insert(adult);
        finish();

        if(Integer.parseInt(adult.getAge())>=5 && Integer.parseInt(adult.getAge())<=15)
        {
            Intent intent = new Intent(this, Cod5to15_Main.class);
            intent.putExtra("id",adult.getMemberID());
            intent.putExtra("resident","1");
            startActivity(intent);

        }


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
