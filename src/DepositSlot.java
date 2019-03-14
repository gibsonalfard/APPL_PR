public class DepositSlot {
   int accountNumber;
   double amountOfDeposit;
   boolean validated;
   
   public boolean isEnvelopeReceived() {
      return true; // deposit envelope was received
   }

    public DepositSlot(int account, double myAmount, boolean valid) {
        this.accountNumber = account;
        this.amountOfDeposit = myAmount;
        this.validated = valid;
    }
   
   public void addDeposit(int myAccount, double amount){
       this.accountNumber = myAccount;
       this.amountOfDeposit = amount;
       this.validated = false;
   }
   
   public void validateDeposit(){
       this.validated = true;
   }
   
   public void validateDeposit(BankDatabase bd){
       this.validated = true;
       bd.debit(this.accountNumber, this.amountOfDeposit);
   }
} 