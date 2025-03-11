package org.exceptionhandling.practice7;

public class VowelCheck {
    public static void main(String[] args){
        try{
           String text="bgtyr ";
            System.out.println("Need to check this Text :: "+text);
            checkVowelInText(text);
            System.out.println("Vowel Found!!!");
        }catch(NotFoundVowelException e){
            System.out.println("Not Vowel Found in text Exception occurred:: "+e.getMessage());
        }
    }
    public static void checkVowelInText(String text) throws NotFoundVowelException{
        boolean flag=false;
        String vowels="aeiouAEIOU";

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(vowels.contains(String.valueOf(ch))){
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new NotFoundVowelException("Vowels not Found!!!");
        }
    }
    static class NotFoundVowelException extends Exception{
        public NotFoundVowelException(String message){
            super(message);
        }
    }
}
