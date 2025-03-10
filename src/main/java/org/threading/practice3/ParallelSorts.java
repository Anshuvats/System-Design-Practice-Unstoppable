package org.threading.practice3;

import java.util.Arrays;

//Write a Java program that sorts an array of integers using multiple threads.
public class ParallelSorts {

    private static final int ARRAY_SIZE=400;
    private static final int NUM_THREAD=4;

    public static void main(String[] args){
        int[] array=createArray();
        System.out.println("Before Sorting:: "+Arrays.toString(array));
        System.out.println("===================================");

        Thread[] threads=new Thread[NUM_THREAD];
        int segmentSize=ARRAY_SIZE/NUM_THREAD;

        for(int i=0;i<NUM_THREAD;i++){
            int startIndex=i*segmentSize;
            int endIndex=(i==NUM_THREAD-1)?ARRAY_SIZE-1:(startIndex+segmentSize-1);
            threads[i]=new Thread(new SortTask(array,startIndex,endIndex));
            threads[i].start();
        }

        for(Thread thread:threads){
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        mergeSort(array,segmentSize);

        System.out.println("After Sorting:: "+Arrays.toString(array));
    }

    private static int[] createArray(){
        int[] array=new int[ARRAY_SIZE];
        for(int i=0;i<ARRAY_SIZE;i++){
            array[i]=(int)(Math.random()*400);
        }
        return array;
    }

    private static void mergeSort(int[] array,int segmentSize){
        int numSegments=NUM_THREAD;
        while(numSegments>1){
            for(int i=0;i<numSegments/2;i++){
              int left=i*(segmentSize*2);
              int right=Math.min(left+(segmentSize*2)-1, ARRAY_SIZE-1);
              int mid=left+segmentSize-1;
              merge(array,left,mid,right);
            }
            segmentSize*=2;
            numSegments/=2;
        }
    }

    private static void merge(int[] array,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int i=left,j=mid+1,k=0;

        while(i<=mid && j<=right){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=right){
            temp[k++]=array[j++];
        }

        System.arraycopy(temp,0,array,left,temp.length);
    }

    static class SortTask implements Runnable{
        private int[] array;
        private int startIndex;
        private int endIndex;

        public SortTask(int[] array,int startIndex,int endIndex){
            this.array=array;
            this.startIndex=startIndex;
            this.endIndex=endIndex;
        }

        @Override
        public void run(){
            Arrays.sort(array,startIndex,endIndex+1);
        }
    }
}
