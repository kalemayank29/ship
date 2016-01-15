package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.Toast;

public class Cod1to5_VII extends AppCompatActivity {

    RadioButton noFever, noUnconsc, noFit, noEar, dontKnowEar, noNeck, dontKnowNeck, noVomit, dontKnowVomit,noCHANGE,dontKnowCHANGE,
                yesMilk, dontKnowMilk, noTeeth, dontKnowTeeth;
    
    EditText yesFever, yesUnconsc, yesFit, yesEar,yesNeck, yesVomit, yesCHANGE, yesMilkX, yesTeeth;
    
    RadioGroup others;
    LinearLayout big;

    Button next, nextVisible;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__vii);

        next = (Button) findViewById(R.id.next);
        big = (LinearLayout)findViewById(R.id.big);
        big.setVisibility(View.GONE);
        next.setVisibility(View.GONE);

            noFever   = (RadioButton) findViewById(R.id.noFever);
               noUnconsc = (RadioButton) findViewById(R.id. noUnconsc);
             noFit   = (RadioButton) findViewById(R.id. noFit);
            noEar    = (RadioButton) findViewById(R.id. noEar);
              dontKnowEar  = (RadioButton) findViewById(R.id. dontKnowEar);
              noNeck  = (RadioButton) findViewById(R.id. noNeck);
              dontKnowNeck  = (RadioButton) findViewById(R.id. dontKnowNeck);
              noVomit  = (RadioButton) findViewById(R.id. noVomit);
               dontKnowVomit = (RadioButton) findViewById(R.id. dontKnowVomit);
              noCHANGE  = (RadioButton) findViewById(R.id.noCHANGE);
               dontKnowCHANGE = (RadioButton) findViewById(R.id.dontKnowCHANGE);
              yesMilk  = (RadioButton) findViewById(R.id.yesMilk);
              dontKnowMilk  = (RadioButton) findViewById(R.id. dontKnowMilk);
               noTeeth = (RadioButton) findViewById(R.id. noTeeth);
               dontKnowTeeth = (RadioButton) findViewById(R.id. dontKnowTeeth);
        
        others = (RadioGroup) findViewById(R.id.others);
        
        yesFever = (EditText) findViewById(R.id.feverDays);
        yesUnconsc = (EditText) findViewById(R.id.unconscDays);
        yesFit = (EditText) findViewById(R.id.fitDays);
        yesEar = (EditText) findViewById(R.id.earDays);
        yesNeck = (EditText) findViewById(R.id.neckDays);
        yesVomit = (EditText) findViewById(R.id.vomitDays);
        yesCHANGE = (EditText) findViewById(R.id.CHANGEDays);
        yesMilkX = (EditText) findViewById(R.id.milkDays);
        yesTeeth = (EditText) findViewById(R.id.teethDays);

        setAll();


        nextVisible = (Button) findViewById(R.id.nextVisible);

        nextVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((noFever.isChecked() || !(yesFever.getText().toString().isEmpty()))
                    && (noUnconsc.isChecked() || !(yesUnconsc.getText().toString().isEmpty()))
                        && (noFit.isChecked() || !(yesFit.getText().toString().isEmpty()))) {
                    if (!(noFever.isChecked() && noFit.isChecked() && noUnconsc.isChecked())) {
                        big.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), Cod1to5_VI.class);
                        startActivity(intent);
                    }

                }
                else
                        Toast.makeText(getApplicationContext(), "Answer The Question!", Toast.LENGTH_SHORT).show();
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
        
        yesEar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesEar.setEnabled(true);
                yesEar.setFocusableInTouchMode(true);
                yesEar.setText("");
                noEar.setChecked(false);
                dontKnowEar.setChecked(false);
                showKeyboard(view);

            }
        });

        yesNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesNeck.setEnabled(true);
                yesNeck.setFocusableInTouchMode(true);
                yesNeck.setText("");
                noNeck.setChecked(false);
                dontKnowNeck.setChecked(false);
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
                dontKnowVomit.setChecked(false);
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

        yesTeeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesTeeth.setEnabled(true);
                yesTeeth.setFocusableInTouchMode(true);
                yesTeeth.setText("");
                noTeeth.setChecked(false);
                dontKnowTeeth.setChecked(false);
                showKeyboard(view);

            }
        });

        yesMilkX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesMilkX.setEnabled(true);
                yesMilkX.setFocusableInTouchMode(true);
                yesMilkX.setText("");
                yesMilk.setChecked(false);
                dontKnowMilk.setChecked(false);
                showKeyboard(view);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int othersValue = others.indexOfChild(findViewById(others.getCheckedRadioButtonId()));
                
                CodOneFive.getInstance().setBrain_fever(yesFever.getText().toString());
                CodOneFive.getInstance().setBrain_unconsc(yesUnconsc.getText().toString());
                CodOneFive.getInstance().setBrain_fit(yesFit.getText().toString());
                CodOneFive.getInstance().setBrain_ear(yesEar.getText().toString());
                CodOneFive.getInstance().setBrain_neck(yesNeck.getText().toString());
                CodOneFive.getInstance().setBrain_vomit(yesVomit.getText().toString());
                CodOneFive.getInstance().setBrain_CHANGE_krog(yesCHANGE.getText().toString());
                CodOneFive.getInstance().setBrain_milk(yesMilkX.getText().toString());
                CodOneFive.getInstance().setBrain_teeth(yesTeeth.getText().toString());
                CodOneFive.getInstance().setBrain_others(String.valueOf(othersValue));

                Intent intent = new Intent(getApplicationContext(),Cod1to5_VII.class);
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


    public void radioClick(View view) {
        String tag = (String) view.getTag();
        switch (tag) {
            case "noFever":
                yesFever.setText("0");
                yesFever.setFocusable(false);
                yesFever.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_fever("0");
                break;

            case "noUnconsc":
                yesUnconsc.setText("0");
                yesUnconsc.setFocusable(false);
                yesUnconsc.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_unconsc("0");
                break;
            case "noFit":
                yesFit.setText("0");
                yesFit.setFocusable(false);
                yesFit.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_fit("0");
                break;

            case "dontKnowFit":
                yesFit.setText("-1");
                yesFit.setFocusable(false);
                yesFit.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_fit("-1");
                break;

            case "noEar":
                yesEar.setText("0");
                yesEar.setFocusable(false);
                yesEar.setClickable(true);
                dontKnowEar.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_ear("0");
                break;
            case "noNeck":
                yesNeck.setText("0");
                yesNeck.setFocusable(false);
                yesNeck.setClickable(true);
                dontKnowNeck.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_neck("0");
                break;
            case "dontKnowEar":
                yesEar.setText("-1");
                yesEar.setFocusable(false);
                yesEar.setClickable(true);
                noEar.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_ear("-1");
                break;
            case "dontKnowNeck":
                yesNeck.setText("-1");
                yesNeck.setFocusable(false);
                yesNeck.setClickable(true);
                noNeck.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_neck("-1");
                break;
            case "noCHANGE":
                yesCHANGE.setText("0");
                yesCHANGE.setFocusable(false);
                yesCHANGE.setClickable(true);
                dontKnowCHANGE.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_CHANGE_krog("0");
                break;
            case "dontKnowCHANGE":
                yesCHANGE.setText("-1");
                yesCHANGE.setFocusable(false);
                yesCHANGE.setClickable(true);
                noCHANGE.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_CHANGE_krog("-1");
                break;
            case "noVomit":
                yesVomit.setText("0");
                yesVomit.setFocusable(false);
                yesVomit.setClickable(true);
                dontKnowVomit.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_vomit("0");
                break;
            case "dontKnowVomit":
                yesVomit.setText("-1");
                yesVomit.setFocusable(false);
                yesVomit.setClickable(true);
                noVomit.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_vomit("-1");
                break;
            case "noTeeth":
                yesTeeth.setText("0");
                yesTeeth.setFocusable(false);
                yesTeeth.setClickable(true);
                dontKnowTeeth.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_teeth("0");
                break;
            case "dontKnowTeeth":
                yesTeeth.setText("-1");
                yesTeeth.setFocusable(false);
                yesTeeth.setClickable(true);
                noTeeth.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_teeth("-1");
                break;

            case "yesMilk":
                yesMilkX.setText("0");
                yesMilkX.setFocusable(false);
                yesMilkX.setClickable(true);
                dontKnowMilk.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_milk("0");
                break;

            case "dontKnowMilk":
                yesMilkX.setText("-1");
                yesMilkX.setFocusable(false);
                yesMilkX.setClickable(true);
                yesMilk.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setBrain_milk("-1");
                break;
            
        }
    }

    
    public void setAll(){
        
        if(CodOneFive.getInstance().getBrain_others()!= null){
            ((RadioButton)others.getChildAt(Integer.parseInt(CodOneFive.getInstance().getBrain_others()))).setChecked(true);
        }
        


        if(CodOneFive.getInstance().getBrain_fever()!= null){
            if(CodOneFive.getInstance().getBrain_fever().equals("0")){
                noFever.setChecked(true);
                yesFever.setText("0");
            }
            else{
                noFever.setChecked(false);
                yesFever.setText(CodOneFive.getInstance().getBrain_fever());
            }
        }

        if(CodOneFive.getInstance().getBrain_unconsc()!= null){
            if(CodOneFive.getInstance().getBrain_unconsc().equals("0")){
                noUnconsc.setChecked(true);
                yesUnconsc.setText("0");
            }
            else{
                noUnconsc.setChecked(false);
                yesUnconsc.setText(CodOneFive.getInstance().getBrain_unconsc());
            }
        }

        if(CodOneFive.getInstance().getBrain_fit()!= null){
            if(CodOneFive.getInstance().getBrain_fit().equals("0")){
                noFit.setChecked(true);
                yesFit.setText("0");
            }
            else{
                noFit.setChecked(false);
                yesFit.setText(CodOneFive.getInstance().getBrain_fit());
            }
        }

        if(CodOneFive.getInstance().getBrain_ear()!= null){
            if(CodOneFive.getInstance().getBrain_ear().equals("0")){
                noEar.setChecked(true);
                dontKnowEar.setChecked(false);
                yesEar.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_ear().equals("-1")) {
                noEar.setChecked(false);
                dontKnowEar.setChecked(true);
                yesEar.setText("-1");
            }
            else{
                noEar.setChecked(false);
                dontKnowEar.setChecked(false);
                yesEar.setText(CodOneFive.getInstance().getBrain_ear());
            }
        }

        if(CodOneFive.getInstance().getBrain_neck()!= null){
            if(CodOneFive.getInstance().getBrain_neck().equals("0")){
                noNeck.setChecked(true);
                dontKnowNeck.setChecked(false);
                yesNeck.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_neck().equals("-1")) {
                noNeck.setChecked(false);
                dontKnowNeck.setChecked(true);
                yesNeck.setText("-1");
            }
            else{
                noNeck.setChecked(false);
                dontKnowNeck.setChecked(false);
                yesNeck.setText(CodOneFive.getInstance().getBrain_neck());
            }
        }

        if(CodOneFive.getInstance().getBrain_vomit()!= null){
            if(CodOneFive.getInstance().getBrain_vomit().equals("0")){
                noVomit.setChecked(true);
                dontKnowVomit.setChecked(false);
                yesVomit.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_vomit().equals("-1")) {
                noVomit.setChecked(false);
                dontKnowVomit.setChecked(true);
                yesVomit.setText("-1");
            }
            else{
                noVomit.setChecked(false);
                dontKnowVomit.setChecked(false);
                yesVomit.setText(CodOneFive.getInstance().getBrain_vomit());
            }
        }

        if(CodOneFive.getInstance().getBrain_CHANGE_krog()!= null){
            if(CodOneFive.getInstance().getBrain_CHANGE_krog().equals("0")){
                noCHANGE.setChecked(true);
                dontKnowCHANGE.setChecked(false);
                yesCHANGE.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_CHANGE_krog().equals("-1")) {
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(true);
                yesCHANGE.setText("-1");
            }
            else{
                noCHANGE.setChecked(false);
                dontKnowCHANGE.setChecked(false);
                yesCHANGE.setText(CodOneFive.getInstance().getBrain_CHANGE_krog());
            }
        }

        if(CodOneFive.getInstance().getBrain_milk()!= null){
            if(CodOneFive.getInstance().getBrain_milk().equals("0")){
                yesMilk.setChecked(true);
                dontKnowMilk.setChecked(false);
                yesMilkX.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_milk().equals("-1")) {
                yesMilk.setChecked(false);
                dontKnowMilk.setChecked(true);
                yesMilkX.setText("-1");
            }
            else{
                yesMilk.setChecked(false);
                dontKnowMilk.setChecked(false);
                yesMilkX.setText(CodOneFive.getInstance().getBrain_milk());
            }
        }

        if(CodOneFive.getInstance().getBrain_teeth()!= null){
            if(CodOneFive.getInstance().getBrain_teeth().equals("0")){
                noTeeth.setChecked(true);
                dontKnowTeeth.setChecked(false);
                yesTeeth.setText("0");
            }
            else if(CodOneFive.getInstance().getBrain_teeth().equals("-1")) {
                noTeeth.setChecked(false);
                dontKnowTeeth.setChecked(true);
                yesTeeth.setText("-1");
            }
            else{
                noTeeth.setChecked(false);
                dontKnowTeeth.setChecked(false);
                yesTeeth.setText(CodOneFive.getInstance().getBrain_teeth());
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__vii, menu);
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
