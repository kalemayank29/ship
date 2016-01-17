package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.SQLException;

/**
 * Created by poorwa on 16/1/16.
 */
public class DeathChildView extends AppCompatActivity {
    TextView memberId, villageName, villageId, familyId, houseId;
    MemberDataInterface memInterface;
    EditText name, age;
    Spinner villageStayBlockSpinner, villageStayNameSpinner,villageBirthBlockSpinner, villageBirthNameSpinner;
    Spinner villageDeathBlockSpinner, villageDeathNameSpinner;

    RadioGroup stillBirth;

    boolean stillBirthFlag = false;

    int stayVillagePosition = 0, birthVillagePosition = 0, deathVillagePosition = 0;

    TextView villageStayBlockTV, villageStayNameTV, villageBirthBlockTV, villageBirthNameTV, villageDeathBlockTV,
    villageDeathNameTV;

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
//        curVillage = 1;

        DeathChildDataInterface childInterface = new DeathChildDataInterface(getApplicationContext());
        child = childInterface.getInfo(memId);

        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        name = (EditText) findViewById(R.id.Name);
        name.setText(translate.Letter_E2M(child.getName()));
        age = (EditText) findViewById(R.id.Age);
        age.setText(child.getAge());
        //age.setVisibility(View.GONE);
        memberId = (TextView) findViewById(R.id.PersonId);
        memberId.setText(child.getMemberID());

        stillBirth = (RadioGroup) findViewById(R.id.stillBirth);
        ((RadioButton)stillBirth.getChildAt(Integer.parseInt(child.getStillBirth()))).setChecked(true);
        // villageName = (TextView) findViewById(R.id.VillageName);
        // villageId = (TextView) findViewById(R.id.VillageId);
        familyId = (TextView) findViewById(R.id.FamilyId);
        familyId.setText(child.getFamilyID());
        houseId = (TextView) findViewById(R.id.HouseId);
        houseId.setText(child.getHouseID());
        villageBirthBlockTV = (TextView) findViewById(R.id.villageBirthBlockTV);
        villageBirthNameTV = (TextView) findViewById(R.id.villageBirthNameTV);
        villageStayBlockTV = (TextView) findViewById(R.id.villageStayBlockTV);
        villageStayNameTV = (TextView) findViewById(R.id.villageStayNameTV);
        villageDeathBlockTV = (TextView) findViewById(R.id.villageDeathBlockTV);
        villageDeathNameTV = (TextView) findViewById(R.id.villageDeathNameTV);
        villageStayId = (TextView) findViewById(R.id.VillageStayId);
        villageStayId.setText(child.getMotherVillageID());
        villageDeathId = (TextView) findViewById(R.id.VillageDeathId);
        villageDeathId.setText(child.getVillageOfDeathID());
        villageBirthId = (TextView) findViewById(R.id.VillageBirthId);
        villageBirthId.setText(child.getVillageOfBirthID());

        if (resident == 1) {
            try {
                Member member = dInterface.getMember(memId, curVillage, 1);
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
        if(resident == 0){
            try {
                Member member = dInterface.getMember(memId, curVillage, 1);
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


        villageStayBlockSpinner = (Spinner) findViewById(R.id.villageStayBlockSpinner);
        final ArrayAdapter villageStayBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageStayBlockSpinner.setAdapter(villageStayBlockAdapter);
        villageStayBlockSpinner.setVisibility(View.GONE);
        villageStayBlockTV.setVisibility(View.VISIBLE);
        villageStayBlockTV.setText(vSpin = translation.Letter_E2M(child.getMotherVillage()));

        switch (villageStayBlockAdapter.getPosition(translation.Letter_E2M(child.getMotherVillage()))) {
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
            if(child.getMotherVillageID().equals(tempArray2[i])) {
                stayVillagePosition = i;
                break;
            }
        }

        villageStayNameSpinner = (Spinner) findViewById(R.id.villageStayNameSpinner);
        villageStayNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageStayNameSpinner.setAdapter(villageStayNameAdapter);
        villageStayNameSpinner.setVisibility(View.GONE);
        villageStayNameTV.setVisibility(View.VISIBLE);
        villageStayNameTV.setText(tempArray1[stayVillagePosition]);


        villageDeathBlockSpinner = (Spinner) findViewById(R.id.villageDeathBlockSpinner);
        final ArrayAdapter villageDeathBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageDeathBlockSpinner.setAdapter(villageDeathBlockAdapter);
        villageDeathBlockSpinner.setVisibility(View.GONE);
        villageDeathBlockTV.setVisibility(View.VISIBLE);
        villageDeathBlockTV.setText(vodSpin = translation.Letter_E2M(child.getVillageOfDeath()));

        switch (villageDeathBlockAdapter.getPosition(translation.Letter_E2M(child.getVillageOfDeath()))) {
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
            if(child.getVillageOfDeathID().equals(tempArray2[i])) {
                deathVillagePosition = i;
                break;
            }
        }


        villageDeathNameSpinner = (Spinner) findViewById(R.id.villageDeathNameSpinner);
        villageDeathNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageDeathNameSpinner.setAdapter(villageDeathNameAdapter);
        villageDeathNameSpinner.setVisibility(View.GONE);
        villageDeathNameTV.setVisibility(View.VISIBLE);
        villageDeathNameTV.setText(tempArray1[deathVillagePosition]);

        villageBirthBlockSpinner = (Spinner) findViewById(R.id.villageBirthBlockSpinner);
        final ArrayAdapter villageBirthBlockAdapter = ArrayAdapter.createFromResource(this, R.array.block_array, android.R.layout.simple_spinner_dropdown_item);
        villageBirthBlockSpinner.setAdapter(villageBirthBlockAdapter);
        villageBirthBlockSpinner.setVisibility(View.GONE);
        villageBirthBlockTV.setVisibility(View.VISIBLE);
        villageBirthBlockTV.setText(vobSpin = translation.Letter_E2M(child.getMotherVillage()));

        switch (villageBirthBlockAdapter.getPosition(translation.Letter_E2M(child.getVillageOfBirth()))) {
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
            if(child.getVillageOfBirthID().equals(tempArray2[i])) {
                birthVillagePosition = i;
                break;
            }
        }


        villageBirthNameSpinner = (Spinner) findViewById(R.id.villageBirthNameSpinner);
        villageBirthNameAdapter = ArrayAdapter.createFromResource(this, R.array.dot, android.R.layout.simple_spinner_dropdown_item);
        villageBirthNameSpinner.setAdapter(villageBirthNameAdapter);
        villageBirthNameSpinner.setVisibility(View.GONE);
        villageBirthNameTV.setVisibility(View.VISIBLE);
        villageBirthNameTV.setText(tempArray1[birthVillagePosition]);

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

        else if(view.getId() == R.id.villageBirthBlockTV || view.getId() == R.id.villageBirthNameTV) {
            villageBirthBlockTV.setVisibility(View.GONE);
            villageBirthNameTV.setVisibility(View.GONE);
            villageBirthBlockSpinner.setVisibility(View.VISIBLE);
            villageBirthNameSpinner.setVisibility(View.VISIBLE);
        }
    }


    public void save_click(View view) throws SQLException {
        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        if (resident == 1) {
            String nameI = getIntent().getStringExtra("name");
            child.setName(nameI);
            name.setText(translate.Letter_E2M(child.getName()));
            name.setEnabled(false);
        } else {
            child.setName(translate.Letter_M2E(name.getText().toString()));
        }

        child.setMotherVillage(translate.Letter_M2E(vSpin));
        child.setMotherVillageID(villageStayId.getText().toString());
//        child.setName(name.getText().toString());

        child.setVillageOfBirth(translate.Letter_M2E(vobSpin));
        child.setVillageOfBirthID(villageBirthId.getText().toString());
        //child.setFamilyID("1");
        //child.setHouseID("1");
        //child.setVillageId("1");
        child.setStillBirth(String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))));
        child.setBirthDate(birthDate.getDayOfMonth() + "-" + (birthDate.getMonth() + 1) + "-" + birthDate.getYear());
        child.setDeathDate(deathDate.getDayOfMonth() + "-" + (deathDate.getMonth() + 1) + "-" + deathDate.getYear());

        if (Integer.parseInt(child.getStillBirth()) == 0) {
            //child.setAge(age.getText().toString());
            stillBirthFlag = true;
            Log.println(Log.ASSERT, "StillFlag update", String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))));
        }
            child.setAge(GetDate.getDate(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(),
                    deathDate.getYear(), deathDate.getMonth(), deathDate.getDayOfMonth()));

        child.setVillageOfDeath(translate.Letter_M2E(vodSpin));
        child.setVillageOfDeathID(villageDeathId.getText().toString());
        child.setStillBirth(String.valueOf(stillBirth.indexOfChild(findViewById(stillBirth.getCheckedRadioButtonId()))));

        Log.println(Log.ASSERT, "AGE", child.getAge());

        child.setHealthMessenger("XYZ");
        child.setHealthMessengerId("1");
        child.setGuideName("XYZ");
        child.setGuideId("1");
        child.setHealthMessengerDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        child.setGuideTestDate(String.valueOf(SystemClock.currentThreadTimeMillis()));
        //  child.setVillageId(String.valueOf(curVillage));

        DeathChildDataInterface deathInterface = new DeathChildDataInterface(getApplicationContext());

        //     if(flag == 0) {
        Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
        //DB.insert   (birth);
        MemberDataInterface memInterface = new MemberDataInterface(getApplicationContext());
        // Translation translation = new Translation();
        DeathChild deathChild = deathInterface.getRecent();

        //Log.println(Log.ASSERT,"member_id", String.valueOf(birth.getMemberId()));
        deathInterface.update(child);

        //if()

        int month = GetDate.getMonths(child.getAge());
        int years = GetDate.getYears(child.getAge());
        int days = GetDate.getDays(child.getAge());

        if (years < 1 && (month > 0 && month < 6)) {
            // COD1TO5
        } else if (years == 0 && month == 0 && days == 0 && stillBirthFlag == true) {
            //STILLBIRTH
            Intent intent = new Intent(this, StillBirthForm.class);
            intent.putExtra("index", String.valueOf(deathChild.getId()));
            intent.putExtra("resident", String.valueOf(resident));
            intent.putExtra("birth_death_date", deathChild.getBirthDate());
            intent.putExtra("fam_id", String.valueOf(deathChild.getFamilyID()));
            Log.println(Log.ASSERT, "index", String.valueOf(deathChild.getId()));
            startActivity(intent);
            finish();

        }


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
