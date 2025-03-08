package org.inheritance.practice7;

public class Main {
    public static void main(String[] args){
      Employee emp1=new Employee("Anshu","Kumar","1163699","Specialist Programmer");
      System.out.println(emp1.getFirstName()+" "+emp1.getLastName()+" "+emp1.getEmpId());
      Employee emp2=new Employee("Aniket","vats","1163670","Senior Software Engineer");
      System.out.println(emp2.getFirstName()+" "+emp2.getLastName()+" "+emp2.getEmpId());
    }
}
