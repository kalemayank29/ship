package com.example.kylehirschfelder.ship;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;


public class MembersFragment extends Fragment {
    View myView;
    ListView lv;
    private static final int VIEWFAM = 0;
    ArrayAdapter<Member> memberAdapter, memberFamAdapter;
    List<Member> memberList, memberFamList;
    MemberDataInterface head;
    int longClickItemIndex;
    Button add, all;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        myView = inflater.inflate(R.layout.fragment_members, container,false);
        lv = (ListView) myView.findViewById(R.id.family_head_list);
        head = new MemberDataInterface(this.getActivity().getApplicationContext());
        memberList = head.getAllFamilyHeads();
        add = (Button) myView.findViewById(R.id.addMemberButton);
        all = (Button) myView.findViewById(R.id.viewAllButton);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MemberForm.class);
                startActivity(intent);
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getActivity(),MemberListView.class);
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

        Log.println(Log.ASSERT, "LIST SIZE: ", String.valueOf(memberList.size()));
        populateList();
        registerForContextMenu(lv);

        return myView;
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("Census Options");
        menu.add(Menu.NONE, VIEWFAM, menu.NONE, "View Family");
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
                view = inflater.inflate(R.layout.family_head_list_item, parent, false);
            }

            Member currentHead = memberList.get(position);

            TextView id = (TextView) view.findViewById(R.id.textId);
            id.setText(String.valueOf(currentHead.getMemberId()));

            TextView head = (TextView) view.findViewById(R.id.textHead);
            head.setText(currentHead.getName());

            return view;
        }
    }
}
