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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.List;

public class BirthFamilyListView extends AppCompatActivity {

    ListView lv,searchList;
    private static final int VIEWFAM = 0, ADDHOUSE = 1, ADDMEMBER = 2, UPMEM = 3, VIEWHOUSE = 4;
    TextView currentVillage;
    ArrayAdapter<Member> memberAdapter, memberSearchAdapter;
    List<Member> memberList, memberSearchList;
    MemberDataInterface head;
    int longClickItemIndex;
    Activity activity;
    int resident,form;
    int curVillage;
    SearchView searchView;
    Button search;
    Translation translation = new Translation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_family_list_view);

        lv = (ListView) findViewById(R.id.family_head_listB);
        searchList = (ListView) findViewById(R.id.searchList);
        currentVillage = (TextView) findViewById(R.id.curVillage);
        searchView = (SearchView) findViewById(R.id.searchView);
        search = (Button) findViewById(R.id.searchButton);

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

        searchView.setIconifiedByDefault(false);
        memberList = head.getAllFamilyHeads(1,curVillage);
        activity = this;

        resident = Integer.parseInt(getIntent().getStringExtra("resident"));
        form = Integer.parseInt(getIntent().getStringExtra("form"));        //1: Birth Mother  2: Death all Family

       // Log.println(Log.ASSERT, "LOG", "" + resident + " " + form);

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


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memberSearchList = head.getIdByName(translation.Letter_M2E(searchView.getQuery().toString()));
                //Log.println(Log.ASSERT,"query", String.valueOf(memberSearchList.size()));
                populateSearchList();
                registerForContextMenu(searchList);
                hideKeyboard(view);

            }
        });
        //Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(memberList.size()));
        populateList();
        registerForContextMenu(lv);



    }

    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        menu.add(Menu.NONE, VIEWFAM, menu.NONE, "कुटुंब प्रमुख माहिती");
    }


    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList, getApplicationContext());
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    public void populateSearchList() {
        memberSearchAdapter = new memberListAdapter(this.memberSearchList, getApplicationContext());
        searchList.setAdapter(memberSearchAdapter);
        memberSearchAdapter.notifyDataSetChanged();
    }


    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEWFAM:
                if(form == 1) {
                    if(resident == 0){
                        Intent intent = new Intent(getApplicationContext(),BirthInfoForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("resident", "0");
                        finish();
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(BirthFamilyListView.this,BirthSelectMother.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        finish();
                        startActivity(intent);
                    }
                }
                else if(form == 2){
                    if(resident == 1){
                        Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("resident", "1");
                        intent.putExtra("form","2");
                        finish();
                        startActivity(intent);
                    }
                    if(resident == 0){
                        Intent intent = new Intent(BirthFamilyListView.this,DeathAdultForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                        intent.putExtra("resident", "0");
                        finish();
                        startActivity(intent);
                    }
                }
                else if(form == 3){
                    if(resident == 1){
                        Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("form","3");
                        intent.putExtra("resident", "1");
                        finish();
                        startActivity(intent);
                    }
                    if(resident == 0){
                        Intent intent = new Intent(BirthFamilyListView.this,DeathChildForm.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                        intent.putExtra("resident", "0");
                        finish();
                        startActivity(intent);
                    }
                }
                else if(form == 4){
                    Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                    intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                    intent.putExtra("form","4");
                    intent.putExtra("resident", "1");
                    finish();
                    startActivity(intent);
                }
                else if(form == 5){
                    if(resident == 1){
                        Intent intent = new Intent(BirthFamilyListView.this,MemberFamilyFromHeadListView.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                        intent.putExtra("form","5");
                        intent.putExtra("resident", "1");



                        finish();
                        startActivity(intent);
                    }
                    if(resident == 0){
                        Intent intent = new Intent(BirthFamilyListView.this,PNMForm_ask.class);
                        intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                        intent.putExtra("resident", "0");
                        // ** TRY **
                        String[] info = new String[10];
                        info[0] = memberList.get(longClickItemIndex).getName();
                        info[1] = String.valueOf(memberList.get(longClickItemIndex).getSex());
                        //info[2] = memberList.get(longClickItemIndex).getVillage();
                        info[2] = "Wut";
                        info[3] = String.valueOf(memberList.get(longClickItemIndex).getVillageId());
                        //info[4] = memberList.get(longClickItemIndex).getVillageBlock();
                        info[4] = "Is this field necessary?";
                        info[5] = memberList.get(longClickItemIndex).getChildDate();
                        info[6] = String.valueOf(memberList.get(longClickItemIndex).getAge());
                        info[7] = String.valueOf(memberList.get(longClickItemIndex).getFamilyId());
                        info[8] = String.valueOf(memberList.get(longClickItemIndex).getHouseId());
                        intent.putExtra("info", info);
                        finish();
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
            head.setText("-- " + object.Letter_E2M(currentHead.getName()));


            return view;
        }
    }
}
