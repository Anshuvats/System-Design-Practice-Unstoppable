package org.inheritance.practice9;

public class Main {
    public static void main(String[] args){
        Truck truck=new Truck("Tata","Tata189567",2024,"CNG",8.43,4.5);
        System.out.println("Truck Details::");
        System.out.println(truck.getMake());
        System.out.println(truck.calculateFuelEfficiency());
        System.out.println(truck.distanceTravelled());
        System.out.println(truck.maxSpeed());
        Motorcycle motorcycle=new Motorcycle("Honda","Spleder1X",2025,"Electric",9.2,3.0);
        System.out.println("====================================");
        System.out.println("Motorcycle Details::");
        System.out.println(motorcycle.getMake());
        System.out.println(motorcycle.calculateFuelEfficiency());
        System.out.println(motorcycle.distanceTravelled());
        System.out.println(motorcycle.maxSpeed());
        Car car=new Car("BMW","BMW1345",2023,"Solar",10.9,6);
        System.out.println("====================================");
        System.out.println("Car Details::");
        System.out.println(car.getMake());
        System.out.println(car.calculateFuelEfficiency());
        System.out.println(car.distanceTravelled());
        System.out.println(car.maxSpeed());
    }
}
