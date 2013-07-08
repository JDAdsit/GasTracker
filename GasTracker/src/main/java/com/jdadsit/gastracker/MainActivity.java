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
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText date   = (EditText) findViewById(R.id.box_one);
        EditText milage = (EditText) findViewById(R.id.box_two);
        EditText volume = (EditText) findViewById(R.id.box_three);
        EditText cost   = (EditText) findViewById(R.id.box_four);

        Integer miles = Calculation.milesDriven(151000, Integer.parseInt(String.valueOf(milage.getText())));
        Float mpg = Calculation.milesPerGallon(miles, Integer.parseInt(String.valueOf(volume.getText())));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(miles.toString());
        stringBuffer.append(" miles, ");
        stringBuffer.append(mpg.toString());
        stringBuffer.append(" miles per gallon");
        String message = stringBuffer.toString();

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
