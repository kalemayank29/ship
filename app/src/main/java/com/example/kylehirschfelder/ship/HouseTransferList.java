package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseTransferList extends AppCompatActivity {

    Button pushAll;
    ListView lv;
    MemberDataInterface interfaceMember;
    CF_DatabaseOperations interfaceHouse;
   ArrayList<String> memberList;
    List<Census> houseList,allList;
    ArrayAdapter<String> memberAdapter;
    int longClickItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_transfer_list);

        memberList = new ArrayList<String>();
        pushAll = (Button) findViewById(R.id.pushAllHouse);
        lv = (ListView) findViewById(R.id.houseTransferList);
        interfaceMember = new MemberDataInterface(getApplicationContext());
        interfaceHouse = new CF_DatabaseOperations(getApplicationContext());
        try {
            houseList = interfaceHouse.getUnsynced(1);

            for (Census house: houseList
                 ) {
                memberList.add(interfaceMember.getHeadFromHouse(Integer.parseInt(house.getHouseID())));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        populateList();
        registerForContextMenu(lv);

        pushAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String, String>> houseMap = new ArrayList<HashMap<String, String>>();

                allList = interfaceHouse.getUnsynced(1);
                HashMap<String,String> village = new HashMap<String, String>();
                village.put("village","2");
                houseMap = interfaceHouse.toHashList(allList,village);


                Bundle bundle = new Bundle();
                bundle.putSerializable("map",houseMap);
                Intent intent = new Intent(HouseTransferList.this, WifiDirectActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("activityFlag","2");

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

    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList);
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_house_transfer_list, menu);
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

    private class memberListAdapter extends ArrayAdapter<String> {

        ArrayList<String> memberList;
        public memberListAdapter(ArrayList<String> medList) {
            super(HouseTransferList.this, R.layout.house_item, medList);
            this.memberList = medList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.house_item, parent, false);
            }

           // Member currentMember = memberList.get(position);
            String current = memberList.get(position);

            Translation object = new Translation();
            TextView name = (TextView) view.findViewById(R.id.headName);
            name.setText(object.Letter_E2M(current));

            return view;
        }
    }
}
