package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransferMemberListView extends AppCompatActivity {

    private static final int VIEW = 0;
    List<Member> memberList = new ArrayList<Member>();
    ListView lv;
    MemberDataInterface interfaceMember;
    ArrayAdapter<Member> memberAdapter;
    int longClickItemIndex;
    Button pushAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_member_list_view);

        pushAll = (Button) findViewById(R.id.pushAllBtn);
        lv = (ListView) findViewById(R.id.ListView);
        interfaceMember = new MemberDataInterface(getApplicationContext());
        memberList = interfaceMember.getAllMembers(0);            // Push only from Local

        populateList();
        registerForContextMenu(lv);

        pushAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String, String>> memberMap = new ArrayList<HashMap<String, String>>();

                memberMap = interfaceMember.toHashList(memberList);

                /*
                for(int i = 0; i < memberList.size(); i++){

                    Member temp = memberList.get(i);

                    HashMap<String, String> pairs = new HashMap<String, String>();
                    pairs.put("familyId", String.valueOf(temp.getFamilyId()));
                    pairs.put("houseId", String.valueOf(temp.getHouseId()));
                    pairs.put("name", temp.getName());
                    pairs.put("age", String.valueOf(temp.getAge()));
                    pairs.put("childId", String.valueOf(temp.getChildId()));
                    pairs.put("marriageStatus", temp.getMarriageStatus());
                    pairs.put("familyPlan", temp.getFamilyPlan());
                    pairs.put("education", temp.getEducation());
                    pairs.put("literacy", temp.getLiteracy());
                    pairs.put("weddingArr", temp.getWeddingArr());
                    pairs.put("weddingDept", temp.getWeddingDept());
                    memberMap.add(pairs);

                }*/

                //Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(memberList.size()));

                Bundle bundle = new Bundle();
                bundle.putSerializable("map",memberMap);
                Intent intent = new Intent(TransferMemberListView.this, WifiDirectActivity.class);
                intent.putExtras(bundle);

                //Log.println(Log.ASSERT, "Size: ", String.valueOf(memberMap.size()));

                startActivity(intent);
            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_list_view, menu);
        return true;
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEW:
                Intent viewIntent = new Intent(getApplicationContext(), ViewMemberProfile.class);
                viewIntent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                startActivity(viewIntent);
                break;

        }
        return super.onContextItemSelected(item);
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

    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList);
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }


    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("Census Options");
        menu.add(Menu.NONE, VIEW, menu.NONE, "View Member");

    }

    private class memberListAdapter extends ArrayAdapter<Member> {

        List<Member> memberList;
        public memberListAdapter(List<Member> medList) {
            super(TransferMemberListView.this, R.layout.member_all_item, medList);
            this.memberList = medList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.member_all_item, parent, false);
            }

            Member currentMember = memberList.get(position);

            TextView id = (TextView) view.findViewById(R.id.textId);
            id.setText(String.valueOf(currentMember.getMemberId()));

            TextView name = (TextView) view.findViewById(R.id.textName);
            name.setText(currentMember.getName());

            return view;
        }
    }
}
