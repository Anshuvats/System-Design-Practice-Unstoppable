package org.inheritance.practice5;

public class SavingAccount extends BankAccount{

    public SavingAccount(String accountNumber, double balance){
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount){
        if(getBalance()-amount<100){
            System.out.println("Insufficient amount which is less Rs.100");
        }else{
            super.withdraw(amount);
        }
    }
}
