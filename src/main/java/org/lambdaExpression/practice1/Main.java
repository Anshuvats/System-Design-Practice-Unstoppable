package org.lambdaExpression.practice1;

public class Main {
    public static void main(String[] args){
        SumCalculator sumCalculator=(x,y)->x+y;
        int result= sumCalculator.sum(10,15);
        System.out.println("Sum of two Number are :: "+result);
    }
}
