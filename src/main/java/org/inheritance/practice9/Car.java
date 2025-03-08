package org.inheritance.practice9;

public class Car extends Vehicle{

    private int numberOfSheets;

    public Car(String make,String model,int year,String fuelType,double fuelEfficiency,int numberOfSheets){
        super(make,model,year,fuelType,fuelEfficiency);
        this.numberOfSheets=numberOfSheets;
    }

    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency()*(1.0/(1.0+getNumberOfSheets()/1000.0));
    }

    @Override
    public double distanceTravelled() {
        return calculateFuelEfficiency()*getFuelEfficiency();
    }

    @Override
    public double maxSpeed() {
        return 100.0;
    }
}
