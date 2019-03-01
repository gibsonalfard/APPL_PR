public class Deposit extends Transaction {
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } 

   // perform transaction
   @Override
   public void execute() {
       BankDatabase bankDatabase = getBankDatabase();
       
       this.amount = promptForDepositAmount();
       
       if(this.amount == CANCELED){
            System.out.println("Canceling transaction...");
       }else{
            System.out.println("Please insert a deposit envelope containing $"+this.amount+".\n");
            System.out.println("Your envelope has been received.\n" +
                                 "NOTE: The money just deposited will not be available"+
                                 "until we verify the amount of any enclosed cash and your checks clear.\n");
            
            bankDatabase.debit(super.getAccountNumber(), amount);
       }
   }

   // prompt user to enter a deposit amount in cents 
   private double promptForDepositAmount() {
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      screen.displayMessage("\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): ");
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return (double) input / 100; // return dollar amount
      }
   }
} 
