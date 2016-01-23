package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Cod1to5_III extends AppCompatActivity {
    LinearLayout measlesT,feverT,coughT,eyesT,goneT,waterT;
    RadioGroup measles,fever,cough,eyes,gone,water;
    RadioButton days,death;
    EditText measlesDays, deathAge;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__iii);

        days = new RadioButton(getApplicationContext());
        death = new RadioButton(getApplicationContext());

     
        measlesT = (LinearLayout) findViewById(R.id.measlesT);
        feverT = (LinearLayout) findViewById(R.id.feverT);
        coughT = (LinearLayout) findViewById(R.id.coughT);
        eyesT = (LinearLayout) findViewById(R.id.eyesT);
        goneT = (LinearLayout) findViewById(R.id.goneT);
        waterT = (LinearLayout) findViewById(R.id.waterT);
        
        measles = (RadioGroup) findViewById(R.id.measles);
        fever = (RadioGroup) findViewById(R.id.fever);
        cough = (RadioGroup) findViewById(R.id.cough);
        eyes = (RadioGroup) findViewById(R.id.eyes);
        gone = (RadioGroup) findViewById(R.id.gone);
        water = (RadioGroup) findViewById(R.id.water);

        days = (RadioButton) findViewById(R.id.noDays);
        death = (RadioButton) findViewById(R.id.noDeathAge);

        measlesDays = (EditText) findViewById(R.id.yesDays);
        deathAge = (EditText) findViewById(R.id.yesDeathAge);

        next = (Button) findViewById(R.id.next);

        setAll();

        deathAge.setFocusableInTouchMode(true);

        measlesDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                measlesDays.setEnabled(true);
                measlesDays.setFocusableInTouchMode(true);
                measlesDays.setText("");
                days.setChecked(false);
                showKeyboard(view);
                //CodOneFive.getInstance().setMeasles_days(measlesDays.getText().toString());
                if(!death.isChecked()) unHideAll();

            }

        });

        deathAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deathAge.setEnabled(true);
                deathAge.setFocusableInTouchMode(true);
                deathAge.setText("");
                death.setChecked(false);
                showKeyboard(view);
                if(!days.isChecked()) unHideAll();
                //CodOneFive.getInstance().setMeasles_days(measlesDays.getText().toString());

            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int measlesValue = measles.indexOfChild(findViewById(measles.getCheckedRadioButtonId()));
                int feverValue = fever.indexOfChild(findViewById(fever.getCheckedRadioButtonId()));
                int coughValue = cough.indexOfChild(findViewById(cough.getCheckedRadioButtonId()));
                int eyesValue = eyes.indexOfChild(findViewById(eyes.getCheckedRadioButtonId()));
                int goneValue = gone.indexOfChild(findViewById(gone.getCheckedRadioButtonId()));
                int waterValue = water.indexOfChild(findViewById(water.getCheckedRadioButtonId()));

                CodOneFive.getInstance().setMeasles_days(measlesDays.getText().toString());
                CodOneFive.getInstance().setDeath_age(deathAge.getText().toString());
                CodOneFive.getInstance().setMeasles_three_days(String.valueOf(measlesValue));
                CodOneFive.getInstance().setMeasles_fever(String.valueOf(feverValue));
                CodOneFive.getInstance().setMeasles_cough(String.valueOf(coughValue));
                CodOneFive.getInstance().setMeasles_eyes(String.valueOf(eyesValue));
                CodOneFive.getInstance().setMeasles_gone(String.valueOf(goneValue));
                CodOneFive.getInstance().setMeasles_water(String.valueOf(waterValue));

                Intent intent = new Intent(getApplicationContext(),Cod1to5_III.class);
                startActivity(intent);
            }
        });


    }

    public void radioClick(View view){
        String tag = (String) view.getTag();
        switch(tag){
            case "noDays":
                measlesDays.setText("0");
                measlesDays.setFocusable(false);
                measlesDays.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setMeasles_days("0");
                
            break;
            case "noDeath":
                deathAge.setText("0");
                deathAge.setFocusable(false);
                deathAge.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setDeath_age("0");
                break;


        }
        hideAll();
    }
    
    private void hideAll(){
        measlesT.setVisibility(View.GONE);
        feverT.setVisibility(View.GONE);
        coughT.setVisibility(View.GONE);
        eyesT.setVisibility(View.GONE);
        goneT.setVisibility(View.GONE);
        waterT.setVisibility(View.GONE);

        measles.setVisibility(View.GONE);
        fever.setVisibility(View.GONE);
        cough.setVisibility(View.GONE);
        eyes.setVisibility(View.GONE);
        gone.setVisibility(View.GONE);
        water.setVisibility(View.GONE);
    }

    private void unHideAll(){
        measlesT.setVisibility(View.VISIBLE);
        feverT.setVisibility(View.VISIBLE);
        coughT.setVisibility(View.VISIBLE);
        eyesT.setVisibility(View.VISIBLE);
        goneT.setVisibility(View.VISIBLE);
        waterT.setVisibility(View.VISIBLE);

        measles.setVisibility(View.VISIBLE);
        fever.setVisibility(View.VISIBLE);
        cough.setVisibility(View.VISIBLE);
        eyes.setVisibility(View.VISIBLE);
        gone.setVisibility(View.VISIBLE);
        water.setVisibility(View.VISIBLE);
    }

    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public void setAll(){
        if(CodOneFive.getInstance().getMeasles_fever()!= null){
            ((RadioButton)fever.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_fever()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_three_days()!= null){
            ((RadioButton)measles.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_three_days()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_cough()!= null){
            ((RadioButton)cough.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_cough()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_eyes()!= null){
            ((RadioButton)eyes.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_eyes()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_gone()!= null){
            ((RadioButton)gone.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_gone()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_water()!= null){
            ((RadioButton)water.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMeasles_water()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMeasles_days()!= null){
            if(CodOneFive.getInstance().getMeasles_days().equals("0")){
                days.setChecked(true);
            }
            else{
                measlesDays.setText(CodOneFive.getInstance().getMeasles_days());
            }
        }

        if(CodOneFive.getInstance().getDeath_age()!= null){
            if(CodOneFive.getInstance().getDeath_age().equals("0")){
                death.setChecked(true);
            }
            else{
                deathAge.setText(CodOneFive.getInstance().getDeath_age());
            }
        }
    }
/*

    public void text_click(View view){
        String tag = (String) view.getTag();
        switch(tag){
            case "yesDays":
                days.setEnabled(false);
                measlesDays.setEnabled(true);
                CodOneFive.getInstance().setMeasles_days(measlesDays.getText().toString());


        }
    }*/
private void hideDefaultKeyboard() {
    this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    //you have got lot of methods here
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__iii, menu);
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
