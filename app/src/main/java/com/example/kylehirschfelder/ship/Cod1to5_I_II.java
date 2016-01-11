package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Cod1to5_I_II extends AppCompatActivity {

    RadioGroup pregMonths,sizeGroup,accidentG;
    Button next;
    int prMonths,size,accident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__i__ii);
        pregMonths = (RadioGroup) findViewById(R.id.pregMonths);
        sizeGroup = (RadioGroup) findViewById(R.id.size);
        accidentG = (RadioGroup) findViewById(R.id.accidentG);
        next = (Button) findViewById(R.id.next);

        if(CodOneFive.getInstance().getBirth_time()!= null){
            ((RadioButton)pregMonths.getChildAt(Integer.parseInt(CodOneFive.getInstance().getBirth_time()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getSize()!= null){
            ((RadioButton)sizeGroup.getChildAt(Integer.parseInt(CodOneFive.getInstance().getSize()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDeath_accident()!= null){
            ((RadioButton)accidentG.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDeath_accident()))).setChecked(true);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prMonths = pregMonths.indexOfChild(findViewById(pregMonths.getCheckedRadioButtonId()));
                size = sizeGroup.indexOfChild(findViewById(sizeGroup.getCheckedRadioButtonId()));
                accident = accidentG.indexOfChild(findViewById(accidentG.getCheckedRadioButtonId()));

                CodOneFive.getInstance().setBirth_time(String.valueOf(prMonths));
                CodOneFive.getInstance().setSize(String.valueOf(size));
                CodOneFive.getInstance().setDeath_accident(String.valueOf(accident));

                Intent intent = new Intent(getApplicationContext(),Cod1to5_III.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__i__ii, menu);
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
