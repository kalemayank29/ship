package com.example.kylehirschfelder.ship;

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
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.List;


public class PNM_Info extends AppCompatActivity {

        ListView lv;
        Button moreBtn;
        int click;
        TextView genericName, brandName, formula, drugClass, color, shape;
        //DrugDBHandler db;
        //Drug aspirin, androgel, acetoaminophen, result;

        View myView;

        @Nullable

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            myView = inflater.inflate(R.layout.activity_pnm__info, container, false);

        //    db = new DrugDBHandler(getActivity().getApplicationContext());
            List<TextView> info;

            //getApplicationContext().deleteDatabase("drugManager");
            //getApplicationContext().deleteDatabase("drugManager1");

        /*    aspirin = new Drug(0, "Aspirin", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");
            acetoaminophen = new Drug(0, "Acetoaminophen", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");
            androgel = new Drug(0, "Androgel", "Bufferin", "C9H8O4", "Nonsteroidal anti-inflammatory drug (NSAID), Salicylate", "White", "Round");

            db.createDrug(acetoaminophen);
            db.createDrug(aspirin);
            db.createDrug(androgel);

            temp = db.getAllDrugs();*/



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

