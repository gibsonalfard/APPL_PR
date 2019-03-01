public class BankDatabase {
   private Admin[] accounts; // array of Accounts
   
   public BankDatabase() {
      accounts = new Admin[3]; // just 2 accounts for testing
      accounts[0] = new Admin(1234, 4321, 1000.0, 1200.0, false);
      accounts[1] = new Admin(8765, 5678, 200.0, 200.0, false); 
      accounts[2] = new Admin(00000, 00000, 200.0, 200.0, true);
   }
   
   private Admin getAccount(int accountNumber) {
      for(Admin ak : accounts){
          if(accountNumber == ak.getAccountNumber()){
              return ak;
          }
      }
      return null;
   } 
   
   public boolean authenticateAdmin(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Admin userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return (userAccount.validatePIN(userPIN) && userAccount.isAdmin() );
      }
      else {
         return false; // account number not found, so return false
      }
   } 
   
   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Admin userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      }
      else {
         return false; // account number not found, so return false
      }
   } 

   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } 

   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   }

   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   }
   
   public void changeAccountPIN(int userAccountNumber, int curPIN, int newPIN){
       if(authenticateUser(userAccountNumber, curPIN)){
           getAccount(userAccountNumber).changePIN(newPIN);
       }else{
           System.out.println("Sorry, Can't Change PIN");
       }
   }
} 