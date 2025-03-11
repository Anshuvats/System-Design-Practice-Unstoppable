package org.multithreading.practice1;


public class Main {
    public static void main(String[] args){
        Counter counter=new Counter();
        int numThreads=6;
        int incrementThreads=10000;
        IncrementThread[] threads=new IncrementThread[numThreads];

        // create and start the threads
        for(int i=0;i<numThreads;i++){
            threads[i]=new IncrementThread(counter,incrementThreads);
            threads[i].start();
        }

        // wait all the threads to finish
        try{
            for(IncrementThread thread:threads){
                thread.join();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Count:: "+counter.getCnt());
    }
}
