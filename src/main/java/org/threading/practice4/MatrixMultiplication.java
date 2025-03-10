package org.threading.practice4;

public class MatrixMultiplication {
    private static final int NUMS_THREAD=2;

    public static void main(String[] args){
        int[][] matrix1={{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int[][] matrix2={{10,11,12},
                         {13,14,15},
                         {16,17,18}};

        int row1=matrix1.length;
        int col1=matrix1[0].length;
        int row2=matrix2.length;
        int col2=matrix2[0].length;

        int[][] result=new int[row1][col2];

        if(col1!=row2){
            throw new IllegalArgumentException("Matix Multiplication is not Possible!!!");
        }

        Thread[] threads=new Thread[NUMS_THREAD];
        int segmentSize=row1/NUMS_THREAD;

        for(int i=0;i<NUMS_THREAD;i++){
            int startIndex=i*segmentSize;
            int endIndex=(i==NUMS_THREAD-1)?row1:(startIndex+segmentSize);
            threads[i]=new Thread(new MultiplicationTask(matrix1,matrix2,result,startIndex,endIndex));
            threads[i].start();
        }

        for(Thread thread:threads){
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Results:: ");
        for(int[] row:result){
            for(int ele:row){
                System.out.println(ele+" ");
            }
            System.out.println();
        }
    }

    static class MultiplicationTask implements Runnable{

        private int[][] matrix1;
        private int[][] matrix2;
        private int[][] result;
        private int startIndex;
        private int endIndex;

        public MultiplicationTask(int[][] matrix1,int[][] matrix2,int[][] result,int startIndex,int endIndex){
            this.matrix1=matrix1;
            this.matrix2=matrix2;
            this.result=result;
            this.startIndex=startIndex;
            this.endIndex=endIndex;
        }

        @Override
        public void run(){
            int m=matrix2[0].length;
            for(int i=startIndex;i<endIndex;i++){
               for(int j=0;j<m;j++){
                   for(int k=0;k<matrix1[0].length;k++){
                       result[i][j]+=matrix1[i][k]*matrix2[k][j];
                   }
               }
            }
        }
    }
}
