package com.example.kylehirschfelder.ship;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class MemberFamilyFromHeadListView extends AppCompatActivity {

    private static final int VIEW = 0;
    ListView lv;
    MemberDataInterface interfaceMember;
    ArrayAdapter<Member> memberAdapter;
    List<Member> memberFamList;
    int longClickItemIndex, familyId,curVillage;
    String form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_family_from_head_list_view);
        Member member = new Member();
        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();
        String index = getIntent().getStringExtra("index");
        form = getIntent().getStringExtra("form");
        familyId = Integer.parseInt(index);
        Log.println(Log.ASSERT,"LOG FAM ID",index);
        lv = (ListView) findViewById(R.id.memberFamListView);
        interfaceMember = new MemberDataInterface(getApplicationContext());
        final Activity activity = this;
        try {
            memberFamList = interfaceMember.getFamilyList(familyId,1,curVillage);
            Log.println(Log.ASSERT,"Member Fam List size", String.valueOf(memberFamList.size()));
        } catch (SQLException e) {
            e.printStackTrace();
        }



        registerForContextMenu(lv);
        populateList();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "कृपया नाव दाबून ठेवावे", Toast.LENGTH_LONG).show();
                longClickItemIndex = i;
                activity.openContextMenu(view);
            }
        });

/*
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });*/
    }

    public void populateList() {
        memberAdapter = new memberHeadListAdapter(this.memberFamList, getApplicationContext());
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_family_from_head_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEW:
                if(form.equals("2")){
                    Intent viewIntent = new Intent(getApplicationContext(), DeathAdultForm.class);
                    viewIntent.putExtra("index", String.valueOf(memberFamList.get(longClickItemIndex).getMemberId()));
                    viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                    viewIntent.putExtra("resident", "1");
                    startActivity(viewIntent);
                }
                else if(form.equals("3")){
                    Intent viewIntent = new Intent(getApplicationContext(), DeathChildForm.class);
                    viewIntent.putExtra("index", String.valueOf(memberFamList.get(longClickItemIndex).getMemberId()));
                    viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                    viewIntent.putExtra("resident", "1");
                    startActivity(viewIntent);
                }
                else if(form.equals("4")){
                    Intent viewIntent = new Intent(getApplicationContext(), StrokeActivity.class);
                    viewIntent.putExtra("index", String.valueOf(memberFamList.get(longClickItemIndex).getMemberId()));
                    viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                    startActivity(viewIntent);
                }
                else if(form.equals("5")){
                    Intent viewIntent = new Intent(getApplicationContext(), PNMForm_ask.class);
                    viewIntent.putExtra("index", String.valueOf(memberFamList.get(longClickItemIndex).getMemberId()));
                    viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                    // ** TRY **
                    String[] info = new String[10];
                    info[0] = memberFamList.get(longClickItemIndex).getName();
                    info[1] = String.valueOf(memberFamList.get(longClickItemIndex).getSex());
                    //info[2] = memberFamList.get(longClickItemIndex).getVillage();
                    info[2] = "Wut";
                    info[3] = String.valueOf(memberFamList.get(longClickItemIndex).getVillageId());
                    //info[4] = memberFamList.get(longClickItemIndex).getVillageBlock();
                    info[4] = "Is this field necessary?";
                    info[5] = memberFamList.get(longClickItemIndex).getChildDate();
                    info[6] = String.valueOf(memberFamList.get(longClickItemIndex).getAge());
                    info[7] = String.valueOf(memberFamList.get(longClickItemIndex).getFamilyId());
                    info[8] = String.valueOf(memberFamList.get(longClickItemIndex).getHouseId());
                    viewIntent.putExtra("info", info);
                    startActivity(viewIntent);
                }
                break;

        }
        return super.onContextItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("......");
        menu.add(Menu.NONE, VIEW, menu.NONE, "सदस्य माहिती");

    }


    private class memberHeadListAdapter extends ArrayAdapter<Member> {
        Context context;
        List<Member> memberFamList;
        public memberHeadListAdapter(List<Member> memberFamList, Context context) {
            super(context, R.layout.family_head_list_item, memberFamList);
            this.context = context;
            this.memberFamList = memberFamList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = inflater.inflate(R.layout.full_census_item, parent, false);
            }

            Member current = memberFamList.get(position);

            /*TextView hId = (TextView) view.findViewById(R.id.house_id);
            hId.setText(String.valueOf(current.getHouseId()));

            TextView fId = (TextView) view.findViewById(R.id.family_id);
            fId.setText(String.valueOf(current.getFamilyId()));*/

            Translation object = new Translation();
            TextView name = (TextView) view.findViewById(R.id.name_field);
            name.setText(object.Letter_E2M(current.getName()));

            TextView age = (TextView) view.findViewById(R.id.age_field);
            age.setText(String.valueOf(current.getAge()));

            TextView gender = (TextView) view.findViewById(R.id.gender_field);
            String memberSex = String.valueOf(current.getSex());
            switch (memberSex) {
                case "1":
                    memberSex = "पुरूष";
                    break;
                case "2":
                    memberSex = "स्त्री     ";
                    break;
            }
            gender.setText(memberSex);

           /* TextView marriage = (TextView) view.findViewById(R.id.marriage_status);
            marriage.setText(current.getMarriageParse());

//            TextView education = (TextView) view.findViewById(R.id.education_field);
  //          education.setText(current.getEducationParse(current.getEducation()));

            TextView literacy = (TextView) view.findViewById(R.id.literacy_field);
            literacy.setText(current.getLiteracyParse());
*/
            return view;
        }
    }
}
