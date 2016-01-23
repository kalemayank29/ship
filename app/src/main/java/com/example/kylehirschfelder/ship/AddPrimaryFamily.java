package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Calendar;

public class AddPrimaryFamily extends AppCompatActivity {
    Translation TR = new Translation();
    Spinner marriageSpinner, educationSpinner;

    private int mYear, wYear;
    private int mMonth, wMonth;
    private int mDay, wDay;
    private int isHead = 1;
    private int flag = 0;
    static final String TAG = "LOG";
    Button pushLocal, localBtn;
    RadioButton manRadioButton, womanRadioButton, litYes, litNo, familyYes, familyNo;
    String gender = "", literacy = "", familyPlanning = "";
    String name = "", age = "", education = "", marriage = "", marrSpin, famSpin, eduSpin, litSpin, wedDep, wedAr;
    EditText nameText, famText, ageText, childText;
    MemberDataInterface db;
    private int villageId;
    public static final String MY_PREFS_NAME = "MyPrefsFile";


    private TextView mDateDisplay, weddingArrDisplay;
    private Button mPickDate, wPickDate;

    static final int DATE_DIALOG_ID = 0;
    static final int WDATE_DIALOG_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_form);
        //db.deleteAllTables();
        pushLocal = (Button) findViewById(R.id.localBtn);

        villageId = ((CurrentVillage) this.getApplication()).getSomeVariable();

        marriageSpinner = (Spinner) findViewById(R.id.spin_marriage);
        final ArrayAdapter marriageAdapter = ArrayAdapter.createFromResource(this, R.array.marriage_array, android.R.layout.simple_spinner_dropdown_item);
        marriageSpinner.setAdapter(marriageAdapter);

//        familySpinner = (Spinner) findViewById(R.id.spin_family_plan);
//        ArrayAdapter familyAdapter = ArrayAdapter.createFromResource(this, R.array.family_array, android.R.layout.simple_spinner_dropdown_item);
//        familySpinner.setAdapter(familyAdapter);

        educationSpinner = (Spinner) findViewById(R.id.spin_education);
        ArrayAdapter educationAdapter = ArrayAdapter.createFromResource(this, R.array.education_array, android.R.layout.simple_spinner_dropdown_item);
        educationSpinner.setAdapter(educationAdapter);

//        literacySpinner = (Spinner) findViewById(R.id.spin_literacy);
//        ArrayAdapter literacyAdapter = ArrayAdapter.createFromResource(this, R.array.literacy_array, android.R.layout.simple_spinner_dropdown_item);
//        literacySpinner.setAdapter(literacyAdapter);
        manRadioButton = (RadioButton) findViewById(R.id.man);
        womanRadioButton = (RadioButton) findViewById(R.id.woman);
        litYes = (RadioButton) findViewById(R.id.yes);
        litNo = (RadioButton) findViewById(R.id.no);
        familyYes = (RadioButton) findViewById(R.id.familyPlanningYes);
        familyNo = (RadioButton) findViewById(R.id.familyPlanningNo);
        famText = (EditText) findViewById(R.id.houseText);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
       // childText = (EditText) findViewById(R.id.childText);


        //********DATE PICKER***********//
        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);

        weddingArrDisplay = (TextView) findViewById(R.id.wedding_arr_date);
        wPickDate = (Button) findViewById(R.id.wedding_arr_date_button);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
                flag = 1;
            }
        });


        pushLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = nameText.getText().toString();
                age = ageText.getText().toString();
              //  childId = childText.getText().toString();
                marrSpin = marriageSpinner.getSelectedItem().toString();
                eduSpin = educationSpinner.getSelectedItem().toString();
//                litSpin = literacySpinner.getSelectedItem().toString();
  //              famSpin = familySpinner.getSelectedItem().toString();
                wedDep = mDateDisplay.getText().toString();
                wedAr = weddingArrDisplay.getText().toString();
                litSpin = literacy;
                famSpin = familyPlanning;
                switch(eduSpin) {
                    case "अशिक्षित":
                        education = "0";
                        break;
                    case "१ ली":
                        education = "1";
                        break;
                    case "२ री":
                        education = "2";
                        break;
                    case "३ री":
                        education = "3";
                        break;
                    case "४ थी":
                        education = "4";
                        break;
                    case "५ वी":
                        education = "5";
                        break;
                    case "६ वी":
                        education = "6";
                        break;
                    case "७ वी":
                        education = "7";
                        break;
                    case "८ वी":
                        education = "8";
                        break;
                    case "९ वी":
                        education = "9";
                        break;
                    case "१० वी":
                        education = "10";
                        break;
                    case "११ वी":
                        education = "11";
                        break;
                    case "१२ वी":
                        education = "12";
                        break;
                    case "B.A":
                        education = "13";
                        break;
                    case "B.Sc":
                        education = "14";
                        break;
                    case "B.Com":
                        education = "15";
                        break;
                    case "M.A":
                        education = "16";
                        break;
                    case "M.Sc":
                        education = "17";
                        break;
                    case "M.Com":
                        education = "18";
                        break;
                    case "इतर":
                        education = "19";
                        break;
                }

                switch (marrSpin) {
                    case "विवाहित":
                        marriage = "1";
                        break;
                    case "अविवाहित":
                        marriage = "2";
                        if(familyYes.isChecked()){
                            familyNo.setChecked(true);
                            familyYes.setChecked(false);
                        }
                        break;
                    case "विधुर":
                        marriage = "3";
                        break;
                    case "विधवा":
                        marriage = "4";
                        break;
                    case "घटस्फोट":
                        marriage = "5";
                        break;
                }


                if (name.equals("") || age.equals("") || education.equals("") || marriage.equals("") ||
                        literacy.equals("") || familyPlanning.equals("") || gender.equals("")) {
                    Toast.makeText(AddPrimaryFamily.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Translation object = new Translation();
                    String tname = object.Letter_M2E(name);
                    Log.println(Log.ASSERT,"name",name);
                    Member member = new Member(-1, -1, isHead, tname, Integer.parseInt(age),Integer.parseInt(gender), -1, "-1",
                                     marriage, familyPlanning, education, literacy, wedAr, wedDep,villageId);

                    db = new MemberDataInterface(getApplicationContext());
                   // Log.println(Log.ASSERT, "log", member.getFamilyPlan());
                    try {
                        long result = db.createMemberTemp(member, 0);
                       // db.cleanFamilyId(0);
                        Log.println(Log.ASSERT, "log", String.valueOf(result));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    finish();
                    Intent intent = new Intent(getApplicationContext(), CensusFormPortal.class);
                    intent.putExtra("flagFamily","1");
                    intent.putExtra("flagCensus","0");
                    startActivity(intent);
                }
            }
        });

        wPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(WDATE_DIALOG_ID);
                flag = 2;
            }
        });

        final Calendar c = Calendar.getInstance();

        if(flag == 1){
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            updateDisplay(DATE_DIALOG_ID);

        }
        else {
            mDay = 0;
            mMonth = -1;
            mYear = 0;
            updateDisplay(DATE_DIALOG_ID);
        }

        Calendar wc = Calendar.getInstance();
        if(flag == 2){
            wYear = wc.get(Calendar.YEAR);
            wMonth = wc.get(Calendar.MONTH);
            wDay = wc.get(Calendar.DAY_OF_MONTH);
            updateDisplay(WDATE_DIALOG_ID);
        }
        else {
            wDay = 0;
            wMonth = -1;
            wYear = 0;
            updateDisplay(WDATE_DIALOG_ID);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_form, menu);
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

    public void updateDisplay(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                this.mDateDisplay.setText(
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(mMonth + 1).append("-")
                                .append(mDay).append("-")
                                .append(mYear).append(" "));
                break;
            case WDATE_DIALOG_ID:
                this.weddingArrDisplay.setText(
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(wMonth + 1).append("-")
                                .append(wDay).append("-")
                                .append(wYear).append(" "));
        }
    }

    public void genderClick(View view) {
        String tag = view.getTag().toString();
        Log.println(Log.ASSERT, "log", tag);

        switch (tag) {
            case "man":
                womanRadioButton.setChecked(false);
                gender = "1";
                break;
            case "woman":
                manRadioButton.setChecked(false);
                gender = "2";
                break;
        }

    }

    public void litClick(View view) {
        String tag = view.getTag().toString();
        switch(tag) {
            case "yes":
                litNo.setChecked(false);
                literacy = "1";
                break;
            case "no":
                litYes.setChecked(false);
                literacy = "0";
                break;
        }
    }

    public void familyPlanningClick(View view) {
        String tag = view.getTag().toString();
        switch(tag) {
            case "yes":
                if((marriageSpinner.getSelectedItem().toString()).equals("अविवाहित")) {
                    familyNo.setChecked(true);
                    familyYes.setChecked(false);
                    familyPlanning = "0";
                }
                else {
                    familyNo.setChecked(false);
                    familyPlanning = "1";
                }
                break;
            case "no":
                familyYes.setChecked(false);
                familyPlanning = "0";
                break;
        }
    }

    public void onBackPressed(){
        displayBackAlert();
    }

    public void displayBackAlert() {
        Translation translation = new Translation();
        new AlertDialog.Builder(this)
                .setTitle(translation.Letter_E2M("nakkee baahera paDaayache aahe kaa") + "?")
                .setMessage(translation.Letter_E2M("sagaLee bharalelee maahitee vaayaa jaaeel"))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        finish();
                        Intent intent = new Intent(AddPrimaryFamily.this, CensusFormPortal.class);
                        intent.putExtra("flagFamily","0");
                        intent.putExtra("flagCensus","0");
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay(DATE_DIALOG_ID);
                }
            };

    private DatePickerDialog.OnDateSetListener wDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    wYear = year;
                    wMonth = monthOfYear;
                    wDay = dayOfMonth;
                    updateDisplay(WDATE_DIALOG_ID);
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                DatePickerDialog dpDialog1 = new DatePickerDialog(this, mDateSetListener, 1995, 0, 1);
                DatePicker datePicker1 = dpDialog1.getDatePicker();

                Calendar c = Calendar.getInstance();//get the current day
                datePicker1.setMaxDate(c.getTimeInMillis());//set the current day as the max date
                return dpDialog1;
            case WDATE_DIALOG_ID:
                DatePickerDialog dpDialog2 = new DatePickerDialog(this, wDateSetListener, 1995, 0, 1);
                DatePicker datePicker2 = dpDialog2.getDatePicker();

                Calendar wc = Calendar.getInstance();//get the current day
                datePicker2.setMaxDate(wc.getTimeInMillis());//set the current day as the max date
                return dpDialog2;
        }
        return null;
    }
}