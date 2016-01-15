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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Cod1to5_VI extends AppCompatActivity {
    
    RadioGroup blood,water,thirst,eyes,skull,urine,urineColor,milk;
    RadioButton noDysentry, noVomit, dontKnowVomit;
    EditText yesDysentry, dysentryDays, yesVomit;
    Button next, nextVisible1, nextVisible2;
    LinearLayout big1, big2, big3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1to5__vi);
        next = (Button) findViewById(R.id.next);
        big1 = (LinearLayout)findViewById(R.id.big1);
        big2 = (LinearLayout)findViewById(R.id.big2);
        big3 = (LinearLayout)findViewById(R.id.big3);
        big1.setVisibility(View.GONE);
        big2.setVisibility(View.GONE);
        big3.setVisibility(View.GONE);
        next.setVisibility(View.GONE);

        blood= (RadioGroup) findViewById(R.id.blood);
        water= (RadioGroup) findViewById(R.id.water);
        thirst = (RadioGroup) findViewById(R.id.thirst);
        eyes = (RadioGroup) findViewById(R.id.eyes);
        skull  = (RadioGroup) findViewById(R.id.skull);
        urine = (RadioGroup) findViewById(R.id.urine);
        urineColor = (RadioGroup) findViewById(R.id.urineColor);
        milk = (RadioGroup) findViewById(R.id.milk);

        noDysentry = (RadioButton) findViewById(R.id.noDysentry);
        noVomit = (RadioButton) findViewById(R.id.noVomit);
        dontKnowVomit = (RadioButton) findViewById(R.id.dontKnowVomit);

        yesDysentry = (EditText) findViewById(R.id.yesDysentry);
        dysentryDays = (EditText) findViewById(R.id.dysentryDays);
        yesVomit = (EditText) findViewById(R.id.yesVomit);


        nextVisible1 = (Button) findViewById(R.id.nextVisible1);
        nextVisible2 = (Button) findViewById(R.id.nextVisible2);


        setAll();

        nextVisible1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yesDysentry.getText().toString().equals("") && noDysentry.isChecked() == false)
                    Toast.makeText(getApplicationContext(), "Answer The Question!", Toast.LENGTH_SHORT).show();
                else if(Integer.parseInt(yesDysentry.getText().toString()) <= 3) {
                    Intent intent = new Intent(getApplicationContext(), Cod1to5_VII.class);
                    startActivity(intent);
                }
                else {
                    big1.setVisibility(View.VISIBLE);
                }
            }
        });

        nextVisible2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dysentryDays.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Answer The Question!", Toast.LENGTH_SHORT).show();
                else if(Integer.parseInt(dysentryDays.getText().toString()) > 15) {
                    Intent intent = new Intent(getApplicationContext(), Cod1to5_VII.class);
                    startActivity(intent);
                }
                else{
                    big3.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });

        dysentryDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                big3.setVisibility(View.GONE);
            }
        });

        blood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(blood.indexOfChild(findViewById(blood.getCheckedRadioButtonId())) == 0) {
                    Intent intent = new Intent(getApplicationContext(), Cod1to5_VII.class);
                    startActivity(intent);
                }
                else
                    big2.setVisibility(View.VISIBLE);
            }
        });

        yesDysentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesDysentry.setEnabled(true);
                yesDysentry.setFocusableInTouchMode(true);
                yesDysentry.setText("");
                noDysentry.setChecked(false);
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

        

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bloodValue = blood.indexOfChild(findViewById(blood.getCheckedRadioButtonId()));
                int waterValue = water.indexOfChild(findViewById(water.getCheckedRadioButtonId()));
                int thirstValue = thirst.indexOfChild(findViewById(thirst.getCheckedRadioButtonId()));
                int skullValue = skull.indexOfChild(findViewById(skull.getCheckedRadioButtonId()));
                int eyesValue = eyes.indexOfChild(findViewById(eyes.getCheckedRadioButtonId()));
                int urineValue = urine.indexOfChild(findViewById(urine.getCheckedRadioButtonId()));
                int urineColorValue = urineColor.indexOfChild(findViewById(urineColor.getCheckedRadioButtonId()));
                int milkValue = milk.indexOfChild(findViewById(milk.getCheckedRadioButtonId()));

                CodOneFive.getInstance().setDysentry_blood(String.valueOf(bloodValue));
                CodOneFive.getInstance().setDysentry_water(String.valueOf(waterValue));
                CodOneFive.getInstance().setDysentry_thirst(String.valueOf(thirstValue));
                CodOneFive.getInstance().setDysentry_skull(String.valueOf(skullValue));
                CodOneFive.getInstance().setDysentry_eyes(String.valueOf(eyesValue));
                CodOneFive.getInstance().setDysentry_urine(String.valueOf(urineValue));
                CodOneFive.getInstance().setDysentry_urine_color(String.valueOf(urineColorValue));
                CodOneFive.getInstance().setDysentry_milk(String.valueOf(milkValue));
                CodOneFive.getInstance().setDysentry_loose(yesDysentry.getText().toString());
                CodOneFive.getInstance().setDysentry_days(dysentryDays.getText().toString());
                CodOneFive.getInstance().setDysentry_vomit(yesVomit.getText().toString());

                Intent intent = new Intent(getApplicationContext(),Cod1to5_VI.class);
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
        if(CodOneFive.getInstance().getDysentry_blood()!= null){
            ((RadioButton) blood.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_blood()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_water()!= null){
            ((RadioButton) water.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_water()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_thirst()!= null){
            ((RadioButton) thirst.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_thirst()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_eyes()!= null){
            ((RadioButton) eyes.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_eyes()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_skull()!= null){
            ((RadioButton) skull.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_skull()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_urine()!= null){
            ((RadioButton) urine.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_urine()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_urine_color()!= null){
            ((RadioButton) urineColor.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_urine_color()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_milk()!= null){
            ((RadioButton) milk.getChildAt(Integer.parseInt(CodOneFive.getInstance().getDysentry_milk()))).setChecked(true);
        }

        if(CodOneFive.getInstance().getDysentry_days()!= null){
            dysentryDays.setText(CodOneFive.getInstance().getDysentry_days());
        }
        
        
        if(CodOneFive.getInstance().getDysentry_loose()!= null){
            if(CodOneFive.getInstance().getDysentry_loose().equals("0")){
                noDysentry.setChecked(true);
                yesDysentry.setText("0");
            }
            else{
                noDysentry.setChecked(false);
                yesDysentry.setText(CodOneFive.getInstance().getDysentry_loose());
            }
        }

        if(CodOneFive.getInstance().getDysentry_vomit()!= null){
            if(CodOneFive.getInstance().getDysentry_vomit().equals("0")){
                noVomit.setChecked(true);
                dontKnowVomit.setChecked(false);
                yesVomit.setText("0");
            }
            else if(CodOneFive.getInstance().getDysentry_vomit().equals("-1")) {
                noVomit.setChecked(false);
                dontKnowVomit.setChecked(true);
                yesVomit.setText("-1");
            }
            else{
                noVomit.setChecked(false);
                dontKnowVomit.setChecked(false);
                yesVomit.setText(CodOneFive.getInstance().getDysentry_vomit());
            }
        }


    }


    public void radioClick(View view){
        String tag = (String) view.getTag();
        switch(tag){
            case "noDysentry":
                yesDysentry.setText("0");
                yesDysentry.setFocusable(false);
                yesDysentry.setClickable(true);
                hideKeyboard(view);
                CodOneFive.getInstance().setDysentry_loose("0");

                break;
            case "noVomit":
                yesVomit.setText("0");
                yesVomit.setFocusable(false);
                yesVomit.setClickable(true);
                dontKnowVomit.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setDysentry_vomit("0");
                break;
            
            case "dontKnowVomit":
                yesVomit.setText("-1");
                yesVomit.setFocusable(false);
                yesVomit.setClickable(true);
                noVomit.setChecked(false);
                hideKeyboard(view);
                CodOneFive.getInstance().setDysentry_vomit("-1");
                break;

        }


    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1to5__vi, menu);
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
