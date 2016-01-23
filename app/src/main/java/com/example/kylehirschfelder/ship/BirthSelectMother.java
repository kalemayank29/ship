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

import java.sql.SQLException;
import java.util.List;

public class BirthSelectMother extends AppCompatActivity {
    private static final int VIEW = 0;

ListView lv;
MemberDataInterface interfaceMember;
ArrayAdapter<Member> memberAdapter;
List<Member> memberFamList;
int longClickItemIndex, familyId;
    Activity activity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_birth_select_mother);
            Member member = new Member();

            String index = getIntent().getStringExtra("index");
            familyId = Integer.parseInt(index);
            Log.println(Log.ASSERT, "LOG FAM ID", index);
            lv = (ListView) findViewById(R.id.femMemListView);
            interfaceMember = new MemberDataInterface(getApplicationContext());

            try {
                memberFamList = interfaceMember.getFemaleFamilyList(familyId,1);

                Log.println(Log.ASSERT,"Member Fam List size", String.valueOf(memberFamList.size()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

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


            return super.onOptionsItemSelected(item);
        }

        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case VIEW:
                    Intent viewIntent = new Intent(getApplicationContext(), BirthInfoForm.class);
                    viewIntent.putExtra("index", String.valueOf(memberFamList.get(longClickItemIndex).getFamilyId()));
                    viewIntent.putExtra("house", String.valueOf(memberFamList.get(longClickItemIndex).getHouseId()));
                    viewIntent.putExtra("resident", "1");
                    viewIntent.putExtra("name", String.valueOf(memberFamList.get(longClickItemIndex).getName()));
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
            view = inflater.inflate(R.layout.birth_item_select_mother, parent, false);
        }

        Member current = memberFamList.get(position);



        Translation object = new Translation();
        TextView name = (TextView) view.findViewById(R.id.textNameB);
        name.setText(object.Letter_E2M(current.getName()));

        TextView age = (TextView) view.findViewById(R.id.ageB);
        age.setText(String.valueOf(current.getAge()));

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
}

