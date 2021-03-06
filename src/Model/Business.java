package Model;

import ControllerView.Keypad;
import ControllerView.Screen;

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
    
    public static final int MAXWITHDRAW = 1000;
    public static final double MAXTRANSFER = 10000;
    public static final int MONTHLY_ADM = 5;
    private Screen screen = new Screen(); // ATM's screen
    private Keypad keypad = new Keypad(); 
    
    public Business(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    
    @Override
    public void payTax(){
        if((getTotalBalance()-Business.MONTHLY_ADM) >= 0){
            credit(Business.MONTHLY_ADM);
        }else{
            credit(this.getTotalBalance());
            this.setAvailableBalance(this.getAvailableBalance()+(getTotalBalance()-Deposito.MONTHLY_ADM));
        }
    }
    
    @Override
    public int displayWithdrawalMenu(){
        screen.displayMessageLine("\nLimit Withdraw for Today is : $"+(Business.MAXWITHDRAW-getWithdrawToday())+".");
        screen.displayMessageLine("\nWithdrawal Menu:");
        screen.displayMessageLine("1 - $20");
        screen.displayMessageLine("2 - $40");
        screen.displayMessageLine("3 - $60");
        screen.displayMessageLine("4 - $100");
        screen.displayMessageLine("5 - $200");
        screen.displayMessageLine("0 - Cancel transaction");
        screen.displayMessage("\nChoose a withdrawal amount: ");
         
        return keypad.getInput(); // get user input through keypad   
    }
    
    @Override
    public boolean isAvailableForWithdraw(double amount){
       return Business.MAXWITHDRAW >= (this.getWithdrawToday()+amount);
    }
    @Override
    public boolean isAvailableForTransfer(double amount){
       return Business.MAXTRANSFER >= (this.getTransferToday()+amount);
    }
}
