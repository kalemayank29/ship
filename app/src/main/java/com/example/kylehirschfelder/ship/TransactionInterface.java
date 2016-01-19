package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TransactionInterface extends AppCompatActivity {

    TransactionDBInterface transactionDbInterface;
    MedicineInventoryDBInterface medicineInventoryDbInterface;
    Button transactionBtn;
    ListView _lv;
    EditText _editQuant, expiryDate, expiryMonth, expiryYear;
    Spinner _spinner;
    TextView dateTransaction;
    List<Transaction> transactionList = new ArrayList<Transaction>();
    List<Transaction> addableTransaction;
    ArrayAdapter<Transaction> transactionAdapter;
    String date;
    String med_id = "1", village_id = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_interface);

        transactionBtn = (Button) findViewById(R.id.addTransaction);
        _lv = (ListView) findViewById(R.id.listView);
        _editQuant = (EditText) findViewById(R.id.editQuantity);
        transactionDbInterface = new TransactionDBInterface(getApplicationContext());
        medicineInventoryDbInterface = new MedicineInventoryDBInterface(getApplicationContext());
        _spinner = (Spinner) findViewById(R.id.spinner);
        dateTransaction = (TextView)findViewById(R.id.transactionDate);
        expiryDate = (EditText)findViewById(R.id.expiryDate);
        expiryMonth = (EditText)findViewById(R.id.expiryMonth);
        expiryYear = (EditText)findViewById(R.id.expiryYear);

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateTransaction.setText(sdf.format(d));



        // Spinner Dropdown elements
        try {
            //use DB to return a list of all the medicine names to populate the spinner
            List<String> labels = medicineInventoryDbInterface.getAllLabels();
            // Creating adapter for spinner and populating it with the new list "labels"
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, labels);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            _spinner.setAdapter(dataAdapter);

            //get the transactions to later populate the listview
           // addableTransaction = transactionDbInterface.getAllTransactions();
            //int count = addableTransaction.size();
            //for (int i = 0; i < count; i++) {
             //   transactionList.add(addableTransaction.get(i));
            //}

        }catch(SQLException exp){}

        transactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //about to do some insane interface wizardry so hold on tight
                    //also might not be the best way to do this
                    Log.println(Log.ASSERT, "", _spinner.getSelectedItem().toString());
                   // String med_id = medicineInventoryDbInterface.getIdFromMedicine(_spinner.getSelectedItem().toString());
                    String id = medicineInventoryDbInterface.getIdFromMedicine(_spinner.getSelectedItem().toString());
                    Log.println(Log.ASSERT, "id", id);
                    Medicine medicine = medicineInventoryDbInterface.getMedicineFromId(Integer.parseInt(id));
                  //  medicineInventoryDbInterface.addQuantity(medicine, Integer.parseInt(_editQuant.getText().toString()));

                    Log.println(Log.ASSERT, "", dateTransaction.getText().toString());
                    Log.println(Log.ASSERT, "", _editQuant.getText().toString());
                    Log.println(Log.ASSERT, "", String.valueOf(medicine.getQuantity()));
                    Log.println(Log.ASSERT, "", expiryDate.getText().toString());

                    String expiry = expiryDate.getText().toString() + "/"  + expiryMonth.getText().toString()
                            + "/" + expiryYear.getText().toString();

                    Transaction transaction = new Transaction(Integer.parseInt(village_id),
                            dateTransaction.getText().toString(), Integer.parseInt(medicine.getId()), Integer.parseInt(_editQuant.getText().toString()),
                             medicine.getQuantity() , expiry);

                    long id1 = transactionDbInterface.createTransaction(transaction);
                    if (id1 != -1) {
                        String msg = "व्यवहार यशस्वी ";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                        Log.println(Log.ASSERT, "TransID", String.valueOf(id1));
                        finish();
                        Intent intent = new Intent(getApplicationContext(), MedicineInventoryInterface.class);
                        startActivity(intent);
                    }
                    else{

                    }
                    //populate the transaction listView
                   // transactionList.add(transaction);
                   // populateList();
                    registerForContextMenu(_lv);

                }catch(SQLException exp){}
            }
        });
    }


    //Populates the _lv (list view) with the addable drugs from the db
    public void populateList() {
        transactionAdapter = new transactionListAdapter(this.transactionList);
        _lv.setAdapter(transactionAdapter);
        transactionAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transaction_interface, menu);
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


    private class transactionListAdapter extends ArrayAdapter<Transaction> {

        List<Transaction> transList;

        public transactionListAdapter(List<Transaction> transList) {
            super(TransactionInterface.this, R.layout.transaction_item, transList);
            this.transList = transList;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.transaction_item, parent, false);
            }

            Transaction currentTransaction = transList.get(position);

            TextView drugId = (TextView) findViewById(R.id.transactionMedDrugId);
            drugId.setText(String.valueOf(currentTransaction.getMedicine_id()));

            TextView villageId = (TextView) view.findViewById(R.id.transactionVillageId);
            villageId.setText(String.valueOf(currentTransaction.getVillage_id()));

            TextView change = (TextView) view.findViewById(R.id.transactionChange);
            change.setText(currentTransaction.getChange());

            TextView total = (TextView) view.findViewById(R.id.transactionMedQuantity);
            total.setText(String.valueOf(currentTransaction.getTotal()));

            TextView textDate = (TextView) view.findViewById(R.id.transactionDate);
            textDate.setText(date);

            return view;
        }
    }
}