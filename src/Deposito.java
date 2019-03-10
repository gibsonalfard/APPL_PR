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
    Screen screen = new Screen();
    
    public static final int MAXWITHDRAW = 100;
    public static final int MAXTRANSFER = 500;
    public static final int MONTHLY_ADM = 1;
    
    public Deposito(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    private void displayWithdrawalMenu(){
         screen.displayMessageLine("1 - $20");
         screen.displayMessageLine("2 - $40");
         screen.displayMessageLine("3 - $60");
         screen.displayMessageLine("4 - $100");
         screen.displayMessageLine("0 - Cancel transaction");
    }
}
