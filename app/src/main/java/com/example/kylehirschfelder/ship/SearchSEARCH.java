package com.example.kylehirschfelder.ship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by poorwa on 29/12/15.
 */
public class SearchSEARCH extends AppCompatActivity {

    TextView textView;
    Button searchButton;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView = (TextView) findViewById(R.id.textView);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchView = (SearchView) findViewById(R.id.searchView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchView.getQuery().toString().equals("नवीन घर क्रमांक")) {
                    Toast.makeText(getBaseContext(), "FOUND", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "NOT FOUND", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
