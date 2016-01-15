package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Cod1to5_IV extends AppCompatActivity {

    RadioGroup growth, meal, malntr, health, play, CHANGE, premat;
    RadioButton noWeight, noSwelling, noDysentry, dontKnowDysentry, noBlind, dontKnowBlind;
    EditText yesWeight, yesSwelling, yesDysentry, yesBlind, milkDays, milkBott, food;
    Button next;
    LinearLayout big;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__iv);


        big = (LinearLayout)findViewById(R.id.big);
        growth = (RadioGroup) findViewById(R.id.growth);
        meal = (RadioGroup) findViewById(R.id.meal);
        malntr = (RadioGroup) findViewById(R.id.malntr);
        health  =  (RadioGroup) findViewById(R.id.health);
        play    =   (RadioGroup) findViewById(R.id.play);
        CHANGE   =  (RadioGroup) findViewById(R.id.CHANGE);
        premat =  (RadioGroup) findViewById(R.id.premat);
        next = (Button) findViewById(R.id.next);

        noWeight = (RadioButton) findViewById(R.id.noWeight);
        noSwelling = (RadioButton) findViewById(R.id.noSwelling);
        noDysentry = (RadioButton) findViewById(R.id.noDysentry);
        dontKnowDysentry = (RadioButton) findViewById(R.id.dontKnowDysentry);
        noBlind = (RadioButton) findViewById(R.id.noBlind);
        dontKnowBlind = (RadioButton) findViewById(R.id.dontKnowBlind);

        yesWeight = (EditText) findViewById(R.id.yesWeight);
        yesSwelling = (EditText) findViewById(R.id.yesSwelling);
        yesDysentry = (EditText) findViewById(R.id.yesDays);
        yesBlind = (EditText) findViewById(R.id.yesBlind);
        milkDays = (EditText) findViewById(R.id.milkDays);
        milkBott = (EditText) findViewById(R.id.milkBott);
        food = (EditText) findViewById(R.id.food);

        setAll();

        yesWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesWeight.setEnabled(true);
                yesWeight.setFocusableInTouchMode(true);
                yesWeight.setText("");
                noWeight.setChecked(false);
                showKeyboard(view);
                big.setVisibility(View.VISIBLE);
            }
        });

        yesSwelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesSwelling.setEnabled(true);
                yesSwelling.setFocusableInTouchMode(true);
                yesSwelling.setText("");
                noSwelling.setChecked(false);
                showKeyboard(view);
                big.setVisibility(View.VISIBLE);
            }
        });

        yesDysentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesDysentry.setEnabled(true);
                yesDysentry.setFocusableInTouchMode(true);
                yesDysentry.setText("");
                noDysentry.setChecked(false);
                dontKnowDysentry.setChecked(false);
                showKeyboard(view);
            }
        });

        yesBlind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesBlind.setEnabled(true);
                yesBlind.setFocusableInTouchMode(true);
                yesBlind.setText("");
                noBlind.setChecked(false);
                dontKnowBlind.setChecked(false);
                showKeyboard(view);
            }
        });

        growth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int growthValue = growth.indexOfChild(findViewById(checkedId));
                if(growthValue == 0 && noWeight.isChecked() && noSwelling.isChecked()) {
                    big.setVisibility(View.GONE);
                }
                else if(growthValue == 1)
                    big.setVisibility(View.VISIBLE);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int growthValue = growth.indexOfChild(findViewById(growth.getCheckedRadioButtonId()));
                int mealValue = meal.indexOfChild(findViewById(meal.getCheckedRadioButtonId()));
                int malntrValue = malntr.indexOfChild(findViewById(malntr.getCheckedRadioButtonId()));
                int healthValue = health.indexOfChild(findViewById(health.getCheckedRadioButtonId()));
                int playValue = play.indexOfChild(findViewById(play.getCheckedRadioButtonId()));
                int CHANGEValue = CHANGE.indexOfChild(findViewById(CHANGE.getCheckedRadioButtonId()));
                int prematValue = premat.indexOfChild(findViewById(premat.getCheckedRadioButtonId()));

                CodOneFive.getInstance().setMalntr_growth(String.valueOf(growthValue));
                CodOneFive.getInstance().setMalntr_meal(String.valueOf(mealValue));
                CodOneFive.getInstance().setMalntr_days(String.valueOf(malntrValue));
                CodOneFive.getInstance().setMalntr_health(String.valueOf(healthValue));
                CodOneFive.getInstance().setMalntr_play(String.valueOf(playValue));
                CodOneFive.getInstance().setMalntr_satvi_CHANGE(String.valueOf(CHANGEValue));
                CodOneFive.getInstance().setMalntr_premature(String.valueOf(prematValue));
                CodOneFive.getInstance().setMalntr_weight(yesWeight.getText().toString());
                CodOneFive.getInstance().setMalntr_swelling(yesSwelling.getText().toString());
                CodOneFive.getInstance().setMalntr_milk(milkDays.getText().toString());
                CodOneFive.getInstance().setMalntr_milk_bott(milkBott.getText().toString());
                CodOneFive.getInstance().setMalntr_food(food.getText().toString());
                CodOneFive.getInstance().setMalntr_poop(yesDysentry.getText().toString());
                CodOneFive.getInstance().setMalntr_blind(yesBlind.getText().toString());

                Intent intent = new Intent(getApplicationContext(),Cod1to5_V.class);
                startActivity(intent);
            }
        });


    }

    public void radioClick(View view){
        String tag = (String) view.getTag();
        switch(tag){
            case "noWeight":
                yesWeight.setText("0");
                yesWeight.setFocusable(false);
                yesWeight.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_weight("0");
                if(noSwelling.isChecked() && growth.indexOfChild(findViewById(growth.getCheckedRadioButtonId())) == 0)
                    big.setVisibility(View.GONE);
                break;
            case "noSwelling":
                yesSwelling.setText("0");
                yesSwelling.setFocusable(false);
                yesSwelling.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_swelling("0");
                if(noWeight.isChecked() && growth.indexOfChild(findViewById(growth.getCheckedRadioButtonId())) == 0)
                    big.setVisibility(View.GONE);
                break;
            case "noDysentry":
                yesDysentry.setText("0");
                yesDysentry.setFocusable(false);
                yesDysentry.setClickable(true);
                dontKnowDysentry.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_poop("0");
                break;
            case "noBlind":
                yesBlind.setText("0");
                yesBlind.setFocusable(false);
                yesBlind.setClickable(true);
                dontKnowBlind.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_blind("0");
                break;
            case "dontKnowDysentry":
                yesDysentry.setText("-1");
                yesDysentry.setFocusable(false);
                yesDysentry.setClickable(true);
                noDysentry.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_poop("-1");
                break;
            case "dontKnowBlind":
                yesBlind.setText("-1");
                yesBlind.setFocusable(false);
                yesBlind.setClickable(true);
                noBlind.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setMalntr_blind("-1");
                break;
        }


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
        if(CodOneFive.getInstance().getMalntr_growth()!= null){
            ((RadioButton)growth.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_growth()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_meal()!= null){
            ((RadioButton)meal.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_meal()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_days()!= null){
            ((RadioButton)malntr.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_days()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_health()!= null){
            ((RadioButton)health.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_health()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_play()!= null){
            ((RadioButton)play.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_play()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_satvi_CHANGE()!= null){
            ((RadioButton)CHANGE.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_satvi_CHANGE()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_premature()!= null){
            ((RadioButton)premat.getChildAt(Integer.parseInt(CodOneFive.getInstance().getMalntr_premature()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getMalntr_milk()!= null){
            milkDays.setText(CodOneFive.getInstance().getMalntr_milk());
        }
        if(CodOneFive.getInstance().getMalntr_milk_bott()!= null){
            milkBott.setText(CodOneFive.getInstance().getMalntr_milk_bott());
        }
        if(CodOneFive.getInstance().getMalntr_food()!= null){
            food.setText(CodOneFive.getInstance().getMalntr_food());
        }


        if(CodOneFive.getInstance().getMalntr_weight()!= null){
            if(CodOneFive.getInstance().getMalntr_weight().equals("0")){
                noWeight.setChecked(true);
                yesWeight.setText("0");
            }
            else{
                noWeight.setChecked(false);
                yesWeight.setText(CodOneFive.getInstance().getMalntr_weight());
            }
        }

        if(CodOneFive.getInstance().getMalntr_swelling()!= null){
            if(CodOneFive.getInstance().getMalntr_swelling().equals("0")){
                noSwelling.setChecked(true);
                yesSwelling.setText("0");
            }
            else{
                noSwelling.setChecked(false);
                yesSwelling.setText(CodOneFive.getInstance().getMalntr_swelling());
            }
        }

        if(CodOneFive.getInstance().getMalntr_poop()!= null){
            if(CodOneFive.getInstance().getMalntr_poop().equals("0")){
                noDysentry.setChecked(true);
                dontKnowDysentry.setChecked(false);
                yesDysentry.setText("0");
            }
            else if(CodOneFive.getInstance().getMalntr_poop().equals("-1")) {
                noDysentry.setChecked(false);
                dontKnowDysentry.setChecked(true);
                yesDysentry.setText("-1");
            }
            else{
                noDysentry.setChecked(false);
                dontKnowDysentry.setChecked(false);
                yesDysentry.setText(CodOneFive.getInstance().getMalntr_poop());
            }
        }

        if(CodOneFive.getInstance().getMalntr_blind()!= null){
            if(CodOneFive.getInstance().getMalntr_blind().equals("0")){
                noBlind.setChecked(true);
                dontKnowBlind.setChecked(false);
                yesBlind.setText("0");
            }
            else if(CodOneFive.getInstance().getMalntr_blind().equals("-1")) {
                noBlind.setChecked(false);
                dontKnowBlind.setChecked(true);
                yesBlind.setText("-1");
            }
            else{
                noBlind.setChecked(false);
                dontKnowBlind.setChecked(false);
                yesBlind.setText(CodOneFive.getInstance().getMalntr_blind());
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__iv, menu);
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
