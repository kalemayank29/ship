package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineInventoryInterface extends AppCompatActivity {
//THIS IS MAIN_ACTIVITY

    ListView _lv;
    Button _addMedicine, _prescribeBtn, _transBtn;
    TextView _drugNameText, _drugMedicineIdText;
    ArrayAdapter<Medicine> medicineAdapter;
    List<Medicine> medicineList = new ArrayList<Medicine>();
    MedicineInventoryDBInterface db;
    List<Medicine> addableMedicine;
    private static final int VERIFY = 0, DELETE = 1;
    int med_id, count;
    String longClickResult;
    int longClickToInt = 0;
    int longClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_inventory);

        db = new MedicineInventoryDBInterface(getApplicationContext());
        _lv = (ListView) findViewById(R.id.listView);
        _addMedicine = (Button) findViewById(R.id.addMedicine);
      //  _addQuantity = (Button) findViewById(R.id.addQuantityBtn);
        _prescribeBtn = (Button) findViewById(R.id.prescribeMedicine);
        _drugNameText = (TextView) findViewById(R.id.textDrugName);
        _drugMedicineIdText = (TextView) findViewById(R.id.textDrugId);
        _transBtn = (Button)findViewById(R.id.transactionBtn);

        //launches the transaction activity



        //populate the medicineList for the listView
        try {
            addableMedicine = db.getAllMedicine();
            count = addableMedicine.size();
            Log.println(Log.ASSERT, "count", String.valueOf(count));
            for (int i = 0; i < count; i++)
                medicineList.add(addableMedicine.get(i));
        }catch(SQLException e){}
        if(count != 0){
            String selected = medicineList.get(0).getName();
            _drugNameText.setText(selected);
            try {
                int id = Integer.parseInt(db.getIdFromMedicine(selected));
                _drugMedicineIdText.setText(String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        //Launches activity to add medicine to database
        _addMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MedicineInventoryAddMedicine.class);
                finish();
                startActivity(intent);
            }
        });

        //Launches activity to prescribe a medicine to a patient\

        _prescribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), PrescriptionInterface.class);
                finish();
                startActivity(intent);
            }
        });

        _transBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TransactionInterface.class);
                finish();
                startActivity(intent);
            }
        });

        _lv.setClickable(true);
        //Gets index of long clicked item
        _lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String selected = _lv.getSelectedItem().toString();
                String selected = medicineList.get(i).getName();
                _drugNameText.setText(selected);
                try {
                    int id = Integer.parseInt(db.getIdFromMedicine(selected));
                    _drugMedicineIdText.setText(String.valueOf(id));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        //Need a way to remove a drug once the quantity is 0
        //Not entirely sure this works
      /*  for(int i = 0; i < addableMedicine.size(); i++){
            if(addableMedicine.get(i).getQuantity() == 0){
                addableMedicine.remove(i);
                registerForContextMenu(_lv);
            }
        }*/

        //populate textedit based on which drug is selected
        populateList();
        registerForContextMenu(_lv);
    }


    //Populates the _lv (list view) with the addable drugs from the db
    public void populateList() {
        medicineAdapter = new medicineListAdapter(this.medicineList);
        _lv.setAdapter(medicineAdapter);
        medicineAdapter.notifyDataSetChanged();
    }


    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderTitle("Inventory Options");
        menu.add(Menu.NONE, VERIFY, menu.NONE, "Restock Medicine");
    }


    //***************************************************************************************************************
    //Try this to get a "yes or no" to increment the medicine
    //THIS COULD NOT WORK

    //This should prompt the user with a text field to enter the quantity of medicine to add
 /*   public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case VERIFY:

                LayoutInflater li = LayoutInflater.from(getApplicationContext());
                View promptsView = li.inflate(R.layout.prompts, null);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
                builder1.setView(promptsView);
                builder1.setMessage("Add Medication Below");
                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        ("+ " + medicineList.get(longClick).getName().toString()),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                med_id = Integer.parseInt(medicineList.get(longClick).getId());
                                longClickResult = userInput.getText().toString();
                                longClickToInt = Integer.parseInt(longClickResult);

                                try {
                                    db.addQuantity(medicineList.get(longClick), longClickToInt, medicineList.get(longClick).getName());
                                }catch(SQLException exp){}

                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                break;
        }
        return super.onContextItemSelected(item);
    }*/
    //****************************************************************************************************************


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            super(MedicineInventoryInterface.this, R.layout.medicine_item, medList);
            this.medList = medList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.medicine_item, parent, false);
            }

            Medicine currentMedicine = medList.get(position);

            TextView medName = (TextView) view.findViewById(R.id.medName);
            medName.setText(currentMedicine.getName());

            //TextView medMedicineId = (TextView) view.findViewById(R.id.medDrugId);
            //medMedicineId.setText(String.valueOf(currentMedicine.getId()));

            TextView medQuantity = (TextView) view.findViewById(R.id.medQuantity);
            medQuantity.setText(String.valueOf(currentMedicine.getQuantity()));

        //    TextView medVillageId = (TextView) view.findViewById(R.id.medVillageId);
          //  medVillageId.setText(currentMedicine.getVillageId());

            return view;
        }
    }
}