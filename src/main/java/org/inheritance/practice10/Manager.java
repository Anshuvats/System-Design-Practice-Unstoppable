package org.inheritance.practice10;

public class Manager extends Employee{

    private int numOfSubordinates;

    public Manager(String name,String address,double salary,String jobTitle,int numOfSubordinates){
        super(name,address,salary,jobTitle);
        this.numOfSubordinates=numOfSubordinates;
    }

    public int getNumOfSubordinates() {
        return numOfSubordinates;
    }

    @Override
    public double calculatePerformanceBonus() {
        return getSalary()*0.5;
    }

    @Override
    public void generatingPerformanceReports() {
        System.out.println("Performance report of "+getName()+" Excellent!!!");
    }

    @Override
    public void managingProjects() {
        System.out.println("Manager "+getName()+" managing the projects");
    }
}
