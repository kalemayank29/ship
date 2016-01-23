package com.example.kylehirschfelder.ship;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BirthSupervisor extends AppCompatActivity {
    ListView lv;
    BirthInfoDBHelper birthInfoDBHelper;
    ArrayAdapter<Birth> birthAdapter;
    List<Birth> birthList;
    int longClickItemIndex, familyId;
    private static final int VIEW = 0;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_supervisor);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String birthShared = preferences.getString("birth","default");


        lv = (ListView) findViewById(R.id.femMemListView);
        birthInfoDBHelper = new BirthInfoDBHelper(getApplicationContext());
        birthList = new ArrayList<Birth>();
        Upload upload = new Upload("URL");

       List<Integer> list = upload.idList(birthShared,0);

        for (int id: list
             ) {
            Birth result = birthInfoDBHelper.getInfo(id);
            birthList.add(result);
        }

       Log.println(Log.ASSERT,"update", upload.updateFlags(list, 0  ,birthShared ));
       // birthList = birthInfoDBHelper.getAll();

        Log.println(Log.ASSERT,"Member Fam List size", String.valueOf(birthList.size()));

        activity = this;

        registerForContextMenu(lv);
        populateList();

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                longClickItemIndex = i;
                activity.openContextMenu(view);
            }
        });
    }

    public void populateList() {
        birthAdapter = new birthListAdapter(this.birthList, getApplicationContext());
        lv.setAdapter( birthAdapter);
        birthAdapter.notifyDataSetChanged();
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEW:
                Intent viewIntent = new Intent(getApplicationContext(), BirthViewForm.class);
                viewIntent.putExtra("index", String.valueOf(birthList.get(longClickItemIndex).getChildID()));
             //   viewIntent.putExtra("house", String.valueOf(memberFamList.get(longClickItemIndex).getHouseId()));
              //  viewIntent.putExtra("resident", "1");
               // viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                finish();
                startActivity(viewIntent);
                break;

        }
        return super.onContextItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("OPTIONS");
        menu.add(Menu.NONE, VIEW, menu.NONE, "जन्म माहिती भरा");

    }







    private class birthListAdapter extends ArrayAdapter<Birth> {
        Context context;
        List<Birth> memberFamList;
        public birthListAdapter(List<Birth> memberFamList, Context context) {
            super(context, R.layout.family_head_list_item, memberFamList);
            this.context = context;
            this.memberFamList = memberFamList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = inflater.inflate(R.layout.birth_item_select_mother, parent, false);
            }

           Birth birth = memberFamList.get(position);


            Translation object = new Translation();
            TextView name = (TextView) view.findViewById(R.id.textNameB);
            name.setText(object.Letter_E2M(birth.getMotherName()));

            TextView age = (TextView) view.findViewById(R.id.ageB);
            age.setText(String.valueOf(birth.getMemberId()));

       /* TextView gender = (TextView) view.findViewById(R.id.sexB);
        String memberSex = String.valueOf(current.getSex());
        switch (memberSex) {
            case "1":
                memberSex = "man";
                break;
            case "2":
                memberSex = "woman";
                break;
        }
        gender.setText(memberSex);
*/

            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birth_supervisor, menu);
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

}
