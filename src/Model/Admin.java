package Model;

import Controller.BankDatabase;
import ControllerView.Keypad;
import ControllerView.Screen;
import View.*;

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
    AdminView view = new AdminView(screen, keypad);
    
    public Admin(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN,
            theAvailableBalance, theTotalBalance);
    }
    
    public int displayMenu() {
      return view.displayMenu();
    }
    
    public void showUnblockMenu(Keypad keypad, BankDatabase bankDatabase, Screen screen){
       view = new AdminView(screen, keypad);
       view.showUnblockMenu(keypad, bankDatabase, screen);
    }
}
