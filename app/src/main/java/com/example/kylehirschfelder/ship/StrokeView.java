package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StrokeView extends AppCompatActivity {
    Button save;
    LinearLayout hoursLayout, suddenLayout;
    Stroke stroke;
    StrokeDBHelper db;
    static int flag = 0;
    Translation TR;
    int id;
    MemberDataInterface dataInterface;
    Member member;
 //   Translation TR;
    ArrayAdapter<String> dataAdapter;
    List<Member> memberList;
    List<String> memberNames;

    int curVillage;
    RadioGroup arm, side, face, talk, part, sudden, hours, cancer, tumor;
    TextView armT, sideT, faceT, talkT, partT, suddenT, hoursT, cancerT, tumorT, informantName;
    Spinner armSpinner, sideSpinner, faceSpinner, talkSpinner, partSpinner, suddenSpinner, hoursSpinner, cancerSpinner, tumorSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke);
        String name = getIntent().getStringExtra("name");
        dataInterface = new MemberDataInterface(getApplicationContext());

        final String id1 = getIntent().getStringExtra("index");
      //  String name = getIntent().getStringExtra("name");
        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

        try {
            member = dataInterface.getMember(Integer.parseInt(id1),curVillage,1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TR = new Translation();
       // stroke = new Stroke();
        db = new StrokeDBHelper(getApplicationContext());
        save = (Button)findViewById(R.id.save);

        hoursLayout = (LinearLayout)findViewById(R.id.hoursLayout);
        suddenLayout = (LinearLayout)findViewById(R.id.suddenLayout);

        informantName = (TextView)findViewById(R.id.informantName);

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

        String idString = getIntent().getStringExtra("stroke_id");
        //     System.out.println("idString" + idString);
        //  String idString = getIntent().getStringExtra("stroke_id");
        id = Integer.parseInt(idString);
        stroke = db.getInfo(id);

        try {
            memberList = dataInterface.getFamilyList(Integer.parseInt(stroke.getFamilyId()), 1, curVillage);
            memberNames = new ArrayList<String>();
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
        armSpinner.setAdapter(dataAdapter);
        sideSpinner.setAdapter(dataAdapter);
        faceSpinner.setAdapter(dataAdapter);
        talkSpinner.setAdapter(dataAdapter);
        partSpinner.setAdapter(dataAdapter);
        suddenSpinner.setAdapter(dataAdapter);
        hoursSpinner.setAdapter(dataAdapter);
        cancerSpinner.setAdapter(dataAdapter);
        tumorSpinner.setAdapter(dataAdapter);

        informantName.setText(TR.Letter_E2M(name));
        
     //   stroke.setStrokeId(String.valueOf(id));

        System.out.println(stroke.getArm());

        if(stroke.getSudden().equals("-1"))
            suddenLayout.setVisibility(View.GONE);
        else if(stroke.getSudden().equals("1"))
            ((RadioButton)sudden.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)sudden.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, suddenSpinner, member, suddenT, stroke.getSudden());
        }
        if(stroke.getHours().equals("-1"))
            hoursLayout.setVisibility(View.GONE);
        else if(stroke.getHours().equals("1"))
            ((RadioButton)hours.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)hours.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, hoursSpinner, member, hoursT, stroke.getHours());
        }


        if(stroke.getArm().equals("1"))
            ((RadioButton)arm.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)arm.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, armSpinner, member, armT, stroke.getArm());
        }if(stroke.getSide().equals("1"))
            ((RadioButton)side.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)side.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, sideSpinner, member, sideT, stroke.getSide());
           // sideT.setText(member.getAge());
        }
        if(stroke.getFace().equals("1"))
            ((RadioButton)face.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)face.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, faceSpinner, member, faceT, stroke.getFace());
        }if(stroke.getTalk().equals("1"))
            ((RadioButton)talk.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)talk.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, talkSpinner, member, talkT, stroke.getTalk());
        }if(stroke.getPart().equals("1"))
            ((RadioButton)part.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)part.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, partSpinner, member, partT, stroke.getPart());
        }

        if(stroke.getCancer().equals("1"))
            ((RadioButton)cancer.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)cancer.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, cancerSpinner, member, cancerT, stroke.getCancer());
        }if(stroke.getTumor().equals("1"))
            ((RadioButton)tumor.getChildAt(1)).setChecked(true);
        else {
            ((RadioButton)tumor.getChildAt(0)).setChecked(true);
            setSpinner(memberNames, tumorSpinner, member, tumorT, stroke.getTumor());
        }



        arm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (arm.indexOfChild(findViewById(checkedId)) == 0) {
                    armSpinner.setVisibility(View.VISIBLE);
                    armT.setVisibility(View.VISIBLE);
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                } else {
                    armSpinner.setVisibility(View.GONE);
                    armT.setVisibility(View.GONE);
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
            }
        });
        side.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(side.indexOfChild(findViewById(checkedId)) == 0) {
                    sideSpinner.setVisibility(View.VISIBLE);
                    sideT.setVisibility(View.VISIBLE);
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                else{
                    sideSpinner.setVisibility(View.GONE);
                    sideT.setVisibility(View.GONE);
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
            }
        });
        face.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(face.indexOfChild(findViewById(checkedId)) == 0) {
                    faceSpinner.setVisibility(View.VISIBLE);
                    faceT.setVisibility(View.VISIBLE);
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                else{
                    faceSpinner.setVisibility(View.GONE);
                    faceT.setVisibility(View.GONE);
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
            }
        });
        talk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(talk.indexOfChild(findViewById(checkedId)) == 0) {
                    talkSpinner.setVisibility(View.VISIBLE);
                    talkT.setVisibility(View.VISIBLE);
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                else{
                    talkSpinner.setVisibility(View.GONE);
                    talkT.setVisibility(View.GONE);
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
                }
            }
        });
        part.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(part.indexOfChild(findViewById(checkedId)) == 0) {
                    partSpinner.setVisibility(View.VISIBLE);
                    partT.setVisibility(View.VISIBLE);
                    suddenLayout.setVisibility(View.VISIBLE);
                    hoursLayout.setVisibility(View.VISIBLE);
                }
                else{
                    partSpinner.setVisibility(View.GONE);
                    partT.setVisibility(View.GONE);
                    suddenLayout.setVisibility(View.GONE);
                    hoursLayout.setVisibility(View.GONE);
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
                if (arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId())) == 0) {
                    stroke.setArm(TR.Letter_M2E(armSpinner.getSelectedItem().toString()));
                } else
                    stroke.setArm(String.valueOf(arm.indexOfChild(findViewById(arm.getCheckedRadioButtonId()))));
                if (side.indexOfChild(findViewById(side.getCheckedRadioButtonId())) == 0) {
                    stroke.setSide(TR.Letter_M2E(sideSpinner.getSelectedItem().toString()));
                } else
                    stroke.setSide(String.valueOf(side.indexOfChild(findViewById(side.getCheckedRadioButtonId()))));
                if (face.indexOfChild(findViewById(face.getCheckedRadioButtonId())) == 0) {
                    stroke.setFace(TR.Letter_M2E(faceSpinner.getSelectedItem().toString()));
                } else
                    stroke.setFace(String.valueOf(face.indexOfChild(findViewById(face.getCheckedRadioButtonId()))));
                if (talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId())) == 0) {
                    stroke.setTalk(TR.Letter_M2E(talkSpinner.getSelectedItem().toString()));
                } else
                    stroke.setTalk(String.valueOf(talk.indexOfChild(findViewById(talk.getCheckedRadioButtonId()))));
                if (part.indexOfChild(findViewById(part.getCheckedRadioButtonId())) == 0) {
                    stroke.setPart(TR.Letter_M2E(partSpinner.getSelectedItem().toString()));
                } else
                    stroke.setPart(String.valueOf(part.indexOfChild(findViewById(part.getCheckedRadioButtonId()))));
                if (sudden.indexOfChild(findViewById(sudden.getCheckedRadioButtonId())) == 0) {
                    stroke.setSudden(TR.Letter_M2E(suddenSpinner.getSelectedItem().toString()));
                } else
                    stroke.setSudden(String.valueOf(sudden.indexOfChild(findViewById(sudden.getCheckedRadioButtonId()))));
                if (hours.indexOfChild(findViewById(hours.getCheckedRadioButtonId())) == 0) {
                    stroke.setHours(TR.Letter_M2E(hoursSpinner.getSelectedItem().toString()));
                } else
                    stroke.setHours(String.valueOf(hours.indexOfChild(findViewById(hours.getCheckedRadioButtonId()))));
                if (cancer.indexOfChild(findViewById(cancer.getCheckedRadioButtonId())) == 0) {
                    stroke.setCancer(TR.Letter_M2E(cancerSpinner.getSelectedItem().toString()));
                } else
                    stroke.setCancer(String.valueOf(cancer.indexOfChild(findViewById(cancer.getCheckedRadioButtonId()))));
                if (tumor.indexOfChild(findViewById(tumor.getCheckedRadioButtonId())) == 0) {
                    stroke.setTumor(TR.Letter_M2E(tumorSpinner.getSelectedItem().toString()));
                } else
                    stroke.setTumor(String.valueOf(tumor.indexOfChild(findViewById(tumor.getCheckedRadioButtonId()))));

                db.update(stroke);
  //              finish();
                Intent intent;
                if(flag != 1) {
                    intent = new Intent(getApplicationContext(), StrokeView.class);
                    intent.putExtra("index", id1);
                    flag++;
                    startActivity(intent);
                }

                finish();

            }
        });

    }

    private void setSpinner(List<String> memberNames, Spinner spinner, Member member, TextView textView, String string) {
        int index = 0;
        for(int i = 0; i < memberNames.size(); i++) {
            if (TR.Letter_E2M(string).equals(memberNames.get(i))) {
                Log.println(Log.ASSERT,"index",String.valueOf(index));
                index = i;
            }
        }
        spinner.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
            spinner.setSelection(index);
       // sideT.setText(TR.Number_E2M(String.valueOf(memberList.get(i).getAge())));
            textView.setText(TR.Number_E2M(String.valueOf(memberList.get(index).getAge())));
    }

}
