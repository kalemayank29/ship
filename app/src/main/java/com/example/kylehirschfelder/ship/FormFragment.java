package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FormFragment extends Fragment {

    Button censusButton, memberButton, birthButton, deathButton, familyButton;

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_forms, container, false);

        censusButton = (Button) myView.findViewById(R.id.censusBtn);
        memberButton = (Button) myView.findViewById(R.id.memberBtn);
        birthButton = (Button) myView.findViewById(R.id.birthBtn);
        deathButton = (Button) myView.findViewById(R.id.deathBtn);
        familyButton = (Button) myView.findViewById(R.id.familyBtn);


        censusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CensusFormPageOne.class);
                startActivity(intent);
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

        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), AddPrimaryFamily.class);
                startActivity(intent);
            }
        });


        return myView;
    }
}