package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormFragment extends Fragment {

    Button censusButton, memberButton, birthButton, deathButton, familyButton,pnm, deathChild, stroke, medicineInventory;

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_forms, container, false);

      //  censusButton = (Button) myView.findViewById(R.id.censusBtn);
       // memberButton = (Button) myView.findViewById(R.id.memberBtn);
        birthButton = (Button) myView.findViewById(R.id.birthBtn);
       // deathButton = (Button) myView.findViewById(R.id.deathBtn);
        familyButton = (Button) myView.findViewById(R.id.familyBtn);
        deathButton = (Button) myView.findViewById(R.id.deathBtn);
        pnm = (Button) myView.findViewById(R.id.pnm);
        deathChild = (Button)myView.findViewById(R.id.deathChild);
        stroke = (Button) myView.findViewById(R.id.stroke);
        medicineInventory = (Button)myView.findViewById(R.id.medicineInventory);

        medicineInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MedicineInventoryInterface.class);
           //     startActivity(intent);
              //  Intent intent = new Intent(getActivity().getApplicationContext(), Cod1_I.class);
                startActivity(intent);
            }
        });



        pnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PNMDialog dialog = new PNMDialog();
                FragmentManager manager = getActivity().getFragmentManager();
                dialog.show(manager, "PNMFrag");
            }
        });

        stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
                intent.putExtra("form","4");
                intent.putExtra("resident", "-10");
                startActivity(intent);
            }
        });

        deathChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeathChildDialog dialog = new DeathChildDialog();
                FragmentManager manager = getActivity().getFragmentManager();
                dialog.show(manager, "deathFrag");
            }
        });

        deathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //  Intent intent = new Intent(getActivity().getApplicationContext(),CodFifteenForm.class);
               // startActivity(intent);


                // ***** CODE THAT IS SUPPOSED TO BE WORKING IN THE FINAL VERSION BELOW ***** \\

                DeathAdultDialog dialog = new DeathAdultDialog();
                FragmentManager manager = getActivity().getFragmentManager();
                dialog.show(manager,"deathFrag");

                // ***** CODE THAT IS SUPPOSED TO BE WORKING IN THE FINAL VERSION ABOVE ***** \\
/*

                BirthInfoDBHelper dbHelper = new BirthInfoDBHelper(getActivity().getApplicationContext());
                List<Birth> birthList = dbHelper.getAll();
                for (Birth element: birthList
                        ) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.42:8888/birth/add");
                    try {
                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(22);
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberId())));
                        nameValuePairs.add(new BasicNameValuePair("village_id",String.valueOf(element.getVillageId())));
                        nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseID())));
                        nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyID())));
                        nameValuePairs.add(new BasicNameValuePair("mother_name",String.valueOf(element.getMotherName())));
                        nameValuePairs.add(new BasicNameValuePair("dob", String.valueOf(element.getBirthDate())));
                        nameValuePairs.add(new BasicNameValuePair("mother_vill_name", String.valueOf(element.getMotherVillage())));
                        nameValuePairs.add(new BasicNameValuePair("mother_vill_id", String.valueOf(element.getMotherVillageID())));
                        nameValuePairs.add(new BasicNameValuePair("vill_of_birth",String.valueOf(element.getVillageOfBirth())));
                        nameValuePairs.add(new BasicNameValuePair("vill_of_birth_id", String.valueOf(element.getVillageOfBirthID())));
                        nameValuePairs.add(new BasicNameValuePair("vill_of_birth_place",String.valueOf(element.getVillageOfBirthPlace())));
                        nameValuePairs.add(new BasicNameValuePair("delivery_name", String.valueOf(element.getDeliveryName())));
                        nameValuePairs.add(new BasicNameValuePair("delivery_method", String.valueOf(element.getDeliveryMethod())));
                        nameValuePairs.add(new BasicNameValuePair("gender", String.valueOf(element.getChildGender())));
                        nameValuePairs.add(new BasicNameValuePair("preg_time", String.valueOf(element.getPregnancyTime())));
                        nameValuePairs.add(new BasicNameValuePair("fad", String.valueOf(element.getFadPresence())));
                        nameValuePairs.add(new BasicNameValuePair("messenger_name", String.valueOf(element.getHealthMessenger())));
                        nameValuePairs.add(new BasicNameValuePair("messenger_id", String.valueOf(element.getHealthMessengerId())));
                        nameValuePairs.add(new BasicNameValuePair("messenger_date", String.valueOf(element.getHealthMessengerDate())));
                        nameValuePairs.add(new BasicNameValuePair("guide_name", String.valueOf(element.getGuideName())));
                        nameValuePairs.add(new BasicNameValuePair("guide_id", String.valueOf(element.getGuideId())));
                        nameValuePairs.add(new BasicNameValuePair("guide_date", String.valueOf(element.getGuideTestDate())));

                        Log.println(Log.ASSERT, "member_id", String.valueOf(element.getMemberId()));
                        Log.println(Log.ASSERT,"village_id",String.valueOf(element.getVillageId()));
                        Log.println(Log.ASSERT,"house_id", String.valueOf(element.getHouseID()));
                        Log.println(Log.ASSERT,"family_id", String.valueOf(element.getFamilyID()));
                        Log.println(Log.ASSERT,"mother_name",String.valueOf(element.getMotherName()));
                        Log.println(Log.ASSERT,"dob", String.valueOf(element.getBirthDate()));
                        Log.println(Log.ASSERT,"mother_vill_name", String.valueOf(element.getMotherVillage()));
                        Log.println(Log.ASSERT,"mother_vill_id", String.valueOf(element.getMotherVillageID()));
                        Log.println(Log.ASSERT,"vill_of_birth",String.valueOf(element.getVillageOfBirth()));
                        Log.println(Log.ASSERT,"vill_of_birth_id", String.valueOf(element.getVillageOfBirthID()));
                        Log.println(Log.ASSERT,"vill_of_birth_place",String.valueOf(element.getVillageOfBirthPlace()));
                        Log.println(Log.ASSERT,"delivery_name", String.valueOf(element.getDeliveryName()));
                        Log.println(Log.ASSERT,"delivery_method", String.valueOf(element.getDeliveryMethod()));
                        Log.println(Log.ASSERT,"gender", String.valueOf(element.getChildGender()));
                        Log.println(Log.ASSERT,"preg_time", String.valueOf(element.getPregnancyTime()));
                        Log.println(Log.ASSERT,"fad", String.valueOf(element.getFadPresence()));
                        Log.println(Log.ASSERT,"messenger_name", String.valueOf(element.getHealthMessenger()));
                        Log.println(Log.ASSERT,"messenger_id", String.valueOf(element.getHealthMessengerId()));
                        Log.println(Log.ASSERT,"messenger_date", String.valueOf(element.getHealthMessengerDate()));
                        Log.println(Log.ASSERT,"guide_name", String.valueOf(element.getGuideName()));
                        Log.println(Log.ASSERT,"guide_id", String.valueOf(element.getGuideId()));
                        Log.println(Log.ASSERT,"guide_date", String.valueOf(element.getGuideTestDate()));

                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        httpclient.execute(httppost);

                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                    }
                }*/

                /*
                MemberDataInterface memberDataInterface = new MemberDataInterface(getActivity().getApplicationContext());
                List<Member> memList = memberDataInterface.getAllMembers(1);
                for (Member element: memList
                        ) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.42:8888/member/submit");
                    try {
                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(14);
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberId())));
                        nameValuePairs.add(new BasicNameValuePair("village_id",String.valueOf(element.getVillageId())));
                        Log.println(Log.ASSERT,"sendvillageid",String.valueOf(element.getVillageId()));
                        nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseId())));
                        nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyId())));
                        nameValuePairs.add(new BasicNameValuePair("family_head_bool",String.valueOf(element.getFamilyHeadId())));
                        nameValuePairs.add(new BasicNameValuePair("name", String.valueOf(element.getName())));
                        nameValuePairs.add(new BasicNameValuePair("age", String.valueOf(element.getAge())));
                        nameValuePairs.add(new BasicNameValuePair("sex", String.valueOf(element.getSex())));
                        nameValuePairs.add(new BasicNameValuePair("m_status",String.valueOf(element.getMarriageStatus())));
                        nameValuePairs.add(new BasicNameValuePair("family_plan", String.valueOf(element.getFamilyPlan())));
                        nameValuePairs.add(new BasicNameValuePair("education",String.valueOf(element.getEducation())));
                        nameValuePairs.add(new BasicNameValuePair("literacy", String.valueOf(element.getLiteracy())));
                        nameValuePairs.add(new BasicNameValuePair("wedding_left", String.valueOf(element.getWeddingDept())));
                        nameValuePairs.add(new BasicNameValuePair("wedding_came", String.valueOf(element.getWeddingArr())));
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        httpclient.execute(httppost);

                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                    }
                }*/
            }
        });
       /* censusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CensusForm.class);
                startActivity(intent);
            }
        });*/

      /*  memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BirthInfoDBHelper dbHelper = new BirthInfoDBHelper(getActivity().getApplicationContext());
                ResidentDialog dialog = new ResidentDialog();
               FragmentManager manager = getActivity().getFragmentManager();
                dialog.show(manager,"frag");
                //dbHelper.deleteAll();
                //Intent intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
              //  Intent intent = new Intent(getActivity().getApplicationContext(), BirthInfoForm.class);
                //startActivity(intent);
              //  Intent intent = new Intent(getActivity().getApplicationContext(), PNM_Info.class);
               // startActivity(intent);
            /*   MemberDataInterface memberDataInterface = new MemberDataInterface(getActivity().getApplicationContext());
                List<Member> memList = memberDataInterface.getAllMembers(1);
                for (Member element: memList
                     ) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.42:8888/member/submit");
                    try {
                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(14);
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberId())));
                        nameValuePairs.add(new BasicNameValuePair("village_id",String.valueOf(element.getVillageId())));
                        Log.println(Log.ASSERT,"sendvillageid",String.valueOf(element.getVillageId()));
                        nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseId())));
                        nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyId())));
                        nameValuePairs.add(new BasicNameValuePair("family_head_bool",String.valueOf(element.getFamilyHeadId())));
                        nameValuePairs.add(new BasicNameValuePair("name", String.valueOf(element.getName())));
                        nameValuePairs.add(new BasicNameValuePair("age", String.valueOf(element.getAge())));
                        nameValuePairs.add(new BasicNameValuePair("sex", String.valueOf(element.getSex())));
                        nameValuePairs.add(new BasicNameValuePair("m_status",String.valueOf(element.getMarriageStatus())));
                        nameValuePairs.add(new BasicNameValuePair("family_plan", String.valueOf(element.getFamilyPlan())));
                        nameValuePairs.add(new BasicNameValuePair("education",String.valueOf(element.getEducation())));
                        nameValuePairs.add(new BasicNameValuePair("literacy", String.valueOf(element.getLiteracy())));
                        nameValuePairs.add(new BasicNameValuePair("wedding_left", String.valueOf(element.getWeddingDept())));
                        nameValuePairs.add(new BasicNameValuePair("wedding_came", String.valueOf(element.getWeddingArr())));
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        httpclient.execute(httppost);

                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                    }
                }
*/

            }
        });
/*
        deathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/
        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CensusFormPortal.class);
                intent.putExtra("flagFamily","0");
                intent.putExtra("flagCensus","0");
                startActivity(intent);
            }
        });


        return myView;
    }
}


