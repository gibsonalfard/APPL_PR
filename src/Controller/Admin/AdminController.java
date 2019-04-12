/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Controller.Admin;

import Model.Admin;
import ControllerView.*;
import Controller.*;
import Controller.Nasabah.Transaction;
import static Model.Constants.*;

/**
 *
 * @author ASUS
 */
public class AdminController {
    BankDatabase bankDatabase;
    CashDispenser cashDispenser;
    Screen screen;
    Keypad keypad;
    Tanggal tanggal;
    
    public AdminController(BankDatabase bankDatabase, CashDispenser cashDispenser, Screen screen, Keypad keypad, Tanggal tanggal){
        this.screen = screen;
        this.keypad = keypad;
        this.bankDatabase = bankDatabase;
        this.tanggal = tanggal;
        this.cashDispenser = cashDispenser;
    }
    
    //display the main menu and perform transactions
    public void performAdmins() {
        // local variable to store transaction currently being processed
        Transaction currentTransaction;
        Admin admin = (Admin)bankDatabase.getAccount(0);

        boolean userExited = false; // user has not chosen to exit

        // loop while user has not chosen option to exit system
        while (!userExited) {
            // show main menu and get user selection
            int mainMenuSelection = admin.displayMenu();

            // decide how to proceed based on user's menu selection
            switch (mainMenuSelection) {
                // user chose to perform one of three transaction types
                case ADD_NASABAH:
                    currentTransaction = new AddNasabah(0, screen, bankDatabase, keypad);
                    currentTransaction.execute();
                    screen.displayMessageLine("Account Added");
                    break;
                case UNBLOCK:
                    admin.showUnblockMenu(keypad, bankDatabase, screen);
                    break;
                case VALIDATE:
                    bankDatabase.updateDepVal(0);
                    break;
                case MONEY_DISPEN:
                    cashDispenser.showCashDispenser();
                    break;
                case ADD_TANGGAL:
                    tanggal.tanggalSekarang();
                    tanggal.addTanggal(1);
                    
                    bankDatabase.resetLimit();
                    
                    if(tanggal.getTanggal() == 3){
                        bankDatabase.monthlyTax();
                    }
                    
                    break;
                case ADD_PAYMENT :
                    currentTransaction = new AddPayment(0, screen, bankDatabase, keypad);
                    currentTransaction.execute();
                    screen.displayMessageLine("Payment Added");
                    break;
                case EXIT: 
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true; 
                    break;
                default: 
                    screen.displayMessageLine( "\nYou did not enter a valid selection. Try again.");
                    break;
            }
        }
    }
}
