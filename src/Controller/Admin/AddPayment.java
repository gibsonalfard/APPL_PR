/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Controller.Admin;

import Controller.BankDatabase;
import Controller.Nasabah.Transaction;
import ControllerView.Keypad;
import ControllerView.Screen;

/**
 *
 * @author ASUS
 */
public class AddPayment extends Transaction {
    Keypad keypad;

    public AddPayment(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad keypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        this.keypad = keypad;
    }

    @Override
    public void execute() {
        int client = setClientNumber();
        double amount = setAmount();
        int collector = setCollectorNumber();
        if (getBankDatabase().addBill(client, amount, collector)) {
            getScreen().displayMessageLine("Succeed adding Payment");
        } else {
            getScreen().displayMessageLine("Fail adding Payment");
        }
        getBankDatabase().showBillList();
    }

    private int setCollectorNumber() {
        getScreen().displayMessage("Insert collector account number :");
        return keypad.getInput();
    }

    private double setAmount() {
        getScreen().displayMessage("Insert amount:");
        return keypad.getInput();
    }

    private int setClientNumber() {
        getScreen().displayMessage("Insert client account number :");
        return keypad.getInput();
    }
    
}
