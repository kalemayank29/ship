package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Cod1_IX extends AppCompatActivity {

    EditText yesMilk, yesUnconsc, yesCry, yesFever, yesCold,yesSwell, yesLose, yesVomit, yesStomach, yesFit, yesStart,
                yesBreath, yesSkin, yesBelly, crampDays, waterDays, deliveryDays;

    RadioButton noMilk, noUnconsc, noCry, noFever, dontKnowFever, noCold, dontKnowCold, noSwell, dontKnowSwell, noLose,
            dontKnowLose, noVomit, dontKnowVomit, noStomach, dontKnowStomach, noFit, dontKnowFit, noStart, dontKnowStart,
            noBreath, dontKnowBreath, noSkin, dontKnowSkin, noBelly, dontKnowBelly;

    RadioGroup teeth, Stop, Time, pregWater, pregFever, feverTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1_ix);

        yesMilk = (EditText) findViewById(R.id.yesMilk);
        yesUnconsc = (EditText) findViewById(R.id.yesUnconsc);
        yesCry = (EditText) findViewById(R.id.yesCry);
        yesFever = (EditText) findViewById(R.id.yesFever);
        yesCold = (EditText) findViewById(R.id.yesCold);
        yesSwell = (EditText) findViewById(R.id.yesSwell);
        yesLose = (EditText) findViewById(R.id.yesLose);
        yesVomit = (EditText) findViewById(R.id.yesVomit);
        yesStomach = (EditText) findViewById(R.id.yesStomach);
        yesFit = (EditText) findViewById(R.id.yesFit);
        yesStart = (EditText) findViewById(R.id.yesStart);
        yesBreath = (EditText) findViewById(R.id.yesBreath);
        yesSkin = (EditText) findViewById(R.id.yesSkin);
        yesBelly = (EditText) findViewById(R.id.yesBelly);
        crampDays = (EditText) findViewById(R.id.crampDays);
        waterDays = (EditText) findViewById(R.id.waterDays);
        deliveryDays = (EditText) findViewById(R.id.deliveryDays);

        yesMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesMilk.setEnabled(true);
                yesMilk.setFocusableInTouchMode(true);
                yesMilk.setText("");
                noMilk.setChecked(false);
                showKeyboard(view);
            }
        });
        yesUnconsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesUnconsc.setEnabled(true);
                yesUnconsc.setFocusableInTouchMode(true);
                yesUnconsc.setText("");
                noUnconsc.setChecked(false);
                showKeyboard(view);
            }
        });
        yesCry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesCry.setEnabled(true);
                yesCry.setFocusableInTouchMode(true);
                yesCry.setText("");
                noCry.setChecked(false);
                showKeyboard(view);
            }
        });
        yesFever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesFever.setEnabled(true);
                yesFever.setFocusableInTouchMode(true);
                yesFever.setText("");
                noFever.setChecked(false);
                showKeyboard(view);
            }
        });
        yesCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesCold.setEnabled(true);
                yesCold.setFocusableInTouchMode(true);
                yesCold.setText("");
                noCold.setChecked(false);
                showKeyboard(view);
            }
        });
        yesSwell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesSwell.setEnabled(true);
                yesSwell.setFocusableInTouchMode(true);
                yesSwell.setText("");
                noSwell.setChecked(false);
                showKeyboard(view);
            }
        });
        yesLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesLose.setEnabled(true);
                yesLose.setFocusableInTouchMode(true);
                yesLose.setText("");
                noLose.setChecked(false);
                showKeyboard(view);
            }
        });
        yesVomit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesVomit.setEnabled(true);
                yesVomit.setFocusableInTouchMode(true);
                yesVomit.setText("");
                noVomit.setChecked(false);
                showKeyboard(view);
            }
        });
        yesStomach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesStomach.setEnabled(true);
                yesStomach.setFocusableInTouchMode(true);
                yesStomach.setText("");
                noStomach.setChecked(false);
                showKeyboard(view);
            }
        });
        yesFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesFit.setEnabled(true);
                yesFit.setFocusableInTouchMode(true);
                yesFit.setText("");
                noFit.setChecked(false);
                showKeyboard(view);
            }
        });
        yesStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesStart.setEnabled(true);
                yesStart.setFocusableInTouchMode(true);
                yesStart.setText("");
                noStart.setChecked(false);
                showKeyboard(view);
            }
        });
        yesBreath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesBreath.setEnabled(true);
                yesBreath.setFocusableInTouchMode(true);
                yesBreath.setText("");
                noBreath.setChecked(false);
                showKeyboard(view);
            }
        });
        yesSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesSkin.setEnabled(true);
                yesSkin.setFocusableInTouchMode(true);
                yesSkin.setText("");
                noSkin.setChecked(false);
                showKeyboard(view);
            }
        });
        yesBelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesBelly.setEnabled(true);
                yesBelly.setFocusableInTouchMode(true);
                yesBelly.setText("");
                noBelly.setChecked(false);
                showKeyboard(view);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1_ix, menu);
        return true;
    }

    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
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
