package org.inheritance.practice4;

public class HRManager extends Employee{

    public HRManager(int salary){
        super(salary);
    }

    public void work(){
        System.out.println("Managed Employee!!!");
    }

    public void addEmployee(){
        System.out.println("Adding Employee!!!");
    }
}
