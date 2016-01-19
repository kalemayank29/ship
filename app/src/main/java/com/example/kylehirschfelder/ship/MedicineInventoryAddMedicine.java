package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineInventoryAddMedicine extends AppCompatActivity {

    Button _confirmBtn;
    TextView DateMedicine;
    EditText _editMedicineId, _editName, expDate;
    MedicineInventoryDBInterface db;
    TransactionDBInterface transactionDb;
    List<Medicine> medicineList = new ArrayList<Medicine>();
    List<Transaction> transactionList = new ArrayList<Transaction>();
    String medicine_id = "", village_id = "";

    //auto initialize quantity
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beta_medicine_inventory_add_medicine);

        db = new MedicineInventoryDBInterface(getApplicationContext());
        transactionDb = new TransactionDBInterface(getApplicationContext());
  //      _editMedicineId = (EditText) findViewById(R.id.editMedicineId);
        _editName = (EditText) findViewById(R.id.editName);
     //   _editQuantity = (EditText) findViewById(R.id.editQuantity);
    //    _editVillageId = (EditText) findViewById(R.id.editVillageId);
      //  expDate = (EditText) findViewById(R.id.);
        _confirmBtn = (Button) findViewById(R.id.confirmBtn);



        _confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sets string variables to the user entered text fields
           //     String medicine_id = _editMedicineId.getText().toString();
                String name = _editName.getText().toString();
             //   quantity = Integer.parseInt(_editQuantity.getText().toString());
           //     String village_id = _editVillageId.getText().toString();
             //   String expDate = _editExpDate.getText().toString();

                //Case handling if user has failed to enter every field
                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_LONG).show();
                    return;

                } else {
                    if (!name.equals("")) {


                        //Make a new medicine object and insert the fields from the form
                        Medicine medicineObj = new Medicine(medicine_id, name);

                        try {
                            //add a new medicine object to the database
                            db.createMedicine(medicineObj);

                            //update the quantity of medicine to add
                            //db.addQuantity(medicineObj, quantity);

                            //create a transaction using the new medicine and quantity recently entered
                       /*     Transaction transaction = new Transaction(Integer.parseInt(village_id),
                                    DateMedicine, Integer.parseInt(medicine_id), quantity);

                            //Add that transaction to the list
                            transactionDb.createTransaction(transaction);
                            transactionList.add(transaction);*/
                            String msg = name + " has been added to the inventory";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MedicineInventoryInterface.class);
                            startActivity(intent);
                        } catch (SQLException exp) {}
                        medicineList.add(medicineObj);

                        //Clear the text fields
//                        _editMedicineId.setText("");
                        _editName.setText("");
                 /*       _editQuantity.setText("");
                        _editVillageId.setText("");
                        _editExpDate.setText("");*/
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beta_medicine_inventory_add_medicine, menu);
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