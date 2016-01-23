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

public class Cod1_I extends AppCompatActivity {

    RadioGroup pregMonths, size, twins;
    RadioButton no;
    EditText yesHandicap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod1__i);

        pregMonths = (RadioGroup) findViewById(R.id.pregMonths);
        size = (RadioGroup) findViewById(R.id.size);
        twins = (RadioGroup) findViewById(R.id.twins);

        no = (RadioButton) findViewById(R.id.no);

        yesHandicap = (EditText) findViewById(R.id.yesHandicap);

        yesHandicap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesHandicap.setEnabled(true);
                yesHandicap.setFocusableInTouchMode(true);
                yesHandicap.setText("");
                no.setChecked(false);
                showKeyboard(view);
                //CodOneFive.getInstance().setMeasles_days(measlesDays.getText().toString());

            }

        });

    }

    public void showKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }


    public void radioClick(View view) { //  Test later to see what goes wrong
        switch(view.getId()) {
            case R.id.no:
                if(((RadioButton)view).isChecked()) {
                    yesHandicap.setEnabled(false);
                }
                break;
            case R.id.yesHandicap:
                yesHandicap.setEnabled(true);
                yesHandicap.setShowSoftInputOnFocus(true);
                no.setChecked(false);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cod1__i, menu);
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
