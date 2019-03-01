public class BankDatabase {
   private Account[] accounts; // array of Accounts
   
   public BankDatabase() {
      accounts = new Account[2]; // just 2 accounts for testing
      accounts[0] = new Account(1234, 4321, 1000.0, 1200.0);
      accounts[1] = new Account(8765, 5678, 200.0, 200.0); 
   }
   
   private Account getAccount(int accountNumber) {
      for(Account ak : accounts){
          if(accountNumber == ak.getAccountNumber()){
              return ak;
          }
      }
      return null;
   } 

   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      }
      else {
         return false; // account number not found, so return false
      }
   } 
   
   public boolean seekAccountNumber(int accountNumber){
       for(Account ak : accounts){
          if(accountNumber == ak.getAccountNumber()){
              return true;
          }
      }
      return false;
}

   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } 

   public void transfer(int userAccountNumber, double amount){
       getAccount(userAccountNumber).transfer(amount);
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
   
   public void blockAccount(int userAccountNumber){
      getAccount(userAccountNumber).blockUser();
   }
   
   public void unblockAccount(int userAccountNumber){
      getAccount(userAccountNumber).unblockUser();
   }
   
   public boolean isAccountBlocked(int userAccountNumber){
       if(getAccount(userAccountNumber) != null) 
           return getAccount(userAccountNumber).isUserBlocked();
       else 
           return false;
   }
   
   public boolean isUserExist(int userAccountNumber){
       return getAccount(userAccountNumber) != null;
   }
} 