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
    private boolean isAdmin;
            
    public Admin(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, boolean Admin) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
        this.isAdmin = Admin;
    }
       
    public boolean isAdmin(){
        return isAdmin;
    }
}
