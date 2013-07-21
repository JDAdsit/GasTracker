package com.jdadsit.gastracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JD on 7/15/13.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    // All Static variables
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "GasManager";

    // Gas table name
    private static final String TABLE_GAS = "gas";

    // Gas table columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_TOTAL_MILAGE = "total_milage";
    private static final String KEY_LATEST_MILAGE = "latest_milage";
    private static final String KEY_VOLUME = "volume";
    private static final String KEY_COST = "cost";
    private static final String KEY_MPG = "mpg";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GAS_TABLE = "CREATE TABLE " + TABLE_GAS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT,"
                + KEY_TOTAL_MILAGE + " INTEGER," + KEY_LATEST_MILAGE + " INTEGER,"
                + KEY_VOLUME + " FLOAT," + KEY_COST + " FLOAT," + KEY_MPG + " FLOAT)";
        db.execSQL(CREATE_GAS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAS);

        // Create table again
        onCreate(db);
    }

    // Adding new row
    public void addRow(Milage milage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, milage.getDate()); // row date
        values.put(KEY_TOTAL_MILAGE, milage.getTotalMilage()); // row total milage
        values.put(KEY_LATEST_MILAGE, milage.getLatestMilage()); // row latest milage
        values.put(KEY_VOLUME, milage.getVolume()); // row volume
        values.put(KEY_COST, milage.getCost()); // row cost
        values.put(KEY_MPG, milage.getMpg()); // row mpg

        // Inserting row
        db.insert(TABLE_GAS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single row
    public Milage getRow(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        assert db != null;
        Cursor cursor = db.query(TABLE_GAS, new String[] { KEY_ID,
                KEY_DATE, KEY_TOTAL_MILAGE, KEY_LATEST_MILAGE, KEY_VOLUME,
                KEY_COST, KEY_MPG}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Milage milage = new Milage(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getFloat(4),
                cursor.getFloat(5), cursor.getFloat(6));

        return milage;
    }

    // Getting all rows
    public List<Milage> getAllRows() {
        List<Milage> milageList = new ArrayList<Milage>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_GAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Milage milage = new Milage();
                milage.setID(Integer.parseInt(cursor.getString(0)));
                milage.setDate(cursor.getString(1));
                milage.setTotalMilage(cursor.getInt(2));
                milage.setLatestMilage(cursor.getInt(3));
                milage.setVolume(cursor.getFloat(4));
                milage.setCost(cursor.getFloat(5));
                milage.setMpg(cursor.getFloat(6));
            } while (cursor.moveToNext());
        }

        // return milage list
        return milageList;
    }

    // Getting row count
    public int getRowsCount() {
        String countQuery = "SELECT * FROM " + TABLE_GAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single contact
    public int updateRow(Milage milage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, milage.getDate());
        values.put(KEY_TOTAL_MILAGE, milage.getTotalMilage());
        values.put(KEY_LATEST_MILAGE, milage.getLatestMilage());
        values.put(KEY_VOLUME, milage.getVolume());
        values.put(KEY_COST, milage.getCost());
        values.put(KEY_MPG, milage.getMpg());

        // updating row
        return db.update(TABLE_GAS, values,KEY_ID + " = ?",
                new String[] { String.valueOf(milage.getID()) });
    }

    // Deleting single row
    public void deleteRow(Milage milage) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GAS, KEY_ID + " = ?",
                new String[] { String.valueOf(milage.getID()) });
        db.close();
    }
}
