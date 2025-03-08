package org.inheritance.practice8;

public class Circle extends Shape{

    public Circle(double radius){
        super(radius);
    }

    @Override
    public double getPerimeter(double radius){
        return super.getPerimeter(radius);
    }

    @Override
    public double getArea(double radius){
        return super.getArea(radius);
    }
}
