package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

public class MemberFamilyFromHeadListView extends AppCompatActivity {

    ListView lv;
    MemberDataInterface interfaceMember;
    ArrayAdapter<Member> memberAdapter;
    List<Member> memberFamList;
    int longClickItemIndex, familyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_family_from_head_list_view);
        Member member = new Member();

        String index = getIntent().getStringExtra("index");
        familyId = Integer.parseInt(index);

        lv = (ListView) findViewById(R.id.listView);
        interfaceMember = new MemberDataInterface(getApplicationContext());

        try {
            memberFamList = interfaceMember.getFamilyList(familyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        registerForContextMenu(lv);
        populateList();

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
                view = inflater.inflate(R.layout.family_head_list_item, parent, false);
            }

            Member currentHead = memberFamList.get(position);

            TextView id = (TextView) view.findViewById(R.id.textId);
            id.setText(String.valueOf(currentHead.getMemberId()));

            TextView head = (TextView) view.findViewById(R.id.textHead);
            head.setText(currentHead.getName());

            return view;
        }
    }
}
