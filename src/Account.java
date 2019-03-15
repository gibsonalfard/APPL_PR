public class Account {

    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private boolean isBlocked;
    private int transferToday = 0;
    private int WithdrawToday = 0;
    private Keypad keypad;
    
    public static int MAXWITHDRAW;
    public int MAXTRANSFER;
    public int MONTHLY_ADM = 1;
    private static int UNBLOCK_COST = 0; // balance cost for unblocking account

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
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Change PIN");
        screen.displayMessageLine("5 - Bank Statement");
        screen.displayMessageLine("0 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        int input = keypad.getInput(); 
        
        return input == 4 ? 5 : (input == 5 ? 6 : input); // return user's selection
    }
    
    public void payTax(){
        
    }
    
    public boolean isAvailableForWithdraw(double amount){
       return true;
    }
    
    public boolean isAvailableForTransfer(double amount){
       return true;
    }
    
    public int getUnblockCost(){
        return Account.UNBLOCK_COST;
    }
} 