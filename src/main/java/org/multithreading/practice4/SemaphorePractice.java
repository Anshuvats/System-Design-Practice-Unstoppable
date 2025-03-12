package org.multithreading.practice4;

import java.util.concurrent.Semaphore;

public class SemaphorePractice {
    private static final int NUM_THREAD=5;
    private static final int NUM_PERMITS=2;

    public static void main(String[] args){
        Semaphore semaphore=new Semaphore(NUM_PERMITS);

        Thread[] threads=new Thread[NUM_THREAD];
        for(int i=0;i<NUM_THREAD;i++){
            threads[i]=new Thread(new Worker(semaphore));
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
        private Semaphore semaphore;

        public Worker(Semaphore semaphore){
            this.semaphore=semaphore;
        }

        @Override
        public void run(){
          try{
              semaphore.acquire();
              System.out.println("Thread Acquire ---> "+Thread.currentThread().getName());
              Thread.sleep(1000);
              System.out.println("Thread Release ---> "+Thread.currentThread().getName());
              semaphore.release();
          }catch(InterruptedException e){
              e.printStackTrace();
          }
        }
    }
}
