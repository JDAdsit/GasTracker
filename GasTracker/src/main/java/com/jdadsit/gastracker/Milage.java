package com.jdadsit.gastracker;

/**
 * Created by JD on 7/14/13.
 */
public class Milage {

    //private variables
    int _id;
    String _date;
    int _total_milage;
    int _latest_milage;
    float _volume;
    float _cost;
    float _mpg;

    // Empty Constructor
    public Milage(){

    }

    // constructor
    public Milage(int id, String _date, int _total_milage, int _latest_milage, float _volume, float _cost, float _mpg) {
        this._id = id;
        this._date = _date;
        this._total_milage = _total_milage;
        this._latest_milage = _latest_milage;
        this._volume = _volume;
        this._cost = _cost;
        this._mpg = _mpg;
    }

    // constructor
    public Milage(String _date, int _total_milage, int _latest_milage, float _volume, float _cost, float _mpg) {
        this._date = _date;
        this._total_milage = _total_milage;
        this._latest_milage = _latest_milage;
        this._volume = _volume;
        this._cost = _cost;
        this._mpg = _mpg;
    }

    // getting ID
    public int getID(){
        return this._id;
    }
    //setting ID
    public void setID(int id){
        this._id = id;
    }

    // getting date
    public String getDate(){
        return this._date;
    }
    // setting date
    public void setDate(String date){
        this._date = date;
    }

    // getting total_milage
    public int getTotalMilage(){
        return this._total_milage;
    }
    // setting total_milage
    public void setTotalMilage(int total_milage){
        this._total_milage = total_milage;
    }

    // getting latest_milage
    public int getLatestMilage(){
        return this._latest_milage;
    }
    // setting latest_milage
    public void setLatestMilage(int latest_milage){
        this._latest_milage = latest_milage;
    }

    // getting volume
    public float getVolume(){
        return this._volume;
    }
    // setting volume
    public void setVolume(float volume){
        this._volume = volume;
    }

    // getting cost
    public float getCost(){
        return this._cost;
    }
    // setting cost
    public void setCost(float cost){
        this._cost = cost;
    }

    // getting mpg
    public float getMpg(){
        return this._mpg;
    }
    // setting mpg
    public void setMpg(float mpg){
        this._mpg = mpg;
    }
}
