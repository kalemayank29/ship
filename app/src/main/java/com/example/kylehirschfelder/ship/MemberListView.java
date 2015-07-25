package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemberListView extends AppCompatActivity {

    List<Member> memberList = new ArrayList<Member>();
    ListView lv;
    MemberDataInterface interfaceMember;
    ArrayAdapter<Member> memberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list_view);

        lv = (ListView) findViewById(R.id.memberAllListView);
        interfaceMember = new MemberDataInterface(getApplicationContext());
        memberList = interfaceMember.getAllMembers(1);

        populateList();
        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_list_view, menu);
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

    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList);
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    private class memberListAdapter extends ArrayAdapter<Member> {

        List<Member> memberList;
        public memberListAdapter(List<Member> medList) {
            super(MemberListView.this, R.layout.member_all_item, medList);
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
