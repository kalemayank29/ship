package com.example.kylehirschfelder.ship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class PNMForm_other extends AppCompatActivity {

    EditText otherField;
    Button save;

    String[] receiveAsk, receiveSee, receiveHear;
    String other;
    PNM pnm;
    int member_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnmform_other);
        otherField = (EditText) findViewById(R.id.otherField);
        save = (Button) findViewById(R.id.saveOther);
        receiveAsk = getIntent().getStringArrayExtra("KEY1");
        receiveSee = getIntent().getStringArrayExtra("KEY2");
        receiveHear = getIntent().getStringArrayExtra("KEY3");

        member_id = 1;

    }

    public void save_click(View view) {
        other = otherField.getText().toString();
        int i = 0;
        pnm = new PNM();
        pnm.setId(member_id);
        pnm.setName(receiveAsk[i++]);
        pnm.setCoughDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setGaspDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setFeverDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setFitDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setFaintDays(Integer.valueOf(receiveAsk[i++]));
        Log.println(Log.ASSERT, "", receiveAsk[i]);
        pnm.setMilk(Integer.valueOf(GetDate.getYears(receiveAsk[i])));              // LOOK INTO FIXING DATES. - AGE FOR DEATH SLIP.
        pnm.setMilkDays(Integer.valueOf(GetDate.getMonths(receiveAsk[i])));
        pnm.setMilkHours(Integer.valueOf(GetDate.getDays(receiveAsk[i++])));
        pnm.setMeaslesDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setVomitDays(Integer.valueOf(receiveAsk[i++]));
        pnm.setBirthMonths(Integer.valueOf(receiveAsk[i++]));
        i = 0;
        pnm.setConscious(Integer.valueOf(receiveSee[i++]));
        pnm.setPulseRate(Integer.valueOf(receiveSee[i++]));
        pnm.setChest(Integer.valueOf(receiveSee[i++]));
        pnm.setBreath(Integer.valueOf(receiveSee[i++]));
        pnm.setWeak(Integer.valueOf(receiveSee[i++]));
        pnm.setDehydrate(Integer.valueOf(receiveSee[i++]));
        pnm.setMeaslesCondition(Integer.valueOf(receiveSee[i++]));
        pnm.setFeverCount(Integer.valueOf(receiveSee[i++]));
        i = 0;
        pnm.setStryder(Integer.valueOf(receiveHear[i++]));
        pnm.setExhale(Integer.valueOf(receiveHear[i++]));
        pnm.setShortBreath(Integer.valueOf(receiveHear[i++]));

        pnm.setComments(other);

        PNMDataInterface dataInterface = new PNMDataInterface(getApplicationContext());
        try {
            dataInterface.createPNM(pnm, 0);
            Toast.makeText(getApplicationContext(), "Form submitted", Toast.LENGTH_SHORT).show();
            finish();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pnmform_other, menu);
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
