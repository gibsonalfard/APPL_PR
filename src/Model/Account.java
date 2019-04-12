package Model;

import ControllerView.Keypad;
import ControllerView.Screen;
import View.AccountView;

public class Account {

    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private boolean isBlocked;
    private int transferToday = 0;
    private int WithdrawToday = 0;
    private Keypad keypad;
    private AccountView view;
    
    public static int MAXWITHDRAW;
    public int MAXTRANSFER;
    public int MONTHLY_ADM = 1;

    // Account constructor initializes attributes
    public Account(int theAccountNumber, int thePIN,
            double theAvailableBalance, double theTotalBalance) {
        accountNumber = theAccountNumber;
        pin = thePIN;
        availableBalance = theAvailableBalance;
        totalBalance = theTotalBalance;
        isBlocked = false;
    }

    // determines whether a user-specified PIN matches PIN in Account
    public boolean validatePIN(int userPIN) {
        return userPIN == pin;
    }

    // returns available balance
    public double getAvailableBalance() {
        return availableBalance;
    }

    // returns the total balance
    public double getTotalBalance() {
        return totalBalance;
    }
    
    public void setAvailableBalance(double amount){
        this.availableBalance += amount;
    }

    /* INI ANEH, TRF kok NAMBAH? */
    public void transfer(double amount) {
        this.availableBalance += amount;
        this.totalBalance += amount;
    }

    public void credit(double amount) {
        this.availableBalance -= amount;
        this.totalBalance -= amount;
    }

    public void debit(double amount) {
        this.totalBalance += amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void changePIN(int thePIN) {
        this.pin = thePIN;
    }

    public void blockUser() {
        this.isBlocked = true;
    }

    public void unblockUser() {
        this.isBlocked = false;
    }

    public boolean isUserBlocked() {
        return this.isBlocked;
    }

    public String getAccountType() {
        return this.getClass().toString().substring(6);
    }

    public int getTransferToday() {
        return transferToday;
    }

    public void setTransferToday(double transferToday) {
        this.transferToday += transferToday;
    }

    public int getWithdrawToday() {
        return WithdrawToday;
    }

    public void setWithdrawToday(double WithdrawToday) {
        this.WithdrawToday += WithdrawToday;
    }
    
    public int displayWithdrawalMenu() {
       return keypad.getInput(); // return user's selection
    }
    
    public int displayMainMenu(Screen screen, Keypad keypad) {
        view = new AccountView(screen, keypad);
        return view.displayMainMenu();
    }
    
    public void payTax(){
        
    }
    
    public boolean isAvailableForWithdraw(double amount){
       return true;
    }
    
    public boolean isAvailableForTransfer(double amount){
       return true;
    }
} 