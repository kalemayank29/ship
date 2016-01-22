package com.example.kylehirschfelder.ship;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kylehirschfelder on 7/23/15.
 */
public class HomeFragment extends Fragment {
    View myView;
    Button selectVillage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_home, container,false);
       // selectVillage = (Button) myView.findViewById(R.id.changeVillage);
       /* selectVillage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VillageSelectDialog dialog = new VillageSelectDialog();
                //FragmentManager manager = getActivity().getFragmentManager();
                //dialog.show(manager,"Villages");
                Intent intent = new Intent(getActivity(),VideoPlayer.class);
                startActivity(intent);

            }
        });
*/
        return myView;

    }

}
