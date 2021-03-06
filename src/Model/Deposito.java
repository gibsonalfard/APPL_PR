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
public class Deposito extends Account {
    public static final int MAXWITHDRAW = 100;
    public static final double MAXTRANSFER = 500;
    public static final int MONTHLY_ADM = 1;
    private Screen screen = new Screen(); // ATM's screen
    private Keypad keypad = new Keypad(); 
    
    public Deposito(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    @Override
    public void payTax(){
        if((getTotalBalance()-Deposito.MONTHLY_ADM) >= 0){
            credit(Deposito.MONTHLY_ADM);
        }else{
            credit(this.getTotalBalance());
            this.setAvailableBalance(this.getAvailableBalance()+(getTotalBalance()-Deposito.MONTHLY_ADM));
        }
    }
    
    @Override
    public int displayWithdrawalMenu(){
        int input;
        
        screen.displayMessageLine("\nLimit Withdraw for Today is : $"+(Deposito.MAXWITHDRAW-getWithdrawToday())+".");
        screen.displayMessageLine("\nWithdrawal Menu:");
        screen.displayMessageLine("1 - $20");
        screen.displayMessageLine("2 - $40");
        screen.displayMessageLine("3 - $60");
        screen.displayMessageLine("4 - $100");
        screen.displayMessageLine("0 - Cancel transaction");
        screen.displayMessage("\nChoose a withdrawal amount: ");
        
        input = keypad.getInput();
        
        return (input > 4) ? displayWithdrawalMenu() : input; // get user input through keypad   
           
    }
    
    @Override
    public boolean isAvailableForWithdraw(double amount){
       return Deposito.MAXWITHDRAW >= (this.getWithdrawToday()+amount);
    }
    @Override
    public boolean isAvailableForTransfer(double amount){
       return Business.MAXTRANSFER >= (this.getTransferToday()+amount);
    }
}

