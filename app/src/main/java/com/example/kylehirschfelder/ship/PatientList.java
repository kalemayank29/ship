package com.example.kylehirschfelder.ship;

import android.app.FragmentManager;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PatientList extends AppCompatActivity {

    ListView listView;
   // List<Birth> birthList;
    //BirthInfoDBHelper dbHelper;
    //ArrayAdapter<Birth> birthAdapter;
    List<Member> memberList;
    MemberDataInterface head;
    ArrayAdapter<Member> memberAdapter;
    int curVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        

        curVillage = ((CurrentVillage) this.getApplication()).getSomeVariable();
        listView = (ListView) this.findViewById(R.id.pfamily_head_list);
         head = new MemberDataInterface(this.getApplicationContext());
        Log.println(Log.ASSERT,"curVillage", String.valueOf(curVillage));
        memberList = head.getAllFamilyHeads(1,curVillage);

       // dbHelper = new BirthInfoDBHelper(this.getApplicationContext());
        // birthList = dbHelper.getAll();
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent = new Intent(getApplicationContext(),MemberFamilyFromHeadListView.class);
            intent.putExtra("index", String.valueOf(memberList.get(i).getFamilyId()));
            startActivity(intent);
           // int age = memberList.get(i).getAge();
          //  if(age<20)
            //    intent.putExtra("name", String.valueOf(memberList.get(i).getName()));
            //    startActivity(intent);
        }
    });
       // Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(birthList.size()));
        populateList();
        registerForContextMenu(listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_list, menu);
        return true;
    }

    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList, this.getApplicationContext());
        listView.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
      //  birthAdapter = new birthListAdapter(this.birthList, this.getApplicationContext());
       // listView.setAdapter((birthAdapter));
        //birthAdapter.notifyDataSetChanged();
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

        if (item.getItemId() == R.id.action_example) {
            //Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
            VillageSelectDialog dialog = new VillageSelectDialog();
            FragmentManager manager = this.getFragmentManager();
            dialog.show(manager,"Villages");
            return true;
        }


        return super.onOptionsItemSelected(item);
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
/*
    private class birthListAdapter extends ArrayAdapter<Birth> {
        Context context;
        List<Birth> birthList;

        public birthListAdapter(List<Birth> birthList, Context context) {
            super(context, R.layout.birth_item, birthList);
            this.context = context;
            this.birthList = birthList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = inflater.inflate(R.layout.birth_item, parent, false);
            }

            Birth current = birthList.get(position);

            TextView Fid = (TextView) view.findViewById(R.id.mNameB);
            Fid.setText(String.valueOf(current.getFamilyID()));

            Translation object = new Translation();
            TextView head = (TextView) view.findViewById(R.id.villageB);
            head.setText(object.Letter_E2M(current.getBirthDate()));

            return view;
        }

    }*/
}
