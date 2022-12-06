package com.example.lab3fx;

public class Location {

    private String locName;
    private double x;
    private double y;
    private boolean gasStation;

    public Location(String locName, double x, double y, boolean gasStation) {
        this.locName = locName;
        this.x = x;
        this.y = y;
        this.gasStation = gasStation;
    }

    public String getLocName() {
        return locName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isGasStation() {
        return gasStation;
    }


    @Override
    public String toString() {
        return locName + ": " + "(" + x + "," + y + ")" + ": " + "can refuel? " + gasStation;

    }
}

