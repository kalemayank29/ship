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
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;


public class PNM_Info extends AppCompatActivity {

        private ListView mainListView ;
        private ArrayAdapter<String> listAdapter ;

        View myView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pnm__info);
            mainListView = (ListView) findViewById( R.id.mainListView );

            // Create and populate a List of planet names.
            String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                    "Jupiter", "Saturn", "Uranus", "Neptune"};
            ArrayList<String> planetList = new ArrayList<String>();
            planetList.addAll( Arrays.asList(planets) );

            // Create ArrayAdapter using the planet list.
            listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);

            // Add more planets. If you passed a String[] instead of a List<String>
            // into the ArrayAdapter constructor, you must not add more items.
            // Otherwise an exception will occur.
            listAdapter.add( "Ceres" );
            listAdapter.add( "Pluto" );
            listAdapter.add( "Haumea" );
            listAdapter.add( "Makemake" );
            listAdapter.add( "Eris" );

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

