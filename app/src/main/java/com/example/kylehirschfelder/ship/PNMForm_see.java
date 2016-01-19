package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PNMForm_see extends AppCompatActivity {

    Button button;

    RadioGroup unconGroup;
    RadioButton unconYes, unconNo;
    String uncon = "0";

    EditText pulseRate;
    String pulse = "";

    RadioGroup breathGroup;
    RadioButton breathYes, breathNo;
    String breath = "0";

    RadioGroup breathHaltGroup;
    RadioButton breathHaltYes, breathHaltNo;
    String breathHalt = "0";

    RadioGroup malnourishedGroup;
    RadioButton malnourishedYes, malnourishedNo;
    String malnourished = "0";

    RadioGroup dehydrationGroup;
    RadioButton dehydrationYes, dehydrationNo;
    String dehydration = "0";

    RadioGroup measlesGroup;
    RadioButton measlesYes, measlesNo;
    String measles = "0";

    EditText feverTemp;
    String fever = "";

    String []receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnmform_see);

        unconGroup = (RadioGroup) findViewById(R.id.unconGroup);
        unconYes = (RadioButton) findViewById(R.id.unconYes);
        unconNo = (RadioButton) findViewById(R.id.unconNo);

        pulseRate = (EditText) findViewById(R.id.pulseRate);

        breathGroup = (RadioGroup) findViewById(R.id.breathGroup);
        breathYes = (RadioButton) findViewById(R.id.breathYes);
        breathNo = (RadioButton) findViewById(R.id.breathNo);

        breathHaltGroup = (RadioGroup) findViewById(R.id.breathHaltGroup);
        breathHaltYes = (RadioButton) findViewById(R.id.breathHaltYes);
        breathHaltNo = (RadioButton) findViewById(R.id.breathHaltNo);

        malnourishedGroup = (RadioGroup) findViewById(R.id.malnourishedGroup);
        malnourishedYes = (RadioButton) findViewById(R.id.malnourishedYes);
        malnourishedNo = (RadioButton) findViewById(R.id.malnourishedNo);

        dehydrationGroup = (RadioGroup) findViewById(R.id.dehydrationGroup);
        dehydrationYes = (RadioButton) findViewById(R.id.dehydrationYes);
        dehydrationNo = (RadioButton) findViewById(R.id.dehydrationNo);

        measlesGroup = (RadioGroup) findViewById(R.id.measlesGroup);
        measlesYes = (RadioButton) findViewById(R.id.measlesYes);
        measlesNo = (RadioButton) findViewById(R.id.measlesNo);

        feverTemp = (EditText) findViewById(R.id.feverTemp);


        receive = getIntent().getStringArrayExtra("KEY");
        button = (Button) findViewById(R.id.saveSee);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((unconGroup.getCheckedRadioButtonId() == -1) ||
                        (breathGroup.getCheckedRadioButtonId() == -1) ||
                        (breathHaltGroup.getCheckedRadioButtonId() == -1) ||
                        (malnourishedGroup.getCheckedRadioButtonId() == -1) ||
                        (dehydrationGroup.getCheckedRadioButtonId() == -1) ||
                        (measlesGroup.getCheckedRadioButtonId() == -1)) {

                    Toast.makeText(getBaseContext(), "क्रुपया सगळी माहिती भरावे", Toast.LENGTH_SHORT).show();
                }
                else {
                    pulse = pulseRate.getText().toString();
                    fever = feverTemp.getText().toString();
                    String[] send = {uncon, pulse, breath, breathHalt, malnourished, dehydration, measles, fever};
                    Intent intent = new Intent(getBaseContext(), PNMForm_hear.class);
                    intent.putExtra("KEY1", receive);
                    intent.putExtra("KEY2", send);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    public void select(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.unconYes:
                if (checked) {
                    uncon = "1";
                }
                break;
            case R.id.unconNo:
                if (checked) {
                    uncon = "0";
                }

                break;
            case R.id.breathYes:
                if (checked) {
                    breath = "1";
                }
                break;
            case R.id.breathNo:
                if (checked) {
                    breath = "0";
                }
                break;
            case R.id.breathHaltYes:
                if (checked) {
                    breathHalt = "1";
                }
                break;
            case R.id.breathHaltNo:
                if (checked) {
                    breathHalt = "0";
                }
                break;
            case R.id.malnourishedYes:
                if (checked) {
                    malnourished = "1";
                }
                break;
            case R.id.malnourishedNo:
                if (checked) {
                    malnourished = "0";
                }
                break;
            case R.id.dehydrationYes:
                if (checked) {
                    dehydration = "1";
                }
                break;
            case R.id.dehydrationNo:
                if (checked) {
                    dehydration = "0";
                }
                break;

            case R.id.measlesYes:
                if(checked) {
                    measles = "1";
                }
                break;
            case R.id.measlesNo:
                if(checked) {
                    measles = "0";
                }
                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pnmform_see, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
