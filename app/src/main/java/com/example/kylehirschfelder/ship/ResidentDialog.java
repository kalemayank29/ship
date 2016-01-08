package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by mayank on 1/6/16.
 */
public class ResidentDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Resident or Non Resident?")
                .setPositiveButton("Resident", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        Intent intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
                        intent.putExtra("resident", "1");
                        intent.putExtra("form","1");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Non-resident", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Intent intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
                        intent.putExtra("resident", "0");
                        intent.putExtra("form","1");
                        startActivity(intent);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}