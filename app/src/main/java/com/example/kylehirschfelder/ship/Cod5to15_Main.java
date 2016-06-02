package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.SQLException;

public class Cod5to15_Main extends AppCompatActivity {

    Button next;
    String resident = "";
    EditText familyHeadName, familyHeadCode, deathPersonName, deathPersonCode, deathMotherName, deathMotherCode,
            deathAge, deathDate;
    RadioGroup answererRelation1, answererRelation2, answererVicinity, answererGender,
            deathFamilyHeadRelation1, deathFamilyHeadRelation2, deathPlace1, deathPlace2, deathGender;
    EditText answererName, answererCode, answererAge, deathAddress, deathReason;
    Translation translation;
    CodFiveToFifteenDBHelper CFTF_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod5to15__main);
        next = (Button)findViewById(R.id.save1);
        translation = new Translation();
        CFTF_DB = new CodFiveToFifteenDBHelper(getApplicationContext());



        familyHeadName = (EditText)findViewById(R.id.familyHeadName);
        familyHeadCode = (EditText)findViewById(R.id.familyHeadCode);
        deathPersonName = (EditText)findViewById(R.id.deathPersonName);
        deathPersonCode = (EditText)findViewById(R.id.deathPersonCode);
        deathMotherName = (EditText)findViewById(R.id.deathMotherName);
        deathMotherCode = (EditText)findViewById(R.id.deathMotherCode);
        deathAge = (EditText)findViewById(R.id.deathAge);

        deathDate = (EditText)findViewById(R.id.dateDeath);

        deathGender = (RadioGroup)findViewById(R.id.deathGender);
        answererRelation1 = (RadioGroup)findViewById(R.id.relation1);
        answererRelation2 = (RadioGroup)findViewById(R.id.relation2);
        answererVicinity = (RadioGroup)findViewById(R.id.LiveTogether);
        answererGender = (RadioGroup)findViewById(R.id.gender);
        deathFamilyHeadRelation1 = (RadioGroup)findViewById(R.id.relationDead1);
        deathFamilyHeadRelation2 = (RadioGroup)findViewById(R.id.relationDead2);
        deathPlace1 = (RadioGroup)findViewById(R.id.placeDeath1);
        deathPlace2 = (RadioGroup)findViewById(R.id.placeDeath2);

        answererName = (EditText)findViewById(R.id.answererName);
        answererCode = (EditText)findViewById(R.id.answererCode);
        answererAge = (EditText)findViewById(R.id.age);
        deathAddress = (EditText)findViewById(R.id.address);
        deathReason = (EditText)findViewById(R.id.reasonDeath);

        CodFiveToFifteen.getInstance().setFamilyHeadName("-1");
        CodFiveToFifteen.getInstance().setFamilyHeadCode("-1");
        CodFiveToFifteen.getInstance().setDeathPersonName("-1");
        CodFiveToFifteen.getInstance().setDeathPersonCode("-1");
        CodFiveToFifteen.getInstance().setDeathMotherName("-1");
        CodFiveToFifteen.getInstance().setDeathMotherCode("-1");
        CodFiveToFifteen.getInstance().setAnswererName("-1");
        CodFiveToFifteen.getInstance().setAnswererCode("-1");
        CodFiveToFifteen.getInstance().setAnswererRelation("-1");
        CodFiveToFifteen.getInstance().setAnswererVicinity("-1");
        CodFiveToFifteen.getInstance().setAnswererAge("-1");
        CodFiveToFifteen.getInstance().setAnswererGender("-1");
        CodFiveToFifteen.getInstance().setDeathAge("-1");
        CodFiveToFifteen.getInstance().setDeathGender("-1");
        CodFiveToFifteen.getInstance().setDeathFamilyHeadRelation("-1");
        CodFiveToFifteen.getInstance().setDeathAddress("-1");
        CodFiveToFifteen.getInstance().setDeathDate("-1");
        CodFiveToFifteen.getInstance().setDeathPlace("-1");
        CodFiveToFifteen.getInstance().setDeathReason("-1");
        
        String mem_id = getIntent().getStringExtra("id");
        int village_id = ((CurrentVillage) getApplication()).getSomeVariable();
        resident = getIntent().getStringExtra("resident");

        DeathAdultDataInterface deathAdult = new DeathAdultDataInterface(getApplicationContext());
        MemberDataInterface memberDataInterface = new MemberDataInterface(getApplicationContext());
        Member member = null, head = null;
        DeathAdult death = deathAdult.getInfo(Integer.parseInt(mem_id));


        Log.println(Log.ASSERT,"memberid",death.getMemberID());
       // Log.println(Log.ASSERT,"villageid", String.valueOf(village_id));

        if(resident.equals("1")){

            try{
                member = memberDataInterface.getMember(Integer.parseInt(death.getMemberID()), village_id, 1 );
                head = memberDataInterface.getMember(member.getFamilyId(), village_id,1 );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            familyHeadName.setText(translation.Letter_E2M(head.getName()));
            familyHeadCode.setText(String.valueOf(head.getMemberId()));

             // deathGender.setText(String.valueOf(member.getSex()));//Parse into male, female
                int sex = member.getSex();
                sex--;                      //HACKED.

                    ((RadioButton)deathGender.getChildAt(sex)).setChecked(true);

            familyHeadName.setEnabled(false);
            familyHeadCode.setEnabled(false);
            deathGender.setEnabled(false);
        }



        deathPersonName.setText(translation.Letter_E2M(death.getName()));
        deathPersonCode.setText(String.valueOf(death.getMemberID()));
        deathMotherCode.setText("XX");
        deathMotherName.setText("XX");
        deathAge.setText(String.valueOf(death.getAge()));
        deathDate.setText(death.getDeathDate());

        deathPersonCode.setEnabled(false);
        deathPersonName.setEnabled(false);
        deathAge.setEnabled(false);
        deathDate.setEnabled(false);
        deathMotherName.setEnabled(false);
        deathMotherCode.setEnabled(false);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 0;
                int answererRelationValue1 = answererRelation1.indexOfChild(findViewById(answererRelation1.getCheckedRadioButtonId()));
                int answererRelationValue2 = answererRelation2.indexOfChild(findViewById(answererRelation2.getCheckedRadioButtonId()));
                int deathFamilyHeadRelationValue1 = deathFamilyHeadRelation1.indexOfChild(findViewById(deathFamilyHeadRelation1.getCheckedRadioButtonId()));
                int deathFamilyHeadRelationValue2 = deathFamilyHeadRelation2.indexOfChild(findViewById(deathFamilyHeadRelation2.getCheckedRadioButtonId()));
                int deathPlaceValue1 = deathPlace1.indexOfChild(findViewById(deathPlace1.getCheckedRadioButtonId()));
                int deathPlaceValue2 = deathPlace2.indexOfChild(findViewById(deathPlace2.getCheckedRadioButtonId()));


                if (answererRelationValue1 == -1)
                    CodFiveToFifteen.getInstance().setAnswererRelation(Integer.toString(6 + answererRelationValue2));
                else
                    CodFiveToFifteen.getInstance().setAnswererRelation(Integer.toString(answererRelationValue2));

                if (deathFamilyHeadRelationValue1 == -1)
                    CodFiveToFifteen.getInstance().setDeathFamilyHeadRelation(Integer.toString(6 + deathFamilyHeadRelationValue2));
                else
                    CodFiveToFifteen.getInstance().setDeathFamilyHeadRelation(Integer.toString(deathFamilyHeadRelationValue1));

                if (deathPlaceValue1 == -1)
                    CodFiveToFifteen.getInstance().setDeathPlace(Integer.toString(2 + deathPlaceValue2));
                else
                    CodFiveToFifteen.getInstance().setDeathPlace(Integer.toString(deathPlaceValue1));


                int answererVicinityValue = answererVicinity.indexOfChild(findViewById(answererVicinity.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setAnswererVicinity(Integer.toString(answererVicinityValue));
                int answererGenderValue = answererGender.indexOfChild(findViewById(answererGender.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setAnswererGender(Integer.toString(answererGenderValue));
                int deathGenderValue = deathGender.indexOfChild(findViewById(deathGender.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setDeathGender(Integer.toString(++deathGenderValue));


                CodFiveToFifteen.getInstance().setFamilyHeadName(familyHeadName.getText().toString());
                CodFiveToFifteen.getInstance().setFamilyHeadCode(familyHeadCode.getText().toString());
                CodFiveToFifteen.getInstance().setDeathPersonName(deathPersonName.getText().toString());
                CodFiveToFifteen.getInstance().setDeathPersonCode(deathPersonCode.getText().toString());
                CodFiveToFifteen.getInstance().setDeathMotherName(deathMotherName.getText().toString());
                CodFiveToFifteen.getInstance().setDeathMotherCode(deathMotherCode.getText().toString());
                CodFiveToFifteen.getInstance().setDeathAge(deathAge.getText().toString());
              //  CodFiveToFifteen.getInstance().setDeathGender(deathGender.getText().toString());
                CodFiveToFifteen.getInstance().setDeathDate(deathDate.getText().toString());
                CodFiveToFifteen.getInstance().setAnswererName(answererName.getText().toString());
                CodFiveToFifteen.getInstance().setAnswererCode(answererCode.getText().toString());
                CodFiveToFifteen.getInstance().setAnswererAge(answererAge.getText().toString());
                CodFiveToFifteen.getInstance().setDeathAddress(deathAddress.getText().toString());
                CodFiveToFifteen.getInstance().setDeathReason(deathReason.getText().toString());

//                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFamilyHeadName()) == -1)                        flag = 1;
             //   if(Integer.parseInt(CodFiveToFifteen.getInstance().getFamilyHeadCode()) == -1)                        flag = 1;
  //              if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathPersonName()) == -1)                        flag = 1;
          //      if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathPersonCode()) == -1)                        flag = 1;
    //            if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathMotherName()) == -1)                        flag = 1;
            //    if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathMotherCode()) == -1)                        flag = 1;
                if(CodFiveToFifteen.getInstance().getAnswererName() == "-1")                        flag = 1;
                if(CodFiveToFifteen.getInstance().getAnswererCode() == "-1")                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getAnswererRelation()) == -1)                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getAnswererVicinity()) == -1)                        flag = 1;
                if(CodFiveToFifteen.getInstance().getAnswererAge() == "-1")                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getAnswererGender()) == -1)                        flag = 1;
               // if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathAge()) == -1)                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathGender()) == -1)                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathFamilyHeadRelation()) == -1)                        flag = 1;
                if(CodFiveToFifteen.getInstance().getDeathAddress() == "-1")                        flag = 1;
//                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathDate()) == -1)                        flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathPlace()) == -1)                        flag = 1;
                if(CodFiveToFifteen.getInstance().getDeathReason() == "-1")                        flag = 1;

                if(flag == 1)
                    displayAlert();
                else
                    displayNextAlert();




            }
        });
    }



    public void displayAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Complete the Form")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
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
    public void displayNextAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Are You Sure?")
                .setMessage("Save the Form???")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        CFTF_DB.insert(CodFiveToFifteen.getInstance());
                        Intent intent = new Intent(getApplicationContext(), Cod5to15_I.class);
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

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_cod5to15__main, menu);
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


