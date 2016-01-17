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
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cod5to15_I extends AppCompatActivity {

    TextView date;
    int flag = 0;
    RadioGroup deathAccident, deathAccidentHow1to6, deathAccidentHow7to12, birthAppearance1to3,
            birthAppearance4to5, lessDaysBirth, breastFeeding,breastFeedingHalt, fever,
            feverShiver, fit, faint, stiffness, neckStiffness, diarrhea, stoolBlood, liquid, cough,
            coughHow1, coughHow2, breathProblem, breathSpeed, mucus, breathWhistle, antibiotics,
            stomachAche, stomachAcheWhere1, stomachAcheWhere2, stomachBloat, vomit, eyesYellow,
            skinRash, rashWhere, rashMeasles, sicklyAppearance, yellowAppearance, frequentlySick,
            symptomsAccompanied1, symptomsAccompanied2, symptomsAccompanied3, CHANGE, BCG, polioDose,
            measlesInjection, answererQuality;
    EditText pregnancyStage, sickDays, feverDays, diarrheaDays, coughDays, breathProblemDays,
            vomitDays, sickTimes, interviewerName;
    TextView t_13_1, t_13_2, information, t_14, t_15_1, t_15_2, t_16_1, t_16_2, illnessDesc,
            t_17, t_18_1, t_18_2, t_18_3, t_19, t_20, t_21, t_22, t_23_1, t_23_2, t_23_3, t_23_4,
            t_24_1, t_24_2, t_24_3, t_25_1, t_25_2, t_25_3, t_25_4, t_25_5, t_25_6, t_26_1, t_26_2, t_26_3,
            t_27_1, t_27_2, t_28, t_29_1, t_29_2, t_29_3, t_30, t_31, t_32_1, t_32_2, t_32_3, t_33_1,
            t_33_2, t_33_3, t_33_4;
    Button next;
    CodFiveToFifteen CFTF = new CodFiveToFifteen();
    CodFiveToFifteenDBHelper CFTF_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod5to15__i);
        CFTF_DB = new CodFiveToFifteenDBHelper(getApplicationContext());

        CodFiveToFifteen.getInstance().setDeathAccident(("-1"));
        CodFiveToFifteen.getInstance().setDeathAccidentHow(("-1"));
        CodFiveToFifteen.getInstance().setBirthAppearance(("-1"));
        CodFiveToFifteen.getInstance().setLessPregnancyTime(("-1"));
        CodFiveToFifteen.getInstance().setPregnancyTime((""));
        CodFiveToFifteen.getInstance().setBreastFeeding(("-1"));
        CodFiveToFifteen.getInstance().setBreastFeedingHalt(("-1"));
        CodFiveToFifteen.getInstance().setSickDays((""));
        CodFiveToFifteen.getInstance().setFever(("-1"));
        CodFiveToFifteen.getInstance().setFeverDays((""));
        CodFiveToFifteen.getInstance().setFeverShiver(("-1"));
        CodFiveToFifteen.getInstance().setFit(("-1"));
        CodFiveToFifteen.getInstance().setFaint(("-1"));
        CodFiveToFifteen.getInstance().setStiffness(("-1"));
        CodFiveToFifteen.getInstance().setNeckStiffness(("-1"));
        CodFiveToFifteen.getInstance().setDiarrhea(("-1"));
        CodFiveToFifteen.getInstance().setDiarrheaDays((""));
        CodFiveToFifteen.getInstance().setStoolBlood(("-1"));
        CodFiveToFifteen.getInstance().setLiquid(("-1"));
        CodFiveToFifteen.getInstance().setCough(("-1"));
        CodFiveToFifteen.getInstance().setCoughDays((""));
        CodFiveToFifteen.getInstance().setCoughHow(("-1"));
        CodFiveToFifteen.getInstance().setBreathProblem(("-1"));
        CodFiveToFifteen.getInstance().setBreathProblemDays((""));
        CodFiveToFifteen.getInstance().setBreathSpeed(("-1"));
        CodFiveToFifteen.getInstance().setMucus(("-1"));
        CodFiveToFifteen.getInstance().setBreathWhistle(("-1"));
        CodFiveToFifteen.getInstance().setAntibiotics(("-1"));
        CodFiveToFifteen.getInstance().setStomachAche(("-1"));
        CodFiveToFifteen.getInstance().setStomachAcheWhere(("-1"));
        CodFiveToFifteen.getInstance().setStomachBloat(("-1"));
        CodFiveToFifteen.getInstance().setVomit(("-1"));
        CodFiveToFifteen.getInstance().setVomitDays((""));
        CodFiveToFifteen.getInstance().setEyesYellow(("-1"));
        CodFiveToFifteen.getInstance().setSkinRash(("-1"));
        CodFiveToFifteen.getInstance().setRashWhere(("-1"));
        CodFiveToFifteen.getInstance().setRashMeasles(("-1"));
        CodFiveToFifteen.getInstance().setSicklyAppearance(("-1"));
        CodFiveToFifteen.getInstance().setYellowAppearance(("-1"));
        CodFiveToFifteen.getInstance().setFrequentlySick(("-1"));
        CodFiveToFifteen.getInstance().setSickTimes((""));
        CodFiveToFifteen.getInstance().setSymptomsAccompanied(("-1"));
        CodFiveToFifteen.getInstance().setCHANGE(("-1"));
        CodFiveToFifteen.getInstance().setBCG(("-1"));
        CodFiveToFifteen.getInstance().setPolioDose(("-1"));
        CodFiveToFifteen.getInstance().setMeaslesInjection(("-1"));
        //   CodFiveToFifteen.getInstance().setWrittenDescription(("-1"));
        CodFiveToFifteen.getInstance().setAnswererQuality(("-1"));
        CodFiveToFifteen.getInstance().setInterviewerName((""));
        CodFiveToFifteen.getInstance().setDate(("-1"));


        date = (TextView)findViewById(R.id.Date);

        t_13_1 = (TextView) findViewById(R.id.t_13_1);
        t_13_2 = (TextView) findViewById(R.id. t_13_2);
        information = (TextView) findViewById(R.id. information);
        t_14 = (TextView) findViewById(R.id. t_14);
        t_15_1 = (TextView) findViewById(R.id. t_15_1);
        t_15_2 = (TextView) findViewById(R.id. t_15_2);
        t_16_1 = (TextView) findViewById(R.id. t_16_1);
        t_16_2 = (TextView) findViewById(R.id. t_16_2);
        illnessDesc = (TextView) findViewById(R.id. illnessDesc);
        t_17 = (TextView) findViewById(R.id. t_17);
        t_18_1 = (TextView) findViewById(R.id. t_18_1);
        t_18_2 = (TextView) findViewById(R.id. t_18_2);
        t_18_3 = (TextView) findViewById(R.id. t_18_3);
        t_19 = (TextView) findViewById(R.id. t_19);
        t_20 = (TextView) findViewById(R.id. t_20);
        t_21 = (TextView) findViewById(R.id. t_21);
        t_22 = (TextView) findViewById(R.id. t_22);
        t_23_1 = (TextView) findViewById(R.id. t_23_1);
        t_23_2 = (TextView) findViewById(R.id. t_23_2);
        t_23_3 = (TextView) findViewById(R.id. t_23_3);
        t_23_4 = (TextView) findViewById(R.id. t_23_4);
        t_24_1 = (TextView) findViewById(R.id. t_24_1);
        t_24_2 = (TextView) findViewById(R.id. t_24_2);
        t_24_3 = (TextView) findViewById(R.id. t_24_3);
        t_25_1 = (TextView) findViewById(R.id. t_25_1);
        t_25_2 = (TextView) findViewById(R.id. t_25_2);
        t_25_3 = (TextView) findViewById(R.id. t_25_3);
        t_25_4 = (TextView) findViewById(R.id. t_25_4);
        t_25_5 = (TextView) findViewById(R.id. t_25_5);
        t_25_6 = (TextView) findViewById(R.id. t_25_6);
        t_26_1 = (TextView) findViewById(R.id. t_26_1);
        t_26_2 = (TextView) findViewById(R.id. t_26_2);
        t_26_3 = (TextView) findViewById(R.id. t_26_3);
        t_27_1 = (TextView) findViewById(R.id. t_27_1);
        t_27_2 = (TextView) findViewById(R.id. t_27_2);
        t_28 = (TextView) findViewById(R.id. t_28);
        t_29_1 = (TextView) findViewById(R.id. t_29_1);
        t_29_2 = (TextView) findViewById(R.id. t_29_2);
        t_29_3 = (TextView) findViewById(R.id. t_29_3);
        t_30 = (TextView) findViewById(R.id. t_30);
        t_31 = (TextView) findViewById(R.id. t_31);
        t_32_1 = (TextView) findViewById(R.id. t_32_1);
        t_32_2 = (TextView) findViewById(R.id. t_32_2);
        t_32_3 = (TextView) findViewById(R.id. t_32_3);
        t_33_1 = (TextView) findViewById(R.id. t_33_1);
        t_33_2 = (TextView) findViewById(R.id. t_33_2);
        t_33_3 = (TextView) findViewById(R.id. t_33_3);
        t_33_4 = (TextView) findViewById(R.id. t_33_4);

        deathAccident = (RadioGroup) findViewById(R.id.deathAccidentHow);
        deathAccidentHow1to6 = (RadioGroup) findViewById(R.id. deathAccidentType1to6);
        deathAccidentHow7to12 = (RadioGroup) findViewById(R.id. deathAccidentType7to12);
        birthAppearance1to3 = (RadioGroup) findViewById(R.id. birthTimeBabyShape1to3);
        birthAppearance4to5 = (RadioGroup) findViewById(R.id. birthTimeBabyShape4to5);
        lessDaysBirth = (RadioGroup) findViewById(R.id. lessDaysBirth);
        breastFeeding = (RadioGroup) findViewById(R.id. breastFeeding);
        breastFeedingHalt = (RadioGroup) findViewById(R.id.breastFeedingHalt);
        fever = (RadioGroup) findViewById(R.id. fever);
        feverShiver = (RadioGroup) findViewById(R.id. feverShiver);
        fit = (RadioGroup) findViewById(R.id. fit);
        faint = (RadioGroup) findViewById(R.id. faint);
        stiffness = (RadioGroup) findViewById(R.id. stiffness);
        neckStiffness = (RadioGroup) findViewById(R.id. neckStiffness);
        diarrhea = (RadioGroup) findViewById(R.id. diarrhea);
        stoolBlood = (RadioGroup) findViewById(R.id. stoolBlood);
        liquid = (RadioGroup) findViewById(R.id. liquid);
        cough = (RadioGroup) findViewById(R.id. cough);
        coughHow1 = (RadioGroup) findViewById(R.id. coughHow1);
        coughHow2 = (RadioGroup) findViewById(R.id. coughHow2);
        breathProblem = (RadioGroup) findViewById(R.id. breathProblem);
        breathSpeed = (RadioGroup) findViewById(R.id. breathSpeed);
        mucus = (RadioGroup) findViewById(R.id. mucus);
        breathWhistle = (RadioGroup) findViewById(R.id. breathWhistle);
        antibiotics = (RadioGroup) findViewById(R.id. antibiotics);
        stomachAche = (RadioGroup) findViewById(R.id. stomachAche);
        stomachAcheWhere1 = (RadioGroup) findViewById(R.id. stomachAcheWhere1);
        stomachAcheWhere2 = (RadioGroup) findViewById(R.id. stomachAcheWhere2);
        stomachBloat = (RadioGroup) findViewById(R.id. stomachBloat);
        vomit = (RadioGroup) findViewById(R.id. vomit);
        eyesYellow = (RadioGroup) findViewById(R.id. eyesYellow);
        skinRash = (RadioGroup) findViewById(R.id. skinRash);
        rashWhere = (RadioGroup) findViewById(R.id. rashWhere);
        rashMeasles = (RadioGroup) findViewById(R.id. rashMeasles);
        sicklyAppearance = (RadioGroup) findViewById(R.id. sicklyAppearance);
        yellowAppearance = (RadioGroup) findViewById(R.id. yellowAppearance);
        frequentlySick = (RadioGroup) findViewById(R.id. frequentlySick);
        symptomsAccompanied1 = (RadioGroup) findViewById(R.id.symptomsAccompanied1);
        symptomsAccompanied2 = (RadioGroup) findViewById(R.id. symptomsAccompanied2);
        symptomsAccompanied3 = (RadioGroup) findViewById(R.id. symptomsAccompanied3);
        CHANGE = (RadioGroup) findViewById(R.id. CHANGE);
        BCG = (RadioGroup) findViewById(R.id. BCG);
        polioDose = (RadioGroup) findViewById(R.id. polioDose);
        measlesInjection = (RadioGroup) findViewById(R.id. measlesInjection);
        answererQuality = (RadioGroup) findViewById(R.id. answererQuality);

        pregnancyStage = (EditText)findViewById(R.id.pregnancyStage);
        sickDays = (EditText)findViewById(R.id.sickDays);
        feverDays = (EditText)findViewById(R.id.feverDays);
        diarrheaDays = (EditText)findViewById(R.id.diarrheaDays);
        coughDays = (EditText)findViewById(R.id.coughDays);
        breathProblemDays = (EditText)findViewById(R.id.breathProblemDays);
        vomitDays = (EditText)findViewById(R.id.vomitDays);
        sickTimes = (EditText)findViewById(R.id.sickTimes);
        interviewerName = (EditText)findViewById(R.id.interviewerName);

        next = (Button) findViewById(R.id.next);

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(sdf.format(d));
        CodFiveToFifteen.getInstance().setDate(date.getText().toString());

        // deathAge.setFocusableInTouchMode(true);

        //   int deathAccidentHowValue = deathAccidentHow.indexOfChild(findViewById(deathAccidentHow.getCheckedRadioButtonId()));
        deathAccident.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int deathAccidentValue = deathAccident.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setDeathAccident(Integer.toString(deathAccidentValue));
                if(deathAccidentValue == 0){
                    t_13_2.setVisibility(View.VISIBLE);
                    deathAccidentHow1to6.setVisibility(View.VISIBLE);
                    deathAccidentHow7to12.setVisibility(View.VISIBLE);
                    makeEditTextInvisible();
                    makeAllInvisible();
                }
                else if(deathAccidentValue == 1){
                    t_13_2.setVisibility(View.GONE);
                    deathAccidentHow1to6.setVisibility(View.GONE);
                    deathAccidentHow7to12.setVisibility(View.GONE);
                    makeAllVisible();
                    makeEditTextVisible();
                }
                else{
                    t_13_2.setVisibility(View.VISIBLE);
                    deathAccidentHow1to6.setVisibility(View.VISIBLE);
                    deathAccidentHow7to12.setVisibility(View.VISIBLE);
                    makeAllVisible();
                    makeEditTextVisible();
                }

            }
        });
        lessDaysBirth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int lessDaysBirthValue = lessDaysBirth.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setLessPregnancyTime(Integer.toString(lessDaysBirthValue));
                if(lessDaysBirthValue == 1){
                    t_15_2.setVisibility(View.GONE);
                    pregnancyStage.setVisibility(View.GONE);
                }
                else {
                    t_15_2.setVisibility(View.VISIBLE);
                    pregnancyStage.setVisibility(View.VISIBLE);
                }
            }
        });
        breastFeeding.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int breastFeedingValue = breastFeeding.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setBreastFeeding(Integer.toString(breastFeedingValue));
                if(breastFeedingValue == 1){
                    t_16_2.setVisibility(View.GONE);
                    breastFeedingHalt.setVisibility(View.GONE);
                }
                else {
                    t_16_2.setVisibility(View.VISIBLE);
                    breastFeedingHalt.setVisibility(View.VISIBLE);
                }
            }
        });
        diarrhea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int diarrheaValue = diarrhea.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setDiarrhea(Integer.toString(diarrheaValue));
                if(diarrheaValue == 1){
                    t_23_2.setVisibility(View.GONE);
                    t_23_3.setVisibility(View.GONE);
                    t_23_4.setVisibility(View.GONE);
                    diarrheaDays.setVisibility(View.GONE);
                    stoolBlood.setVisibility(View.GONE);
                    liquid.setVisibility(View.GONE);
                }
                else {
                    t_23_2.setVisibility(View.VISIBLE);
                    t_23_3.setVisibility(View.VISIBLE);
                    t_23_4.setVisibility(View.VISIBLE);
                    diarrheaDays.setVisibility(View.VISIBLE);
                    stoolBlood.setVisibility(View.VISIBLE);
                    liquid.setVisibility(View.VISIBLE);
                }
            }
        });
        cough.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int coughValue = cough.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setCough(Integer.toString(coughValue));
                if(coughValue == 1){
                    t_24_2.setVisibility(View.GONE);
                    t_24_3.setVisibility(View.GONE);
                    coughDays.setVisibility(View.GONE);
                    coughHow1.setVisibility(View.GONE);
                    coughHow2.setVisibility(View.GONE);
                }
                else {
                    t_24_2.setVisibility(View.VISIBLE);
                    t_24_3.setVisibility(View.VISIBLE);
                    coughDays.setVisibility(View.VISIBLE);
                    coughHow1.setVisibility(View.VISIBLE);
                    coughHow2.setVisibility(View.VISIBLE);
                }
            }
        });
        breathProblem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int breathProblemValue = breathProblem.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setBreathProblem(Integer.toString(breathProblemValue));
                if(breathProblemValue == 1){
                    t_25_2.setVisibility(View.GONE);
                    t_25_3.setVisibility(View.GONE);
                    t_25_4.setVisibility(View.GONE);
                    t_25_5.setVisibility(View.GONE);
                    t_25_6.setVisibility(View.GONE);
                    breathProblemDays.setVisibility(View.GONE);
                    breathSpeed.setVisibility(View.GONE);
                    mucus.setVisibility(View.GONE);
                    breathWhistle.setVisibility(View.GONE);
                    antibiotics.setVisibility(View.GONE);

                }
                else {
                    t_25_2.setVisibility(View.VISIBLE);
                    t_25_3.setVisibility(View.VISIBLE);
                    t_25_4.setVisibility(View.VISIBLE);
                    t_25_5.setVisibility(View.VISIBLE);
                    t_25_6.setVisibility(View.VISIBLE);
                    breathProblemDays.setVisibility(View.VISIBLE);
                    breathSpeed.setVisibility(View.VISIBLE);
                    mucus.setVisibility(View.VISIBLE);
                    breathWhistle.setVisibility(View.VISIBLE);
                    antibiotics.setVisibility(View.VISIBLE);
                }
            }
        });
        stomachAche.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int stomachAcheValue = stomachAche.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setStomachAche(Integer.toString(stomachAcheValue));
                if(stomachAcheValue == 1){
                    t_26_2.setVisibility(View.GONE);
                    stomachAcheWhere1.setVisibility(View.GONE);
                    stomachAcheWhere2.setVisibility(View.GONE);
                }
                else {
                    t_26_2.setVisibility(View.VISIBLE);
                    stomachAcheWhere1.setVisibility(View.VISIBLE);
                    stomachAcheWhere2.setVisibility(View.VISIBLE);
                }
            }
        });
        vomit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int vomitValue = vomit.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setVomit(Integer.toString(vomitValue));
                if(vomitValue == 1){
                    t_27_2.setVisibility(View.GONE);
                    vomitDays.setVisibility(View.GONE);
                }
                else {
                    t_27_2.setVisibility(View.VISIBLE);
                    vomitDays.setVisibility(View.VISIBLE);
                }
            }
        });
        skinRash.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int skinRashValue = skinRash.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setSkinRash(Integer.toString(skinRashValue));
                if(skinRashValue == 1){
                    t_29_2.setVisibility(View.GONE);
                    t_29_3.setVisibility(View.GONE);
                    rashWhere.setVisibility(View.GONE);
                    rashMeasles.setVisibility(View.GONE);
                }
                else {
                    t_29_2.setVisibility(View.VISIBLE);
                    t_29_3.setVisibility(View.VISIBLE);
                    rashWhere.setVisibility(View.VISIBLE);
                    rashMeasles.setVisibility(View.VISIBLE);
                }
            }
        });
        frequentlySick.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int frequentlySickValue = frequentlySick.indexOfChild(findViewById(checkedId));
                CodFiveToFifteen.getInstance().setFrequentlySick(Integer.toString(frequentlySickValue));
                if(frequentlySickValue == 1){
                    t_32_2.setVisibility(View.GONE);
                    t_32_3.setVisibility(View.GONE);
                    sickTimes.setVisibility(View.GONE);
                    symptomsAccompanied1.setVisibility(View.GONE);
                    symptomsAccompanied2.setVisibility(View.GONE);
                    symptomsAccompanied3.setVisibility(View.GONE);
                }
                else {
                    t_32_2.setVisibility(View.VISIBLE);
                    t_32_3.setVisibility(View.VISIBLE);
                    sickTimes.setVisibility(View.VISIBLE);
                    symptomsAccompanied1.setVisibility(View.VISIBLE);
                    symptomsAccompanied2.setVisibility(View.VISIBLE);
                    symptomsAccompanied3.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0;
                int deathAccidentHowValue1 = deathAccidentHow1to6.indexOfChild(findViewById(deathAccidentHow1to6.getCheckedRadioButtonId()));
                int deathAccidentHowValue2 = deathAccidentHow7to12.indexOfChild(findViewById(deathAccidentHow7to12.getCheckedRadioButtonId()));
                int birthAppearanceValue1 = birthAppearance1to3.indexOfChild(findViewById(birthAppearance1to3.getCheckedRadioButtonId()));
                int birthAppearanceValue2 = birthAppearance4to5.indexOfChild(findViewById(birthAppearance4to5.getCheckedRadioButtonId()));
                int coughHowValue1 = coughHow1.indexOfChild(findViewById(coughHow1.getCheckedRadioButtonId()));
                int coughHowValue2 = coughHow2.indexOfChild(findViewById(coughHow2.getCheckedRadioButtonId()));
                int stomachAcheWhereValue1 = stomachAcheWhere1.indexOfChild(findViewById(stomachAcheWhere1.getCheckedRadioButtonId()));
                int stomachAcheWhereValue2 = stomachAcheWhere2.indexOfChild(findViewById(stomachAcheWhere2.getCheckedRadioButtonId()));
                int symptomsAccompaniedValue1 = symptomsAccompanied1.indexOfChild(findViewById(symptomsAccompanied1.getCheckedRadioButtonId()));
                int symptomsAccompaniedValue2 = symptomsAccompanied2.indexOfChild(findViewById(symptomsAccompanied2.getCheckedRadioButtonId()));
                int symptomsAccompaniedValue3 = symptomsAccompanied3.indexOfChild(findViewById(symptomsAccompanied3.getCheckedRadioButtonId()));




                if(deathAccidentHowValue1 == -1)
                    CodFiveToFifteen.getInstance().setDeathAccidentHow(Integer.toString(6 + deathAccidentHowValue2));
                else
                    CodFiveToFifteen.getInstance().setDeathAccidentHow(Integer.toString(deathAccidentHowValue1));

                if(birthAppearanceValue1 == -1)
                    CodFiveToFifteen.getInstance().setBirthAppearance(Integer.toString(3 + birthAppearanceValue2));
                else
                    CodFiveToFifteen.getInstance().setBirthAppearance(Integer.toString(birthAppearanceValue1));

                if(coughHowValue1 == -1)
                    CodFiveToFifteen.getInstance().setCoughHow(Integer.toString(2 + coughHowValue2));
                else
                    CodFiveToFifteen.getInstance().setCoughHow(Integer.toString(coughHowValue1));

                if(stomachAcheWhereValue1 == -1)
                    CodFiveToFifteen.getInstance().setStomachAcheWhere(Integer.toString(2 + stomachAcheWhereValue2));
                else
                    CodFiveToFifteen.getInstance().setStomachAcheWhere(Integer.toString(stomachAcheWhereValue1));

                if(symptomsAccompaniedValue1 != -1)
                    CodFiveToFifteen.getInstance().setSymptomsAccompanied(Integer.toString(symptomsAccompaniedValue1));
                else if(symptomsAccompaniedValue2 != -1)
                    CodFiveToFifteen.getInstance().setSymptomsAccompanied(Integer.toString(symptomsAccompaniedValue2));
                else
                    CodFiveToFifteen.getInstance().setSymptomsAccompanied(Integer.toString(symptomsAccompaniedValue3));

                int breastFeedingHaltValue =breastFeedingHalt.indexOfChild(findViewById(breastFeedingHalt.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setBreastFeedingHalt(Integer.toString(breastFeedingHaltValue));
                int  feverValue = fever.indexOfChild(findViewById( fever.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setFever(Integer.toString(feverValue));
                int  feverShiverValue = feverShiver.indexOfChild(findViewById( feverShiver.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setFeverShiver(Integer.toString(feverShiverValue));
                int  fitValue = fit.indexOfChild(findViewById( fit.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setFit(Integer.toString(fitValue));
                int  faintValue = faint.indexOfChild(findViewById( faint.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setFaint(Integer.toString(faintValue));
                int  stiffnessValue = stiffness.indexOfChild(findViewById( stiffness.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setStiffness(Integer.toString(stiffnessValue));
                int  neckStiffnessValue = neckStiffness.indexOfChild(findViewById( neckStiffness.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setNeckStiffness(Integer.toString(neckStiffnessValue));
                int  stoolBloodValue = stoolBlood.indexOfChild(findViewById( stoolBlood.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setStoolBlood(Integer.toString(stoolBloodValue));
                int  liquidValue = liquid.indexOfChild(findViewById( liquid.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setLiquid(Integer.toString(liquidValue));
                int  breathSpeedValue = breathSpeed.indexOfChild(findViewById( breathSpeed.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setBreathSpeed(Integer.toString(breathSpeedValue));
                int  mucusValue = mucus.indexOfChild(findViewById( mucus.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setMucus(Integer.toString(mucusValue));
                int  breathWhistleValue = breathWhistle.indexOfChild(findViewById( breathWhistle.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setBreathWhistle(Integer.toString(breathWhistleValue));
                int  antibioticsValue = antibiotics.indexOfChild(findViewById( antibiotics.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setAntibiotics(Integer.toString(antibioticsValue));
                int stomachBloatValue =stomachBloat.indexOfChild(findViewById(stomachBloat.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setStomachBloat(Integer.toString(stomachBloatValue));
                int  eyesYellowValue = eyesYellow.indexOfChild(findViewById( eyesYellow.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setEyesYellow(Integer.toString(eyesYellowValue));
                int rashWhereValue =rashWhere.indexOfChild(findViewById(rashWhere.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setRashWhere(Integer.toString(rashWhereValue));
                int  rashMeaslesValue = rashMeasles.indexOfChild(findViewById( rashMeasles.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setRashMeasles(Integer.toString(rashMeaslesValue));
                int  sicklyAppearanceValue = sicklyAppearance.indexOfChild(findViewById( sicklyAppearance.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setSicklyAppearance(Integer.toString(sicklyAppearanceValue));
                int  yellowAppearanceValue = yellowAppearance.indexOfChild(findViewById( yellowAppearance.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setYellowAppearance(Integer.toString(yellowAppearanceValue));
                int  CHANGEValue = CHANGE.indexOfChild(findViewById( CHANGE.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setCHANGE(Integer.toString( CHANGEValue));
                int  BCGValue = BCG.indexOfChild(findViewById( BCG.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setBCG(Integer.toString( BCGValue));
                int  polioDoseValue = polioDose.indexOfChild(findViewById( polioDose.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setPolioDose(Integer.toString(polioDoseValue));
                int measlesInjectionValue =measlesInjection.indexOfChild(findViewById(measlesInjection.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setMeaslesInjection(Integer.toString(measlesInjectionValue));
                int  answererQualityValue = answererQuality.indexOfChild(findViewById( answererQuality.getCheckedRadioButtonId()));
                CodFiveToFifteen.getInstance().setAnswererQuality(Integer.toString(answererQualityValue));

                CodFiveToFifteen.getInstance().setPregnancyTime(pregnancyStage.getText().toString());
                CodFiveToFifteen.getInstance().setSickDays(sickDays.getText().toString());
                CodFiveToFifteen.getInstance().setFeverDays(feverDays.getText().toString());
                CodFiveToFifteen.getInstance().setDiarrheaDays(diarrheaDays.getText().toString());
                CodFiveToFifteen.getInstance().setCoughDays(coughDays.getText().toString());
                CodFiveToFifteen.getInstance().setBreathProblemDays(breathProblemDays.getText().toString());
                CodFiveToFifteen.getInstance().setVomitDays(vomitDays.getText().toString());
                CodFiveToFifteen.getInstance().setSickTimes(sickTimes.getText().toString());
                CodFiveToFifteen.getInstance().setInterviewerName(interviewerName.getText().toString());

                /*String dateValue = date.getDayOfMonth() + "-" + (date.getMonth() + 1) + "-" + date.getYear();
                CodFiveToFifteen.getInstance().setDate(dateValue);*/

                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathAccident()) == -1 &&
                        !(deathAccident.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDeathAccidentHow()) == -1 &&
                        !(deathAccidentHow1to6.getVisibility() == View.GONE) && !(deathAccidentHow7to12.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBirthAppearance()) == -1 &&
                        !(birthAppearance1to3.getVisibility() == View.GONE) && !(birthAppearance4to5.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getLessPregnancyTime()) == -1 &&
                        !(lessDaysBirth.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getPregnancyTime() == "" &&
                        !(pregnancyStage.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBreastFeeding()) == -1 &&
                        !(breastFeeding.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBreastFeedingHalt()) == -1 &&
                        !(breastFeedingHalt.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getSickDays() == "" &&
                        !(sickDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFever()) == -1 &&
                        !(fever.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getFeverDays() == "" &&
                        !(feverDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFeverShiver()) == -1 &&
                        !(feverShiver.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFit()) == -1 &&
                        !(fit.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFaint()) == -1 &&
                        !(faint.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getStiffness()) == -1 &&
                        !(stiffness.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getNeckStiffness()) == -1 &&
                        !(neckStiffness.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getDiarrhea()) == -1 &&
                        !(diarrhea.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getDiarrheaDays() == "" &&
                        !(diarrheaDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getStoolBlood()) == -1 &&
                        !(stoolBlood.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getLiquid()) == -1 &&
                        !(liquid.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getCough()) == -1 &&
                        !(cough.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getCoughDays() == "" &&
                        !(coughDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getCoughHow()) == -1 &&
                        !(coughHow1.getVisibility() == View.GONE) && !(coughHow2.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBreathProblem()) == -1 &&
                        !(breathProblem.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getBreathProblemDays() == "" &&
                        !(breathProblemDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBreathSpeed()) == -1 &&
                        !(breathSpeed.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getMucus()) == -1 &&
                        !(mucus.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBreathWhistle()) == -1 &&
                        !(breathWhistle.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getAntibiotics()) == -1 &&
                        !(antibiotics.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getStomachAche()) == -1 &&
                        !(stomachAche.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getStomachAcheWhere()) == -1 &&
                        !(stomachAcheWhere1.getVisibility() == View.GONE) && !(stomachAcheWhere2.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getStomachBloat()) == -1 &&
                        !(stomachBloat.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getVomit()) == -1 &&
                        !(vomit.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getVomitDays() == "" &&
                        !(vomitDays.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getEyesYellow()) == -1 &&
                        !(eyesYellow.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getSkinRash()) == -1 &&
                        !(skinRash.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getRashWhere()) == -1 &&
                        !(rashWhere.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getRashMeasles()) == -1 &&
                        !(rashMeasles.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getSicklyAppearance()) == -1 &&
                        !(sicklyAppearance.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getYellowAppearance()) == -1 &&
                        !(yellowAppearance.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getFrequentlySick()) == -1 &&
                        !(frequentlySick.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getSickTimes() == "" &&
                        !(sickTimes.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getSymptomsAccompanied()) == -1 &&
                        !(symptomsAccompanied1.getVisibility() == View.GONE) && !(symptomsAccompanied2.getVisibility() == View.GONE)
                        && !(symptomsAccompanied3.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getCHANGE()) == -1 &&
                        !(CHANGE.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getBCG()) == -1 &&
                        !(BCG.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getPolioDose()) == -1 &&
                        !(polioDose.getVisibility() == View.GONE))
                    flag = 1;
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getMeaslesInjection()) == -1 &&
                        !(measlesInjection.getVisibility() == View.GONE))
                    flag = 1;
              /*  if(Integer.parseInt(CodFiveToFifteen.getInstance().getWrittenDescription()) == -1 &&
!(writtenDescription.getVisibility() == View.GONE))
flag = 1;*/
                if(Integer.parseInt(CodFiveToFifteen.getInstance().getAnswererQuality()) == -1 &&
                        !(answererQuality.getVisibility() == View.GONE))
                    flag = 1;
                if(CodFiveToFifteen.getInstance().getInterviewerName() == "" &&
                        !(interviewerName.getVisibility() == View.GONE))
                    flag = 1;




                Log.d("Pch", CodFiveToFifteen.getInstance().getDeathAccident());
                Log.d("Pch", CodFiveToFifteen.getInstance().getDeathAccidentHow());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBirthAppearance());
                Log.d("Pch", CodFiveToFifteen.getInstance().getLessPregnancyTime());
                Log.d("Pch", CodFiveToFifteen.getInstance().getPregnancyTime());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreastFeeding());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreastFeedingHalt());
                Log.d("Pch", CodFiveToFifteen.getInstance().getSickDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getFever());
                Log.d("Pch", CodFiveToFifteen.getInstance().getFeverDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getFeverShiver());
                Log.d("Pch", CodFiveToFifteen.getInstance().getFit());
                Log.d("Pch", CodFiveToFifteen.getInstance().getFaint());
                Log.d("Pch", CodFiveToFifteen.getInstance().getStiffness());
                Log.d("Pch", CodFiveToFifteen.getInstance().getNeckStiffness());
                Log.d("Pch", CodFiveToFifteen.getInstance().getDiarrhea());
                Log.d("Pch", CodFiveToFifteen.getInstance().getDiarrheaDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getStoolBlood());
                Log.d("Pch", CodFiveToFifteen.getInstance().getLiquid());
                Log.d("Pch", CodFiveToFifteen.getInstance().getCough());
                Log.d("Pch", CodFiveToFifteen.getInstance().getCoughDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getCoughHow());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreathProblem());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreathProblemDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreathSpeed());
                Log.d("Pch", CodFiveToFifteen.getInstance().getMucus());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBreathWhistle());
                Log.d("Pch", CodFiveToFifteen.getInstance().getAntibiotics());
                Log.d("Pch", CodFiveToFifteen.getInstance().getStomachAche());
                Log.d("Pch", CodFiveToFifteen.getInstance().getStomachAcheWhere());
                Log.d("Pch", CodFiveToFifteen.getInstance().getStomachBloat());
                Log.d("Pch", CodFiveToFifteen.getInstance().getVomit());
                Log.d("Pch", CodFiveToFifteen.getInstance().getVomitDays());
                Log.d("Pch", CodFiveToFifteen.getInstance().getEyesYellow());
                Log.d("Pch", CodFiveToFifteen.getInstance().getSkinRash());
                Log.d("Pch", CodFiveToFifteen.getInstance().getRashWhere());
                Log.d("Pch", CodFiveToFifteen.getInstance().getRashMeasles());
                Log.d("Pch", CodFiveToFifteen.getInstance().getSicklyAppearance());
                Log.d("Pch", CodFiveToFifteen.getInstance().getYellowAppearance());
                Log.d("Freq", CodFiveToFifteen.getInstance().getFrequentlySick());
                Log.d("Pch", CodFiveToFifteen.getInstance().getSickTimes());
                Log.d("Pch", CodFiveToFifteen.getInstance().getSymptomsAccompanied());
                Log.d("Pch", CodFiveToFifteen.getInstance().getCHANGE());
                Log.d("Pch", CodFiveToFifteen.getInstance().getBCG());
                Log.d("Pch", CodFiveToFifteen.getInstance().getPolioDose());
                Log.d("Pch", CodFiveToFifteen.getInstance().getMeaslesInjection());
//                Log.d("Pch", CodFiveToFifteen.getInstance().getWrittenDescription());
                Log.d("Pch", CodFiveToFifteen.getInstance().getAnswererQuality());
                Log.d("Pch", CodFiveToFifteen.getInstance().getInterviewerName());
                Log.d("Pch", CodFiveToFifteen.getInstance().getDate());

                if(flag == 1)
                    displayAlert();
                else
                    displayNextAlert();

                CodFiveToFifteenDBHelper dbHelper = new CodFiveToFifteenDBHelper(getApplicationContext());
                dbHelper.insert(CodFiveToFifteen.getInstance());
                //CodFiveToFifteen.getInstance().destroy();



            }
        });





    }


    public void makeAllInvisible(){
        information.setVisibility(View.GONE);
        illnessDesc.setVisibility(View.GONE);
        t_14.setVisibility(View.GONE);
        t_15_1.setVisibility(View.GONE);
        t_15_2.setVisibility(View.GONE);
        t_16_1.setVisibility(View.GONE);
        t_16_2.setVisibility(View.GONE);
        t_17.setVisibility(View.GONE);
        t_18_1.setVisibility(View.GONE);
        t_18_2.setVisibility(View.GONE);
        t_18_3.setVisibility(View.GONE);
        t_19.setVisibility(View.GONE);
        t_20.setVisibility(View.GONE);
        t_21.setVisibility(View.GONE);
        t_22.setVisibility(View.GONE);
        t_23_1.setVisibility(View.GONE);
        t_23_2.setVisibility(View.GONE);
        t_23_3.setVisibility(View.GONE);
        t_23_4.setVisibility(View.GONE);
        t_24_1.setVisibility(View.GONE);
        t_24_2.setVisibility(View.GONE);
        t_24_3.setVisibility(View.GONE);
        t_25_1.setVisibility(View.GONE);
        t_25_2.setVisibility(View.GONE);
        t_25_3.setVisibility(View.GONE);
        t_25_4.setVisibility(View.GONE);
        t_25_5.setVisibility(View.GONE);
        t_25_6.setVisibility(View.GONE);
        t_26_1.setVisibility(View.GONE);
        t_26_2.setVisibility(View.GONE);
        t_26_3.setVisibility(View.GONE);
        t_27_1.setVisibility(View.GONE);
        t_27_2.setVisibility(View.GONE);
        t_28.setVisibility(View.GONE);
        t_29_1.setVisibility(View.GONE);
        t_29_2.setVisibility(View.GONE);
        t_29_3.setVisibility(View.GONE);
        t_30.setVisibility(View.GONE);
        t_31.setVisibility(View.GONE);
        t_32_1.setVisibility(View.GONE);
        t_32_2.setVisibility(View.GONE);
        t_32_3.setVisibility(View.GONE);

        birthAppearance1to3.setVisibility(View.GONE);
        birthAppearance4to5.setVisibility(View.GONE);
        lessDaysBirth.setVisibility(View.GONE);
        breastFeeding.setVisibility(View.GONE);
        breastFeedingHalt.setVisibility(View.GONE);
        fever.setVisibility(View.GONE);
        feverShiver.setVisibility(View.GONE);
        fit.setVisibility(View.GONE);
        faint.setVisibility(View.GONE);
        stiffness.setVisibility(View.GONE);
        neckStiffness.setVisibility(View.GONE);
        diarrhea.setVisibility(View.GONE);
        stoolBlood.setVisibility(View.GONE);
        liquid.setVisibility(View.GONE);
        cough.setVisibility(View.GONE);
        coughHow1.setVisibility(View.GONE);
        coughHow2.setVisibility(View.GONE);
        breathProblem.setVisibility(View.GONE);
        breathSpeed.setVisibility(View.GONE);
        mucus.setVisibility(View.GONE);
        breathWhistle.setVisibility(View.GONE);
        antibiotics.setVisibility(View.GONE);
        stomachAche.setVisibility(View.GONE);
        stomachAcheWhere1.setVisibility(View.GONE);
        stomachAcheWhere2.setVisibility(View.GONE);
        stomachBloat.setVisibility(View.GONE);
        vomit.setVisibility(View.GONE);
        eyesYellow.setVisibility(View.GONE);
        skinRash.setVisibility(View.GONE);
        rashWhere.setVisibility(View.GONE);
        rashMeasles.setVisibility(View.GONE);
        sicklyAppearance.setVisibility(View.GONE);
        yellowAppearance.setVisibility(View.GONE);
        frequentlySick.setVisibility(View.GONE);
        symptomsAccompanied1.setVisibility(View.GONE);
        symptomsAccompanied2.setVisibility(View.GONE);
        symptomsAccompanied3.setVisibility(View.GONE);




    }

    public void makeAllVisible(){
        information.setVisibility(View.VISIBLE);
        illnessDesc.setVisibility(View.VISIBLE);
        t_14.setVisibility(View.VISIBLE);
        t_15_1.setVisibility(View.VISIBLE);
        t_15_2.setVisibility(View.VISIBLE);
        t_16_1.setVisibility(View.VISIBLE);
        t_16_2.setVisibility(View.VISIBLE);
        t_17.setVisibility(View.VISIBLE);
        t_18_1.setVisibility(View.VISIBLE);
        t_18_2.setVisibility(View.VISIBLE);
        t_18_3.setVisibility(View.VISIBLE);
        t_19.setVisibility(View.VISIBLE);
        t_20.setVisibility(View.VISIBLE);
        t_21.setVisibility(View.VISIBLE);
        t_22.setVisibility(View.VISIBLE);
        t_23_1.setVisibility(View.VISIBLE);
        t_23_2.setVisibility(View.VISIBLE);
        t_23_3.setVisibility(View.VISIBLE);
        t_23_4.setVisibility(View.VISIBLE);
        t_24_1.setVisibility(View.VISIBLE);
        t_24_2.setVisibility(View.VISIBLE);
        t_24_3.setVisibility(View.VISIBLE);
        t_25_1.setVisibility(View.VISIBLE);
        t_25_2.setVisibility(View.VISIBLE);
        t_25_3.setVisibility(View.VISIBLE);
        t_25_4.setVisibility(View.VISIBLE);
        t_25_5.setVisibility(View.VISIBLE);
        t_25_6.setVisibility(View.VISIBLE);
        t_26_1.setVisibility(View.VISIBLE);
        t_26_2.setVisibility(View.VISIBLE);
        t_26_3.setVisibility(View.VISIBLE);
        t_27_1.setVisibility(View.VISIBLE);
        t_27_2.setVisibility(View.VISIBLE);
        t_28.setVisibility(View.VISIBLE);
        t_29_1.setVisibility(View.VISIBLE);
        t_29_2.setVisibility(View.VISIBLE);
        t_29_3.setVisibility(View.VISIBLE);
        t_30.setVisibility(View.VISIBLE);
        t_31.setVisibility(View.VISIBLE);
        t_32_1.setVisibility(View.VISIBLE);
        t_32_2.setVisibility(View.VISIBLE);
        t_32_3.setVisibility(View.VISIBLE);

        birthAppearance1to3.setVisibility(View.VISIBLE);
        birthAppearance4to5.setVisibility(View.VISIBLE);
        lessDaysBirth.setVisibility(View.VISIBLE);
        breastFeeding.setVisibility(View.VISIBLE);
        breastFeedingHalt.setVisibility(View.VISIBLE);
        fever.setVisibility(View.VISIBLE);
        feverShiver.setVisibility(View.VISIBLE);
        fit.setVisibility(View.VISIBLE);
        faint.setVisibility(View.VISIBLE);
        stiffness.setVisibility(View.VISIBLE);
        neckStiffness.setVisibility(View.VISIBLE);
        diarrhea.setVisibility(View.VISIBLE);
        stoolBlood.setVisibility(View.VISIBLE);
        liquid.setVisibility(View.VISIBLE);
        cough.setVisibility(View.VISIBLE);
        coughHow1.setVisibility(View.VISIBLE);
        coughHow2.setVisibility(View.VISIBLE);
        breathProblem.setVisibility(View.VISIBLE);
        breathSpeed.setVisibility(View.VISIBLE);
        mucus.setVisibility(View.VISIBLE);
        breathWhistle.setVisibility(View.VISIBLE);
        antibiotics.setVisibility(View.VISIBLE);
        stomachAche.setVisibility(View.VISIBLE);
        stomachAcheWhere1.setVisibility(View.VISIBLE);
        stomachAcheWhere2.setVisibility(View.VISIBLE);
        stomachBloat.setVisibility(View.VISIBLE);
        vomit.setVisibility(View.VISIBLE);
        eyesYellow.setVisibility(View.VISIBLE);
        skinRash.setVisibility(View.VISIBLE);
        rashWhere.setVisibility(View.VISIBLE);
        rashMeasles.setVisibility(View.VISIBLE);
        sicklyAppearance.setVisibility(View.VISIBLE);
        yellowAppearance.setVisibility(View.VISIBLE);
        frequentlySick.setVisibility(View.VISIBLE);
        symptomsAccompanied1.setVisibility(View.VISIBLE);
        symptomsAccompanied2.setVisibility(View.VISIBLE);
        symptomsAccompanied3.setVisibility(View.VISIBLE);




    }

    public void makeEditTextInvisible(){
        pregnancyStage.setVisibility(View.GONE);
        sickDays.setVisibility(View.GONE);
        feverDays.setVisibility(View.GONE);
        diarrheaDays.setVisibility(View.GONE);
        coughDays.setVisibility(View.GONE);
        breathProblemDays.setVisibility(View.GONE);
        vomitDays.setVisibility(View.GONE);
        sickTimes.setVisibility(View.GONE);
    }

    public void makeEditTextVisible(){
        pregnancyStage.setVisibility(View.VISIBLE);
        sickDays.setVisibility(View.VISIBLE);
        feverDays.setVisibility(View.VISIBLE);
        diarrheaDays.setVisibility(View.VISIBLE);
        coughDays.setVisibility(View.VISIBLE);
        breathProblemDays.setVisibility(View.VISIBLE);
        vomitDays.setVisibility(View.VISIBLE);
        sickTimes.setVisibility(View.VISIBLE);
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
                        Intent intent = new Intent(getApplicationContext(), DeathAdultForm.class);
                        intent.putExtra("index","2");
                        intent.putExtra("resident","1");
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
        getMenuInflater().inflate(R.menu.menu_cod5to15__i, menu);
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
