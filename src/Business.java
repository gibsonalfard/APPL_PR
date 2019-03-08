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
    public static final int MAXTRANSFER = 10000;
    public static final int MONTHLY_ADM = 5;
    
    public Business(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
}
