package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CensusForm extends AppCompatActivity {
    Census census = new Census();
    EditText casteText, oldHouseText, pBusinessText, aBus1Text,aBus2Text, aBus3Text;
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
    String[] arraySpinner;
    String famId, flagCensus, flagFamily;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_form);



        flagCensus = getIntent().getStringExtra("flagCensus");
        flagFamily = getIntent().getStringExtra("flagFamily");

        casteText = (EditText) (findViewById(R.id.caste_et));
        religion_sp = (Spinner)findViewById(R.id.religion_sp);
        pBusinessText = (EditText) (findViewById(R.id.fhb1_et));
        aBus1Text = (EditText) (findViewById(R.id.fhb2_et));
        aBus2Text = (EditText) (findViewById(R.id.fhb3_et));
        aBus3Text = (EditText) (findViewById(R.id.fhb4_et));
        drylandAText = (EditText) (findViewById(R.id.dryacres_et));
        wetlandAText = (EditText) (findViewById(R.id.wetacres_et));

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

/*        ohid_et = (EditText) (findViewById(R.id.ohid_et));
        ofid_et = (EditText) (findViewById(R.id.ofid_et)); */

        this.arraySpinner = new String[] {
                "---",
                "हिंदू",
                "मुसलमान",
                "ख्रिश्चन",
                "शीख",
                "जैन",
                "बौद्ध"
        };
        religion_sp = (Spinner) findViewById(R.id.religion_sp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        religion_sp.setAdapter(adapter);
    }

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


    public void saveClick(View view) throws IOException {
        CF_DatabaseOperations DB = new CF_DatabaseOperations(context);
        // Translation TR = new Translation();
        String temp = "";

        int checkBoxFlag = 0;
        int flag = 0;

        /* Set CheckBox Strings */

        for (int i = 0; i < 5; i++) {
            if ( wall[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setWall(temp);
        temp = "";

        for (int i = 0; i < 6; i++) {
            if ( roof[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setRoof(temp);
        temp = "";

        for (int i = 0; i < 5; i++) {
            if ( cooking[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setCooking(temp);
        temp = "";

        for (int i = 0; i < 7; i++) {
            if ( water[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setWater(temp);
        temp = "";
        for (int i = 0; i < 15; i++) {
            if ( thing[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setThing(temp);
        temp = "";
        for (int i = 0; i < 8; i++) {
            if ( animals[i].isChecked())
                temp = temp + '1';
            else
                temp = temp + '0';
        }
        census.setAnimal(temp);


        // Log.println(Log.ASSERT, "LOG", census.getHouseID());
        census.setCaste(casteText.getText().toString());
        //Log.println(Log.ASSERT, "LOG", census.getCaste());
        census.setReligion(religion_sp.getSelectedItem().toString());
        census.setReligionParse(census.getReligion());
       // Log.println(Log.ASSERT, "LOG", census.getReligion());
        //census.setReligionParse(census.getReligion());
        //Log.println(Log.ASSERT, "LOG", );
        census.setpBusiness(pBusinessText.getText().toString());
        //Log.println(Log.ASSERT, "LOG", census.getpBusiness());
        census.setaBusiness1(aBus1Text.getText().toString());
        //Log.println(Log.ASSERT, "LOG", census.getaBusiness1());
        census.setaBusiness2(aBus2Text.getText().toString());
       // Log.println(Log.ASSERT, "LOG", census.getaBusiness2());
        census.setaBusiness3(aBus3Text.getText().toString());
       // Log.println(Log.ASSERT, "LOG", census.getaBusiness3());
        census.setDrylandA(drylandAText.getText().toString());
        //Log.println(Log.ASSERT, "LOG", census.getDrylandA());
    //    census.setDrylandG(drylandGText.getText().toString());
        //Log.println(Log.ASSERT, "LOG", census.getDrylandG());
        census.setWetlandA(wetlandAText.getText().toString());
      //  Log.println(Log.ASSERT, "LOG", census.getWetlandA());
      //  census.setWetlandG(wetlandGText.getText().toString());
       /* Log.println(Log.ASSERT, "LOG", census.getWetlandG());
        Log.println(Log.ASSERT, "LOG", census.getWall());
        Log.println(Log.ASSERT, "LOG", census.getRoof());
        Log.println(Log.ASSERT, "LOG", census.getElectricity());
        Log.println(Log.ASSERT, "LOG", census.getHouseOwner());
        Log.println(Log.ASSERT, "LOG", census.getToilet());
        Log.println(Log.ASSERT, "LOG", census.getToiletUse());
        Log.println(Log.ASSERT, "LOG", census.getCooking());
        Log.println(Log.ASSERT, "LOG", census.getKitchen());
        Log.println(Log.ASSERT, "LOG", census.getWater());
        Log.println(Log.ASSERT, "LOG", census.getThing());
        Log.println(Log.ASSERT, "LOG", census.getAnimal());

*/
        if (census.getCaste().isEmpty()) {
            flag = 1;
//             casteet = TR.Letter_M2E( casteet);
        }
        else if (census.getReligion().equals("---")) {
            flag = 1;
        }
        else if (census.getpBusiness().isEmpty()) {
            flag = 1;
        }
     /*   else if (census.getaBusiness1().isEmpty()) {
            flag = 1;
        }
        else if (census.getaBusiness2().isEmpty()) {
            flag = 1;
        }
        else if (census.getaBusiness3().isEmpty()) {
            flag = 1;
        }*/



    /*    else if (census.getDrylandA().isEmpty()) {
            flag = 1;
        }
        else if (census.getDrylandG().isEmpty()) {
            flag = 1;
        }
        else if (census.getWetlandA().isEmpty()) {
            flag = 1;
        }
        else if (census.getWetlandG().isEmpty()) {
            flag = 1;
        }

    */
        else if ((census.getWall().equals("00000"))) {
            flag = 1;
        }
        else if ((census.getRoof().equals("000000"))) {
            flag = 1;
        }
        else if ((census.getElectricity().isEmpty())) {
            flag = 1;
        }
        else if ((census.getHouseOwner().isEmpty())) {
            flag = 1;
        }
        else if ((census.getToilet().isEmpty())) {
            flag = 1;
        }
        else if ((census.getToiletUse().isEmpty())) {
            flag = 1;
        }
        else if((census.getCooking().equals("00000"))) {
            flag = 1;
        }
        else if ((census.getKitchen().isEmpty())) {
            flag = 1;
        }
        else if(census.getWater().equals("000000")) {
            flag = 1;
        }
        else if(census.getThing().equals("000000000000000")) {
            flag = 1;
        }
        else if(census.getAnimal().equals("00000000")) {
            flag = 1;
        }

        String sub = census.getAnimal().substring(0, 7);
        if(sub.contains("1") && census.getAnimal().charAt(7) == '1'){
            checkBoxFlag = 1;
        }
        sub = census.getThing().substring(0, 14);
        if(sub.contains("1") && census.getThing().charAt(14) == 1){
             checkBoxFlag = 1;
        }


      /*  List<NameValuePair> data = new ArrayList<NameValuePair>();
        data.add(new BasicNameValuePair("caste", census.getCaste()));
        data.add(new BasicNameValuePair("religion", census.getReligion()));
        data.add(new BasicNameValuePair("p_bus", census.getpBusiness()));
        data.add(new BasicNameValuePair("a_bus_1", census.getaBusiness1()));
        data.add(new BasicNameValuePair("a_bus_2", census.getaBusiness2()));
        data.add(new BasicNameValuePair("a_bus_3", census.getaBusiness3()));
        data.add(new BasicNameValuePair("dry_land_a", census.getDrylandA()));
        data.add(new BasicNameValuePair("dry_land_g", census.getDrylandG()));
        data.add(new BasicNameValuePair("wet_land_a", census.getWetlandA()));
        data.add(new BasicNameValuePair("wet_land_g", census.getWetlandG()));
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
        data.add(new BasicNameValuePair("old_house_id", "0"));

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/

        if(flag == 0) {
           // HttpClient httpClient = new DefaultHttpClient();
            //HttpPost httpPost = new HttpPost("http://192.168.1.237:8888/censusform/submit");
            //httpPost.setEntity(new UrlEncodedFormEntity(data));
            //HttpResponse response = httpClient.execute(httpPost);
            //Log.println(Log.ASSERT, "LOG", response.toString());
            if(checkBoxFlag == 0) {
                Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_SHORT).show();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());
                census.setDate(formattedDate);
                DB.insert(census, 0);

                Log.println(Log.ASSERT, "LOG", census.getWall());
                Log.println(Log.ASSERT, "LOGRELIGION", census.getReligion());
                Log.println(Log.ASSERT, "LOG", census.getRoof());
                Log.println(Log.ASSERT, "LOG", census.getElectricity());
                Log.println(Log.ASSERT, "LOG", census.getHouseOwner());
                Log.println(Log.ASSERT, "LOG", census.getToilet());
                Log.println(Log.ASSERT, "LOG", census.getToiletUse());
                Log.println(Log.ASSERT, "LOG", census.getCooking());
                Log.println(Log.ASSERT, "LOG", census.getKitchen());
                Log.println(Log.ASSERT, "LOG", census.getWater());
                Log.println(Log.ASSERT, "LOG", census.getThing());
                Log.println(Log.ASSERT, "LOG", census.getAnimal());

               /* Census element = DB.getRecent(0);
                Log.println(Log.ASSERT, "log", element.getHouseID());
                MemberDataInterface insertInterface = new MemberDataInterface(getApplicationContext());

                try {
                    Member insert = insertInterface.getMember(Integer.parseInt(famId), 0);
                    insert.setHouseId(Integer.parseInt(element.getHouseID()));
                    insertInterface.update(insert, insert.getMemberId(),0);

                } catch (SQLException e) {
                    e.printStackTrace();
                }*/

                finish();
                Intent intent = new Intent(getApplicationContext(), CensusFormPortal.class);
                intent.putExtra("flagFamily",flagFamily);
                intent.putExtra("flagCensus","1");
                startActivity(intent);
            }
            else
                displayCheckboxAlert();
        }

        else
            displayalert();

    }

    @Override
    public void onBackPressed(){
        displayBackAlert();
    }

    public void displayBackAlert() {
        Translation translation = new Translation();
        new AlertDialog.Builder(this)
                .setTitle(translation.Letter_E2M("nakkee baahera paDaayache aahe kaa") + "?")
                .setMessage(translation.Letter_E2M("sagaLee bharalelee maahitee vaayaa jaaeel"))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        finish();
                        Intent intent = new Intent(CensusForm.this, CensusFormPortal.class);
                        intent.putExtra("flagFamily",flagFamily);
                        intent.putExtra("flagCensus","0");
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

    public void displayalert() {
        new AlertDialog.Builder(this)
                .setTitle("अडचण")
                .setMessage("सर्व माहिती भरा")
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

    public void displayCheckboxAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Please uncheck the 'other' option")
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_census_form, menu);
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
