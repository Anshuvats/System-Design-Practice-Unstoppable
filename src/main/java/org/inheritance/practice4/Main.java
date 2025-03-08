package org.inheritance.practice4;

public class Main {
    public static void main(String[] args){
        Employee emp=new Employee(10000);
        HRManager mgr=new HRManager(200000);

        //work
        emp.work();
        mgr.work();

        //salary
        int empSal=emp.getSalary();
        System.out.println(empSal);
        int mgrSal=mgr.getSalary();
        System.out.println(mgrSal);

        //addEmp by HRManager
        mgr.addEmployee();
    }
}
