package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DrugInfoFragment extends Fragment {

    ListView lv;
    Button moreBtn;
    int click;
    TextView genericName, brandName, formula, drugClass, color, shape;
    DrugDBHandler db;
    Drug aspirin, androgel, acetoaminophen, result;

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_druginfo, container, false);

        db = new DrugDBHandler(getActivity().getApplicationContext());
        List<Drug> temp;

        //getApplicationContext().deleteDatabase("drugManager");
        //getApplicationContext().deleteDatabase("drugManager1");

        aspirin = new Drug(0, "Aspirin", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");
        acetoaminophen = new Drug(0, "Acetoaminophen", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");
        androgel = new Drug(0, "Androgel", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");

        db.createDrug(acetoaminophen);
        db.createDrug(aspirin);
        db.createDrug(androgel);

        temp = db.getAllDrugs();
        for (int i = 0; i < temp.size(); i++) {
            Log.e("NAME: ", String.valueOf(temp.get(i).get_id()));
            Log.e("NAME: ", temp.get(i).get_generic());
        }

        lv = (ListView) myView.findViewById(R.id.listView);
        moreBtn = (Button) myView.findViewById(R.id.moreInfoBtn);
        genericName = (TextView) myView.findViewById(R.id.editGeneric);
        brandName = (TextView) myView.findViewById(R.id.editBrand);
        formula = (TextView) myView.findViewById(R.id.editFormula);
        drugClass = (TextView) myView.findViewById(R.id.editClass);
        color = (TextView) myView.findViewById(R.id.editColor);
        shape = (TextView) myView.findViewById(R.id.editShape);


        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MoreDrugInfo.class);
                startActivity(intent);
            }
        });

        Log.e("SIZE:", String.valueOf(temp.size()));
        lv.setClickable(true);
        result = new Drug();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                click = position;
                Log.e("Clicked item: ", String.valueOf(click));

                if (click != 0) {
                    result = db.getDrug(click);
                    brandName.setText(result.get_brand());
                    genericName.setText(result.get_generic());
                    drugClass.setText(result.get_class());
                    color.setText(result.get_color());
                    formula.setText(result.get_formula());
                    shape.setText(result.get_shape());
                }
            }
        });
        return myView;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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