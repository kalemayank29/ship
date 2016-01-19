package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PrescriptionInterface extends AppCompatActivity {

    EditText _editMemberId, _editFamilyId, _editDoseDays, _editDoseQuant;
    Button _prescribeBtn;
    Spinner _idSpinner;
    PrescriptionsDBInterface dbInterface;
    MedicineInventoryDBInterface medicineDbInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_interface);

        dbInterface = new PrescriptionsDBInterface(getApplicationContext());
        medicineDbInterface = new MedicineInventoryDBInterface(getApplicationContext());

      //  _editMemberId = (EditText) findViewById(R.id.editMemberId);
        //_editFamilyId = (EditText) findViewById(R.id.editFamilyId);
        _editDoseDays = (EditText) findViewById(R.id.editDoseDays);
        _editDoseQuant = (EditText) findViewById(R.id.editDoseQuantity);
        _prescribeBtn = (Button) findViewById(R.id.prescribeMedicine);
        _idSpinner = (Spinner) findViewById(R.id.spinner);


        // Spinner Dropdown elements
        try {
            //use DB to return a list of all the medicine names to populate the spinner
            List<String> labels = medicineDbInterface.getAllLabels();
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, labels);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            _idSpinner.setAdapter(dataAdapter);
        }catch(SQLException exp){}

        _prescribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //get the current system date
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String date = df.format(c.getTime());

                    int familyId = 1,memberId = 1;

                    //Sets string variables to the user entered text fields
//                    int memberId = Integer.parseInt(_editMemberId.getText().toString());
  //                  int familyId = Integer.parseInt(_editFamilyId.getText().toString());
                    //Log.println(Log.ASSERT, "", _idSpinner.getSelectedItem().toString());
                    //pass in selected item to getIdFromMedicine to retrieve the ID associated with that name
                    int medicineId = Integer.parseInt(medicineDbInterface.getIdFromMedicine(_idSpinner.getSelectedItem().toString()));

                    int doseDays = Integer.parseInt(_editDoseDays.getText().toString());
                    int doseQuant = Integer.parseInt(_editDoseQuant.getText().toString());

                    if (date.equals("") || memberId == 0 || familyId == 0 || medicineId == 0 || doseDays == 0 ||
                            doseQuant == 0) {
                        Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Prescription prescription = new Prescription(0, date,
                                memberId, familyId, medicineId, doseDays, doseQuant);
                        //need to add prescriptions to transaction list
                        long ret = dbInterface.insertPrescription(prescription,getApplicationContext());
                        Log.println(Log.ASSERT, "presID", String.valueOf(ret));
                        if(ret != 0){
                            String msg = "Prescription has been entered";
                            finish();
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MedicineInventoryInterface.class);
                        }

                    }
                } catch (SQLException exp) {}
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prescription_interface, menu);
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