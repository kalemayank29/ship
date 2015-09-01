package com.example.kylehirschfelder.ship;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by mayank on 8/7/15.
 */
public class LoginDialog {
    public void displayalert(AlertDialog.Builder alertDialog, final Context context) {

        alertDialog.setTitle("LOGIN");
        alertDialog.setIcon(R.drawable.key);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);


//        alertDialog.setMessage("Enter Username:");
        final TextView uNameText = new TextView(context);
        uNameText.setText("Enter Username:");
        uNameText.setTextSize(20f);
        uNameText.setTextColor(Color.parseColor("#000000"));
        final EditText uNameInput = new EditText(context);
        uNameInput.setTextColor(Color.parseColor("#000000"));
        uNameInput.setTextSize(20f);
        layout.addView(uNameText);
        layout.addView(uNameInput);

//        alertDialog.setMessage("Enter Password:");
        final TextView passwordText = new TextView(context);
        passwordText.setText("Enter Password:");
        passwordText.setTextSize(20f);
        passwordText.setTextColor(Color.parseColor("#000000"));
        final EditText passwordInput = new EditText(context);
//        passwordInput.setInputType(1);
        passwordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
        passwordInput.setTextSize(20f);
        passwordInput.setTextColor(Color.parseColor("#000000"));
        //passwordInput.setTextColor(000000);
        layout.addView(passwordText);
        layout.addView(passwordInput);
//        alertDialog.setView(passwordInput);

        alertDialog.setView(layout);

        /*
        *
        * */

        alertDialog.setPositiveButton("ENTER",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        String password = passwordInput.getText().toString();
                        if (password.equals("abc")) {
                            Toast.makeText(context, "Password Matched", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, TransferPortal.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setAction(android.content.Intent.ACTION_VIEW);
                            context.startActivity(intent);
                        }
                        else {
                            Toast.makeText(context, "Incorrect Password", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }


                    }
                });
        alertDialog.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

}
