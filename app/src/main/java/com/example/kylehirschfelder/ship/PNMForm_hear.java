package com.example.kylehirschfelder.ship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PNMForm_hear extends AppCompatActivity {

    Button button;

    RadioGroup striderGroup;
    RadioButton striderYes, striderNo;
    String strider = "0";

    RadioGroup wheezeGroup;
    RadioButton wheezeYes, wheezeNo;
    String wheeze = "0";

    RadioGroup noiseGroup;
    RadioButton noiseYes, noiseNo;
    String noise = "0";

    String []receive1, receive2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnmform_hear);

        receive1 = getIntent().getStringArrayExtra("KEY1");
        receive2 = getIntent().getStringArrayExtra("KEY2");

        striderGroup = (RadioGroup) findViewById(R.id.striderGroup);
        striderYes = (RadioButton) findViewById(R.id.striderYes);
        striderNo = (RadioButton) findViewById(R.id.striderNo);

        wheezeGroup = (RadioGroup) findViewById(R.id.wheezeGroup);
        wheezeYes = (RadioButton) findViewById(R.id.wheezeYes);
        wheezeNo = (RadioButton) findViewById(R.id.wheezeNo);

        noiseGroup = (RadioGroup) findViewById(R.id.noiseGroup);
        noiseYes = (RadioButton) findViewById(R.id.noiseYes);
        noiseNo = (RadioButton) findViewById(R.id.noiseNo);

        button = (Button) findViewById(R.id.saveHear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((striderGroup.getCheckedRadioButtonId() == -1) ||
                        (wheezeGroup.getCheckedRadioButtonId() == -1) ||
                        (noiseGroup.getCheckedRadioButtonId() == -1)) {

                    Toast.makeText(getBaseContext(), "क्रुपया सगळी माहिती भरावे", Toast.LENGTH_SHORT).show();
                }
                else {
                    String[] send = {strider, wheeze, noise};
                    Intent intent = new Intent(getBaseContext(), PNMForm_other.class);
                    intent.putExtra("KEY1", receive1);
                    intent.putExtra("KEY2", receive2);
                    intent.putExtra("KEY3", send);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    public void select(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.striderYes:
                if (checked) {
                    strider = "1";
                }
                break;
            case R.id.striderNo:
                if (checked) {
                    strider = "0";
                }

                break;
            case R.id.wheezeYes:
                if (checked) {
                    wheeze = "1";
                }
                break;
            case R.id.wheezeNo:
                if (checked) {
                    wheeze = "0";
                }
                break;
            case R.id.noiseYes:
                if (checked) {
                    noise = "1";
                }
                break;
            case R.id.noiseNo:
                if (checked) {
                    noise = "0";
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pnmform_hear, menu);
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
