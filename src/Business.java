/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tio
 */
public class Business extends Account {    
    Screen screen = new Screen();
    public static final int MAXWITHDRAW = 1000;
    public static final int MAXTRANSFER = 10000;
    public static final int MONTHLY_ADM = 5;
    
    public Business(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    public void displayWithdrawalMenu(){
         screen.displayMessageLine("1 - $20");
         screen.displayMessageLine("2 - $40");
         screen.displayMessageLine("3 - $60");
         screen.displayMessageLine("4 - $100");
         screen.displayMessageLine("5 - $200");         
         screen.displayMessageLine("6 - $400");
         screen.displayMessageLine("7 - $800");
         screen.displayMessageLine("8 - $1000");
         screen.displayMessageLine("0 - Cancel transaction");
    }
    
    @Override
    public int displayMainMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Transfer");
        screen.displayMessageLine("5 - Change PIN");
        screen.displayMessageLine("6 - Bank Statement");
        screen.displayMessageLine("0 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        
        return keypad.getInput(); // return user's selection
    }
}
