package org.inheritance.practice9;

public class Motorcycle extends Vehicle{

    private double engineDisplacement;

    public Motorcycle(String make,String model,int year,String fuelType,double fuelEfficiency,double engineDisplacement){
        super(make,model,year,fuelType,fuelEfficiency);
        this.engineDisplacement=engineDisplacement;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency()*(1.0/(1.0+getEngineDisplacement()/1000.0));
    }

    @Override
    public double distanceTravelled() {
        return calculateFuelEfficiency()*getFuelEfficiency();
    }

    @Override
    public double maxSpeed() {
        return 180.0;
    }
}
