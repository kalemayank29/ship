package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TransferFragment extends Fragment {

    Button memberButton, birthButton, deathButton, pushButton;
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_transfer, container,false);

        Context context = getActivity().getApplicationContext();
       // LoginDialog loginDialog = new LoginDialog();
        //AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        //loginDialog.displayalert(alertDialog, context);



        birthButton = (Button)myView.findViewById(R.id.birthBtn);
        memberButton = (Button) myView.findViewById(R.id.memberBtn);
        deathButton = (Button) myView.findViewById(R.id.deathBtn);
        pushButton = (Button) myView.findViewById(R.id.push);

        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.println(Log.ASSERT,"in","func");
                deathAdultPush();
                deathChildPush();
                birthPush();
            }
        });

        deathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DeathSupervisor.class);
                startActivity(intent);
            }
        });
        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BirthSupervisor.class);
                startActivity(intent);
            }
        });
        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Intent intent = new Intent(getActivity(), CensusFormPortal.class);
              //  startActivity(intent);



                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);



                JSONParser jsonParser = new JSONParser();
             try {
                    JSONArray json = jsonParser.getJSONFromUrl("http://192.168.1.155/member/all");
                    Log.println(Log.ASSERT,"json size",json.toString());
                    MemberDataInterface memberInterface = new MemberDataInterface(getActivity().getApplicationContext());
                    FamilyHeadDataInterface headInterface = new FamilyHeadDataInterface(getActivity().getApplicationContext());

                    for (int i = 0; i < json.length(); i++) {
                    //for (int i = 0; i < 500; i++) {
                        try {
                            JSONObject c = json.getJSONObject(i);

                            Member element = new Member();
                            //element.setMemberId(Integer.parseInt(c.getString("id")));
                            //element.setFamilyId(Integer.parseInt(c.getString("family_id")));
                            element.setFamilyHeadId(Integer.parseInt(c.getString("family_head_id")));
                            element.setVillageId(Integer.parseInt(c.getString("village_id")));
                            element.setName(c.getString("name"));
                            element.setAge(Integer.parseInt(c.getString("age")));
                            element.setSex(Integer.parseInt(c.getString("sex")));
                            element.setHouseId(Integer.parseInt(c.getString("house_id")));
                            element.setChildId(Integer.parseInt(c.getString("child_id")));
                            element.setChildDate(c.getString("birth_date"));
                            element.setMarriageStatus(c.getString("m_status"));
                            element.setFamilyPlan(c.getString("family_plan"));
                            element.setEducation("education");
                            element.setLiteracy(c.getString("literacy"));
                            element.setWeddingArr(c.getString("marriage_came"));
                            element.setWeddingDept(c.getString("marriage_left"));

                           // familyId = element.getFamilyId();
                            //  if(element.getFamilyHeadId() == 0){
                              //  Member head = memberInterface.getLastHead(element.getVillageId());
                            //    familyId = head.getMemberId();
                          //}

                          //  element.setFamilyId(familyId);
                            Log.println(Log.ASSERT,"Fam id", String.valueOf(element.getFamilyId()));
                            Log.println(Log.ASSERT,"Name", element.getName());
                            Log.println(Log.ASSERT,"Gender", String.valueOf(element.getSex()));
                            memberInterface.createMember(element,1);
                        }
                        catch (JSONException e)
                        { e.printStackTrace(); } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
/*
                try {
                    JSONArray json = jsonParser.getJSONFromUrl("http://192.168.1.33:8888/census/all");
                    Log.println(Log.ASSERT,"json size",json.toString());
                    CF_DatabaseOperations dbOperations = new CF_DatabaseOperations(getActivity().getApplicationContext());


                    //for (int i = 0; i < json.length(); i++) {
                        for (int i = 0; i < 500; i++) {
                        try {
                            JSONObject c = json.getJSONObject(i);

                            Census element = new Census();
                            //element.setMemberId(Integer.parseInt(c.getString("id")));
                            element.setCaste(c.getString("caste"));
                            element.setReligion(c.getString("religion_stored"));
                            element.setpBusiness(c.getString("p_business"));
                            element.setaBusiness1(c.getString("a_business_1"));
                            element.setaBusiness2("a_business_2");
                            element.setaBusiness3("a_business_3");
                            element.setDrylandA("farm_dry_a");
                            element.setWetlandA("farm_wet_a");

                           String wallString = Parse.parseString(5, c.getString("wall_stored"));
                          String  roofString = Parse.parseString(6, c.getString("roof_stored"));
                          String  cookingString = Parse.parseString(5, c.getString("cook"));
                           String waterString = Parse.parseString(7, c.getString("water_stored"));
                            String thingString = Parse.parseString(15,c.getString("thing"));
                           String animalString = Parse.parseString(8, c.getString("animal"));

                            element.setWall(wallString);
                            element.setRoof(roofString);

                            element.setElectricity(c.getString("electricity"));
                            element.setHouseOwner("house_owner");
                            element.setToilet(c.getString("toilet"));
                            element.setToiletUse(c.getString("toilet_use"));

                            element.setCooking(cookingString);

                            element.setKitchen(c.getString("kitchen"));

                            element.setWater(waterString);
                            element.setThing(thingString);
                            element.setAnimal(animalString);

                            element.setDate(c.getString("date"));
                            element.setOldHouseID(c.getString("old_house_id"));

                                Log.println(Log.ASSERT,"caste",element.getCaste());
                            dbOperations.insert(element, 1);
                        }
                        catch (JSONException e)
                        { e.printStackTrace(); }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

        });
        //Intent intent = new Intent(getActivity(), TransferMemberListView.class);
        //startActivity(intent);

        return myView;
    }

    public void birthPush() {
        BirthInfoDBHelper dbHelper = new BirthInfoDBHelper(getActivity().getApplicationContext());
        List<Birth> birthList = dbHelper.getAll();
        for (Birth element : birthList
                ) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.1.33:8888/birth/add");
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(22);
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberId())));
                nameValuePairs.add(new BasicNameValuePair("village_id", String.valueOf(element.getVillageId())));
                nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseID())));
                nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyID())));
                nameValuePairs.add(new BasicNameValuePair("mother_name", String.valueOf(element.getMotherName())));
                nameValuePairs.add(new BasicNameValuePair("dob", String.valueOf(element.getBirthDate())));
                nameValuePairs.add(new BasicNameValuePair("mother_vill_name", String.valueOf(element.getMotherVillage())));
                nameValuePairs.add(new BasicNameValuePair("mother_vill_id", String.valueOf(element.getMotherVillageID())));
                nameValuePairs.add(new BasicNameValuePair("vill_of_birth", String.valueOf(element.getVillageOfBirth())));
                nameValuePairs.add(new BasicNameValuePair("vill_of_birth_id", String.valueOf(element.getVillageOfBirthID())));
                nameValuePairs.add(new BasicNameValuePair("vill_of_birth_place", String.valueOf(element.getVillageOfBirthPlace())));
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
                Log.println(Log.ASSERT, "village_id", String.valueOf(element.getVillageId()));
                Log.println(Log.ASSERT, "house_id", String.valueOf(element.getHouseID()));
                Log.println(Log.ASSERT, "family_id", String.valueOf(element.getFamilyID()));
                Log.println(Log.ASSERT, "mother_name", String.valueOf(element.getMotherName()));
                Log.println(Log.ASSERT, "dob", String.valueOf(element.getBirthDate()));
                Log.println(Log.ASSERT, "mother_vill_name", String.valueOf(element.getMotherVillage()));
                Log.println(Log.ASSERT, "mother_vill_id", String.valueOf(element.getMotherVillageID()));
                Log.println(Log.ASSERT, "vill_of_birth", String.valueOf(element.getVillageOfBirth()));
                Log.println(Log.ASSERT, "vill_of_birth_id", String.valueOf(element.getVillageOfBirthID()));
                Log.println(Log.ASSERT, "vill_of_birth_place", String.valueOf(element.getVillageOfBirthPlace()));
                Log.println(Log.ASSERT, "delivery_name", String.valueOf(element.getDeliveryName()));
                Log.println(Log.ASSERT, "delivery_method", String.valueOf(element.getDeliveryMethod()));
                Log.println(Log.ASSERT, "gender", String.valueOf(element.getChildGender()));
                Log.println(Log.ASSERT, "preg_time", String.valueOf(element.getPregnancyTime()));
                Log.println(Log.ASSERT, "fad", String.valueOf(element.getFadPresence()));
                Log.println(Log.ASSERT, "messenger_name", String.valueOf(element.getHealthMessenger()));
                Log.println(Log.ASSERT, "messenger_id", String.valueOf(element.getHealthMessengerId()));
                Log.println(Log.ASSERT, "messenger_date", String.valueOf(element.getHealthMessengerDate()));
                Log.println(Log.ASSERT, "guide_name", String.valueOf(element.getGuideName()));
                Log.println(Log.ASSERT, "guide_id", String.valueOf(element.getGuideId()));
                Log.println(Log.ASSERT, "guide_date", String.valueOf(element.getGuideTestDate()));

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
        }
    }

    public void deathAdultPush() {
        DeathAdultDataInterface dataInterface = new DeathAdultDataInterface(getActivity().getApplicationContext());
        List<DeathAdult> deathList = dataInterface.getAll();
        for (DeathAdult element : deathList
                ) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.1.10:80/deathAdult/add");
            try {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(18);
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(element.getId())));
                nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyID())));
                nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseID())));
                nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberID())));
                nameValuePairs.add(new BasicNameValuePair("village_id", String.valueOf(element.getVillageId())));
                nameValuePairs.add(new BasicNameValuePair("birth_date", String.valueOf(element.getBirthDate())));
                nameValuePairs.add(new BasicNameValuePair("death_date", String.valueOf(element.getDeathDate())));
                nameValuePairs.add(new BasicNameValuePair("age", String.valueOf(element.getAge())));
                nameValuePairs.add(new BasicNameValuePair("village_of_stay", String.valueOf(element.getVillageStay())));
                nameValuePairs.add(new BasicNameValuePair("village_of_stay_id", String.valueOf(element.getVillageStayId())));
                nameValuePairs.add(new BasicNameValuePair("village_of_death", String.valueOf(element.getVillageOfDeath())));
                nameValuePairs.add(new BasicNameValuePair("village_of_death_id", String.valueOf(element.getVillageOfDeathID())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger", String.valueOf(element.getHealthMessenger())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger_id", String.valueOf(element.getHealthMessengerId())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger_date", String.valueOf(element.getHealthMessengerDate())));
                nameValuePairs.add(new BasicNameValuePair("guide_id", String.valueOf(element.getGuideId())));
                nameValuePairs.add(new BasicNameValuePair("guide_name", String.valueOf(element.getGuideName())));
                nameValuePairs.add(new BasicNameValuePair("guide_test_date", String.valueOf(element.getGuideTestDate())));

                Log.println(Log.ASSERT, "member_id", String.valueOf(element.getId()));
 /*               Log.println(Log.ASSERT, "village_id", String.valueOf(element.getVillageId()));
                Log.println(Log.ASSERT, "house_id", String.valueOf(element.getHouseID()));
                Log.println(Log.ASSERT, "family_id", String.valueOf(element.getFamilyID()));
                Log.println(Log.ASSERT, "mother_name", String.valueOf(element.getMotherName()));
                Log.println(Log.ASSERT, "dob", String.valueOf(element.getBirthDate()));
                Log.println(Log.ASSERT, "mother_vill_name", String.valueOf(element.getMotherVillage()));
                Log.println(Log.ASSERT, "mother_vill_id", String.valueOf(element.getMotherVillageID()));
                Log.println(Log.ASSERT, "vill_of_birth", String.valueOf(element.getVillageOfBirth()));
                Log.println(Log.ASSERT, "vill_of_birth_id", String.valueOf(element.getVillageOfBirthID()));
                Log.println(Log.ASSERT, "vill_of_birth_place", String.valueOf(element.getVillageOfBirthPlace()));
                Log.println(Log.ASSERT, "delivery_name", String.valueOf(element.getDeliveryName()));
                Log.println(Log.ASSERT, "delivery_method", String.valueOf(element.getDeliveryMethod()));
                Log.println(Log.ASSERT, "gender", String.valueOf(element.getChildGender()));
                Log.println(Log.ASSERT, "preg_time", String.valueOf(element.getPregnancyTime()));
                Log.println(Log.ASSERT, "fad", String.valueOf(element.getFadPresence()));
                Log.println(Log.ASSERT, "messenger_name", String.valueOf(element.getHealthMessenger()));
                Log.println(Log.ASSERT, "messenger_id", String.valueOf(element.getHealthMessengerId()));
                Log.println(Log.ASSERT, "messenger_date", String.valueOf(element.getHealthMessengerDate()));
                Log.println(Log.ASSERT, "guide_name", String.valueOf(element.getGuideName()));
                Log.println(Log.ASSERT, "guide_id", String.valueOf(element.getGuideId()));
                Log.println(Log.ASSERT, "guide_date", String.valueOf(element.getGuideTestDate()));
*/
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
        }
    }

    public void deathChildPush() {
        DeathChildDataInterface dataInterface = new DeathChildDataInterface(getActivity().getApplicationContext());
        List<DeathChild> deathList = dataInterface.getAll();
        for (DeathChild element : deathList
                ) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.1.10:80/deathChild/add");
            try {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(18);
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(element.getId())));
                nameValuePairs.add(new BasicNameValuePair("village_id", String.valueOf(element.getVillageId())));
                nameValuePairs.add(new BasicNameValuePair("mother_village", String.valueOf(element.getMotherVillage())));
                nameValuePairs.add(new BasicNameValuePair("mother_village_id", String.valueOf(element.getMotherVillageID())));
                nameValuePairs.add(new BasicNameValuePair("village_of_birth", String.valueOf(element.getVillageOfBirth())));
                nameValuePairs.add(new BasicNameValuePair("village_of_birth_id", String.valueOf(element.getVillageOfBirthID())));
                nameValuePairs.add(new BasicNameValuePair("name", String.valueOf(element.getName())));


                nameValuePairs.add(new BasicNameValuePair("family_id", String.valueOf(element.getFamilyID())));
                nameValuePairs.add(new BasicNameValuePair("house_id", String.valueOf(element.getHouseID())));
                nameValuePairs.add(new BasicNameValuePair("member_id", String.valueOf(element.getMemberID())));
                nameValuePairs.add(new BasicNameValuePair("birth_date", String.valueOf(element.getBirthDate())));
                nameValuePairs.add(new BasicNameValuePair("death_date", String.valueOf(element.getDeathDate())));
                nameValuePairs.add(new BasicNameValuePair("age", String.valueOf(element.getAge())));

                nameValuePairs.add(new BasicNameValuePair("still_birth", String.valueOf(element.getStillBirth())));

                nameValuePairs.add(new BasicNameValuePair("village_of_death", String.valueOf(element.getVillageOfDeath())));
                nameValuePairs.add(new BasicNameValuePair("village_of_death_id", String.valueOf(element.getVillageOfDeathID())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger", String.valueOf(element.getHealthMessenger())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger_id", String.valueOf(element.getHealthMessengerId())));
                nameValuePairs.add(new BasicNameValuePair("health_messenger_date", String.valueOf(element.getHealthMessengerDate())));
                nameValuePairs.add(new BasicNameValuePair("guide_id", String.valueOf(element.getGuideId())));
                nameValuePairs.add(new BasicNameValuePair("guide_name", String.valueOf(element.getGuideName())));
                nameValuePairs.add(new BasicNameValuePair("guide_test_date", String.valueOf(element.getGuideTestDate())));

                Log.println(Log.ASSERT, "member_id", String.valueOf(element.getId()));
 /*









 Log.println(Log.ASSERT, "village_id", String.valueOf(element.getVillageId()));
                Log.println(Log.ASSERT, "house_id", String.valueOf(element.getHouseID()));
                Log.println(Log.ASSERT, "family_id", String.valueOf(element.getFamilyID()));
                Log.println(Log.ASSERT, "mother_name", String.valueOf(element.getMotherName()));
                Log.println(Log.ASSERT, "dob", String.valueOf(element.getBirthDate()));
                Log.println(Log.ASSERT, "mother_vill_name", String.valueOf(element.getMotherVillage()));
                Log.println(Log.ASSERT, "mother_vill_id", String.valueOf(element.getMotherVillageID()));
                Log.println(Log.ASSERT, "vill_of_birth", String.valueOf(element.getVillageOfBirth()));
                Log.println(Log.ASSERT, "vill_of_birth_id", String.valueOf(element.getVillageOfBirthID()));
                Log.println(Log.ASSERT, "vill_of_birth_place", String.valueOf(element.getVillageOfBirthPlace()));
                Log.println(Log.ASSERT, "delivery_name", String.valueOf(element.getDeliveryName()));
                Log.println(Log.ASSERT, "delivery_method", String.valueOf(element.getDeliveryMethod()));
                Log.println(Log.ASSERT, "gender", String.valueOf(element.getChildGender()));
                Log.println(Log.ASSERT, "preg_time", String.valueOf(element.getPregnancyTime()));
                Log.println(Log.ASSERT, "fad", String.valueOf(element.getFadPresence()));
                Log.println(Log.ASSERT, "messenger_name", String.valueOf(element.getHealthMessenger()));
                Log.println(Log.ASSERT, "messenger_id", String.valueOf(element.getHealthMessengerId()));
                Log.println(Log.ASSERT, "messenger_date", String.valueOf(element.getHealthMessengerDate()));
                Log.println(Log.ASSERT, "guide_name", String.valueOf(element.getGuideName()));
                Log.println(Log.ASSERT, "guide_id", String.valueOf(element.getGuideId()));
                Log.println(Log.ASSERT, "guide_date", String.valueOf(element.getGuideTestDate()));
*/
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
        }
    }

}
