package org.inheritance.practice10;

public class Developer extends Employee{

    private String projectDomain;

    public Developer(String name,String address,double salary,String jobTitle,String projectDomain){
        super(name,address,salary,jobTitle);
        this.projectDomain=projectDomain;
    }

    public String getProjectDomain() {
        return projectDomain;
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
        System.out.println("Manager "+getName()+" managing the projects of "+projectDomain);
    }
}
