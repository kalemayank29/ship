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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.List;

public class BirthFamilyListView extends AppCompatActivity {

    ListView lv;
    private static final int VIEWFAM = 0, ADDHOUSE = 1, ADDMEMBER = 2, UPMEM = 3, VIEWHOUSE = 4;
    TextView currentVillage;
    ArrayAdapter<Member> memberAdapter, memberFamAdapter;
    List<Member> memberList, memberFamList;
    MemberDataInterface head;
    int longClickItemIndex;
    Activity activity;
    int resident,form;
    int curVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_family_list_view);

        lv = (ListView) findViewById(R.id.family_head_listB);
        currentVillage = (TextView) findViewById(R.id.curVillage);
        head = new MemberDataInterface(getApplicationContext());
        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();
        switch(curVillage){
            case 12:
                currentVillage.setText("खुरसा ");
                break;
            case 13:
                currentVillage.setText("मुरमाडी");
                break;
            case 14:
                currentVillage.setText("गिलगाव");
                break;

        }
        memberList = head.getAllFamilyHeads(1,curVillage);
        activity = this;

        resident =Integer.parseInt(getIntent().getStringExtra("resident"));
        form = Integer.parseInt(getIntent().getStringExtra("form"));        //1: Birth Mother  2: Death all Family

        Log.println(Log.ASSERT, "LOG", "" + resident + " " + form);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                longClickItemIndex = position;
                activity.openContextMenu(arg1);

            }
        });

        Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(memberList.size()));
        populateList();
        registerForContextMenu(lv);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birth_family_list_view, menu);
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

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle(".....");
        menu.add(Menu.NONE, VIEWFAM, menu.NONE, "Select Family Head");
    }


    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList, getApplicationContext());
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEWFAM:
                if(form == 1) {
                    if(resident == 0){
                        Intent intent = new Intent(getApplicationContext(),BirthInfoForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("resident", "0");
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(BirthFamilyListView.this,BirthSelectMother.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        startActivity(intent);
                    }
                }
                else if(form == 2){
                    if(resident == 1){
                        Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("resident", "1");
                        intent.putExtra("form","2");
                        startActivity(intent);
                    }
                    if(resident == 0){
                        Intent intent = new Intent(BirthFamilyListView.this,DeathAdultForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                        intent.putExtra("resident", "0");
                        startActivity(intent);
                    }
                }
                else if(form == 3){
                    if(resident == 1){
                        Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("form","3");
                        intent.putExtra("resident", "1");
                        startActivity(intent);
                    }
                    if(resident == 0){
                        Intent intent = new Intent(BirthFamilyListView.this,DeathChildForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                        intent.putExtra("resident", "0");
                        startActivity(intent);
                    }
                }
                break;
        }
        return super.onContextItemSelected(item);
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


            TextView Fid = (TextView) view.findViewById(R.id.familyId);
            Fid.setText(String.valueOf(currentHead.getFamilyId()));

            Translation object = new Translation();
            TextView head = (TextView) view.findViewById(R.id.textName);
            head.setText(object.Letter_E2M(currentHead.getName()));


            return view;
        }
    }
}
