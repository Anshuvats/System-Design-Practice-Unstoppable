package org.exceptionhandling.practice2;

public class EvenOdd {
    public static void main(String[] args){
       int n=18;
       tryNumber(n);
       n=7;
       tryNumber(n);
    }
    public static void tryNumber(int num){
        try{
            checkEvenOddNumber(num);
            System.out.println(num+" num is even!!!");
        }catch(IllegalArgumentException e){
            System.out.println("Exception Happens:: "+e.getMessage());
        }
    }
    public static void checkEvenOddNumber(int num){
        if(num%2!=0){
            throw new IllegalArgumentException(num+" is odd number!!!");
        }
    }
}
