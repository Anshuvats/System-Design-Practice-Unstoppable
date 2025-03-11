package org.exceptionhandling.practice1;

public class Division {
    public static void main(String[] args){
        try{
            int res=division(5,0);
            System.out.println("Results:: "+res);
        }catch(ArithmeticException e){
            System.out.println("Exception occurred:: "+e.getMessage());
        }
    }
    public static int division(int dividend,int divisor){
        if(divisor==0){
            throw new ArithmeticException("Cannot divided by given Zero!!!");
        }
        return dividend/divisor;
    }
}
