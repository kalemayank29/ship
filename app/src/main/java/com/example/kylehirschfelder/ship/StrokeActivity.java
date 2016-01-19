package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StrokeActivity extends AppCompatActivity {
    Button save;
    LinearLayout suddenLayout, hoursLayout;
    Stroke stroke;
    StrokeDBHelper db;
    MemberDataInterface dataInterface;
    Member member;
    Translation TR;
    ArrayAdapter<String> dataAdapter;
    List<Member> memberList;

    String name, id;
    int curVillage;
    RadioGroup arm, side, face, talk, part, sudden, hours, cancer, tumor;
    TextView armT, sideT, faceT, talkT, partT, suddenT, hoursT, cancerT, tumorT, informantName;
    Spinner armSpinner, sideSpinner, faceSpinner, talkSpinner, partSpinner, suddenSpinner, hoursSpinner, cancerSpinner, tumorSpinner;    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke);

        dataInterface = new MemberDataInterface(getApplicationContext());

        id = getIntent().getStringExtra("index");
        name = getIntent().getStringExtra("name");
        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        try {
            member = dataInterface.getMember(Integer.parseInt(id),curVillage,1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        TR = new Translation();
        stroke = new Stroke();
        db = new StrokeDBHelper(getApplicationContext());
        save = (Button)findViewById(R.id.save);

        hoursLayout = (LinearLayout)findViewById(R.id.hoursLayout);
        suddenLayout = (LinearLayout)findViewById(R.id.suddenLayout);

        arm = (RadioGroup)findViewById(R.id.arm);
        side = (RadioGroup)findViewById(R.id.side);
        face = (RadioGroup)findViewById(R.id.face);
        talk = (RadioGroup)findViewById(R.id.talk);
        part = (RadioGroup)findViewById(R.id.part);
        sudden = (RadioGroup)findViewById(R.id.sudden);
        hours = (RadioGroup)findViewById(R.id.hours);
        cancer = (RadioGroup)findViewById(R.id.cancer);
        tumor = (RadioGroup)findViewById(R.id.tumor);

        armT = (TextView)findViewById(R.id.armT);
        sideT = (TextView)findViewById(R.id.sideT);
        faceT = (TextView)findViewById(R.id.faceT);
        talkT = (TextView)findViewById(R.id.talkT);
        partT = (TextView)findViewById(R.id.partT);
        suddenT = (TextView)findViewById(R.id.suddenT);
        hoursT = (TextView)findViewById(R.id.hoursT);
        cancerT = (TextView)findViewById(R.id.cancerT);
        tumorT = (TextView)findViewById(R.id.tumorT);
        informantName = (TextView)findViewById(R.id.informantName);

        armSpinner = (Spinner)findViewById(R.id.armSpinner);
        sideSpinner = (Spinner)findViewById(R.id.sideSpinner);
        faceSpinner = (Spinner)findViewById(R.id.faceSpinner);
        talkSpinner = (Spinner)findViewById(R.id.talkSpinner);
        partSpinner = (Spinner)findViewById(R.id.partSpinner);
        suddenSpinner = (Spinner)findViewById(R.id.suddenSpinner);
        hoursSpinner = (Spinner)findViewById(R.id.hoursSpinner);
        cancerSpinner = (Spinner)findViewById(R.id.cancerSpinner);
        tumorSpinner = (Spinner)findViewById(R.id.tumorSpinner);

        armT.setVisibility(View.GONE);
        sideT.setVisibility(View.GONE);
        faceT.setVisibility(View.GONE);
        talkT.setVisibility(View.GONE);
        partT.setVisibility(View.GONE);
        suddenT.setVisibility(View.GONE);
        hoursT.setVisibility(View.GONE);
        cancerT.setVisibility(View.GONE);
        tumorT.setVisibility(View.GONE);

        armSpinner.setVisibility(View.GONE);
        sideSpinner.setVisibility(View.GONE);
        faceSpinner.setVisibility(View.GONE);
        talkSpinner.setVisibility(View.GONE);
        partSpinner.setVisibility(View.GONE);
        suddenSpinner.setVisibility(View.GONE);
        hoursSpinner.setVisibility(View.GONE);
        cancerSpinner.setVisibility(View.GONE);
        tumorSpinner.setVisibility(View.GONE);

        hoursLayout.setVisibility(View.GONE);
        suddenLayout.setVisibility(View.GONE);

        informantName.setText(TR.Letter_E2M(name));

        stroke.setStrokeId("2");
        stroke.setFamilyId("2");
        stroke.setInfId("2");
        stroke.setArm("-1");
        stroke.setSide("-1");
        stroke.setFace("-1");
        stroke.setTalk("-1");
        stroke.setPart("-1");
        stroke.setSudden("-1");
        stroke.setHours("-1");
        stroke.setCancer("-1");
        stroke.setTumor("-1");


        try {
            memberList = dataInterface.getFamilyList(member.getFamilyId(), 1, curVillage);
            List<String> memberNames = new ArrayList<String>();
           // memberNames.add("---");
            for (Member element : memberList
                    ) {
                    memberNames.add(TR.Letter_E2M(element.getName()));
            }
           dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, memberNames);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stroke.setFamilyId(String.valueOf(member.getFamilyId()));
        armSpinner.setAdapter(dataAdapter);
        sideSpinner.setAdapter(dataAdapter);
        faceSpinner.setAdapter(dataAdapter);
        talkSpinner.setAdapter(dataAdapter);
        partSpinner.setAdapter(dataAdapter);
        suddenSpinner.setAdapter(dataAdapter);
        hoursSpinner.setAdapter(dataAdapter);
        cancerSpinner.setAdapter(dataAdapter);
        tumorSpinner.setAdapter(dataAdapter);



        armSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                armT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sideSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sideT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        faceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                faceT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        talkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                talkT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        partSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                partT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        suddenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                suddenT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        hoursSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hoursT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        cancerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cancerT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tumorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tumorT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        arm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) != 0 &&
                        side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) != 0 &&
                        face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) != 0 &&
                        talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) != 0 &&
                        part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) != 0){
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
                else{
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                if (arm.indexOfChild(findViewById(checkedId)) == 0) {
                    armSpinner.setVisibility(View.VISIBLE);
                    armT.setVisibility(View.VISIBLE);
                } else {
                    armSpinner.setVisibility(View.GONE);
                    armT.setVisibility(View.GONE);
                }
            }
        });
        side.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) != 0 &&
                        side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) != 0 &&
                        face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) != 0 &&
                        talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) != 0 &&
                        part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) != 0){
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
                else{
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                if(side.indexOfChild(findViewById(checkedId)) == 0) {
                    sideSpinner.setVisibility(View.VISIBLE);
                    sideT.setVisibility(View.VISIBLE);
                }
                else{
                    sideSpinner.setVisibility(View.GONE);
                    sideT.setVisibility(View.GONE);
                }
            }
        });
        face.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) != 0 &&
                        side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) != 0 &&
                        face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) != 0 &&
                        talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) != 0 &&
                        part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) != 0){
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
                else{
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                if(face.indexOfChild(findViewById(checkedId)) == 0) {
                    faceSpinner.setVisibility(View.VISIBLE);
                    faceT.setVisibility(View.VISIBLE);
                }
                else{
                    faceSpinner.setVisibility(View.GONE);
                    faceT.setVisibility(View.GONE);
                }
            }
        });
        talk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(talk.indexOfChild(findViewById(checkedId)) == 0) {
                    if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) != 0 &&
                            side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) != 0 &&
                            face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) != 0 &&
                            talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) != 0 &&
                            part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) != 0){
                        suddenLayout.setVisibility(View.GONE);
                        hoursLayout.setVisibility(View.GONE);
                    }
                    else{
                        suddenLayout.setVisibility(View.VISIBLE);
                        hoursLayout.setVisibility(View.VISIBLE);
                    }
                    talkSpinner.setVisibility(View.VISIBLE);
                    talkT.setVisibility(View.VISIBLE);
                }
                else{
                    talkSpinner.setVisibility(View.GONE);
                    talkT.setVisibility(View.GONE);
                }
            }
        });
        part.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) != 0 &&
                        side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) != 0 &&
                        face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) != 0 &&
                        talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) != 0 &&
                        part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) != 0){
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
                else{
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                if(part.indexOfChild(findViewById(checkedId)) == 0) {
                    partSpinner.setVisibility(View.VISIBLE);
                    partT.setVisibility(View.VISIBLE);
                }
                else{
                    partSpinner.setVisibility(View.GONE);
                    partT.setVisibility(View.GONE);
                }
            }
        });
        sudden.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(sudden.indexOfChild(findViewById(checkedId)) == 0) {
                    suddenSpinner.setVisibility(View.VISIBLE);
                    suddenT.setVisibility(View.VISIBLE);
                }
                else{
                    suddenSpinner.setVisibility(View.GONE);
                    suddenT.setVisibility(View.GONE);
                }
            }
        });
        hours.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(hours.indexOfChild(findViewById(checkedId)) == 0) {
                    hoursSpinner.setVisibility(View.VISIBLE);
                    hoursT.setVisibility(View.VISIBLE);
                }
                else{
                    hoursSpinner.setVisibility(View.GONE);
                    hoursT.setVisibility(View.GONE);
                }
            }
        });
        cancer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (cancer.indexOfChild(findViewById(checkedId)) == 0) {
                    cancerSpinner.setVisibility(View.VISIBLE);
                    cancerT.setVisibility(View.VISIBLE);
                } else {
                    cancerSpinner.setVisibility(View.GONE);
                    cancerT.setVisibility(View.GONE);
                }
            }
        });
        tumor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (tumor.indexOfChild(findViewById(checkedId)) == 0) {
                    tumorSpinner.setVisibility(View.VISIBLE);
                    tumorT.setVisibility(View.VISIBLE);
                } else {
                    tumorSpinner.setVisibility(View.GONE);
                    tumorT.setVisibility(View.GONE);
                }
            }
        });
        

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) == 0){
                    stroke.setArm(TR.Letter_M2E(armSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setArm(String.valueOf(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId()))));
                if(side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) == 0){
                    stroke.setSide(TR.Letter_M2E(sideSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setSide(String.valueOf(side.indexOfChild(findViewById(side.getCheckedRadioButtonId()))));
                if(face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) == 0){
                    stroke.setFace(TR.Letter_M2E(faceSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setFace(String.valueOf(face.indexOfChild(findViewById(face.getCheckedRadioButtonId()))));
                if(talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) == 0){
                    stroke.setTalk(TR.Letter_M2E(talkSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setTalk(String.valueOf(talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId()))));
                if(part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) == 0){
                    stroke.setPart(TR.Letter_M2E(partSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setPart(String.valueOf(part.indexOfChild(findViewById(part.getCheckedRadioButtonId()))));
                if(sudden.indexOfChild(findViewById(sudden.getCheckedRadioButtonId())) == 0){
                    stroke.setSudden(TR.Letter_M2E(suddenSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setSudden(String.valueOf(sudden.indexOfChild(findViewById(sudden.getCheckedRadioButtonId()))));
                   if(hours.indexOfChild(findViewById(hours.getCheckedRadioButtonId())) == 0){
                    stroke.setHours(TR.Letter_M2E(hoursSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setHours(String.valueOf(hours.indexOfChild(findViewById(hours.getCheckedRadioButtonId()))));
                if(cancer.indexOfChild(findViewById(cancer.getCheckedRadioButtonId())) == 0){
                    stroke.setCancer(TR.Letter_M2E(cancerSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setCancer(String.valueOf(cancer.indexOfChild(findViewById(cancer.getCheckedRadioButtonId()))));
                if(tumor.indexOfChild(findViewById(tumor.getCheckedRadioButtonId())) == 0) {
                    stroke.setTumor(TR.Letter_M2E(tumorSpinner.getSelectedItem().toString()));
                }
                else
                    stroke.setTumor(String.valueOf(tumor.indexOfChild(findViewById(tumor.getCheckedRadioButtonId()))));

                if(stroke.getArm().equals("-1") ||
                        stroke.getSide().equals("-1") || stroke.getFace().equals("-1") || stroke.getTalk().equals("-1") ||
                        stroke.getPart().equals("-1") || (suddenLayout.getVisibility() != View.GONE && stroke.getSudden().equals("-1"))
                || (hoursLayout.getVisibility() != View.GONE && stroke.getHours().equals("-1")) || stroke.getCancer().equals("-1") || stroke.getTumor().equals("-1")){
                    Toast.makeText(getApplicationContext(), "Complete the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.e("", stroke.getArm());
                    System.out.println(stroke.getFamilyId());
                    System.out.println(stroke.getInfId());
                    System.out.println(stroke.getArm());
                    System.out.println(stroke.getSide());
                    System.out.println(stroke.getFace());
                    System.out.println(stroke.getTalk());
                    System.out.println(stroke.getPart());
                    System.out.println(stroke.getSudden());
                    System.out.println(stroke.getHours());
                    System.out.println(stroke.getCancer());
                    System.out.println(stroke.getTumor());
                    long z = db.insert(stroke);
                    System.out.println("idMain" + z);
                  //  String id = String.valueOf(z);
                    System.out.println("idMain" + id);
                   // Stroke stroke1 = db.getInfo(1);


                    finish();
                    Intent intent = new Intent(getApplicationContext(), StrokeView.class);
                    intent.putExtra("stroke_id", String.valueOf(z));
                    intent.putExtra("index", id);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stroke, menu);
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
