package org.threading.practice7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock lock;

    public BankAccount(){
        balance=0.0;
        lock=new ReentrantLock();
    }

    public void deposit(double amount){
        lock.lock();
        try{
           balance+=amount;
            System.out.println("the amount is deposited : "+amount);
            System.out.println("Total balance after the deposit is: "+balance);
        }finally{
            lock.unlock();
        }
    }

    public void withdraw(double amount){
       lock.lock();
       try{
           if(balance>=amount){
               balance-=amount;
               System.out.println("the amount is withdraw is : "+amount);
               System.out.println("Total balance after the withdrawal is: "+balance);
           }else{
               System.out.println("Try to  withdraw  : "+amount);
               System.out.println("Insufficient Balance !!!");
           }
       }finally{
           lock.unlock();
       }
    }

    public static void main(String[] args){

        BankAccount account=new BankAccount();

        Thread depositThread1=new Thread(()->account.deposit(1000));
        Thread depositThread2=new Thread(()->account.deposit(500));

        Thread withdrawThread1=new Thread(()->account.withdraw(50));
        Thread withdrawThread2=new Thread(()->account.withdraw(100));

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();
    }
}
