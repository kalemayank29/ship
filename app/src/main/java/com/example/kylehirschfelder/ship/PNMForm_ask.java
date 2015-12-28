package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PNMForm_ask extends AppCompatActivity {

    RadioButton gaspYes, gaspNo;
    EditText gaspDays;
    String gasp = "0";

    RadioButton coughYes, coughNo;
    EditText coughDays;
    String cough = "0";

    RadioButton feverYes, feverNo;
    EditText feverDays;
    String fever = "0";

    RadioButton fitYes, fitNo;
    EditText fitDays;
    String fit = "0";

    RadioButton faintYes, faintNo;
    EditText faintDays;
    String faint = "0";

    RadioButton milkYes, milkLess, milkNo;
    EditText milkDays, milkHours;
    String milk = "0";

    RadioButton measlesYes, measlesNo;
    EditText measlesDays;
    String measles = "0";

    RadioButton vomitYes, vomitNo;
    EditText vomitDays;
    String vomit = "";

    EditText birthMonths;
    String birth = "000";

    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnmform_ask);

        gaspYes = (RadioButton) findViewById(R.id.gaspYes);
        gaspNo = (RadioButton) findViewById(R.id.gaspNo);
        gaspDays = (EditText) findViewById(R.id.gaspDays);

        coughYes = (RadioButton) findViewById(R.id.coughYes);
        coughNo = (RadioButton) findViewById(R.id.coughNo);
        coughDays = (EditText) findViewById(R.id.coughDays);

        feverYes = (RadioButton) findViewById(R.id.feverYes);
        feverNo = (RadioButton) findViewById(R.id.feverNo);
        feverDays = (EditText) findViewById(R.id.feverDays);

        fitYes = (RadioButton) findViewById(R.id.fitYes);
        fitNo = (RadioButton) findViewById(R.id.fitNo);
        fitDays = (EditText) findViewById(R.id.fitDays);

        faintYes = (RadioButton) findViewById(R.id.faintYes);
        faintNo = (RadioButton) findViewById(R.id.faintNo);
        faintDays = (EditText) findViewById(R.id.faintDays);

        milkYes = (RadioButton) findViewById(R.id.milkYes);
        milkLess = (RadioButton) findViewById(R.id.milkLess);
        milkNo = (RadioButton) findViewById(R.id.milkNo);
        milkDays = (EditText) findViewById(R.id.milkDays);
        milkHours = (EditText) findViewById(R.id.milkHours);

        measlesYes = (RadioButton) findViewById(R.id.measlesYes);
        measlesNo = (RadioButton) findViewById(R.id.measlesNo);
        measlesDays = (EditText) findViewById(R.id.measlesDays);

        vomitYes = (RadioButton) findViewById(R.id.vomitYes);
        vomitNo = (RadioButton) findViewById(R.id.vomitNo);
        vomitDays = (EditText) findViewById(R.id.vomitDays);

        birthMonths = (EditText) findViewById(R.id.birthMonths);

        save = (Button) findViewById(R.id.saveAsk);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cough = coughDays.getText().toString();
                gasp = gaspDays.getText().toString();
                fever = feverDays.getText().toString();
                fit = fitDays.getText().toString();
                faint = faintDays.getText().toString();
                milk = milkDays.getText().toString();
                measles = measlesDays.getText().toString();
                vomit = vomitDays.getText().toString();
                birth = birthMonths.getText().toString();
                String []send = {cough, gasp, fever, fit, faint, milk, measles, vomit, birth};
                Intent intent = new Intent(getBaseContext(), PNMForm_see.class);
                intent.putExtra("KEY", send);
                startActivity(intent);
            }
        });

    }

    public void select(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.gaspYes:
                if (checked) {
                    gaspDays.setVisibility(view.VISIBLE);
                    gasp = "1";
                }
                break;
            case R.id.gaspNo:
                if (checked) {
                    gaspDays.setVisibility(view.INVISIBLE);
                    gasp = "0";
                }

                break;
            case R.id.coughYes:
                if (checked) {
                    coughDays.setVisibility(view.VISIBLE);
                    cough = "1";
                }
                break;
            case R.id.coughNo:
                if (checked) {
                    coughDays.setVisibility(view.INVISIBLE);
                    cough = "0";
                }
                break;
            case R.id.feverYes:
                if (checked) {
                    feverDays.setVisibility(view.VISIBLE);
                    fever = "1";
                }
                break;
            case R.id.feverNo:
                if (checked) {
                    feverDays.setVisibility(view.INVISIBLE);
                    fever = "0";
                }
                break;
            case R.id.fitYes:
                if (checked) {
                    fitDays.setVisibility(view.VISIBLE);
                    fit = "1";
                }
                break;
            case R.id.fitNo:
                if (checked) {
                    fitDays.setVisibility(view.INVISIBLE);
                    fit = "0";
                }
                break;
            case R.id.faintYes:
                if (checked) {
                    faintDays.setVisibility(view.VISIBLE);
                    faint = "1";
                }
                break;
            case R.id.faintNo:
                if (checked) {
                    faintDays.setVisibility(view.INVISIBLE);
                    faint = "0";
                }
                break;
            case R.id.milkYes:
                if (checked) {
                    milk = "100";
                }
                break;
            case R.id.milkLess:
                if (checked) {
                    milk = "010";
                }
                break;
            case R.id.milkNo:
                if(checked) {
                    milk = "001";
                }
                break;
            case R.id.measlesYes:
                if(checked) {
                    measlesDays.setVisibility(view.VISIBLE);
                }
                break;
            case R.id.measlesNo:
                if(checked)
                    measlesDays.setVisibility(view.INVISIBLE);
                break;
            case R.id.vomitYes:
                if(checked) {
                    vomitDays.setVisibility(view.VISIBLE);
                }
                break;
            case R.id.vomitNo:
                if(checked)
                    vomitDays.setVisibility(view.INVISIBLE);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pnmform_ask, menu);
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
