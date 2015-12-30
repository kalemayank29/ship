package com.example.kylehirschfelder.ship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.SQLException;

public class DeathAdultForm extends AppCompatActivity {

    TextView name, memberId, villageName, villageId, familyId, houseId;
    MemberDataInterface memInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_adult_form);

        Translation translation = new Translation();

        name = (TextView) findViewById(R.id.Name);
        memberId = (TextView) findViewById(R.id.PersonId);
        villageName = (TextView) findViewById(R.id.VillageName);
        villageId = (TextView) findViewById(R.id.VillageId);
        familyId = (TextView) findViewById(R.id.FamilyId);
        houseId = (TextView) findViewById(R.id.HouseId);

        memInterface = new MemberDataInterface(getApplicationContext());
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
