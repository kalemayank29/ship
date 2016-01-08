package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by mayank on 1/7/16.
 */
public class VillageSelectDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Select the village")
                .setItems(R.array.select_village_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.setBackgroundColor(Color.parseColor("#222222"));
                        // The 'which' argument contains the index position
                        // of the selected item
                        Intent intent;
                        switch(which){
                            case 0:
                                ((CurrentVillage) getActivity().getApplication()).setSomeVariable(12);

                                break;
                            case 1:
                                ((CurrentVillage) getActivity().getApplication()).setSomeVariable(13);
                                break;
                            case 2:
                                ((CurrentVillage) getActivity().getApplication()).setSomeVariable(14);
                                break;
                        }


                    }
                });
        return builder.create();


    }
}
