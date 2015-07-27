package com.example.kylehirschfelder.ship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FormFragment extends Fragment {

    Button censusButton, memberButton, birthButton, deathButton;

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_forms, container, false);

        censusButton = (Button) myView.findViewById(R.id.censusBtn);
        memberButton = (Button) myView.findViewById(R.id.memberBtn);
        birthButton = (Button) myView.findViewById(R.id.birthBtn);
        deathButton = (Button) myView.findViewById(R.id.deathBtn);

        censusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        deathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return myView;
    }
}
