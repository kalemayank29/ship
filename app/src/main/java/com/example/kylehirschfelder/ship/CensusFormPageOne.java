package com.example.kylehirschfelder.ship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class CensusFormPageOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button formButton;
    String isCement, isBrick, isSand, isJunk, isOthers, religion, electricity, house_owner,
            caste, pbus, abus1, abus2, abus3, wall_a,wall_b,wall_c, wall_d, wall_e, isFam,familyId;

    EditText casteId, pbusId, abus1Id, abus2Id, abus3Id, famId;
    Spinner religionSpinner, electricitySpinner, house_ownershipSpinner,
            toiletsSpinner, toilet_usersSpinner,
            waterSpinner;

    CheckBox cementBox, sandBox, junkBox, brickBox, otherBox;
    Boolean cement, brick, sand, junk, other;
    Button newButton;
    String houseId;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_form_page_one);

        familyId = getIntent().getStringExtra("index");

        religionSpinner = (Spinner) findViewById(R.id.spinReligion);
        electricitySpinner = (Spinner) findViewById(R.id.spinElec);
        house_ownershipSpinner = (Spinner) findViewById(R.id.spinHouseOwner);

        cementBox = (CheckBox) findViewById(R.id.cementCheck);
        brickBox = (CheckBox) findViewById(R.id.brickCheck);
        sandBox = (CheckBox) findViewById(R.id.sandCheck);
        junkBox = (CheckBox) findViewById(R.id.junkCheck);
        otherBox = (CheckBox) findViewById(R.id.otherCheck);
        famId = (EditText) findViewById(R.id.famId);
        pbusId = (EditText) findViewById(R.id.pBusId);
        abus1Id = (EditText) findViewById(R.id.aBus1Id);
        abus2Id = (EditText) findViewById(R.id.aBus2Id);
        abus3Id = (EditText) findViewById(R.id.aBus3Id);
        casteId = (EditText) findViewById(R.id.casteId);
        newButton = (Button) findViewById(R.id.next);

        final Intent dataTransfer = new Intent(CensusFormPageOne.this, CensusFormPageTwo.class);

        ArrayAdapter adapterRel = ArrayAdapter.createFromResource(this, R.array.religion, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterElec = ArrayAdapter.createFromResource(this, R.array.electricity, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterHouseOwner = ArrayAdapter.createFromResource(this, R.array.house_ownership, android.R.layout.simple_spinner_dropdown_item);

        religionSpinner.setAdapter(adapterRel);
        electricitySpinner.setAdapter(adapterElec);
        house_ownershipSpinner.setAdapter(adapterHouseOwner);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cement = cementBox.isChecked();
                brick = brickBox.isChecked();
                sand = sandBox.isChecked();
                junk = junkBox.isChecked();
                other = otherBox.isChecked();

                if (cement) isCement = "1";
                else isCement = "0";

                if (brick) isBrick = "2";
                else isBrick = "0";

                if (sand) isSand = "4";
                else isSand = "0";

                if (junk) isJunk = "8";
                else isJunk = "0";

                if (other) isOthers = "16";
                else isOthers = "0";

                isFam = famId.getText().toString();
                caste = casteId.getText().toString();
                pbus = pbusId.getText().toString();
                abus1 = abus1Id.getText().toString();
                abus2 = abus2Id.getText().toString();
                abus3 = abus3Id.getText().toString();
                religion = religionSpinner.getSelectedItem().toString();
                switch (religion) {
                    case "Hindu":
                        religion = "1";
                        break;
                    case "Muslum":
                        religion = "2";
                        break;
                    case "Christian":
                        religion = "4";
                        break;
                    case "Sikh":
                        religion = "8";
                        break;
                    case "Jain":
                        religion = "16";
                        break;
                    case "Buddhism":
                        religion = "32";
                        break;
                }

                electricity = electricitySpinner.getSelectedItem().toString();
                switch (electricity) {
                    case "Yes":
                        electricity = "1";
                        break;
                    case "No":
                        electricity = "0";
                        break;
                }
                house_owner = house_ownershipSpinner.getSelectedItem().toString();
                switch (house_owner) {
                    case "Owned":
                        house_owner = "1";
                        break;
                    case "Rented":
                        house_owner = "0";
                        break;
                }

                dataTransfer.putExtra("familyId", familyId);
                dataTransfer.putExtra("wall_a", isCement);
                dataTransfer.putExtra("wall_b", isBrick);
                dataTransfer.putExtra("wall_c", isSand);
                dataTransfer.putExtra("wall_d", isJunk);
                dataTransfer.putExtra("wall_e", isOthers);
                dataTransfer.putExtra("p_business", pbus);
                dataTransfer.putExtra("a_bus_1", abus1);
                dataTransfer.putExtra("a_bus_2", abus2);
                dataTransfer.putExtra("a_bus_3", abus3);
                dataTransfer.putExtra("caste", caste);
                dataTransfer.putExtra("religion", religion);
                dataTransfer.putExtra("electricity", electricity);
                dataTransfer.putExtra("house_owner", house_owner);
                dataTransfer.putExtra("fam", isFam);
                startActivity(dataTransfer);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_census_form_page_one, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
