package ControllerView;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Keypad {
   private Scanner input; // reads data from the command line
                         
   public Keypad() {
      input = new Scanner(System.in);    
   } 

   public int getInput() {
      try{
            return input.nextInt(); // user enters an integer          
      } 
      catch (NoSuchElementException e){
          System.out.println("Invalid Input");
      }
      return input.nextInt(); // user enters an integer          
   } 
} 