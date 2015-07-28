package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kylehirschfelder on 7/27/15.
 */
public class MedicineInventoryFragment extends Fragment {
    View myView;
    Button add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_medicine_inventory, container, false);

        add = (Button) myView.findViewById(R.id.addBtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MedicineAddInterface.class);
                startActivity(intent);
            }
        });


        return myView;
    }
}
