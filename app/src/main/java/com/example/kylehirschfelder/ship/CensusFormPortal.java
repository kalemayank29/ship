package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class CensusFormPortal extends AppCompatActivity{
    CheckBox checkBoxHead, checkBoxMember, checkBoxHouse;
    Button familyHead, familyMember, familyHouse, save, nope;
    ArrayAdapter<Member> memberAdapter;
    List<Member> memberList;
    CF_DatabaseOperations censusOperations;
    FamilyHeadDataInterface headDataInterface;
    MemberDataInterface memberInterface;
    String flagFamily, flagCensus;
    Census object;
    ListView lv;
    int curVillage;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_census_form_portal);

    flagCensus = getIntent().getStringExtra("flagCensus");
    flagFamily = getIntent().getStringExtra("flagFamily");

    curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();

    checkBoxHead = (CheckBox) findViewById(R.id.checkBoxHead);
    checkBoxMember = (CheckBox) findViewById(R.id.checkBoxMember);
    checkBoxHouse = (CheckBox) findViewById(R.id.checkBoxHouse);


    familyHead = (Button) findViewById(R.id.familyHead);
    familyMember = (Button) findViewById(R.id.familyMember);
    familyHouse = (Button) findViewById(R.id.house);
    save = (Button) findViewById(R.id.save);
    nope = (Button) findViewById(R.id.nope);

    lv = (ListView) this.findViewById(R.id.portalList);
    memberInterface = new MemberDataInterface(this.getApplicationContext());
    censusOperations = new CF_DatabaseOperations(getApplicationContext());
    headDataInterface = new FamilyHeadDataInterface(getApplicationContext());
    memberList = memberInterface.getAllMembers(0);

    if(memberList.size()>0){
        flagFamily = "1";
        if(memberList.size()>1){
            flagFamily = "2";
        }

    }

    if(flagCensus.equals("1")) checkBoxHouse.setChecked(true);
    if(flagFamily.equals("1") || flagFamily.equals("2")) checkBoxHead.setChecked(true);
    if(flagFamily.equals("2")) checkBoxMember.setChecked(true);

    populateList();

    familyHead.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            List<Member> checkHead = memberInterface.getAllFamilyHeads(0,curVillage);
            if(flagFamily.equals("0") && flagCensus.equals("0") && (checkHead.size() < 1)){
                finish();
                Intent intent = new Intent(CensusFormPortal.this, AddPrimaryFamily.class);
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(),"कुटुंब प्रमुखाची नोंदणी आधीच केली आहे ", Toast.LENGTH_SHORT).show();

        }
    });

    familyMember.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!flagFamily.equals("0"))
            {
                finish();
                Intent intent = new Intent(CensusFormPortal.this, MemberForm.class);
                intent.putExtra("flagFamily",flagFamily);
                intent.putExtra("flagCensus",flagCensus);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"आधी कुटुंब प्रमुख नोंदणी करा ", Toast.LENGTH_SHORT).show();
            }
        }
    });


    familyHouse.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if( !flagFamily.equals("0") && flagCensus.equals("0")) {
                finish();
                Intent intent = new Intent(CensusFormPortal.this, CensusForm.class);
                intent.putExtra("flagFamily",flagFamily);
                intent.putExtra("flagCensus",flagCensus);
                startActivity(intent);
            }
            else if(flagCensus.equals("1")){
                finish();
                object = censusOperations.getRecent(0);
                Intent intent = new Intent(CensusFormPortal.this, CF_ViewForm.class);
                intent.putExtra("flagFamily", flagFamily);
                intent.putExtra("flagCensus", "1");
                intent.putExtra("index",object.getHouseID());
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"घर नोंदणी करायच्या आधी कुटुंब प्रमुख नोंदणी करावी ", Toast.LENGTH_SHORT).show();
            }

        }
    });

    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!flagFamily.equals("0") && flagCensus.equals("1")){


                Census tempHouse = censusOperations.getRecent(0);
                //Log.println(Log.ASSERT,"CENSUS RELIGION",tempHouse.getReligion());
                censusOperations.insert(tempHouse, 1);
                //tempHouse = censusOperations.getRecent(1);

               /* for (Member element : memberList
                        ) {
                    element.setHouseId(Integer.parseInt(tempHouse.getHouseID()));
                    //    Log.println(Log.ASSERT, "MemberHouseid", String.valueOf(element.getHouseId()));
                }*/

                //List<Member> head = memberInterface.getAllFamilyHeads(0,curVillage);
                //Member tempHead = head.get(0);
                //tempHead.setHouseId(Integer.parseInt(tempHouse.getHouseID()));

                /*try {
                    //memberInterface.createVillMember(tempHead, 1);
                    headDataInterface.createMember(tempHead);
                    tempHead = headDataInterface.getRecent();
                    //tempHead.setFamilyId(tempHead.getMemberId());
                    //memberInterface.update(tempHead, tempHead.getMemberId(), 1);
                    //Log.println(Log.ASSERT,"new head id", String.valueOf(tempHead.getMemberId()));
                    for (Member element : memberList
                            ) {
                        element.setFamilyId(tempHead.getMemberId());

                    }*/

                    for (int i = 0; i < memberList.size(); i++) {

                        memberList.get(i).setVillageId(curVillage);

                        String flag = null;

                        try {
                            flag = memberInterface.createMember(memberList.get(i), 1);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        Log.println(Log.ASSERT,"member_id", String.valueOf(memberList.get(i).getMemberId()));
                        Log.println(Log.ASSERT,"family_id", String.valueOf(memberList.get(i).getFamilyId()));
                        Log.println(Log.ASSERT,"village id", String.valueOf(memberList.get(i).getVillageId()));
                        Log.println(Log.ASSERT,"house id", String.valueOf(memberList.get(i).getHouseId()));
                       // Log.println(Log.ASSERT,"falg", flag);

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        String member = preferences.getString("member","default");

                        member += flag;
                        Log.println(Log.ASSERT,"falg", member);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("member", member);
                        editor.commit();

                    }

                    //   head = memberInterface.getFamilyList(tempHead.getFamilyId(),1);
               /*     for (Member temp: head
                         ) {
                        Log.println(Log.ASSERT,"Member Id", String.valueOf(temp.getMemberId()));
                        Log.println(Log.ASSERT,"House Id", String.valueOf(temp.getHouseId()));
                        Log.println(Log.ASSERT,"Family Id", String.valueOf(temp.getFamilyId()));
                        Log.println(Log.ASSERT,"Name", String.valueOf(temp.getName()));
                        Log.println(Log.ASSERT,"Is family Head", String.valueOf(temp.getFamilyHeadId()));

                    }*/

                    memberInterface.deleteAllTables();
                    censusOperations.deleteAllCensus();


                finish();
                Intent intent = new Intent(CensusFormPortal.this, MainActivity.class);
                startActivity(intent);

            }
            else
                Toast.makeText(getBaseContext(), "सर्व फॉर्म भरून सेव करावे ", Toast.LENGTH_SHORT).show();
        }
    });

    nope.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            displayNopeAlert();

        }
    });
}

    public void displayNopeAlert() {
        new AlertDialog.Builder(this)
                .setTitle("खरच सर्व भरलेली माहिती नकोय?")
                .setMessage("ही माहिती राहणार नाही ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        memberInterface.deleteAllTables();
                        censusOperations.deleteAllCensus();

                        finish();
                        Intent intent = new Intent(CensusFormPortal.this,MainActivity.class);
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

    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList, this.getApplicationContext());
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed(){
        displayBackAlert();
    }

    public void displayBackAlert() {
        Translation translation = new Translation();
        new AlertDialog.Builder(this)
                .setTitle("मागे जाऊ शकत नाही ")
                .setMessage("\"सेव\" किवा \"नको\"  बटन दाबावे ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_primary_family, menu);
        return true;
        }

    public void checkBoxUnCheck(View view){
        String tag = view.getTag().toString();
        switch (tag){
        case "checkBoxHead":
        if(!flagFamily.equals("0")) checkBoxHead.setChecked(true);
            else
                checkBoxHead.setChecked(false);
        break;

        case "checkBoxMember":
        if(flagFamily.equals("2")) checkBoxMember.setChecked(true);
            else
                checkBoxMember.setChecked(false);
        break;
        case "checkBoxHouse":
            if(flagCensus.equals("1")) checkBoxHouse.setChecked(true);
            else
                checkBoxHouse.setChecked(false);
        break;
        }
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

    private class memberListAdapter extends ArrayAdapter<Member> {
        Context context;
        List<Member> memberList;
        public memberListAdapter(List<Member> memberList, Context context) {
            super(context, R.layout.family_head_list_item, memberList);
            this.context = context;
            this.memberList = memberList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = inflater.inflate(R.layout.family_head_list_item, parent, false);
            }

            Member currentHead = memberList.get(position);

            //TextView id = (TextView) view.findViewById(R.id.textId);
            //id.setText(String.valueOf(currentHead.getMemberId()));

            Translation object = new Translation();
            TextView head = (TextView) view.findViewById(R.id.textHead);
            head.setText(object.Letter_E2M(currentHead.getName()));

            return view;
        }
    }
}
