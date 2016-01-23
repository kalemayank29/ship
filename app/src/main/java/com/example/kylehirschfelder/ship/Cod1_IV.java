package com.example.kylehirschfelder.ship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Cod1_IV extends AppCompatActivity {

    RadioGroup cry,work, breath, color, wounds, bend, fit, unConsc, arms, water, twins, age, first, delivery;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1__iv);

        cry = (RadioGroup) findViewById(R.id.cry);
        work = (RadioGroup) findViewById(R.id.work);
        breath = (RadioGroup) findViewById(R.id.breath);
        color = (RadioGroup) findViewById(R.id.color);
        wounds = (RadioGroup) findViewById(R.id.wounds);
        bend = (RadioGroup) findViewById(R.id.bend);
        fit = (RadioGroup) findViewById(R.id.fit);
        unConsc = (RadioGroup) findViewById(R.id.unConsc);
        arms = (RadioGroup) findViewById(R.id.arms);
        water = (RadioGroup) findViewById(R.id.water);
        twins = (RadioGroup) findViewById(R.id.twins);
        age = (RadioGroup) findViewById(R.id.age);
        first = (RadioGroup) findViewById(R.id.first);
        delivery = (RadioGroup) findViewById(R.id.delivery);

        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cryValue = cry.indexOfChild(findViewById(cry.getCheckedRadioButtonId()));
                int workValue = work.indexOfChild(findViewById(work.getCheckedRadioButtonId()));
                int breathValue = breath.indexOfChild(findViewById(breath.getCheckedRadioButtonId()));
                int colorValue = color.indexOfChild(findViewById(color.getCheckedRadioButtonId()));
                int woundsValue = wounds.indexOfChild(findViewById(wounds.getCheckedRadioButtonId()));
                int bendValue = bend.indexOfChild(findViewById(bend.getCheckedRadioButtonId()));
                int fitValue = fit.indexOfChild(findViewById(fit.getCheckedRadioButtonId()));
                int unConscValue = unConsc.indexOfChild(findViewById(unConsc.getCheckedRadioButtonId()));
                int armsValue = arms.indexOfChild(findViewById(arms.getCheckedRadioButtonId()));
                int waterValue = water.indexOfChild(findViewById(water.getCheckedRadioButtonId()));
                int twinsValue = twins.indexOfChild(findViewById(twins.getCheckedRadioButtonId()));
                int ageValue = age.indexOfChild(findViewById(age.getCheckedRadioButtonId()));
                int firstValue = first.indexOfChild(findViewById(first.getCheckedRadioButtonId()));
                int deliveryValue = delivery.indexOfChild(findViewById(delivery.getCheckedRadioButtonId()));



            }
        });


/*

int cryValue = cry.indexOfChild(findViewById(cry.getCheckedRadioButtonId()));
 int workValue = work.indexOfChild(findViewById(work.getCheckedRadioButtonId()));
 int breathValue = breath.indexOfChild(findViewById(breath.getCheckedRadioButtonId()));
 int colorValue = color.indexOfChild(findViewById(color.getCheckedRadioButtonId()));
 int woundsValue = wounds.indexOfChild(findViewById(wounds.getCheckedRadioButtonId()));
 int bendValue = bend.indexOfChild(findViewById(bend.getCheckedRadioButtonId()));
 int fitValue = fit.indexOfChild(findViewById(fit.getCheckedRadioButtonId()));
 int unConscValue = unConsc.indexOfChild(findViewById(unConsc.getCheckedRadioButtonId()));
 int armsValue = arms.indexOfChild(findViewById(arms.getCheckedRadioButtonId()));
 int waterValue = water.indexOfChild(findViewById(water.getCheckedRadioButtonId()));
 int twinsValue = twins.indexOfChild(findViewById(twins.getCheckedRadioButtonId()));
 int ageValue = age.indexOfChild(findViewById(age.getCheckedRadioButtonId()));
 int firstValue = first.indexOfChild(findViewById(first.getCheckedRadioButtonId()));
 int deliverValue = deliver.indexOfChild(findViewById(deliver.getCheckedRadioButtonId()));

 */




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1__iv, menu);
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
