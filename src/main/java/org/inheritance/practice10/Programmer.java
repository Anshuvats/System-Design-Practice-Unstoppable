package org.inheritance.practice10;

public class Programmer extends Employee{
    private String programmingLang;

    public Programmer(String name,String address,double salary,String jobTitle,String programmingLang){
        super(name,address,salary,jobTitle);
        this.programmingLang=programmingLang;
    }

    public String getProgrammingLang() {
        return programmingLang;
    }

    @Override
    public double calculatePerformanceBonus() {
        return getSalary()*0.7;
    }

    @Override
    public void generatingPerformanceReports() {
        System.out.println("Performance report of "+getName()+" Excellent!!!");
    }

    @Override
    public void managingProjects() {
        System.out.println("Manager "+getName()+" managing the projects of "+programmingLang);
    }
}
