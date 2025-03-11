package org.exceptionhandling.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Empty_File_Check {
    public static void main(String[] args){
        try{
            checkEmptyFile("text1.txt");
        }catch(FileNotFoundException e){
            System.out.println("File Not Found Exception happen :: "+e.getMessage());
        }catch(EmptyFileException e){
            System.out.println("Empty File Exception happen :: "+e.getMessage());
        }
    }
    public static void checkEmptyFile(String fileName) throws FileNotFoundException, EmptyFileException{
        File file=new File(fileName);
        Scanner sc=new Scanner(file);
        if(!sc.hasNextLine()){
            sc.close();
            throw new EmptyFileException("Empty File is found!!!");
        }
        sc.close();
    }
    static class EmptyFileException extends Exception{
        public EmptyFileException(String message){
            super(message);
        }
    }
}
