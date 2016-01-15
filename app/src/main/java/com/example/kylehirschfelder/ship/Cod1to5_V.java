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

public class Cod1to5_V extends AppCompatActivity {

    RadioGroup cough,asthama,face,coughSound,coughVomit,coughWhoop,coughWhoopCont,dose;
    Button back, next;
    RadioButton noMucus, dontKnowMucus, noFever, dontKnowFever, noCHANGE, dontKnowCHANGE, noCoughL,dontKnowCoughL;
    EditText yesMucus, yesFever, yesCHANGE, yesCoughL, coughDays,asthamaDays;
    LinearLayout big, otherBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__v);

        big = (LinearLayout)findViewById(R.id.big);
        otherBig = (LinearLayout)findViewById(R.id.otherBig);
        cough = (RadioGroup) findViewById(R.id.cough);
        asthama =(RadioGroup) findViewById(R.id.asthama);
        face = (RadioGroup) findViewById(R.id.face);
        coughSound = (RadioGroup) findViewById(R.id.coughSound);
        coughVomit = (RadioGroup) findViewById(R.id.coughVomit);
        coughWhoop = (RadioGroup) findViewById(R.id.coughWhoop);
        coughWhoopCont = (RadioGroup) findViewById(R.id.coughWhoopCont);
        dose = (RadioGroup) findViewById(R.id.dose);



        noMucus = (RadioButton) findViewById(R.id.noMucus);
        dontKnowMucus= (RadioButton) findViewById(R.id.dontKnowMucus);
        noFever = (RadioButton) findViewById(R.id. noFever);
        dontKnowFever = (RadioButton) findViewById(R.id. dontKnowFever);
        noCHANGE = (RadioButton) findViewById(R.id. noCHANGE);
        dontKnowCHANGE= (RadioButton) findViewById(R.id. dontKnowCHANGE);
        noCoughL= (RadioButton) findViewById(R.id. noCoughL);
        dontKnowCoughL = (RadioButton) findViewById(R.id.dontKnowCoughL);

        yesMucus = (EditText) findViewById(R.id.yesMucus);
        yesFever = (EditText) findViewById(R.id.yesFever);
        yesCHANGE = (EditText) findViewById(R.id.yesCHANGE);
        yesCoughL = (EditText) findViewById(R.id.yesCoughL);
        coughDays = (EditText) findViewById(R.id.coughDays);
        asthamaDays = (EditText) findViewById(R.id.asthamaDays);

        setAll();

        cough.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(cough.indexOfChild(findViewById(checkedId)) == 0 && asthama.indexOfChild(findViewById(asthama.getCheckedRadioButtonId())) == 0) {
                    big.setVisibility(View.GONE);
                    otherBig.setVisibility(View.GONE);
                }
                else {
                    big.setVisibility(View.VISIBLE);
                    otherBig.setVisibility(View.VISIBLE);
                }
            }
        });
        asthama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(cough.indexOfChild(findViewById(cough.getCheckedRadioButtonId())) == 0 && asthama.indexOfChild(findViewById(checkedId)) == 0) {
                    big.setVisibility(View.GONE);
                    otherBig.setVisibility(View.GONE);
                }
                else {
                    big.setVisibility(View.VISIBLE);
                    otherBig.setVisibility(View.VISIBLE);
                }
            }
        });
        
        yesCoughL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesCoughL.setEnabled(true);
                yesCoughL.setFocusableInTouchMode(true);
                yesCoughL.setText("");
                noCoughL.setChecked(false);
                dontKnowCoughL.setChecked(false);
                showKeyboard(view);

            }
        });
        


        yesCHANGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesCHANGE.setEnabled(true);
                yesCHANGE.setFocusableInTouchMode(true);
                yesCHANGE.setText("");
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(false);
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
                dontKnowFever.setChecked(false);
                showKeyboard(view);

            }
        });


        yesMucus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesMucus.setEnabled(true);
                yesMucus.setFocusableInTouchMode(true);
                yesMucus.setText("");
                noMucus.setChecked(false);
                dontKnowMucus.setChecked(false);
                showKeyboard(view);

            }
        });

        coughDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesCHANGE.setText("");
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(false);
            }
        });


        yesCHANGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(coughDays.getText().toString()) < 15)
                    otherBig.setVisibility(View.GONE);
                else
                    otherBig.setVisibility(View.VISIBLE);
            }
        });
        noCHANGE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Integer.parseInt(coughDays.getText().toString()) < 15)
                    otherBig.setVisibility(View.GONE);
                else
                    otherBig.setVisibility(View.VISIBLE);
            }
        });
        dontKnowCHANGE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Integer.parseInt(coughDays.getText().toString()) < 15)
                    otherBig.setVisibility(View.GONE);
                else
                    otherBig.setVisibility(View.VISIBLE);
            }
        });


        back = (Button) findViewById(R.id.back);
        next = (Button) findViewById(R.id.next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cod1to5_IV.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coughValue = cough.indexOfChild(findViewById(cough.getCheckedRadioButtonId()));
                int asthamaValue = asthama.indexOfChild(findViewById(asthama.getCheckedRadioButtonId()));
                int faceValue = face.indexOfChild(findViewById(face.getCheckedRadioButtonId()));
                int coughSoundValue = coughSound.indexOfChild(findViewById(coughSound.getCheckedRadioButtonId()));
                int coughVomitValue = coughVomit.indexOfChild(findViewById(coughVomit.getCheckedRadioButtonId()));
                int coughWhoopValue = coughWhoop.indexOfChild(findViewById(coughWhoop.getCheckedRadioButtonId()));
                int coughWhoopContValue = coughWhoopCont.indexOfChild(findViewById(coughWhoopCont.getCheckedRadioButtonId()));
                int doseValue = dose.indexOfChild(findViewById(dose.getCheckedRadioButtonId()));

                //Log.println(Log.ASSERT,"cough",String.valueOf(doseValue));
                CodOneFive.getInstance().setBreath_cough(String.valueOf(coughValue));
                CodOneFive.getInstance().setBreath_asthama(String.valueOf(asthamaValue));
                CodOneFive.getInstance().setCough_face(String.valueOf(faceValue));
                CodOneFive.getInstance().setCough_sound(String.valueOf(coughSoundValue));
                CodOneFive.getInstance().setCough_vomit(String.valueOf(coughVomitValue));
                CodOneFive.getInstance().setCough_whoop(String.valueOf(coughWhoopValue));
                CodOneFive.getInstance().setCough_whoop_spread(String.valueOf(coughWhoopContValue));
                CodOneFive.getInstance().setCough_dose(String.valueOf(doseValue));
                CodOneFive.getInstance().setBreath_cough_days(coughDays.getText().toString());
                CodOneFive.getInstance().setBreath_asthama_days(asthamaDays.getText().toString());
                CodOneFive.getInstance().setBreath_mucus(yesMucus.getText().toString());
                CodOneFive.getInstance().setBreath_fever(yesFever.getText().toString());
                CodOneFive.getInstance().setBreath_CHANGE_kanvhavat(yesCHANGE.getText().toString());
                CodOneFive.getInstance().setBreath_cough_long(yesCoughL.getText().toString());

                Intent intent = new Intent(getApplicationContext(), Cod1to5_V.class);
                startActivity(intent);

            }
        });




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
        if(CodOneFive.getInstance().getBreath_cough()!= null){
            ((RadioButton) cough.getChildAt(Integer.parseInt(CodOneFive.getInstance().getBreath_cough()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getBreath_asthama()!= null){
            ((RadioButton) asthama.getChildAt(Integer.parseInt(CodOneFive.getInstance().getBreath_asthama()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_face()!= null){
            ((RadioButton) face.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_face()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_sound()!= null){
            ((RadioButton) coughSound.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_sound()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_vomit()!= null){
            ((RadioButton) coughVomit.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_vomit()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_whoop()!= null){
            ((RadioButton) coughWhoop.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_whoop()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_whoop_spread()!= null){
            ((RadioButton) coughWhoopCont.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_whoop_spread()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getCough_dose()!= null){
            ((RadioButton) dose.getChildAt(Integer.parseInt(CodOneFive.getInstance().getCough_dose()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getBreath_cough_days()!= null){
            coughDays.setText(CodOneFive.getInstance().getBreath_cough_days());
        }
        if(CodOneFive.getInstance().getBreath_asthama_days()!= null){
            asthamaDays.setText(CodOneFive.getInstance().getBreath_asthama_days());
        }

        

        if(CodOneFive.getInstance().getBreath_mucus()!= null){
            if(CodOneFive.getInstance().getBreath_mucus().equals("0")){
                noMucus.setChecked(true);
                dontKnowMucus.setChecked(false);
                yesMucus.setText("0");
            }
            else if(CodOneFive.getInstance().getBreath_mucus().equals("-1")) {
                noMucus.setChecked(false);
                dontKnowMucus.setChecked(true);
                yesMucus.setText("-1");
            }
            else{
                noMucus.setChecked(false);
                dontKnowMucus.setChecked(false);
                yesMucus.setText(CodOneFive.getInstance().getBreath_mucus());
            }
        }

        if(CodOneFive.getInstance().getBreath_fever()!= null){
            if(CodOneFive.getInstance().getBreath_fever().equals("0")){
                noFever.setChecked(true);
                dontKnowFever.setChecked(false);
                yesFever.setText("0");
            }
            else if(CodOneFive.getInstance().getBreath_fever().equals("-1")) {
                noFever.setChecked(false);
                dontKnowFever.setChecked(true);
                yesFever.setText("-1");
            }
            else{
                noFever.setChecked(false);
                dontKnowFever.setChecked(false);
                yesFever.setText(CodOneFive.getInstance().getBreath_fever());
            }
        }

        if(CodOneFive.getInstance().getBreath_CHANGE_kanvhavat()!= null){
            if(CodOneFive.getInstance().getBreath_CHANGE_kanvhavat().equals("0")){
                noCHANGE.setChecked(true);
                dontKnowCHANGE.setChecked(false);
                yesCHANGE.setText("0");
            }
            else if(CodOneFive.getInstance().getBreath_CHANGE_kanvhavat().equals("-1")) {
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(true);
                yesCHANGE.setText("-1");
            }
            else{
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(false);
                yesCHANGE.setText(CodOneFive.getInstance().getBreath_CHANGE_kanvhavat());
            }
        }

        if(CodOneFive.getInstance().getBreath_cough_long()!= null){
            if(CodOneFive.getInstance().getBreath_cough_long().equals("0")){
                noCoughL.setChecked(true);
                dontKnowCoughL.setChecked(false);
                yesCoughL.setText("0");
            }
            else if(CodOneFive.getInstance().getBreath_cough_long().equals("-1")) {
                noCoughL.setChecked(false);
                dontKnowCoughL.setChecked(true);
                yesCoughL.setText("-1");
            }
            else{
                noCoughL.setChecked(false);
                dontKnowCoughL.setChecked(false);
                yesCoughL.setText(CodOneFive.getInstance().getBreath_cough_long());
            }
        }

    }

    public void radioClick(View view){
        String tag = (String) view.getTag();
        switch(tag){
            case "noMucus":
                yesMucus.setText("0");
                yesMucus.setFocusable(false);
                yesMucus.setClickable(true);
                dontKnowMucus.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_mucus("0");
                break;
            case "noFever":
                yesFever.setText("0");
                yesFever.setFocusable(false);
                yesFever.setClickable(true);
                dontKnowFever.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_fever("0");
                break;
            case "dontKnowMucus":
                yesMucus.setText("-1");
                yesMucus.setFocusable(false);
                yesMucus.setClickable(true);
                noMucus.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_mucus("-1");
                break;
            case "dontKnowFever":
                yesFever.setText("-1");
                yesFever.setFocusable(false);
                yesFever.setClickable(true);
                noFever.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_fever("-1");
                break;
            case "noCHANGE":
                yesCHANGE.setText("0");
                yesCHANGE.setFocusable(false);
                yesCHANGE.setClickable(true);
                dontKnowCHANGE.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_CHANGE_kanvhavat("0");
                break;
            case "dontKnowCHANGE":
                yesCHANGE.setText("-1");
                yesCHANGE.setFocusable(false);
                yesCHANGE.setClickable(true);
                noCHANGE.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_CHANGE_kanvhavat("-1");
                break;
            case "noCoughL":
                yesCoughL.setText("0");
                yesCoughL.setFocusable(false);
                yesCoughL.setClickable(true);
                dontKnowCoughL.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_cough_long("0");
                break;
            case "dontKnowCoughL":
                yesCoughL.setText("-1");
                yesCoughL.setFocusable(false);
                yesCoughL.setClickable(true);
                noCoughL.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBreath_cough_long("-1");
                break;

        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__v, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button(RadioGroup) findViewById(R.id. so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
