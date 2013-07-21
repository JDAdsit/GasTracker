package com.jdadsit.gastracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import java.util.List;

public class DatabaseActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.jdadsit.GasTracker.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buildRow(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addRow(new Milage("1/2/13", 152000, 1000, 10, 40, 100));

        // Reading all milage
        List<Milage> milage = db.getAllRows();

        for (Milage row : milage) {
            String message = "Id: "+ row.getID()+" ,date: " + row.getDate() + " ,total row: " + row.getTotalMilage() +
                   " ,latest row: " + row.getLatestMilage() + " ,volume: " + row.getVolume() +
                   " ,cost: " + row.getCost() + " ,mpg: " + row.getMpg();
            // Writing Contacts to log

            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.database, menu);
        return true;
    }
}
