package org.multithreading.practice1;

public class Counter {

    private int cnt=0;

    public synchronized void increment(){
        cnt++;
    }

    public int getCnt(){
        return cnt;
    }
}
