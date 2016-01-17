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

import java.util.ArrayList;
import java.util.List;

public class DeathSupervisor extends AppCompatActivity {

    ListView lv;
    DeathAdultDataInterface deathAdultDataInterface;
    ArrayAdapter<DeathAdult> deathAdapter;
    List<DeathAdult> deathList;
    int longClickItemIndex, familyId;
    private static final int VIEW = 0;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_supervisor);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String deathShared = preferences.getString("deathA","default");


        lv = (ListView) findViewById(R.id.femMemListView);
        deathAdultDataInterface = new DeathAdultDataInterface(getApplicationContext());
        deathList = new ArrayList<DeathAdult>();
        Upload upload = new Upload("URL");

        List<Integer> list = upload.idList(deathShared,0);

        for (int id: list
                ) {
            DeathAdult result = deathAdultDataInterface.getInfo(id);
            deathList.add(result);
        }

        //Log.println(Log.ASSERT, "update", upload.updateFlags(list, 0, deathShared));
        // deathList = deathInfoDBHelper.getAll();

        Log.println(Log.ASSERT,"Member Fam List size", String.valueOf(deathList.size()));

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
        deathAdapter = new deathListAdapter(this.deathList, getApplicationContext());
        lv.setAdapter( deathAdapter);
        deathAdapter.notifyDataSetChanged();
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEW:
                Intent viewIntent = new Intent(getApplicationContext(), DeathAdultView.class);
                viewIntent.putExtra("index", String.valueOf(deathList.get(longClickItemIndex).getId()));
                //   viewIntent.putExtra("house", String.valueOf(memberFamList.get(longClickItemIndex).getHouseId()));
                //  viewIntent.putExtra("resident", "1");
                // viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
                startActivity(viewIntent);
                break;

        }
        return super.onContextItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("OPTIONS");
        menu.add(Menu.NONE, VIEW, menu.NONE, "DeathAdult slip BHARA");

    }



    private class deathListAdapter extends ArrayAdapter<DeathAdult> {
        Context context;
        List<DeathAdult> memberFamList;
        public deathListAdapter(List<DeathAdult> memberFamList, Context context) {
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

            DeathAdult death = memberFamList.get(position);


            Translation object = new Translation();
            TextView name = (TextView) view.findViewById(R.id.textNameB);
            name.setText(object.Letter_E2M(death.getName()));

            TextView age = (TextView) view.findViewById(R.id.ageB);
            age.setText(String.valueOf(death.getAge()));

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
        getMenuInflater().inflate(R.menu.menu_death_supervisor, menu);
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
