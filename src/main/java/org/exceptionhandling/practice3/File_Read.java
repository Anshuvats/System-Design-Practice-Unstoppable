package org.exceptionhandling.practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Read {
    public static void main(String[] args){
        try{
           readFile("read.txt");
        }catch(FileNotFoundException e){
            System.out.println("Exception Message:: "+e.getMessage());
        }
    }
    public static void readFile(String fileName) throws FileNotFoundException{
        File file=new File(fileName);
        Scanner sc=new Scanner(file);

        while(sc.hasNextLine()){
            String line =sc.nextLine();
            System.out.println(line);
        }
        sc.close();
    }
}
