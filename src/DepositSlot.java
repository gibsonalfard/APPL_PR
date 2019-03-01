public class DepositSlot {
   int accountNumber;
   private double amountOfDeposit;
   
   public boolean isEnvelopeReceived() {
      return true; // deposit envelope was received
   }
   
   public void addDeposit(int myAccount, double amount){
       this.accountNumber = myAccount;
       this.amountOfDeposit = amount;
   }
} 