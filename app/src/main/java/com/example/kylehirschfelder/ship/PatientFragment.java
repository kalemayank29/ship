package com.example.kylehirschfelder.ship;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mayank on 7/28/15.
 */
public class PatientFragment extends Fragment  {
    View myView;
    ListView listView;
    List<Member> memberList;
    MemberDataInterface head;
    ArrayAdapter<Member> memberAdapter;
    Button buttPatient;
    int curVillage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_patients, container,false);
        listView = (ListView) myView.findViewById(R.id.family_head_list);
        head = new MemberDataInterface(this.getActivity().getApplicationContext());

        curVillage = ((CurrentVillage) this.getActivity().getApplication()).getSomeVariable();

        Log.println(Log.ASSERT,"curVillage", String.valueOf(curVillage));

        memberList = head.getAllFamilyHeads(1,curVillage);

        /*for (Member element: memberList
             ) {
            Log.println(Log.ASSERT,"villageid", String.valueOf(element.getVillageId()));
        }*/

        memberAdapter = new memberListAdapter(this.memberList, myView.getContext());


        buttPatient = (Button) myView.findViewById(R.id.buttonPatient);
        //Intent intent = new Intent(getActivity().getApplicationContext(), PatientList.class);
        Intent intent = new Intent(getActivity().getApplicationContext(), Cod1to5_V.class);
        startActivity(intent);
/*
        buttPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);



                JSONParser jsonParser = new JSONParser();
                try {
                    JSONArray json = jsonParser.getJSONFromUrl("http://192.168.10.6:8888/member/all");
                    // Log.println(Log.ASSERT,"json size",json.toString());
                    MemberDataInterface memberInterface = new MemberDataInterface(getActivity().getApplicationContext());
                    FamilyHeadDataInterface headInterface = new FamilyHeadDataInterface(getActivity().getApplicationContext());

                    int familyId = 0;

                    for (int i = 0; i < json.length(); i++) {
                        try {
                            JSONObject c = json.getJSONObject(i);

                            Member element = new Member();
                            element.setMemberId(Integer.parseInt(c.getString("id")));
                            element.setFamilyId(Integer.parseInt(c.getString("family_id")));
                            element.setFamilyHeadId(Integer.parseInt(c.getString("family_head_id")));
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


                            if(element.getFamilyHeadId() == 1){
                                Member head;
                                headInterface.createMember(element);
                                head = headInterface.getRecent();
                                familyId = head.getMemberId();
                            }

                            element.setFamilyId(familyId);
                            Log.println(Log.ASSERT, "Fam id", String.valueOf(element.getFamilyId()));
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
            }
        });*/
        return myView;
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
                view = inflater.inflate(R.layout.member_all_item, parent, false);
            }

            Member currentHead = memberList.get(position);

           // TextView Hid = (TextView) view.findViewById(R.id.houseIdM);
          //  Hid.setText(String.valueOf(currentHead.getHouseId()));

            TextView Fid = (TextView) view.findViewById(R.id.familyId);
            Fid.setText(String.valueOf(currentHead.getFamilyId()));

            Translation object = new Translation();
            TextView head = (TextView) view.findViewById(R.id.textName);
            head.setText(object.Letter_E2M(currentHead.getName()));


            return view;
        }

    }
}
