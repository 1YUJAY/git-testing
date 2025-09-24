package com.sheridan;

public class Car {
    private String make;
    private String model;
    private int year;
    private double fuelLevel;
    private double fuelEfficiency;

    public Car(String make, String model, int year, double fuelEfficiency) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelLevel = 0.0;
    }

    public void refuel(double liters) {
        if (liters > 0) {
            fuelLevel += liters;
            System.out.println("Refueled " + liters + " liters. Current fuel: " + fuelLevel + " liters.");
        } else {
            System.out.println("Invalid fuel amount.");
        }
    }

    public void drive(double distance) {
        double requiredFuel = distance / fuelEfficiency;

        if (requiredFuel <= fuelLevel) {
            fuelLevel -= requiredFuel;
            System.out.println("Drove " + distance + "km. Remaining fuel: " + fuelLevel + " liters.");
        } else {
            System.out.println("Not enough fuel to drive " + distance + " km.");
        }
    }

    public void displayInfo() {
        System.out.println(year + " " + make + " " + model);
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public static void main(String[] args) {
        Car myCar = new Car("Honda", "Civic", 2015, 15.0);
        myCar.displayInfo();
        myCar.refuel(20);
        myCar.drive(100);
        myCar.drive(300);
        System.out.println("Final fuel level: " + myCar.getFuelLevel() + " liters.");
    }
}
