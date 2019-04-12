/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package View;

import ControllerView.Keypad;
import ControllerView.Screen;
import Controller.BankDatabase;

/**
 *
 * @author ASUS
 */
public class AdminView {
    Screen screen;
    Keypad keypad;
    
    public AdminView(Screen sc, Keypad kp){
        screen = sc;
        keypad = kp;
    }
    
    public int displayMenu() {
      screen.displayMessageLine("\nAdmin menu:");
      screen.displayMessageLine("1 - Add Nasabah");
      screen.displayMessageLine("2 - Unblock Nasabah");
      screen.displayMessageLine("3 - Validate Deposit");
      screen.displayMessageLine("4 - See Money Dispenser");
      screen.displayMessageLine("5 - Add Tanggal");
      screen.displayMessageLine("6 - Add Payment to Acc");
      screen.displayMessageLine("0 - Exit\n");
      screen.displayMessage("Enter a choice: ");
      return keypad.getInput(); // return user's selection
    }
    
    public void showUnblockMenu(Keypad keypad, BankDatabase bankDatabase, Screen screen){
       screen.displayMessage("Insert account number to unblock : ");
       int accNum = keypad.getInput();
       
       if(bankDatabase.isAccountBlocked(accNum)){
           bankDatabase.unblockAccount(accNum);
           screen.displayMessageLine("Account number "+accNum+" has been unblocked");
       }else{
           screen.displayMessageLine("Account number "+accNum+" was not blocked anyway");
       }  
    }
}
