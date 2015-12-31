package com.example.kylehirschfelder.ship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by poorwa on 29/12/15.
 */
public class SearchSEARCH extends AppCompatActivity {

    TextView textView;
    Button searchButton;
    SearchView searchView;
    List<Member> list;
    Translation translation = new Translation();
    MemberDataInterface member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        member = new MemberDataInterface(getApplicationContext());

        //select id from member where name = searchView.getQuery()

        textView = (TextView) findViewById(R.id.textView);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchView = (SearchView) findViewById(R.id.searchView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text="";
                list = member.getIdByName(translation.Letter_M2E(searchView.getQuery().toString()));
                for (Member element: list
                     ) {
                    text += "."+ translation.Letter_E2M(element.getName());
                }
                textView.setText(text);


            }
        });

    }
}
