package org.inheritance.practice10;

public class Main {
    public static void main(String[] args){
        Manager manager=new Manager("Vidhya","Kerala",200000,"Senior Project Manager",6);
        System.out.println("Manager Details::");
        System.out.println(manager.calculatePerformanceBonus());
        manager.generatingPerformanceReports();
        manager.managingProjects();
        Developer developer=new Developer("Anshu","Bihar",100000,"Senior Software Engineer","Banking Domain");
        System.out.println("================================");
        System.out.println("Developer Details::");
        System.out.println(developer.calculatePerformanceBonus());
        developer.generatingPerformanceReports();
        developer.managingProjects();
        Programmer programmer=new Programmer("Aditi","Banglore",50000,"Java Programmer","Java");
        System.out.println("================================");
        System.out.println("Programmer Details::");
        System.out.println(programmer.calculatePerformanceBonus());
        programmer.generatingPerformanceReports();
        programmer.managingProjects();
    }
}
