package exceptionspractice;

import java.util.Scanner;

public class ExceptionsPractice {

  

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
          String number = sc.nextLine();
        int convertedString;
        
        try{
        convertedString = Integer.parseInt(number);
        System.out.println(convertedString);
          
      } catch (Exception e){
          System.out.println("Bad String");
      } finally{
          //TODO
      }
    }
}
    

