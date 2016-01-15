package com.example.kylehirschfelder.ship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.SQLException;

public class MemberFormUpdate extends AppCompatActivity {
    int memberId;
    MemberDataInterface updateForm;
    Member element;
    EditText name,age;
    Spinner marriageSpinner;
    int curVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_form);
        updateForm = new MemberDataInterface(getApplicationContext());
        memberId = Integer.parseInt(getIntent().getStringExtra("index"));
        int curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();
        try {
            element = updateForm.getMember(memberId, 1,curVillage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        name = (EditText) findViewById(R.id.nameText);
        age = (EditText) findViewById(R.id.ageText);

        Translation object = new Translation();
        name.setHint(object.Letter_E2M(element.getName()));

        age.setHint(Integer.toString(element.getAge()));
Log.println(Log.ASSERT,"Age",String.valueOf(element.getAge()));
        marriageSpinner = (Spinner) findViewById(R.id.spin_marriage);
        final ArrayAdapter marriageAdapter = ArrayAdapter.createFromResource(this,R.array.marriage_array,android.R.layout.simple_spinner_dropdown_item);
        marriageSpinner.setAdapter(marriageAdapter);
        setMarriageHint(element.getMarriageStatus());

    }

    public void setMarriageHint(String marriage){


        switch (marriage){
            case "1":
                marriageSpinner.setSelection(1);
                break;

            case "2":
                marriageSpinner.setSelection(2);
                break;

            case "3":
                marriageSpinner.setSelection(3);
                break;

            case "4":
                marriageSpinner.setSelection(4);
                break;

            case "5":
                marriageSpinner.setSelection(5);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_form_update, menu);
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
