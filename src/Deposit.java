
import java.io.IOException;
import java.util.List;

public class Deposit extends Transaction {
   private double amount; // amount to deposit
   private Keypad keypad = new Keypad(); // reference to keypad
   private static DepositSlot[] depositSlot = new DepositSlot[100]; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option
   private final static int UNBLOCK_COST = 2; // balance cost for unblocking account

   private int numberOfDeposit = 0;

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      keypad = atmKeypad;
      
      if(numberOfDeposit == 0){
          depositSlot[0] = atmDepositSlot;
          numberOfDeposit += 1;
      }else{
          depositSlot[numberOfDeposit] = atmDepositSlot;
          numberOfDeposit = depositSlot.length + 1;
      }
   } 
   
//   public void showByAccount(int accountNumber){
//       
//   }

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
            depositSlot[numberOfDeposit] = new DepositSlot(super.getAccountNumber(), amount, false);
//            depositSlot[numberOfDeposit].addDeposit(super.getAccountNumber(), amount);
            
            bankDatabase.setBankStatement(getAccountNumber(), "Deposit", 0,0,(int)amount,"No");
            
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
   
   public void displayDepVal() throws IOException{
       BankDatabase bankDatabase = new BankDatabase();
       List<BankStatement> subList = bankDatabase.getList();
       
       if(subList != null){
           int size = subList.size();
           
           System.out.println();
           System.out.println("=========================================================================================================");
           System.out.println("Id Statement\tAccount Number\tDate\t\tDescription\tDeposit");
           System.out.println("=========================================================================================================");
           
           for(int i = 0; i < size ; i++){
               if(subList.get(i).getDepositValidate().equals("No")){
                   System.out.print(subList.get(i).getIdStatement()+"\t\t");
                   System.out.print(subList.get(i).getAccount()+"\t");
                   System.out.print(subList.get(i).getDate());
                   System.out.print(subList.get(i).getDescription());
                   System.out.print(subList.get(i).getDeposit());
                   
               }
           }
       
           System.out.println("Enter Id Statement to validate :");
           int input = keypad.getInput();
           
           if (input == CANCELED) {
                System.out.println("Canceling Validation...");
           }
           else {
               bankDatabase.updateDepVal(input);
           }
       }
   }
   
   public int getUnblockCost(){
        return Deposit.UNBLOCK_COST;
   }
} 
