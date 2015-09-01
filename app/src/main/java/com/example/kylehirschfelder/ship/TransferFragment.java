package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
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
import android.widget.Button;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


public class TransferFragment extends Fragment {

    Button memberButton;
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_transfer, container,false);

        Context context = getActivity().getApplicationContext();
        LoginDialog loginDialog = new LoginDialog();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        loginDialog.displayalert(alertDialog, context);

        memberButton = (Button) myView.findViewById(R.id.memberBtn);

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Intent intent = new Intent(getActivity(), CensusFormPortal.class);
              //  startActivity(intent);



                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);



                JSONParser jsonParser = new JSONParser();
                try {
                    JSONArray json = jsonParser.getJSONFromUrl("http://192.168.1.237:8888/member/all");
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
            }

        });
        //Intent intent = new Intent(getActivity(), TransferMemberListView.class);
        //startActivity(intent);

        return myView;
    }
}
