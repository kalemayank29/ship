package com.example.kylehirschfelder.ship;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CensusViewForm extends AppCompatActivity {

    public enum RadioCheck {
        ELECTRICITY(0), HOUSE(1), TOILET(2), TOILET_USE(3), KITCHEN(4), WALL(5), ROOF(6), COOKING(7), WATER(8), THING(9), ANIMALS(10);
        private final int id;
        RadioCheck(int id) { this.id = id; }
        public int getValue() { return id; }
    }
    Census census = new Census();
    EditText houseIDText, casteText, oldHouseText, pBusinessText, aBus1Text,aBus2Text, aBus3Text;
    //  EditText pBusiness = new EditText, jameen_et = new EditText[4];
    EditText drylandAText,drylandGText, wetlandAText, wetlandGText;
    RadioButton electricity[] = new RadioButton[2],
            house[] = new RadioButton[2],
            toilet[] = new RadioButton[2],
            toiletUse[] = new RadioButton[2],
            kitchen[] = new RadioButton[2];
    CheckBox wall[] = new CheckBox[5],
            roof[] = new CheckBox[6],
            cooking[] = new CheckBox[5],
            water[] = new CheckBox[7],
            thing[] = new CheckBox[15],
            animals[] = new CheckBox[8];



    Spinner religion_sp;
    Button submit;
    String[] arraySpinner, getStrings;
    Context context = this;
    int selector = 1;
    private int flag = 0;
    String religionString = "", wallString = "", roofString = "", cookingString = "",
            waterString ="", thingString = "", animalString = "", flagCensus, flagFamily;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_form);

        getStrings = getIntent().getStringArrayExtra("radio_check");

        // flagCensus = getIntent().getStringExtra("flagCensus");
       // flagFamily = getIntent().getStringExtra("flagFamily");
      // houseId =  getIntent().getStringExtra("index");

        casteText = (EditText) (findViewById(R.id.caste_et));
        religion_sp = (Spinner)findViewById(R.id.religion_sp);
        pBusinessText = (EditText) (findViewById(R.id.fhb1_et));
        aBus1Text = (EditText) (findViewById(R.id.fhb2_et));
        aBus2Text = (EditText) (findViewById(R.id.fhb3_et));
        aBus3Text = (EditText) (findViewById(R.id.fhb4_et));
        drylandAText = (EditText) (findViewById(R.id.dryacres_et));
        wetlandAText = (EditText) (findViewById(R.id.wetacres_et));

        Log.println(Log.ASSERT, "log", Boolean.toString(casteText.isEnabled()));


        getStrings = getIntent().getStringArrayExtra("radio_check");



        wall[0] = (CheckBox)findViewById(R.id.cement);
        wall[1] = (CheckBox)findViewById(R.id.brick);
        wall[2] = (CheckBox)findViewById(R.id.mud);
        wall[3] = (CheckBox)findViewById(R.id.kud);
        wall[4] = (CheckBox)findViewById(R.id.otherwall);

        roof[0] = (CheckBox)findViewById(R.id.cementslab);
        roof[1] = (CheckBox)findViewById(R.id.mangalore);
        roof[2] = (CheckBox)findViewById(R.id.normal);
        roof[3] = (CheckBox)findViewById(R.id.tin);
        roof[4] = (CheckBox)findViewById(R.id.grass);
        roof[5] = (CheckBox)findViewById(R.id.otherroof);

        electricity[0] = (RadioButton)findViewById(R.id.yes);
        electricity[1] = (RadioButton)findViewById(R.id.no);

        house[0] = (RadioButton)findViewById(R.id.owner);
        house[1] = (RadioButton)findViewById(R.id.renter);


        toilet[0] = (RadioButton)findViewById(R.id.yes_w);
        toilet[1] = (RadioButton)findViewById(R.id.no_w);

        toiletUse[0] = (RadioButton)findViewById(R.id.yes2_w);
        toiletUse[1] = (RadioButton)findViewById(R.id.no2_w);


        cooking[0] = (CheckBox)findViewById(R.id.stove);
        cooking[1] = (CheckBox)findViewById(R.id.gas);
        cooking[2] = (CheckBox)findViewById(R.id.rockel);
        cooking[3] = (CheckBox)findViewById(R.id.wood);
        cooking[4] = (CheckBox)findViewById(R.id.othercook);

        kitchen[0] = (RadioButton)findViewById(R.id.yes_r);
        kitchen[1] = (RadioButton)findViewById(R.id.no_r);


        water[0] = (CheckBox)findViewById(R.id.well);
        water[1] = (CheckBox)findViewById(R.id.hpump);
        water[2] = (CheckBox)findViewById(R.id.tap);
        water[3] = (CheckBox)findViewById(R.id.lake);
        water[4] = (CheckBox)findViewById(R.id.river);
        water[5] = (CheckBox)findViewById(R.id.naala);
        water[6] = (CheckBox)findViewById(R.id.otherwise);

        thing[0] = (CheckBox)findViewById(R.id.fourwheel);
        thing[1] = (CheckBox)findViewById(R.id.twowheel);
        thing[2] = (CheckBox)findViewById(R.id.tvcolor);
        thing[3] = (CheckBox)findViewById(R.id.tvbw);
        thing[4] = (CheckBox)findViewById(R.id.cycle);
        thing[5] = (CheckBox)findViewById(R.id.wallclock);
        thing[6] = (CheckBox)findViewById(R.id.wristwatch);
        thing[7] = (CheckBox)findViewById(R.id.radiotape);
        thing[8] = (CheckBox)findViewById(R.id.newspaper);
        thing[9] = (CheckBox)findViewById(R.id.phone);
        thing[10] = (CheckBox)findViewById(R.id.mobile);
        thing[11] = (CheckBox)findViewById(R.id.freeze);
        thing[12] = (CheckBox)findViewById(R.id.fancooler);
        thing[13] = (CheckBox)findViewById(R.id.bailbandi);
        thing[14] = (CheckBox)findViewById(R.id.nota2);

        animals[0] = (CheckBox)findViewById(R.id.cow);
        animals[1] = (CheckBox)findViewById(R.id.bull);
        animals[2] = (CheckBox)findViewById(R.id.mhais);
        animals[3] = (CheckBox)findViewById(R.id.bakri);
        animals[4] = (CheckBox)findViewById(R.id.kkb);
        animals[5] = (CheckBox)findViewById(R.id.horse);
        animals[6] = (CheckBox)findViewById(R.id.pig);
        animals[7] = (CheckBox)findViewById(R.id.nota3);

        submit = (Button)findViewById(R.id.save);

        /*

        Parse.parseString(2, getStrings[RadioCheck.ELECTRICITY.getValue()]);
        Parse.parseString(2, getStrings[RadioCheck.HOUSE.getValue()]);
        Parse.parseString(2, getStrings[RadioCheck.TOILET.getValue()]);
        Parse.parseString(2, getStrings[RadioCheck.TOILET_USE.getValue()]);
        Parse.parseString(2, getStrings[RadioCheck.KITCHEN.getValue()]);
        wallString = Parse.parseString(5, getStrings[RadioCheck.WALL.getValue()]);
        roofString = Parse.parseString(6, getStrings[RadioCheck.ROOF.getValue()]);
        cookingString = Parse.parseString(5, getStrings[RadioCheck.COOKING.getValue()]);
        waterString = Parse.parseString(7, getStrings[RadioCheck.WATER.getValue()]);
        thingString = Parse.parseString(15, getStrings[RadioCheck.THING.getValue()]);
        animalString = Parse.parseString(8, getStrings[RadioCheck.ANIMALS.getValue()]);

        */


        int status = Integer.parseInt(getIntent().getStringExtra("index"));
        Log.println(Log.ASSERT,"Status",String.valueOf(status));

        CF_DatabaseOperations dop = new CF_DatabaseOperations(context);

        census = dop.getInfo(status,1);

        dop.getAll();


//        Log.println(Log.ASSERT,"houseid",census.getHouseID());
        // houseIDText = (EditText) findViewById(R.id.houseText)
        // houseIDText.setHint(census.getHouseID());
        casteText.setHint(census.getCaste());
        //Log.println(Log.ASSERT,"caste",census.getCaste());

        Log.println(Log.ASSERT,"rel",census.getReligion());
        religionString = set_religion_Hint(census.getReligion());

        pBusinessText.setHint(census.getpBusiness());
        aBus1Text.setHint(census.getaBusiness1());
        aBus2Text.setHint(census.getaBusiness2());
        aBus3Text.setHint(census.getaBusiness3());
        drylandAText.setHint(census.getDrylandA());
        //drylandGText.setHint(census.getDrylandG());
        wetlandAText.setHint(census.getWetlandA());
        // wetlandGText.setHint(census.getWetlandG());
        wallString = set_wall_Hint(census.getWall());
        roofString = set_roof_Hint(census.getRoof());
        set_electricity_Hint(census.getElectricity());
        set_house_Hint(census.getHouseOwner());
        set_toilet_Hint(census.getToilet());
        set_toiletUse_Hint(census.getToiletUse());
        cookingString = set_cooking_Hint(census.getCooking());
        set_kitchen_Hint(census.getKitchen());
        waterString = set_water_Hint(census.getWater());
        thingString = set_thing_Hint(census.getThing());
        animalString = set_animals_Hint(census.getAnimal());
    }


    public void set_electricity_Hint(String string){
        switch(string){
            case "1":
                electricity[0].setChecked(true);
                break;
            case "0":
                electricity[1].setChecked(true);
                break;
        }
    }
    public void set_house_Hint(String string){
        switch(string){
            case "1":
                house[0].setChecked(true);
                break;
            case "0":
                house[1].setChecked(true);
                break;
        }
    }
    public void set_toilet_Hint(String string){
        switch(string){
            case "1":
                toilet[0].setChecked(true);
                break;
            case "0":
                toilet[1].setChecked(true);
                break;
        }
    }
    public void set_toiletUse_Hint(String string){
        switch(string){
            case "1":
                toiletUse[0].setChecked(true);
                break;
            case "0":
                toiletUse[1].setChecked(true);
                break;
        }
    }
    public void set_kitchen_Hint(String string){
        switch(string){
            case "1":
                kitchen[0].setChecked(true);
                break;
            case "0":
                kitchen[1].setChecked(true);
                break;
        }
    }

    public String set_religion_Hint(String string) {
      /*  Variables v = new Variables();
        Translation TR = new Translation();*/
        this.arraySpinner = new String[] {
                "---",
                "हिंदू",
                "मुसलमान",
                "ख्रिश्चन",
                "शीख",
                "जैन",
                "बौद्ध"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);

        religion_sp.setAdapter(adapter);
        switch(string){
//            case "हिंदू":
            case "1":
                // adapter.add(arraySpinner[1]);
                religion_sp.setSelection(1);
                break;
            //case "मुसलमान":
            case "2":
                // adapter.add(arraySpinner[2]);
                religion_sp.setSelection(2);
                break;
            //case "ख्रिश्चन":
            case "4":
                //adapter.add(arraySpinner[3]);
                religion_sp.setSelection(3);
                break;
            //case "शीख":
            case "8":
                //adapter.add(arraySpinner[4]);
                religion_sp.setSelection(4);
                break;
            //case "जैन":
            case "16":
                //adapter.add(arraySpinner[5]);
                religion_sp.setSelection(5);
                break;
            //case "बौद्ध":
            case "32":
                // adapter.add(arraySpinner[6]);
                religion_sp.setSelection(6);
                break;
            default:
                //  adapter.add(arraySpinner[0]);
                religion_sp.setSelection(0);
                break;
        }
        return string;
    }

    public String set_wall_Hint(String string){
        char ch[] = new char[5];
        for(int i = 0; i < 5; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                wall[i].setChecked(true);
            else
                wall[i].setChecked(false);

        }
        return string;
    }
    public String set_roof_Hint(String string){
        char ch[] = new char[6];
        for(int i = 0; i < 6; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                roof[i].setChecked(true);
            else
                roof[i].setChecked(false);

        }
        return string;
    }
    public String set_cooking_Hint(String string){
        char ch[] = new char[5];
        for(int i = 0; i < 5; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                cooking[i].setChecked(true);
            else
                cooking[i].setChecked(false);

        }
        return string;
    }
    public String set_water_Hint(String string){
        char ch[] = new char[7];
        for(int i = 0; i < 7; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                water[i].setChecked(true);
            else
                water[i].setChecked(false);
        }
        return string;
    }
    public String set_thing_Hint(String string){
        char ch[] = new char[15];
        for(int i = 0; i < 15; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                thing[i].setChecked(true);
            else
                thing[i].setChecked(false);

        }
        return string;
    }
    public String set_animals_Hint(String string){
        char ch[] = new char[8];
        for(int i = 0; i < 8; i++) {
            ch[i] = string.charAt(i);
            if(ch[i] == '1')
                animals[i].setChecked(true);
            else
                animals[i].setChecked(false);

        }
        return string;
    }


    public void saveClick(View view) throws IOException{
        flag = 0;
        CF_DatabaseOperations DB = new CF_DatabaseOperations(context);

        census.setCaste(casteText.getText().toString());
        census.setReligionParse(religion_sp.getSelectedItem().toString());
        census.setpBusiness(pBusinessText.getText().toString());
        census.setaBusiness1(aBus1Text.getText().toString());
        census.setaBusiness2(aBus2Text.getText().toString());
        census.setaBusiness3(aBus3Text.getText().toString());
        census.setDrylandA(drylandAText.getText().toString());
        //     census.setDrylandG(drylandGText.getText().toString());
        census.setWetlandA(wetlandAText.getText().toString());
        //   census.setWetlandG(wetlandGText.getText().toString());



        if (census.getCaste().isEmpty())
            census.setCaste(casteText.getHint().toString());

        if ((census.getReligion().equals("---"))){
            census.setReligion(religionString);
        }
        if (census.getpBusiness().isEmpty())
            census.setpBusiness(pBusinessText.getHint().toString());
        if (census.getaBusiness1().isEmpty())
            census.setaBusiness1(aBus1Text.getHint().toString());
        if (census.getaBusiness2().isEmpty())
            census.setaBusiness2(aBus2Text.getHint().toString());
        if (census.getaBusiness3().isEmpty())
            census.setaBusiness3(aBus3Text.getHint().toString());

        if (census.getDrylandA().isEmpty())
            census.setDrylandA(drylandAText.getHint().toString());
        //     if (census.getDrylandG().isEmpty())
        //       census.setDrylandG(drylandGText.getHint().toString());
        if (census.getWetlandA().isEmpty())
            census.setWetlandA(wetlandAText.getHint().toString());
        //      if (census.getWetlandG().isEmpty())
        //        census.setWetlandG(wetlandGText.getHint().toString());



        String temp = "";
        for (int i = 0; i < 5; i++) {
            if (wall[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("00000"))
            set_wall_Hint(wallString);
        else
            census.setWall(temp);


        temp = "";
        for (int i = 0; i < 6; i++) {
            if (roof[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("000000"))
            set_roof_Hint(roofString);
        else
            census.setRoof(temp);

        temp = "";
        for (int i = 0; i < 5; i++) {
            if (cooking[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("00000"))
            set_cooking_Hint(cookingString);
        else
            census.setCooking(temp);

        temp = "";
        for (int i = 0; i < 7; i++) {
            if (water[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("0000000"))
            set_water_Hint(waterString);
        else
            census.setWater(temp);


        temp = "";
        for (int i = 0; i < 15; i++) {
            if (thing[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("000000000000000"))
            set_thing_Hint(thingString);
        else
            census.setThing(temp);



        temp = "";
        for (int i = 0; i < 8; i++) {
            if (animals[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        if(temp.equals("00000000"))
            set_animals_Hint(animalString);
        else
            census.setAnimal(temp);



        String sub = census.getAnimal().substring(0, 7);
        if(sub.contains("1") && census.getAnimal().charAt(7) == '1'){
            flag = 1;
        }
        sub = census.getThing().substring(0, 14);
        if(sub.contains("1") && census.getThing().charAt(14) == '1'){
            flag = 1;
        }


/*
        List<NameValuePair> data = new ArrayList<NameValuePair>();
        data.add(new BasicNameValuePair("caste", census.getCaste()));
        data.add(new BasicNameValuePair("religion", census.getReligion()));
        data.add(new BasicNameValuePair("p_bus", census.getpBusiness()));
        data.add(new BasicNameValuePair("a_bus_1", census.getaBusiness1()));
        data.add(new BasicNameValuePair("a_bus_2", census.getaBusiness2()));
        data.add(new BasicNameValuePair("a_bus_3", census.getaBusiness3()));
        data.add(new BasicNameValuePair("dry_land_a", census.getDrylandA()));
       // data.add(new BasicNameValuePair("dry_land_g", census.getDrylandG()));
        data.add(new BasicNameValuePair("wet_land_a", census.getWetlandA()));
        //data.add(new BasicNameValuePair("wet_land_g", census.getWetlandG()));
        data.add(new BasicNameValuePair("wall", census.getWall()));
        data.add(new BasicNameValuePair("roof", census.getRoof()));
        data.add(new BasicNameValuePair("electricity", census.getElectricity()));
        data.add(new BasicNameValuePair("house_owner", census.getHouseOwner()));
        data.add(new BasicNameValuePair("toilet", census.getToilet()));
        data.add(new BasicNameValuePair("toilet_use", census.getToiletUse()));
        data.add(new BasicNameValuePair("cooking", census.getCooking()));
        data.add(new BasicNameValuePair("kitchen", census.getKitchen()));
        data.add(new BasicNameValuePair("water", census.getWater()));
        data.add(new BasicNameValuePair("thing", census.getThing()));
        data.add(new BasicNameValuePair("animal", census.getAnimal()));
        data.add(new BasicNameValuePair("date", "0"));
        data.add(new BasicNameValuePair("thing", "0"));

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/

        if(flag == 0) {
           /* HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://192.168.1.237:8888/censusform/submit");
            httpPost.setEntity(new UrlEncodedFormEntity(data));
            HttpResponse response = httpClient.execute(httpPost);
            Log.println(Log.ASSERT, "LOG", response.toString());*/
          //  DB.updateUser(census, selector);
            Toast.makeText(getBaseContext(), "Form Resubmitted", Toast.LENGTH_LONG).show();
            finish();
            Intent intent = new Intent(CensusViewForm.this, FormFragment.class);
            intent.putExtra("flagFamily",flagFamily);
            intent.putExtra("flagCensus",flagCensus);
            startActivity(intent);
        }
        else
            displayCheckboxAlert();
    }




    /*-------------------------------------------------------func start--------------------*/
    public void radioClick(View view) {
        String tag = (String) view.getTag();
        switch(tag) {
            case "yes":
                electricity[1].setChecked(false);
                census.setElectricity("1");
                break;
            case "no":
                electricity[0].setChecked(false);
                census.setElectricity("0");
                break;
            case "owner":
                house[1].setChecked(false);
                census.setHouseOwner("1");
                break;
            case "renter":
                house[0].setChecked(false);
                census.setHouseOwner("0");
                break;
            case "yes_w":
                toilet[1].setChecked(false);
                census.setToilet("1");
                break;
            case "no_w":
                toilet[0].setChecked(false);
                census.setToilet("0");
                break;
            case "yes2_w":
                if(toilet[1].isChecked()) {
                    toiletUse[0].setChecked(false);
                    toiletUse[1].setChecked(true);
                    census.setToiletUse("0");
                }
                else {
                    census.setToiletUse("1");
                    toiletUse[1].setChecked(false);
                }
                break;
            case "no2_w":
                toiletUse[0].setChecked(false);
                census.setToiletUse("0");

                break;
            case "yes_r":
                kitchen[1].setChecked(false);
                census.setKitchen("1");
                break;
            case "no_r":
                kitchen[0].setChecked(false);
                census.setKitchen("0");
                break;
            default:
                break;
        }
    }


    /*--------------------------------------------------------------functions end*/


    public void displayCheckboxAlert(){
        new AlertDialog.Builder(this)
                .setTitle("अडचण")
                .setMessage("कृपया 'अन्य' को अनचेक कीजीये")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void onBackPressed(){
        displayBackAlert();
    }

    public void displayBackAlert() {
        Translation translation = new Translation();
        new AlertDialog.Builder(this)
                //.setTitle("नक्की बाहेर पडायचे आहे का?")
                //.setMessage("सगळी भरलेली माहिती वाया जाईल ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        finish();
                        Intent intent = new Intent(CensusViewForm.this, MainActivity.class);
                       // intent.putExtra("flagFamily",flagFamily);
                        //intent.putExtra("flagCensus",flagCensus);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cf__view_form, menu);
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