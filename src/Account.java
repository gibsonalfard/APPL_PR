import java.util.*;

public class Account {
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits
   private List<BankStatement> log = new ArrayList<BankStatement>();

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;      
      BankStatement e = new BankStatement("Previous Balance", 0, 0, 0, true, availableBalance);
      log.add(e);
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
   
   public void Log(String desc, int ref, double withdrawal, double deposit, boolean validate) {
       BankStatement e = new BankStatement(desc, ref, withdrawal, deposit, validate, availableBalance);
       log.add(e);
   }
} 