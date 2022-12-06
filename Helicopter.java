package com.example.lab3fx;

public class Helicopter {

    private Location location;
    private double maxFuelCap;
    private double currFuel;
    private double milesPerGal;

    public Helicopter(Location location, double maxFuelCap, double currFuel, double milesPerGal) {
        this.location = location;
        this.maxFuelCap = maxFuelCap;
        this.currFuel = currFuel;
        this.milesPerGal = milesPerGal;
    }

    public Location getLocation() { return location; }

    public double getMaxFuelCap() { return maxFuelCap; }

    public double getCurrFuel() { return currFuel; }

    public double getMilesPerGal() { return milesPerGal; }

    public String flyTo(Location newLocation) {

        double x1 = location.getX();
        double y1 = location.getY();
        double x2 = newLocation.getX();
        double y2 = newLocation.getY();

        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double requiredFuel = distance / milesPerGal;

        String fuel;
        if (currFuel >= requiredFuel) {
            currFuel = currFuel - requiredFuel;
            this.location = newLocation;

            fuel = "Your flight has been completed!";

        } else {

            fuel = "Not enough fuel to travel.";
        }
        return fuel;
    }
    public String refuel() {

        String status;

        if (location.isGasStation() == true) {
            status = "You have refueled successfully!";

            currFuel = maxFuelCap;
        }
        else {
            status = "CANNOT REFUEL.";
        }
        return status;

    }

    public void setName(String hName) {
    }

    public void setFuel(double hFuel) {
        this.currFuel = hFuel;
        this.maxFuelCap = hFuel;
    }
    public void setMPG(double hMPG) {
        milesPerGal = hMPG;
    }
}
