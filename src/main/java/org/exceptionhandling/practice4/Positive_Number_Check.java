package org.exceptionhandling.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Positive_Number_Check {
    public static void main(String[] args){
        try{
            checkNumberFromFile("text.txt");
            System.out.println("All numbers are Positive!!!");
        }catch(FileNotFoundException e){
            System.out.println("File not found!!! "+e.getMessage());
        }catch(PositiveNumberException e){
            System.out.println("Exceptions are happening!!! "+e.getMessage());
        }
    }

    public static void checkNumberFromFile(String fileName) throws FileNotFoundException, PositiveNumberException{
        File file=new File(fileName);
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
            int num=Integer.parseInt(sc.nextLine());
            if(num>0){
                throw new PositiveNumberException("Positive number found:: "+num);
            }
        }
        sc.close();
    }
    static class PositiveNumberException extends Exception{
        public PositiveNumberException(String message){
            super(message);
        }
    }
}
