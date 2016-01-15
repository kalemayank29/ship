package com.example.kylehirschfelder.ship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.SQLException;

public class ViewMemberProfile extends AppCompatActivity {



    TextView editFam, editName, editAge, editChildId,
            editMarriage, editHouse, editFamPlan, editEdu, editLit,
            editDeparture, editArrival;
    Member member;
    MemberDataInterface db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member_profile);

        db = new MemberDataInterface(getApplicationContext());

        editFam = (TextView) findViewById(R.id.editFamilyIdText);
        editName = (TextView) findViewById(R.id.editNameText);
        editAge = (TextView) findViewById(R.id.editAgeText);
        editHouse = (TextView) findViewById(R.id.editHouseIdText);
        editMarriage = (TextView) findViewById(R.id.editMarriageText);
        editFamPlan = (TextView) findViewById(R.id.editFamily);
        editEdu  = (TextView) findViewById(R.id.editEducationText);
        editLit = (TextView) findViewById(R.id.editLiteracyText);
        editDeparture = (TextView) findViewById(R.id.editDepartureText);
        editArrival = (TextView) findViewById(R.id.editArrivalText);

        String index = getIntent().getStringExtra("index");
        int curVillage =  ((CurrentVillage) this.getApplication()).getSomeVariable();

        try {
            member = db.getMember(Integer.parseInt(index), 1,curVillage);
            Log.println(Log.ASSERT, "LOGGING HOUSE: ", String.valueOf(member.getHouseId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        editFam.setText(String.valueOf(member.getFamilyId()));
        editName.setText(String.valueOf(member.getName()));
        editAge.setText(String.valueOf(member.getAge()));
        editHouse.setText(String.valueOf(member.getHouseId()));
        editMarriage.setText(String.valueOf(member.getMarriageStatus()));
        editFamPlan.setText(String.valueOf(member.getFamilyPlan()));
        editEdu.setText(String.valueOf(member.getEducation()));
        editLit.setText(String.valueOf(member.getLiteracy()));
        editDeparture.setText(String.valueOf(member.getWeddingDept()));
        editArrival.setText(String.valueOf(member.getWeddingArr()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_member_profile, menu);
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
