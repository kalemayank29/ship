package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by mayank on 1/21/16.
 */
public class PNMDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("PNM Form")
                .setItems(R.array.death_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.setBackgroundColor(Color.parseColor("#222222"));
                        // The 'which' argument contains the index position
                        // of the selected item
                        Intent intent;
                        switch(which){
                            case 0:
                                intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
                                intent.putExtra("form","5");
                                intent.putExtra("resident","1");
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getActivity().getApplicationContext(), BirthFamilyListView.class);
                                intent.putExtra("form","5");
                                intent.putExtra("resident","0");
                                startActivity(intent);
                                break;
                            case 2:
                               /* intent = new Intent(getActivity().getApplicationContext(), PNMForm_ask.class);
                                intent.putExtra("form","5");
                                intent.putExtra("resident","3");
                                intent.putExtra("index", "-1");
                                startActivity(intent);*/
                                break;

                        }


                    }
                });
        return builder.create();


    }
}
