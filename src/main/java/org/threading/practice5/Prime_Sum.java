package org.threading.practice5;

public class Prime_Sum {
    private static final int NUM_THREADS=4;

    public static void main(String[] args){
        int limit=100000;

        Thread[] threads=new Thread[NUM_THREADS];
        PrimeSumTask[] primeSumTasks=new PrimeSumTask[NUM_THREADS];

        int segmentSize=limit/NUM_THREADS;

        long startTime=System.currentTimeMillis();
        for(int i=0;i<NUM_THREADS;i++){
            int startIndex=(i==0)?2:i*segmentSize;
            int endIndex=(i==NUM_THREADS-1)?limit:(segmentSize+startIndex);
            primeSumTasks[i]=new PrimeSumTask(startIndex,endIndex);
            threads[i]=new Thread(primeSumTasks[i]);
            threads[i].start();
        }
        long sum=0;
        for(int i=0;i<NUM_THREADS;i++){
            try{
                threads[i].join();
                sum+=primeSumTasks[i].getSumPrime();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        long endTime=System.currentTimeMillis();
        System.out.println("Sum of prime Number is :: "+limit+" "+sum);
        System.out.println("Time Taken "+(endTime-startTime)+" MilliSeconds");
    }
    static class PrimeSumTask implements Runnable{
        private int startIndex;
        private int endIndex;
        private long sumPrime;

        public PrimeSumTask(int startIndex,int endIndex){
            this.startIndex=startIndex;
            this.endIndex=endIndex;
            this.sumPrime=0;
        }
        public long getSumPrime(){
            return sumPrime;
        }

        private boolean isPrime(int number){
            if(number<2){
                return false;
            }
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number%i==0){
                    return false;
                }
            }
            return true;
        }

        @Override
        public void run(){
          for(int i=startIndex;i<endIndex;i++){
              if(isPrime(i)){
                  sumPrime+=i;
              }
          }
        }
    }
}
