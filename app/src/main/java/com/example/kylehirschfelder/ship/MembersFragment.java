package com.example.kylehirschfelder.ship;

import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;


public class MembersFragment extends Fragment{
    View myView;
    ListView lv;
    private static final int VIEWFAM = 0, ADDHOUSE = 1, ADDMEMBER = 2, UPMEM = 3, VIEWHOUSE = 4;
    ArrayAdapter<Member> memberAdapter, memberFamAdapter;
    List<Member> memberList, memberFamList;
    MemberDataInterface head;
    int longClickItemIndex, curVillage;
    Activity activity;

    Button add, all;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        myView = inflater.inflate(R.layout.fragment_members, container,false);
        lv = (ListView) myView.findViewById(R.id.family_head_list);
        curVillage = ((CurrentVillage) this.getActivity().getApplication()).getSomeVariable();

        head = new MemberDataInterface(this.getActivity().getApplicationContext());
        memberList = head.getAllFamilyHeads(1,curVillage);
     //   add = (Button) myView.findViewById(R.id.addMemberButton);
//        all = (Button) myView.findViewById(R.id.viewAllButton);
        activity = getActivity();



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                longClickItemIndex = position;
                activity.openContextMenu(arg1);
            }
        });



        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });

        Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(memberList.size()));
        populateList();
        registerForContextMenu(lv);

        return myView;
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle(".....");
        menu.add(Menu.NONE, VIEWFAM, menu.NONE, "कुटुंब माहिती");
      //  menu.add(Menu.NONE, ADDHOUSE, menu.NONE, "घर माहिती भरा");
      //  menu.add(Menu.NONE, ADDMEMBER, menu.NONE, "सदस्य जोडा");
      //  menu.add(Menu.NONE, UPMEM, menu.NONE, "सदस्य सुधारणा");
        menu.add(Menu.NONE, VIEWHOUSE, menu.NONE, "घर माहिती पहा");
    }


    public void populateList() {
        memberAdapter = new memberListAdapter(this.memberList, myView.getContext());
        lv.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VIEWFAM:
                Intent intent = new Intent(getActivity(),MemberFamilyFromHeadListView.class);
                intent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getFamilyId()));
                startActivity(intent);
                break;
            case ADDHOUSE:
                Intent censusIntent = new Intent(getActivity(),NewCensusForm.class);
                censusIntent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getHouseId()));
                startActivity(censusIntent);
                //if(memberList.get(longClickItemIndex).getHouseId() == -1)
                  //  startActivity(censusIntent);
               // else
                 //   Toast.makeText(getActivity(),"घर माहिती आधीच भरले गेले आहे",Toast.LENGTH_LONG).show();
                break;
            case ADDMEMBER:
                Intent memberIntent = new Intent(getActivity(),MemberForm.class);
                memberIntent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
                startActivity(memberIntent);
                break;
            case UPMEM:
                Intent updateIntent = new Intent(getActivity(),MemberFormUpdate.class);
                updateIntent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getMemberId()));
            //    if(head.isSynced(memberList.get(longClickItemIndex).getMemberId(),1) == 1)
                    startActivity(updateIntent);
              //  else
                    Toast.makeText(getActivity(),"आता संपादित करू शकत नाही",Toast.LENGTH_LONG).show();
                break;
            case VIEWHOUSE:
                Intent hintent = new Intent(getActivity(),CensusViewForm.class);
                Member houseMember = new Member();

                    //houseMember = head.getMember(memberList.get(longClickItemIndex).getMemberId(), 1);
                    hintent.putExtra("index", String.valueOf(memberList.get(longClickItemIndex).getHouseId()));

                if(houseMember.getHouseId() == -1)  Toast.makeText(getActivity(),"घर माहिती भरले गेले नाही",Toast.LENGTH_LONG).show();
                else startActivity(hintent);
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

         //   TextView Hid = (TextView) view.findViewById(R.id.houseIdM);
           // Hid.setText(String.valueOf(currentHead.getHouseId()));

            TextView Fid = (TextView) view.findViewById(R.id.familyId);
            Fid.setText(String.valueOf(currentHead.getFamilyId()));

            Translation object = new Translation();
            TextView head = (TextView) view.findViewById(R.id.textName);
            head.setText(object.Letter_E2M(currentHead.getName()));


            return view;
        }
    }
}
