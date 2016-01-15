package com.example.kylehirschfelder.ship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by poorwa on 12/1/16.
 */
public class CodFifteenForm extends AppCompatActivity {

    TextView dateOfForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_fifteen);
        dateOfForm = (TextView) findViewById(R.id.dateOfForm);
        Date d = new Date();
        Translation translation = new Translation();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateOfForm.setText(translation.Number_E2M(dateFormat.format(d)));

    }
}
