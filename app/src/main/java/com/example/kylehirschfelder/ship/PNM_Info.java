package com.example.kylehirschfelder.ship;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
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

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;


public class PNM_Info extends AppCompatActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    TextView diagTreat, diagnosis, treatment;
    EditText diag_edit, treat_edit;
    String ItemIndex;
    String severe_pneumonia, many_day_disease, pneumonia, wheezing, fever, dehydration, cold_cough, other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnm__info);

        mainListView = (ListView) findViewById( R.id.mainListView );
        diagTreat = (TextView)findViewById(R.id.diagnosis_treatment);

        diagnosis = (TextView)findViewById(R.id.diagnosis);
        treatment = (TextView)findViewById(R.id.treatment);
        diag_edit = (EditText)findViewById(R.id.diagnosis_editText);
        treat_edit = (EditText)findViewById(R.id.treatment_editText);
        // Create and populate a List of planet names.
        String[] disease = new String[] { "अ) गंभीर न्युमोनिया",
                "ब). जास्त दिवसांचा रोग",
                "क). न्युमोनिया","ड). व्हीज", "इ). ताप (१०० डिग्री. फॅ किवा जास्त)",
                "फ).डिहायड्रेशन", "त). सर्दी / साधा खोकला ", "थ). इतर रोग लिहा :"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(disease) );

        diagnosis.setVisibility(View.GONE);
        treatment.setVisibility(View.GONE);
        diag_edit.setVisibility(View.GONE);
        treat_edit.setVisibility(View.GONE);

        severe_pneumonia ="अ) गंभीर न्युमोनिया"+
                "निदान :\n" +
                "खालील पैकी कोणतेही एक किवा जास्त लक्षणे असल्यास\n" +
                "- दुध ओढणे / पिणे बंद\n" +
                "- बेशुद्धी / खुप गुंगी\n" +
                "- फिट / दाटी\n" +
                "- मध्ये मध्ये श्वास थांबतो\n" +
                "- छाती बलकुशा खुप आत ओढतात\n" +
                "- स्ट्रायडर (शांत मुलात)\n" +
                "- अपुर्या महिन्याच्या नवजात मुलाला न्युमोनिया\n" +
                "        उपचार :\n" +
                "        कोट्राचा डोस देऊन ताबडतोब\n" +
                "हॉस्पिटल मध्ये पाठवा\n" +
                "नेले / नेले नाही\n" +
                "कुठे?\n" +
                "कोणाकडे?\n" +
                "काय परिणाम?\n" +
                "हॉस्पिटल मध्ये न नेल्यास कोट्राचे\n" +
                "औषध सुरु ठेवा";

        many_day_disease ="ब). जास्त दिवसांचा रोग" +
                "निदान  : \n" +
                "(खालील पैकी कोणतेही एक किवा जास्त लक्षणे असल्यास)\n" +
                "- फार कुपोषित \n" +
                "- वारंवार लहाक \n" +
                "- खोकला ३० दिवसांहून जास्त \n" +
                "\n" +
                "उपचार  :\n" +
                "डॉक्टरकडे तपासणीला पाठवा.\n" +
                "(सोबत न्युमोनिया असल्यास कोट्रा सुरु करा)\n" +
                "नेले / नेले नाही?\n" +
                "कुठे?\n" +
                "कोणाकडे?\n" +
                "काय परिणाम?";
        pneumonia = "क). न्युमोनिया"+
                "निदान :\n" +
                "१). वाढलेला श्वास \n" +
                "१ - २ महिने वय - श्वास ६० किवा जास्त दोन वेळ मोजले असताना \n" +
                "२ - १२ महिने वय - श्वास ५० किवा जास्त + खोकला \n" +
                "१ - ५ वर्ष वय - श्वास ४० किवा जास्त + खोकला \n" +
                "\n" +
                "उपचार  : \n" +
                "कोट्रा औषध \n" +
                "\n" +
                "० ते ६ महिने - १/२ बुच / चमचा \n" +
                "सकाळ संध्याकाळ - ७ दिवस \n" +
                "\n" +
                "६ महिने ते ५ वर्ष - १ बुच / चमचा \n" +
                "सकाळ संध्याकाळ - ५ दिवस";
        wheezing ="ड). व्हीज"+
                "उपचार :\n" +
                "सालब्यूटामॉल (४ मि. ग्रॅ)\n" +
                "१ वर्षाखालील - १ / ८ गोळी स. दु. सं.\n" +
                "१ ते ५ वर्ष - १ / ४ गोळी स. दु. सं";
        fever = "इ). ताप (१०० डिग्री. फॅ किवा जास्त)\n" +
                "उपचार  : \n" +
                "पॅरासिटमॉल गोळी \n" +
                "१ वर्षाखालील - १ / ८ गोळी स. दु. सं.\n" +
                "१ ते ५ वर्ष - १ / ४ गोळी स. दु. सं. \n";
        dehydration = "फ). डिहायड्रेशन \n" +
                "निदान  :\n" +
                "- डोळे खोल गेले, जीभ कोरडी पडली\n" +
                "चामडीवर वळ टिकून राहते, लघवी कमी \n" +
                "उपचार : \n" +
                "सल्ला  - \n" +
                "ओ. आर. एस / दूध / आंबील ";
        cold_cough = "त). सर्दी / साधा खोकला \n" +
                "उपचार : \n" +
                "- सल्ला - इंजेक्शन / औषध नको, लहाक लागल्यास लवकर परत आणा.\n" +
                "खाणे पिणे सुरु ठेवा.\n" +
                "घरगुती इलाज (तुळस, अदरकचा रस) ताप असल्यास पॅरासिटमॉल द्य";

        diagTreat.setText(severe_pneumonia);

        // Create ArrayAdapter using the planet list.

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                // ItemIndex = position;
                //diagTreat.setText(severe_pneumonia);
                diagTreat.setVisibility(View.VISIBLE);
                diagnosis.setVisibility(View.GONE);
                treatment.setVisibility(View.GONE);
                diag_edit.setVisibility(View.GONE);
                treat_edit.setVisibility(View.GONE);

                ItemIndex = Integer.toString(position);
                switch (ItemIndex) {
                    case "0":
                        diagTreat.setText(severe_pneumonia);
                        break;
                    case "1":
                        diagTreat.setText(many_day_disease);
                        break;
                    case "2":
                        diagTreat.setText(pneumonia);
                        break;
                    case "3":
                        diagTreat.setText(wheezing);
                        break;
                    case "4":
                        diagTreat.setText(fever);
                        break;
                    case "5":
                        diagTreat.setText(dehydration);
                        break;
                    case "6":
                        diagTreat.setText(cold_cough);
                        break;
                    case "7":
                        diagTreat.setText("");
                        diagTreat.setVisibility(View.GONE);
                        diagnosis.setVisibility(View.VISIBLE);
                        treatment.setVisibility(View.VISIBLE);
                        diag_edit.setVisibility(View.VISIBLE);
                        treat_edit.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });


        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
      /*  listAdapter.add( "Ceres" );
        listAdapter.add( "Pluto" );
        listAdapter.add( "Haumea" );
        listAdapter.add( "Makemake" );
        listAdapter.add( "Eris" );
*/
        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birth_family_list_view, menu);
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

