package Controller.Nasabah;

// Withdrawal.java

import Controller.BankDatabase;
import Controller.CashDispenser;
import ControllerView.Keypad;
import ControllerView.Screen;

// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser
   BankDatabase bankDatabase = getBankDatabase();
   // constant corresponding to menu option to cancel
   private final static int CANCELED = 0;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   }

   // perform transaction
   @Override
   public void execute() {

       this.amount = displayMenuOfAmounts();
       
       if(this.amount == 0){
           System.out.println("Canceling transaction...");
       }else{
           if(cashDispenser.isSufficientCashAvailable(amount) && 
             (bankDatabase.getAvailableBalance(super.getAccountNumber()) >= amount)){

                if(bankDatabase.isAvailableWithdraw(super.getAccountNumber(), amount)){
                    bankDatabase.credit(super.getAccountNumber(), amount);
                    cashDispenser.dispenseCash(amount);
                    System.out.println("Your cash has been dispensed. Please take your cash now.");
                    bankDatabase.setBankStatement(getAccountNumber(), "Withdrawal", 0, amount, 0, null);
                    
                }else{
                    System.out.println("You Exceeded Your Withdraw Limit For Today.");
                }
           }else{
               System.out.println("Sorry, Cash Dispenser is Empty or Your Balace not sufficient\n");
           }
       }
   } 

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 100; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200, 400, 800,1000};

      // loop while no valid choice has been made
      while (userChoice == 100) {
         // display the withdrawal menu
        int input = bankDatabase.getWithdrawal(super.getAccountNumber());

         // determine how to proceed based on the input value
         switch (input) {
            case 1: // if the user chose a withdrawal amount 
            case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
            case 3: // corresponding amount from amounts array
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        
               userChoice = amounts[input]; // save user's choice
               break;       
            case CANCELED: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine(
                  "\nInvalid selection. Try again.");
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 