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
 * Created by kylehirschfelder on 7/26/15.
 */
public class TransferFragment extends Fragment {

    Button memberButton;
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_transfer, container,false);

        memberButton = (Button) myView.findViewById(R.id.memberBtn);

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getActivity(), TransferMemberListView.class);
                startActivity(intent);
            }
        });

        return myView;
    }
}
