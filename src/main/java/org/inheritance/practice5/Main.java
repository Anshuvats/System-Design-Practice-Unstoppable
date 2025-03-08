package org.inheritance.practice5;

public class Main {
    public static void main(String[] args){
        System.out.println("Create new account----> ");
        BankAccount bankAccount=new BankAccount("234569SBIN0000",5000);
        //deposit
        bankAccount.deposit(1000);
        //withdraw
        bankAccount.withdraw(5000);

        SavingAccount savingAccount=new SavingAccount("234780SBIN0000",7000);
        //withdraw
        savingAccount.withdraw(6950);
    }
}
