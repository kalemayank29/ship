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
import java.util.ArrayList;
import java.util.List;

public class DeathAdultView extends AppCompatActivity {

    TextView memberId, villageName, villageId, familyId, houseId, villageStayBlockTV, villageStayNameTV, villageDeathBlockTV, villageDeathNameTV;

    int stayVillagePosition = 0, deathVillagePosition = 0;

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
        resident = Integer.parseInt(getIntent().getStringExtra("resident"));

       // memId = 2;
       // memId = Integer.parseInt(getIntent().getStringExtra("index"));


            memId = Integer.parseInt(getIntent().getStringExtra("_id"));

        DeathAdultDataInterface dbInterface = new DeathAdultDataInterface(getApplicationContext());
        //Log.println(Log.ASSERT, "index", String.valueOf(memId));



            adult = dbInterface.getInfo(memId);


        MemberDataInterface dInterface = new MemberDataInterface(getApplicationContext());
        birthDate = (DatePicker) findViewById(R.id.BirthDate);
        int year, month, day;
        year = GetDate.getYears(adult.getBirthDate());
        month = GetDate.getMonths(adult.getBirthDate());
        day = GetDate.getDays(adult.getBirthDate());
        birthDate.init(year, --month, day, null);

        Log.println(Log.ASSERT, "getVillageOfStay", adult.getVillageStay());
        Log.println(Log.ASSERT, "getVillageOfDeath", adult.getVillageOfDeath());

        deathDate = (DatePicker) findViewById(R.id.DeathDate);
        year = GetDate.getYears(adult.getDeathDate());
        month = GetDate.getMonths(adult.getDeathDate());
        day = GetDate.getDays(adult.getDeathDate());
        Log.println(Log.ASSERT, "DateWa", "" + year + "-" + month + "-" + day);

        deathDate.init(year, --month, day, null);

//        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        name = (EditText) findViewById(R.id.Name);
        name.setText(translation.Letter_E2M(adult.getName()));

        age = (EditText) findViewById(R.id.Age);
        age.setText(adult.getAge());
        memberId = (TextView) findViewById(R.id.PersonId);
        memberId.setText(adult.getMemberID());
        // villageName = (TextView) findViewById(R.id.VillageName);
        // villageId = (TextView) findViewById(R.id.VillageId);
        familyId = (TextView) findViewById(R.id.FamilyId);
        familyId.setText(adult.getFamilyID());
        houseId = (TextView) findViewById(R.id.HouseId);
        houseId.setText(adult.getHouseID());
        villageStayId = (TextView) findViewById(R.id.VillageStayId);
        villageStayId.setText(adult.getVillageStayId());
        villageDeathId = (TextView) findViewById(R.id.VillageDeathId);
        villageDeathId.setText(adult.getVillageOfDeathID());

/*        if (resident == 1) {
            try {
                Member member = dInterface.getMember(memId, 1);
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
*/



        String temp = adult.getVillageStay();
        villageStayBlockSpinner = (Spinner) findViewById(R.id.villageStayBlockSpinner);
        villageStayBlockTV = (TextView) findViewById(R.id.villageStayBlockTV);
        final ArrayAdapter villageStayBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageStayBlockSpinner.setAdapter(villageStayBlockAdapter);
        villageStayBlockSpinner.setVisibility(View.GONE);
        villageStayBlockTV.setVisibility(View.VISIBLE);
        if(!temp.equalsIgnoreCase("non-resident")) {
            temp = translation.Letter_E2M(temp);
        }

        villageStayBlockTV.setText(vSpin = temp);

        switch (villageStayBlockAdapter.getPosition(translation.Letter_E2M(adult.getVillageStay()))) {
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
            default:
                tempArray1 = getResources().getStringArray(R.array.non_resident);
                tempArray2 = getResources().getStringArray(R.array.non_resident_array);
                break;

        }


        for(int i = 0; i < tempArray2.length; i++) {
            if(adult.getVillageStayId().equals(tempArray2[i])) {
                stayVillagePosition = i;
                break;
            }
        }

//        villageBlockSpinner.setVisibility(View.GONE);
//        villageNameSpinner.setVisibility(View.GONE);


        villageStayNameSpinner = (Spinner) findViewById(R.id.villageStayNameSpinner);
        villageStayNameTV = (TextView) findViewById(R.id.villageStayNameTV);
        villageStayNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
        villageStayNameSpinner.setVisibility(View.GONE);
        villageStayNameTV.setVisibility(View.VISIBLE);
        villageStayNameTV.setText(tempArray1[stayVillagePosition]);



        villageDeathBlockSpinner = (Spinner) findViewById(R.id.villageDeathBlockSpinner);
        villageDeathBlockTV = (TextView) findViewById(R.id.villageDeathBlockTV);
        final ArrayAdapter villageDeathBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageDeathBlockSpinner.setAdapter(villageDeathBlockAdapter);
        villageDeathBlockSpinner.setVisibility(View.GONE);
        villageDeathBlockTV.setVisibility(View.VISIBLE);

//        villageDeathBlockTV.setText(vodSpin = translation.Letter_E2M(adult.getVillageOfDeath()));

        temp = adult.getVillageOfDeath();
        if(!temp.equalsIgnoreCase("non-resident")) {
            temp = translation.Letter_E2M(temp);
        }
        villageDeathBlockTV.setText(vodSpin = temp);

        Log.println(Log.ASSERT, "VillageOfDeath", adult.getVillageOfDeath());

        switch (villageDeathBlockAdapter.getPosition(translation.Letter_E2M(adult.getVillageOfDeath()))) {
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
            if(adult.getVillageOfDeathID().equals(tempArray2[i])) {
                deathVillagePosition = i;
                break;
            }
        }

        villageDeathNameSpinner = (Spinner) findViewById(R.id.villageDeathNameSpinner);
        villageDeathNameTV = (TextView) findViewById(R.id.villageDeathNameTV);
        villageDeathNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
        villageDeathNameSpinner.setVisibility(View.GONE);
        villageDeathNameTV.setVisibility(View.VISIBLE);
        villageDeathNameTV.setText(tempArray1[deathVillagePosition]);

        
        

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
    
    public void updateVillage(View view) {
        if(view.getId() == R.id.villageStayBlockTV || view.getId() == R.id.villageStayNameTV) { 
                villageStayBlockTV.setVisibility(View.GONE);
                villageStayNameTV.setVisibility(View.GONE);
                villageStayBlockSpinner.setVisibility(View.VISIBLE);
                villageStayNameSpinner.setVisibility(View.VISIBLE);
        }
        else if(view.getId() == R.id.villageDeathBlockTV || view.getId() == R.id.villageDeathNameTV) {
            villageDeathBlockTV.setVisibility(View.GONE);
            villageDeathNameTV.setVisibility(View.GONE);
            villageDeathBlockSpinner.setVisibility(View.VISIBLE);
            villageDeathNameSpinner.setVisibility(View.VISIBLE);
        }
    }
    
    public void save_click(View view) throws SQLException {
//        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
/*        if (resident == 1) {
            String nameI = getIntent().getStringExtra("name");
            adult.setName(nameI);
            name.setText(translate.Letter_E2M(adult.getName()));
            name.setEnabled(false);
        } else {
            adult.setName(translate.Letter_M2E(name.getText().toString()));
        }
*/
        adult.setName(translate.Letter_M2E(name.getText().toString()));

        adult.setVillageStay(translate.Letter_M2E(vSpin));
        adult.setVillageStayId(villageStayId.getText().toString());

       // adult.setMemberID(String.valueOf(memId));
        adult.setFamilyID(familyId.getText().toString());
        adult.setHouseID(houseId.getText().toString());


        adult.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
        adult.setDeathDate(deathDate.getDayOfMonth() + "-" + (deathDate.getMonth() + 1) + "-" + deathDate.getYear());

        adult.setAge(age.getText().toString());

        adult.setVillageOfDeath(translate.Letter_M2E(vodSpin));

        adult.setVillageOfDeathID(villageDeathId.getText().toString());
        adult.setHealthMessenger("XYZ");
        adult.setHealthMessengerId("1");
        adult.setGuideName("XYZ");
        adult.setGuideId("1");

        adult.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        adult.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));

        adult.setVillageId(String.valueOf(curVillage));
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
        deathInterface.update(adult);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String deathShared = preferences.getString("deathA","default");

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(memId);
        Upload upload = new Upload("URL");
        String deathResult = upload.updateFlags(ids,1,deathShared);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("deathA",deathResult );
        editor.commit();

        Log.println(Log.ASSERT,"age", String.valueOf(GetDate.getYears(adult.getAge())));
        if(GetDate.getYears(adult.getAge())>=5 && GetDate.getYears(adult.getAge())<=15){
            Intent intent = new Intent(getApplicationContext(), Cod5to15_Main.class);
            intent.putExtra("id",String.valueOf(adult.getId()));
            //Log.println(Log.ASSERT,"ID", String.valueOf(adult.getId()));
            intent.putExtra("resident","1");
            startActivity(intent);
        }

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
