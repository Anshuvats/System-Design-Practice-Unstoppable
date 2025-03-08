package org.inheritance.practice4;

public class Employee {
    private int salary;

    public Employee(int salary){
        this.salary=salary;
    }

    public void work(){
        System.out.println("Employees are working!!!");
    }

    public int getSalary(){
        return salary;
    }
}
