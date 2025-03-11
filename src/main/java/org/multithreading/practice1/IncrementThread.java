package org.multithreading.practice1;

//Write a Java program to create and start multiple threads that increment a shared counter variable concurrently.
public class IncrementThread extends Thread{
    private Counter counter;
    private int incrementThreads;

    public IncrementThread(Counter counter,int incrementThreads){
        this.counter=counter;
        this.incrementThreads=incrementThreads;
    }

    @Override
    public void run(){
         counter.increment();
    }
}
