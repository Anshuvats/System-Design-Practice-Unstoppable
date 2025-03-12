package org.multithreading.practice5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierPractice {
    private static final int NUM_THREAD=4;
    private static final CyclicBarrier barrier=new CyclicBarrier(NUM_THREAD,new BarrierAction());

    public static void main(String[] args){
        Thread[] threads=new Thread[NUM_THREAD];
        for(int i=0;i<NUM_THREAD;i++){
            threads[i]=new Thread(new Worker());
            threads[i].start();
        }

        try{
            for(Thread thread:threads){
                thread.join();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    static class Worker implements Runnable{
        public void run(){
            try{
                System.out.println("Thread Await---> "+Thread.currentThread().getName());
                barrier.await();
                System.out.println("Thread Completed!!! "+Thread.currentThread().getName());
            }catch (InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }

    static class BarrierAction implements Runnable{
        public void run(){
            System.out.println("Barrier Achieved!!!");
        }
    }
}
