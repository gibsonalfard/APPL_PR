/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tio
 */
public class Student extends Account {    
    public static final int MAXWITHDRAW = 20;
    public static final int MAXTRANSFER = 0;
    public static final int TRANSACT_ADM = 0;
    private Screen screen = new Screen(); // ATM's screen
    private Keypad keypad = new Keypad(); 
    
    public Student(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    @Override
    public int displayMainMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Change PIN");
        screen.displayMessageLine("0 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        int input = keypad.getInput(); 
        
        return input == 4 ? 5 : input; // return user's selection
    }
   
    @Override
    public int displayWithdrawalMenu(){
        int input;
        screen.displayMessageLine("\nLimit Withdraw for Today is : $"+(Student.MAXWITHDRAW-getWithdrawToday())+".");
        screen.displayMessageLine("\nWithdrawal Menu:");
        screen.displayMessageLine("1 - $20");
        screen.displayMessageLine("0 - Cancel transaction");
        screen.displayMessage("\nChoose a withdrawal amount: ");
        
        input = keypad.getInput();
        
        return (input > 1) ? displayWithdrawalMenu() : input; // get user input through keypad      
    }
   
   @Override
   public boolean isAvailableForWithdraw(double amount){
       return Student.MAXWITHDRAW >= (this.getWithdrawToday()+amount);
   }
}