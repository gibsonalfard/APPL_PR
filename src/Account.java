public class Account {
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits
       private Screen screen; // ATM's screen
    private Keypad keypad; 
   //every type of account hep dis
    public static final int MAXWITHDRAW = 100;
    public static final int MAXTRANSFER = 0;
    public static final int TRANSACT_ADM = 0;

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   }

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin) {
         return true;
      }
      else {
         return false;
      }
   } 

   // returns available balance
   public double getAvailableBalance() {
      return availableBalance;
   } 

   // returns the total balance
   public double getTotalBalance() {
      return totalBalance;
   }
   
   public void transfer(double amount){
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
   
   public void changePIN(int thePIN){
       this.pin = thePIN;
   }
   
   public String getAccountType() {
       return this.getClass().toString().substring(6);
   }
   
   public int displayMainMenu() {
       return keypad.getInput(); // return user's selection
   }
} 