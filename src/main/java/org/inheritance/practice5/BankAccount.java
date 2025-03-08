package org.inheritance.practice5;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount){
        accountNumber+=amount;
    }

    public void withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            System.out.println("Remaining balance "+balance);
        }else{
            System.out.println("Oops!!! Insufficient balance!!!");
        }
    }

    public double getBalance(){
        return balance;
    }
}
