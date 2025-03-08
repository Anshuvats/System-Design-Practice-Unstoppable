package org.inheritance.practice8;

public class Shape {

    private double radius;

    public Shape(double radius){
        this.radius=radius;
    }

    public double getPerimeter(double radius){
        return 2*3.14*radius;
    }

    public double getArea(double radius){
        return 3.14*radius*radius;
    }
}
