package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MedicineAddListView extends AppCompatActivity {

    private static final int VERIFY = 0, DELETE = 1;

    ListView lv;
    Button btn, pushBtn;
    MedicineDBHandler db = new MedicineDBHandler(this);
    List<Medicine> medicineList = new ArrayList<Medicine>();
    List<Medicine> medicineListCur = new ArrayList<Medicine>();
    int longClickItemIndex = 0, longClickItemIndexCur = 0;
    ArrayAdapter<Medicine> medicineAdapter;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_add_list_view);

        lv = (ListView) findViewById(R.id.medList);
        btn = (Button) findViewById(R.id.curBtn);
        pushBtn = (Button) findViewById(R.id.allBtn);
        List<Medicine> addableMed = db.getAllMedicine();

        int count = addableMed.size();


        for (int i = 0; i < count; i++) {
            medicineList.add(addableMed.get(i));
        }

        Log.println(Log.ASSERT, "SIZE OF LIST:", String.valueOf(medicineList.size()));
        size = medicineList.size();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MedicineAddShowCur.class);
                startActivity(intent);
            }
        });

        pushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<HashMap<String, String>> drugMap = new ArrayList<HashMap<String, String>>();


                for(int i = 0; i < medicineList.size(); i++){

                    Medicine temp = medicineList.get(i);

                    HashMap<String, String> pairs = new HashMap<String, String>();
                    pairs.put("name", temp.get_name());
                    pairs.put("tab", temp.get_mg());
                    pairs.put("exp_date", temp.get_expDate());
                    pairs.put("bott_date", temp.get_openDate());
                    pairs.put("no_tab", temp.get_noTabs());
                    pairs.put("patient_id", temp.get_patientId());
                    drugMap.add(pairs);
                }

                Bundle bundle = new Bundle();
                bundle.putSerializable("map",drugMap);
                Intent intent = new Intent(MedicineAddListView.this, WifiDirectActivity.class);
                intent.putExtras(bundle);


                Log.println(Log.ASSERT, "Size of Cur: ", String.valueOf(db.getMedicineCurCount()));
                Log.println(Log.ASSERT, "Size of DB: ", String.valueOf(db.getMedicineCount()));

                for(int i = 0; i < size; i++) {
                    Medicine temp = medicineList.get(i);
                    db.createMedicineCur(temp);
                    db.deleteMed(temp);

                }

                medicineList.clear();

                medicineAdapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });

        populateList();
        registerForContextMenu(lv);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });
    }

    public void populateList() {
        medicineAdapter = new medicineListAdapter(this.medicineList);
        lv.setAdapter(medicineAdapter);
        medicineAdapter.notifyDataSetChanged();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("Census Options");
        menu.add(Menu.NONE, VERIFY, menu.NONE, "Verify Medicine");
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete Medicine");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VERIFY:
                //List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>();
                HashMap<String, String> pairs = new HashMap<String, String>();
                HashMap<String, String> map1 = new HashMap<String, String>();
                HashMap<String, String> map2 = new HashMap<String, String>();

                Medicine temp = medicineList.get(longClickItemIndex);

                ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();

                list.add(map1);
                list.add(map2);

                pairs.put("name", temp.get_name());
                pairs.put("tab", temp.get_mg());
                pairs.put("exp_date", temp.get_expDate());
                pairs.put("bott_date", temp.get_openDate());
                pairs.put("no_tab", temp.get_noTabs());
                pairs.put("patient_id", temp.get_patientId());

                /*
                    NameValuePairs.add(new BasicNameValuePair("name", temp.get_name()));
                    NameValuePairs.add(new BasicNameValuePair("tab", temp.get_mg()));
                    NameValuePairs.add(new BasicNameValuePair("exp_date", temp.get_expDate()));
                    NameValuePairs.add(new BasicNameValuePair("bott_date", temp.get_openDate()));
                    NameValuePairs.add(new BasicNameValuePair("no_tab", temp.get_noTabs()));
                    NameValuePairs.add(new BasicNameValuePair("patient_id", temp.get_patientId()));
                */

                Bundle bundle = new Bundle();
                bundle.putSerializable("map",list);
                Intent intent = new Intent(MedicineAddListView.this, WifiDirectActivity.class);
                intent.putExtras(bundle);

                db.createMedicineCur(temp);
                db.deleteMed(medicineList.get(longClickItemIndex));
                medicineList.remove(longClickItemIndex);
                medicineAdapter.notifyDataSetChanged();

                startActivity(intent);

                break;
            case DELETE:
                Log.e("DELETE",String.valueOf(item.getItemId()));


                db.deleteMed(medicineList.get(longClickItemIndex));
                medicineList.remove(longClickItemIndex);
                medicineAdapter.notifyDataSetChanged();

                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medicine_add_list_view, menu);
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

    private class medicineListAdapter extends ArrayAdapter<Medicine> {

        List<Medicine> medList;
        public medicineListAdapter(List<Medicine> medList) {
            super(MedicineAddListView.this, R.layout.medicine_item, medList);
            this.medList = medList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.medicine_item, parent, false);
            }

            Medicine currentMedicine = medList.get(position);

            TextView medName = (TextView) view.findViewById(R.id.medName);
            medName.setText(currentMedicine.get_name());

            TextView medMg = (TextView) view.findViewById(R.id.medMg);
            medMg.setText(currentMedicine.get_mg());

            TextView medTab = (TextView) view.findViewById(R.id.medNoTab);
            medTab.setText(currentMedicine.get_noTabs());

            TextView medExp = (TextView) view.findViewById(R.id.medBotExp);
            medExp.setText(currentMedicine.get_expDate());

            TextView medOpen = (TextView) view.findViewById(R.id.medBotOpen);
            medOpen.setText(currentMedicine.get_openDate());

            TextView medPatId = (TextView) view.findViewById(R.id.medPatientId);
            medPatId.setText(currentMedicine.get_patientId());

            return view;
        }
    }
}
