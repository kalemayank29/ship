package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kylehirschfelder on 1/8/16.
 */
public class EducationFragment extends Fragment {

    //declare variables here
    View myView;
    Button cholera;

    //Similar to onCreate, except on Create for fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_educationfragment, container, false);
        cholera = (Button) myView.findViewById(R.id.cholera);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("member", "");
        editor.putString("birth", "");
        editor.putString("deathA", "");
        editor.putString("vhw", "Mayank Kale");
        editor.putString("supervisor", "Ryan Singh");
        editor.putString("vhwId","56");
        editor.putString("supervisorId","75");
        editor.commit();

        cholera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VillageSelectDialog dialog = new VillageSelectDialog();
                //FragmentManager manager = getActivity().getFragmentManager();
                //dialog.show(manager,"Villages");
                Intent intent = new Intent(getActivity(),VideoPlayer.class);
                startActivity(intent);

            }
        });


        //return the view
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
