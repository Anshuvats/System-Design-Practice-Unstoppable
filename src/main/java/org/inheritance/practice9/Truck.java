package org.inheritance.practice9;

public class Truck extends Vehicle{

    private double cargoCapacity;

    public Truck(String make,String model,int year,String fuelType,double fuelEfficiency,double cargoCapacity){
        super(make,model,year,fuelType,fuelEfficiency);
        this.cargoCapacity=cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency()*(1.0/(1.0+getCargoCapacity()/1000.0));
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
