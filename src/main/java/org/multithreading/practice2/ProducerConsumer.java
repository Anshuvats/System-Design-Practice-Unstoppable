package org.multithreading.practice2;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int BUFFER_SIZE=6;
    private static final Queue<Integer>bufferQueue=new LinkedList<>();

    public static void main(String[] args){
        Thread producerThread=new Thread(new Producer());
        Thread consumerThread=new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }
    static class Producer implements Runnable{

        @Override
       public void run(){
            int val=0;
            while(true){
                synchronized (bufferQueue) {
                    while (bufferQueue.size() == BUFFER_SIZE) {
                        try{
                            bufferQueue.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Producer Produced:: " + val);
                    bufferQueue.add(val++);
                    //Notify to Consumer producer send the data
                    bufferQueue.notify();

                    //timer
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
       }
    }

    static class Consumer implements Runnable{

        @Override
        public void run(){
            while(true) {
                synchronized (bufferQueue) {
                    while (bufferQueue.isEmpty()) {
                       try{
                           bufferQueue.wait();
                       }catch(InterruptedException e){
                           e.printStackTrace();
                       }
                    }
                    int val = bufferQueue.poll();
                    System.out.println("Consumer consumed:: " + val);
                    //Notify to Producer, Consumer received the data
                    bufferQueue.notify();

                    //timer
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
