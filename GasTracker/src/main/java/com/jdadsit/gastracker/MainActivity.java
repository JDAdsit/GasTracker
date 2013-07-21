package com.jdadsit.gastracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.jdadsit.GasTracker.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        String message;
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText dateEditText   = (EditText) findViewById(R.id.box_one);
        EditText milageEditText = (EditText) findViewById(R.id.box_two);
        EditText volumeEditText = (EditText) findViewById(R.id.box_three);
        EditText costEditText   = (EditText) findViewById(R.id.box_four);
        String date    = dateEditText.getText().toString();
        Integer milage = (milageEditText.getText().length() == 0) ? 0 : Integer.parseInt(milageEditText.getText().toString());
        Float volume   = (volumeEditText.getText().length() == 0) ? 0 : Float.parseFloat(volumeEditText.getText().toString());
        Float cost     = (costEditText.getText().length() == 0) ? 0   : Float.parseFloat(costEditText.getText().toString());

        if (milage > 151000) {
            Integer miles   = Calculation.milesDriven(151000, milage);
            Float mpg       = (volume == 0) ? 0 : Calculation.milesPerGallon(miles, volume);
            Float frugality = (cost == 0) ? 0 : Calculation.milesPerDollar(miles, cost);

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("You drove ");
            stringBuffer.append(miles.toString());
            stringBuffer.append(" miles.\nGot ");
            stringBuffer.append(mpg.toString());
            stringBuffer.append(" miles per gallon.\nAnd you drove ");
            stringBuffer.append(frugality.toString());
            stringBuffer.append(" miles per dollar spent.");
            message = stringBuffer.toString();
        } else {
            message = "Your milage needs to be higher than the last time you put fuel in";
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
