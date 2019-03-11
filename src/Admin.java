/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tio
 */
public class Admin extends Account {           
    private Screen screen = new Screen();
    private Keypad keypad = new Keypad();
    
    
    public Admin(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    private int displayMainMenu() {
      screen.displayMessageLine("\nAdmin menu:");
      screen.displayMessageLine("1 - Add Nasabah");
      screen.displayMessageLine("2 - Unblock Nasabah");
      screen.displayMessageLine("3 - Validate Deposit");
      screen.displayMessageLine("4 - See Money Dispenser");
      screen.displayMessageLine("0 - Exit\n");
      screen.displayMessage("Enter a choice: ");
      return keypad.getInput(); // return user's selection
    }
    
   
}
