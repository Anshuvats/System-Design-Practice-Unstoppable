package org.threading.practice2;

public class Find_Even_Odd_Number {

    private static final int MAX_NUMBER=20;
    private static Object lock=new Object();
    private static boolean evenTrigger=true;

    public static void main(String[] args){
        Thread evenThread=new Thread(()->{
            for(int i=2;i<=MAX_NUMBER;i+=2){
                synchronized (lock) {
                    while (!evenTrigger) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even Number from evenThread " + i);
                    evenTrigger = false;
                    lock.notify();
                }
            }
        });

        Thread oddThread=new Thread(()->{
            for(int i=1;i<=MAX_NUMBER;i+=2){
                synchronized (lock) {
                    while (evenTrigger) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd Number from oddThread " + i);
                    evenTrigger = true;
                    lock.notify();
                }
            }
        });
        evenThread.start();
        oddThread.start();
    }
}
