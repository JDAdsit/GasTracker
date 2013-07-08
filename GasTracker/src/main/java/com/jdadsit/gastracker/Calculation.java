package com.jdadsit.gastracker;

/**
 * Created by JD on 7/7/13.
 */
public class Calculation {

    public static int milesDriven(int previousMilage, int currentMilage) {
        // calculate the milage driven since the last fill up
        return (currentMilage - previousMilage);
    }

    public static float milesPerGallon(int distanceTraveled, float gallonsOfFuel) {
        // calculate the miles per gallon
        return (distanceTraveled / gallonsOfFuel);
    }

    public static float milesPerDollar(int miles, float dollars) {
        // calculate how many miles the car went on one dollar
    }
}
