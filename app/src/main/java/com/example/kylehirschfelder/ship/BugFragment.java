package com.example.kylehirschfelder.ship;

import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BugFragment extends Fragment {
    View myView;
    EditText etUser, etBug;
    Spinner etSpinCat, etSpinImport;
    Button bugButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_bug, container,false);

        //Links variables to their ids

        etUser = (EditText) myView.findViewById(R.id.editName);
        etBug = (EditText) myView.findViewById(R.id.editBug);
        etSpinCat = (Spinner) myView.findViewById(R.id.catSpin);
        etSpinImport = (Spinner) myView.findViewById(R.id.impSpin);
        bugButton = (Button)myView.findViewById(R.id.bugButton);

        //Links spinners to their adapters
        ArrayAdapter adapterCat = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.category, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterImport = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.importance, android.R.layout.simple_spinner_dropdown_item);
        etSpinImport.setAdapter(adapterImport);
        etSpinCat.setAdapter(adapterCat);


        bugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Gets the current date
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = df.format(c.getTime());

                //Gets all the text entered by the user and populates the String variables
                String user = etUser.getText().toString();
                String bug = etBug.getText().toString();
                String cat = etSpinCat.getSelectedItem().toString();
                String spinImport = etSpinImport.getSelectedItem().toString();


                //Populates a NameValuePair list with the user entered data
                List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>(1);
                NameValuePairs.add(new BasicNameValuePair("user", user));
                NameValuePairs.add(new BasicNameValuePair("bug", bug));
                NameValuePairs.add(new BasicNameValuePair("category", cat));
                NameValuePairs.add(new BasicNameValuePair("importance", spinImport));
                NameValuePairs.add(new BasicNameValuePair("date", newDate));

                //Checks if the user has left any fields null
                if(user.equals("") || bug.equals("")){
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please enter all fields", Toast.LENGTH_LONG).show();
                    return;
                }
                /*
                //Creates a string of the website to route the HTTP through
                String url = "http://45.55.84.23/bugs/submit";
                HTTPHandler newHttp = new HTTPHandler(url, NameValuePairs);
                //If there is no exception thrown, the bug will be submitted to the database,
                //otherwise there will be an error shown on the screen
                if(newHttp.requestHTTP()){
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Your bug has been submitted", Toast.LENGTH_LONG).show();
                    etUser.setText("");
                    etBug.setText("");
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "There has been an error submitting your bug", Toast.LENGTH_LONG).show();
                }
                */
            }
        });
        return myView;
    }
}
