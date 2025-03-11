package org.exceptionhandling.practice6;

import java.util.*;

public class Duplicate_Number_Check {
    public static void main(String[] args){
        try{
            List<Integer>list=readNumbersFromUsers();
            checkDuplicateNumber(list);
        }catch(Duplicate_Number_Exception e){
            System.out.println("Duplicate Number is Found:: "+e.getMessage());
        }
    }
    public static List<Integer> readNumbersFromUsers(){
        List<Integer>list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        System.out.println("How Many Numbers do you want to take inputs");
        int num=sc.nextInt();
        System.out.println("Input the integers:: ");
        for(int i=0;i<num;i++){
            int ele=sc.nextInt();
            list.add(ele);
        }
        sc.close();
        return list;
    }
    public static void checkDuplicateNumber(List<Integer>list) throws Duplicate_Number_Exception{
        Set<Integer>set=new HashSet<>();
        for(int ele:list){
            if(set.contains(ele)){
                throw new Duplicate_Number_Exception("Duplicate Number Found!!! "+ele);
            }
            set.add(ele);
        }
    }
    static class Duplicate_Number_Exception extends Exception{
        public Duplicate_Number_Exception(String message){
            super(message);
        }
    }
}
